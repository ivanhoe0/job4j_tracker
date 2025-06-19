package ru.job4j.tracker;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CreateManyItems implements UserAction {
    private final Output out;
    private static final Logger LOG = LogManager.getLogger(CreateManyItems.class.getName());

    public CreateManyItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create many items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        long startTime = System.currentTimeMillis();
        out.println("=== Create many items ===");
        int count = input.askInt("Введите кол-во заявок ");
        for (int i = 0; i < count; i++) {
            tracker.add(new Item("Заявка № " + i));
        }
        out.println("Добавлено заявок: " + count);
        long executeTime = System.currentTimeMillis() - startTime;
        LOG.trace("Creating " + count + " items complete in " + executeTime + "ms");
        return true;
    }
}