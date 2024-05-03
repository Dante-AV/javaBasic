package ru.otus.homework.hw04;


public class User {

    private final String lastname;
    private final String firstname;
    private final String surname;
    private final int birthYear;
    private final String email;

    public User(String lastname, String firstname, String surname, int birthYear, String email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.surname = surname;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void printUserInfo() {
        System.out.println("ФИО: " + lastname + " " + firstname + " " + surname);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail: " + email + "\n");
    }

    public int getBirthYear() {
        return birthYear;
    }
}
