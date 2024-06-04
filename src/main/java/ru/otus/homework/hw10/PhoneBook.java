package ru.otus.homework.hw10;

import java.util.*;

public class PhoneBook {
    Map<String, List<String>> map = new HashMap<>();

    public PhoneBook() {
    }

    public void add(String name, String phoneNumber) {
        if (map.containsKey(name)) {
            var phoneNumbers = map.get(name);
            phoneNumbers.add(phoneNumber);
            map.put(name, phoneNumbers);
        } else {
            var phoneNumbers = new ArrayList<String>();
            phoneNumbers.add(phoneNumber);
            map.put(name, phoneNumbers);
        }
    }

    public void find(String name) {
        if (map.containsKey(name)) {
            List<String> value = map.get(name);
            System.out.println("По имени " + name + " найдены номера телефонов: " + value);
        } else {
            System.out.println("В справочнике нет таких данных");
        }
    }

    public boolean containsPhoneNumber(String phoneNumber) {
        Set<Map.Entry<String, List<String>>> entries = map.entrySet();
        for (Map.Entry<String, List<String>> pair : entries) {
            List<String> valueList = pair.getValue();
            for (String value : valueList) {
                if (value.equals(phoneNumber)) {
                    System.out.println("В справочнике есть номер телефона " + value);
                    return true;
                }
            }
        }
        System.out.println("В справочнике нет такого номер телефона");
        return false;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "map=" + map +
                '}';
    }
}
