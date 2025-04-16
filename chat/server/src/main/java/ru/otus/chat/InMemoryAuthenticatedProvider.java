package ru.otus.chat;

import java.sql.*;
import java.sql.PreparedStatement;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider {

    private final Server server;

    private static final String USERS_ROLES_QUERY = """
            select role from roles
            join users on roles.id = users.role_id
            where users.username = ?
            """;

    private static final String USERNAME_QUERY = """
            select username from users
            where login = ? and password = ?
            """;

    private static final String USER_IS_EXIST_QUERY = """
                    select count(1) from users
                    where login = ? or username = ?
            """;

    private static final String FIND_ROLE_ID_QUERY = """
                    select id from roles
                    where role = ?
            """;

    private static final String ADD_NEW_USER_QUERY = """
                    insert into users (login, password, username, role_id) values (?, ?, ?, ?)
            """;


    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/postgres";
    public Connection connection;

    {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, "postgres", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public InMemoryAuthenticatedProvider(Server server) {
        this.server = server;
    }

    @Override
    public void initialize() {
        System.out.println("initialize InMemoryAuthenticatedProvider");
    }

    @Override
    public String getRole(String username) {
        String role = null;
        try (PreparedStatement ps = connection.prepareStatement(USERS_ROLES_QUERY)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    role = rs.getString(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return role;
    }

    private String getUsernameByLoginAndPassword(String login, String password) {
        String username = null;
        try (PreparedStatement ps = connection.prepareStatement(USERNAME_QUERY)) {
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    username = rs.getString(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return username;
    }

    private void addUser(String login, String password, String username, String role) {
        Role currentRole = new Role();
        try (PreparedStatement ps = connection.prepareStatement(FIND_ROLE_ID_QUERY)) {
            if (role.equals("ADMIN")) {
                ps.setString(1, "ADMIN");
            } else {
                ps.setString(1, "USER");
            }
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    currentRole.setId(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (PreparedStatement ps = connection.prepareStatement(ADD_NEW_USER_QUERY)) {
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, username);
            ps.setInt(4, currentRole.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isUserAlreadyExist(String login, String username) {
        int flag = 0;
        try (PreparedStatement ps = connection.prepareStatement(USER_IS_EXIST_QUERY)) {
            ps.setString(1, login);
            ps.setString(2, username);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    flag = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return flag == 1;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUsername = getUsernameByLoginAndPassword(login, password);
        if (authUsername == null) {
            clientHandler.sendMsg("Некорректный логин/пароль");
            return false;
        }
        if (server.isUsernameBusy(authUsername)) {
            clientHandler.sendMsg("Данная учетная запись уже занята");
            return false;
        }

        clientHandler.setUsername(authUsername);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/authok " + authUsername);
        return true;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String username, String role) {
        if (login.trim().length() < 3 || password.trim().length() < 3 || username.trim().length() < 3) {
            clientHandler.sendMsg("Логин 3+ символа, пароль 3+ символа, имя пользователя 3+ символа");
            return false;
        }
        if (isUserAlreadyExist(login, username)) {
            clientHandler.sendMsg("Логин/имя пользователя уже занято");
            return false;
        }

        addUser(login, password, username, role);
        clientHandler.setUsername(username);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + username);
        return true;
    }
}