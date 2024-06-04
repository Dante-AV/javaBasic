package ru.otus.homework.hw10;


public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Алексей", "89542329898");
        phoneBook.add("Алексей", "89542321212");
        phoneBook.add("Александр", "89263232323");
        phoneBook.add("Анна", "89653233321");
        phoneBook.add("Татьяна", "89645654545");
        System.out.println(phoneBook);

        phoneBook.find("Алексей");
        phoneBook.containsPhoneNumber("89542329898");

    }
}