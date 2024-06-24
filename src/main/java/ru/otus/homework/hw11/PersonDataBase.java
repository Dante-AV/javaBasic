package ru.otus.homework.hw11;

import java.util.*;

import static ru.otus.homework.hw11.Position.*;

public class PersonDataBase {
    private final Map<Long, Person> personList = new HashMap();
    private static final Set<Position> MANAGER_POSITIONS = Set.of(MANAGER, DIRECTOR, BRANCH_DIRECTOR, SENIOR_MANAGER);

    public void add(Person person) {
        personList.put(person.getId(), person);
    }


    public Person findById(Long id) {
        Person personById = null;
        if (personList.containsKey(id)) {
            personById = personList.get(id);
        }
        return personById;
    }

    public boolean isManager(Person person) {
        return MANAGER_POSITIONS.contains(person.getPosition());
    }

    public boolean isEmployee(Long id) {
        boolean isEmployee = false;
        if (personList.containsKey(id)) {
            Position personPosition = personList.get(id).getPosition();
            isEmployee = !MANAGER_POSITIONS.contains(personPosition);
        }
        return isEmployee;
    }

    @Override
    public String toString() {
        return "PersonDataBase{" +
                "personList=" + personList +
                '}';
    }
}
