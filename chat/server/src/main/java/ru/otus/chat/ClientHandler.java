package ru.otus.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class ClientHandler {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;

    private String username;
    private boolean authenticated;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился");

                while (true) {
                    sendMsg("Перед работой с чатом необходимо выполнить аутентификацию " +
                            "/auth login password \n" +
                            "или регистрацию /reg login password username role(ADMIN or USER)");
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }

                        if (message.startsWith("/auth ")) {
                            String[] elements = message.split(" ");
                            if (elements.length != 3) {
                                sendMsg("Неверный формат команды /auth ");
                                continue;
                            }
                            if (server.getAuthenticatedProvider().authenticate(
                                    this, elements[1], elements[2])) {
                                authenticated = true;
                                break;
                            }
                        }
                        if (message.startsWith("/reg ")) {
                            String[] elements = message.split(" ");
                            if (elements.length != 5) {
                                sendMsg("Неверный формат команды /reg ");
                                continue;
                            }
                            if (!(elements[4].equals("USER")) && !(elements[4].equals("ADMIN"))) {
                                sendMsg("Неверная роль, возможные роли - USER, ADMIN");
                                continue;
                            }
                            if (server.getAuthenticatedProvider().registration(
                                    this, elements[1], elements[2], elements[3], Roles.valueOf(elements[4]))) {
                                authenticated = true;
                                break;
                            }
                        }
                    }
                }

                while (authenticated) {
                    String message = in.readUTF();
                    String[] line = message.split(" ", 3);
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        if (line.length == 3) {
                            if (message.startsWith("/w")) {
                                server.oneClientMessage(line[1], username + ": " + line[2]);
                            }
                        }
                        if (line.length == 2) {
                            if (message.startsWith("/kick") && (!username.equals((line[1])))) {
                                server.oneClientMessage(line[1], "Вас отключили от чата");
                                server.oneClientMessage(line[1], "/exitok");
                            } else {
                                server.oneClientMessage(username, "По команде /kick вы не можете выйти из чата, выйти из чата - команда /exit");
                            }

                            if (!server.getRole(username).equals(Roles.ADMIN)) {
                                server.oneClientMessage(username, "Роль не ADMIN, нет прав на отключение пользователей из чата");
                            }
                        }
                    } else {
                        server.broadcastMessage(username + ": " + message);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при закрытии соединения: " + e.getMessage());
        }
    }
}
