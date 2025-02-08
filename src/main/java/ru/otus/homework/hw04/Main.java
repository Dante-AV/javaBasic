package ru.otus.homework.hw04;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var users = new User[]{new User("User1", "User1", "User1", 1980, "User1@mail.ru"),
                new User("User2", "User2", "User2", 1990, "User2@mail.ru"),
                new User("User3", "User3", "User3", 1992, "User3@mail.ru"),
                new User("User4", "User4", "User4", 1985, "User4@mail.ru"),
                new User("User5", "User5", "User5", 1970, "User5@mail.ru"),
                new User("User6", "User6", "User6", 1975, "User6@mail.ru"),
                new User("User7", "User7", "User7", 1993, "User7@mail.ru"),
                new User("User8", "User8", "User8", 1990, "User8@mail.ru"),
                new User("User9", "User9", "User9", 1991, "User9@mail.ru"),
                new User("User10", "User10", "User10", 1997, "User10@mail.ru")};

        int currentYear = LocalDate.now().getYear();
        for (int i = 0; i < users.length; i++) {
            if (currentYear - users[i].getBirthYear() > 40) {
                users[i].printUserInfo();
            }
        }
    }
}
