package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Replace Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("========== Replacing Item =========");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка с id: " + id + " изенена на заявку: " + item);
        } else {
            System.out.println("Заявка с id: " + id + " не найдена");
        }
        return true;
    }
}
