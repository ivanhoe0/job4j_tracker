package ru.job4j.tracker;

public class Exit implements UserAction {
    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
