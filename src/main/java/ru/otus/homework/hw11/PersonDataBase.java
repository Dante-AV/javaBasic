package ru.otus.homework.hw11;

import java.util.*;

public class PersonDataBase {
    private final Map<Long, Person> personList = new HashMap();
    private final Map<Position, Person> personList2 = new HashMap();

    public void add(Person person) {
        personList.put(person.getId(), person);
        personList2.put(person.getPosition(), person);
    }


    public Person findById(Long id) {
        Person personById = null;
        if (personList.containsKey(id)) {
            personById = personList.get(id);
        }
        return personById;
    }

    public boolean isManager(Person person) {
        if (personList2.containsKey(person.getPosition())) {
            if (personList2.containsKey(Position.MANAGER) || personList2.containsKey(Position.DIRECTOR) ||
                    personList2.containsKey(Position.BRANCH_DIRECTOR) || personList2.containsKey(Position.SENIOR_MANAGER)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmployee(Long id) {
        Position personPosition = personList.get(id).getPosition();
        if (!(personPosition.equals(Position.MANAGER) || personPosition.equals(Position.DIRECTOR) ||
                personPosition.equals(Position.BRANCH_DIRECTOR) || personPosition.equals(Position.SENIOR_MANAGER))) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "PersonDataBase{" +
                "personList=" + personList +
                '}';
    }
}
