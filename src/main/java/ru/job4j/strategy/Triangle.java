package ru.job4j.strategy;

public class Triangle implements Shape {

    @Override
    public String draw() {
        return "    ^       " + "\n"
                + "   / \\     " + "\n"
                + "  /___\\    ";
    }
}
