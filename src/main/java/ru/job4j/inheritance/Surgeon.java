package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private int anatomy;

    public Surgeon(String name, String sur, String edu, int chem, int anatomy) {
        super(name, sur, edu, chem);
        this.anatomy = anatomy;
    }

    public void makeAnOperation() {
        System.out.println("Операция");
    }
}
