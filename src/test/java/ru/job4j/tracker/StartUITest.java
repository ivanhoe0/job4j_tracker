package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Test", "Fix Pc"};
        Tracker tracker = new Tracker();
        Input input = new StubInput(answers);
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Test");
        assertThat(created.getName(), is(expected.getName()));
        StartUI.createItem(input, tracker);
        created = tracker.findAll()[1];
        expected = new Item("Fix Pc");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item newItem = new Item("New Item");
        tracker.add(newItem);
        String[] answers = {String.valueOf(newItem.getId()), "Edited Item"};
        Input input = new  StubInput(answers);
        StartUI.editItem(input, tracker);
        Item edited = tracker.findById(newItem.getId());
        Item expected = new Item("Edited Item");
        assertThat(edited.getName(), is(expected.getName()));
    }

    @Test
    public void whenDelteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertThat(deleted, is(nullValue()));
    }

}