package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.prinln("===== Show all Items =====");
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            for (Item item : items) {
                out.prinln(item);
            }
        } else {
            out.prinln("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
