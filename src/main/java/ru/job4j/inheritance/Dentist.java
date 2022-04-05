package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private String dentistry;

    public Dentist(String name, String sur, String edu, int chem, String dentistry) {
        super(name, sur, edu, chem);
        this.dentistry = dentistry;
    }

    public void healTeeth() {
        System.out.println("лечить зубы");
    }
}
