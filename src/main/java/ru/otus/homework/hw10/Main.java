package ru.otus.homework.hw10;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Алексей","89898988787");
        phoneBook.add("Алексей","89121211122");
        phoneBook.add("Андрей","89545677899");
        System.out.println(phoneBook);

        phoneBook.find("Алексей");
        phoneBook.containsPhoneNumber("89121211122");
    }
}
