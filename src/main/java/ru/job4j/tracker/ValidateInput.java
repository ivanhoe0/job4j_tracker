package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input in;
    private final Output out;

    public ValidateInput(Input input, Output output) {
        in = input;
        out = output;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int rsl = -1;
        do {
            try {
                rsl = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.prinln("Please enter validate data again.");
            }
        } while (invalid);
        return rsl;
    }
}
