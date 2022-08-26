package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User anotherUser = (User) obj;
        return age == anotherUser.age
                && Objects.equals(name, anotherUser.name);
    }

    @Override
    public int compareTo(User o) {
        int result = this.name.compareTo(o.name);
        return result == 0 ? Integer.compare(this.age, o.age) : result;
    }
}
