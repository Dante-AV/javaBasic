package ru.otus.homework.hw19;

import ru.otus.homework.hw12.MyException;

import java.io.*;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите имя файла и текст");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] text = line.split(" ");
        String fileName = text[0];
        int count = 0;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                String regex = String.format("%s", text[1]);
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(str);
                while (m.find()) {
                    if (m.group().equals(text[1])) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Количество слов " + text[1] + " в файле " + fileName + ": " + count);
    }
}
