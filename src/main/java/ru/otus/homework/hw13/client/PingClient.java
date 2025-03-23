package ru.otus.homework.hw13.client;

import java.io.*;

public class PingClient {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public PingClient(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(new BufferedInputStream(inputStream));
        this.outputStream = new DataOutputStream(new BufferedOutputStream(outputStream));
    }

    public void send(String text) throws IOException {
        outputStream.write(text.getBytes());
        outputStream.flush();
    }

    public String read() throws IOException {
        return inputStream.readUTF();
    }
}