package ru.otus.homework.hw09;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        printList(1, 10);
        sumElements(new ArrayList<>(Arrays.asList(1, 7, 3, 9)));
        updateList(7, new ArrayList<>(Arrays.asList(1, 7, 3, 9)));
        changeElements(7, new ArrayList<>(Arrays.asList(1, 7, 3, 9)));
        employeeInfo(new ArrayList<>(Arrays.asList(new Employee("Иван", 35), new Employee("Алексей", 40), new Employee("Семен", 45))));
        employeeInfo(new ArrayList<>(Arrays.asList(new Employee("Иван", 35), new Employee("Алексей", 40), new Employee("Семен", 45))), 40);
        compareAge(new ArrayList<>(Arrays.asList(new Employee("Иван", 35), new Employee("Алексей", 40), new Employee("Семен", 45))), 40);
        youngEmployee(new ArrayList<>(Arrays.asList(new Employee("Иван", 35), new Employee("Алексей", 20), new Employee("Семен", 45))));
    }

    public static List<Integer> printList(int min, int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        System.out.println(list);
        return list;
    }

    public static int sumElements(List<Integer> numbers) {
        int sum = 0;
        for (var num : numbers) {
            if (num > 5) {
                sum += num;
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static void updateList(int num, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, num);
        }
        System.out.println(numbers);
    }

    public static void changeElements(int num, List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, numbers.get(i) + num);
        }
        System.out.println(numbers);
    }

    public static List<String> employeeInfo(List<Employee> employees) {
        List<String> names = new ArrayList<>();
        for (var employee : employees) {
            names.add(employee.getName());
        }
        System.out.println(names);
        return names;
    }

    public static List<Employee> employeeInfo(List<Employee> employees, int minAge) {
        List<Employee> employeesList = new ArrayList<>();
        for (var employee : employees) {
            if (employee.getAge() >= minAge) {
                employeesList.add(employee);
            }
        }
        System.out.println(employeesList);
        return employeesList;
    }

    public static boolean compareAge(List<Employee> employees, int minAge) {
        for (var employee : employees) {
            if (employee.getAge() > minAge) {
                return true;
            }
        }
        return false;
    }

    public static Employee youngEmployee(List<Employee> employees) {
        Employee minAgeEmployee = employees.get(0);
        for (Employee employee : employees) {
            minAgeEmployee = minAgeEmployee.getAge() < employee.getAge() ? new Employee(minAgeEmployee.getName(), minAgeEmployee.getAge()) : new Employee(employee.getName(), employee.getAge());
        }
        System.out.println(minAgeEmployee);
        return minAgeEmployee;
    }
}
