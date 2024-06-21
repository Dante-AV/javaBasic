package ru.otus.homework.hw11;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PersonDataBase personDataBase = new PersonDataBase();
        personDataBase.add(new Person("Алексей", Position.DEVELOPER, 1L));
        personDataBase.add(new Person("Татьяна", Position.MANAGER, 5L));
        personDataBase.add(new Person("Анна", Position.MANAGER, 10L));
        System.out.println(personDataBase);
        var person = personDataBase.findById(10L);
        System.out.println(person);
        var isManager = personDataBase.isManager(new Person(Position.MANAGER));
        System.out.println(isManager);
        var isEmployee = personDataBase.isEmployee(1L);
        System.out.println(isEmployee);


        int[] array1 = {7, 87, 11, 0, 9, 6, 4, 1, -5};
        int[] array2 = {55, 9, 5, 77, 0, 6, 4, 1, -7};
        SortArray.bubbleSort(array1);
        System.out.println(Arrays.toString(array1));
        SortArray.quickSort(array2, 0, array2.length - 1);
        System.out.println(Arrays.toString(array2));
    }
}
