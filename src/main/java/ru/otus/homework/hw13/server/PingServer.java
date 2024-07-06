package ru.otus.homework.hw13.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Client connected");
                processRequest(client);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processRequest(Socket client) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        String operation = null;
        int result = 0;

        out.writeUTF("Введите 2 числа и команду +, -, * или /");
        out.flush();

        String userInput = in.readLine();
        var numbers = userInput.split("[-+*/]");

        Pattern pattern = Pattern.compile("[-+*/]");
        Matcher matcher = pattern.matcher(userInput);

        if (matcher.find()) {
            operation = matcher.group(0);
        } else {
            System.out.println("No operation found");
        }

        if (Objects.equals(operation, "+")) {
            result = Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
        } else if (Objects.equals(operation, "*")) {
            result = Integer.parseInt(numbers[0]) * Integer.parseInt(numbers[1]);
        } else if (Objects.equals(operation, "/")) {
            result = Integer.parseInt(numbers[0]) / Integer.parseInt(numbers[1]);
        } else if (Objects.equals(operation, "-")) {
            result = Integer.parseInt(numbers[0]) - Integer.parseInt(numbers[1]);
        }

        System.out.println("result: " + result);
        out.writeUTF(String.valueOf(result));
        out.flush();
    }
}
