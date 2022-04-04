package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private int informatics;

    public Programmer(String name, String surname, String education, int mathematics, int informatics) {
        super(name, surname, education, mathematics);
        this.informatics = informatics;
    }

    public Programmer() {
    }

    public void createAlgorithm() {
        System.out.println("Алгоритм");
    }
}
