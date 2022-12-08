package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> byName = person -> person.getName().contains(key);
        Predicate<Person> bySureName = person -> person.getSurname().contains(key);
        Predicate<Person> byPhone = person -> person.getPhone().contains(key);
        Predicate<Person> byAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = byName.or(byAddress.or(byPhone.or(bySureName)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
