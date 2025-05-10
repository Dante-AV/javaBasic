package ru.otus.java.basic.http.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class HttpServer {
    private int port;
    private Dispatcher dispatcher;

    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
    }

    public void start() {
        ExecutorService serv = Executors.newFixedThreadPool(5);
        ExecutorService serv2 = Executors.newFixedThreadPool(5);
        serv.execute(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Сервер запущен на порту: " + port);
                while (true) {
                    try (Socket socket = serverSocket.accept()) {
                        byte[] buffer = new byte[8192];
                        int n = socket.getInputStream().read(buffer);
                        if (n < 0) {
                            System.out.println("Получено битое сообщение");
                            continue;
                        }
                        String rawRequest = new String(buffer, 0, n);
                        HttpRequest request = new HttpRequest(rawRequest);
                        request.info(true);
                        serv2.execute(() -> {
                            try {
                                dispatcher.execute(request, socket.getOutputStream());
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                        serv2.shutdown();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        serv.shutdown();
    }
}
