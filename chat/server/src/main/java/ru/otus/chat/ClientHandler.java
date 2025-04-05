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
    private static int userCount = 0;

    public ClientHandler(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        userCount++;
        username = "user_" + userCount;

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился");

                while (true) {
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
