package ru.otus.homework.hw13.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PingClient {

    private final DataInputStream in;
    private final DataOutputStream out;

    public PingClient(Socket socket) throws IOException {
        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        this.out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    public void send(String message) throws IOException {
        out.write(message.getBytes());
        out.flush();
    }

    public String read() throws IOException {
        return in.readUTF();
    }
}
