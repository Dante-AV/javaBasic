package ru.otus.homework.hw11;

import java.util.*;

import static ru.otus.homework.hw11.Position.*;

public class PersonDataBase {
    private final Map<Long, Person> personList = new HashMap<>();
    private static final Set<Position> MANAGER_POSITIONS = Set.of(MANAGER, DIRECTOR, BRANCH_DIRECTOR, SENIOR_MANAGER);

    public Person findById(Long id) {
        Person person = null;
        if (personList.containsKey(id)) {
            person = personList.get(id);
        }
        return person;
    }

    public void add(Person person) {
        personList.put(person.getId(), person);
    }

    public boolean isManager(Person person) {
        return MANAGER_POSITIONS.contains(person.getPosition());
    }

    public boolean isEmployee(Long id) {
        boolean isEmployee = false;
        if (personList.containsKey(id)) {
            isEmployee = !MANAGER_POSITIONS.contains(personList.get(id).getPosition());
        }
        return isEmployee;
    }
}

