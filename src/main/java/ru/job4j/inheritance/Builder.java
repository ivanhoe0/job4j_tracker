package ru.job4j.inheritance;

public class Builder extends Engineer {
    private int drawing;

    public Builder(String name, String surname, String education, int mathematics, int drawing) {
        super(name, surname, education, mathematics);
        this.drawing = drawing;
    }

    public Builder() {
    }

    public void makeAnDrawing() {
        System.out.println("Drawing");
    }
}
