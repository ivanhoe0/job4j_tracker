package ru.job4j.inheritance;

public class Doctor extends Profession {
    private int chemistry;

    public Doctor(String name, String surname, String education, int chemistry) {
        super(name, surname, education);
        this.chemistry = chemistry;
    }

    public Doctor() {
    }

    public void heal() {
        System.out.println("Лечение");
    }
}
