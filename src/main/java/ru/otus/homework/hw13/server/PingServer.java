package ru.otus.homework.hw13.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Клиент подключен к серверу");
                processRequest(client);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void processRequest(Socket client) throws IOException {
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(client.getInputStream()));
        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
        outputStream.writeUTF("Введите 2 числа и команду +, -, * или /");
        outputStream.flush();
        String operation = null;
        int result = 0;

        String userInput = inputStream.readLine();
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
        outputStream.writeUTF(String.valueOf(result));
        outputStream.flush();
    }
}
