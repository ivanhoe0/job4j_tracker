package ru.job4j.tracker;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DeleteAllItems implements UserAction {
    private final Output out;
    private static final Logger LOG = LogManager.getLogger(DeleteAllItems.class.getName());

    public DeleteAllItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        long startTime = System.currentTimeMillis();
        out.println("=== Delete all items ===");
        List<Item> allItems = tracker.findAll();
        List<Integer> collect = allItems.stream()
                .map(Item::getId).toList();
        for (Integer integer : collect) {
            tracker.delete(integer);
        }
        out.println("=== Все заявки удалены ===");
        LOG.trace("Deleting all items complete in " + (System.currentTimeMillis() - startTime) + "ms");
        return true;
    }
}
