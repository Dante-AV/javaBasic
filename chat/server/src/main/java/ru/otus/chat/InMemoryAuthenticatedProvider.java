package ru.otus.chat;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider {
    private static class User {
        private final String login;
        private final String password;
        private final String username;

        public User(String login, String password, String username) {
            this.login = login;
            this.password = password;
            this.username = username;
        }
    }

    private Server server;
    private ConcurrentHashMap<User, Roles> users;

    public InMemoryAuthenticatedProvider(Server server) {
        this.server = server;
        this.users = new ConcurrentHashMap<>();
        this.users.put(new User("qwe", "qwe", "qwe1"), Roles.ADMIN);
        this.users.put(new User("asd", "asd", "asd1"), Roles.USER);
        this.users.put(new User("zxc", "zxc", "zxc1"), Roles.USER);
    }

    @Override
    public void initialize() {
        System.out.println("initialize InMemoryAuthenticatedProvider");
    }

    private String getUsernameByLoginAndPassword(String login, String password) {
        ConcurrentHashMap.KeySetView<User, Roles> key = users.keySet();
        for (User user : key) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user.username;
            }
        }
        return null;
    }

    private boolean isLoginAlreadyExist(String login) {
        ConcurrentHashMap.KeySetView<User, Roles> key = users.keySet();
        for (User user : key) {
            if (user.login.equals(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameAlreadyExist(String username) {
        ConcurrentHashMap.KeySetView<User, Roles> key = users.keySet();
        for (User user : key) {
            if (user.username.equals(username)) {
                return true;
            }
        }
        return false;
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
    public boolean registration(ClientHandler clientHandler, String login, String password, String username, Roles role) {
        if (login.trim().length() < 3 || password.trim().length() < 3 || username.trim().length() < 3) {
            clientHandler.sendMsg("Логин 3+ символа, пароль 3+ символа, имя пользователя 3+ символа");
            return false;
        }
        if (isLoginAlreadyExist(login)) {
            clientHandler.sendMsg("Указанный логин уже занят");
            return false;
        }
        if (isUsernameAlreadyExist(username)) {
            clientHandler.sendMsg("Указанное имя пользователя уже занято");
            return false;
        }
        users.put(new User(login, password, username), role);
        clientHandler.setUsername(username);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + username);
        return true;
    }

    @Override
    public Roles getRole(String username) {
        Roles role = null;
        for (var user : users.keySet()) {
            if (username.equals(user.username)) {
                role = users.get(user);
            }
        }
        return role;
    }
}