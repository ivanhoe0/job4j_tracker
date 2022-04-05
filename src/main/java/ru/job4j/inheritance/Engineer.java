package ru.job4j.inheritance;

public class Engineer extends Profession {
    private int mathematics;

    public Engineer(String name, String surname, String education, int mathematics) {
        super(name, surname, education);
        this.mathematics = mathematics;
    }

    public void makeAnCalculation() {
        System.out.println("расчет произведен");
    }
}
