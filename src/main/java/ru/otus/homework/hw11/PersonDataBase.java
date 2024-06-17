package ru.otus.homework.hw11;

import java.util.*;

public class PersonDataBase {
    private final List<Person> personList = new ArrayList<>();

    public void add(Person person) {
        personList.add(new Person(person.getName(), person.getPosition(), person.getId()));
    }


    public Person findById(Long id) {
        Person personById = null;
        for (int i = 0; i < personList.size(); i++) {
            if (id.equals(personList.get(i).getId())) {
                personById = personList.get(i);
            }
        }
        return personById;
    }

    public boolean isManager(Person person) {
        return person.getPosition() == Position.MANAGER || person.getPosition() == Position.DIRECTOR ||
                person.getPosition() == Position.BRANCH_DIRECTOR || person.getPosition() == Position.SENIOR_MANAGER;
    }

    public boolean isEmployee(Long id) {
        boolean isEmployee = false;
        for (int i = 0; i < personList.size(); i++) {
            if (id.equals(personList.get(i).getId())) {
                if (!(personList.get(i).getPosition() == Position.MANAGER || personList.get(i).getPosition() == Position.DIRECTOR ||
                        personList.get(i).getPosition() == Position.BRANCH_DIRECTOR || personList.get(i).getPosition() == Position.SENIOR_MANAGER)) {
                    return true;
                }
            }
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
