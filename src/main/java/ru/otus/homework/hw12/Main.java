package ru.otus.homework.hw12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        String myNameFiles = null;
        List<File> files = new ArrayList<>();
        String dirPath = "D:/javaBasic/";

        File fileDirectory = new File(dirPath);
        File[] fileList;
        if (fileDirectory.isDirectory()) {
            fileList = fileDirectory.listFiles();
            if (fileList != null) {
                for (var fileName : fileList) {
                    if (fileName.isFile()) {
                        files.add(fileName);
                        System.out.println(fileName.getName());
                    }
                }
            }
        }

        while (!isExit) {
            String name = scanner.nextLine();
            for (File file : files) {
                if (file.getName().equals(name)) {
                    myNameFiles = file.getName();
                    //  isExit = true;
                } else {
                    isExit = true;
                }
            }
        }

        if (myNameFiles != null) {
            try (InputStreamReader reader = new InputStreamReader(new FileInputStream(myNameFiles))) {
                int n = reader.read();
                while (n != -1) {
                    System.out.print((char) n);
                    n = reader.read();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if (myNameFiles != null) {
            try (FileOutputStream out = new FileOutputStream(myNameFiles, true)) {
                String text = scanner.nextLine();
                byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
                out.write(buffer);
            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }
}
