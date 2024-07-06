package ru.otus.homework.hw13.client;

import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 8080)) {
            PingClient pingClient = new PingClient(socket);
            String info = pingClient.read();
            System.out.println(info);
            String userInput = scanner.nextLine();
            pingClient.send(userInput + "\r\n");
            String result = pingClient.read();
            System.out.println("result: " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}