package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
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

}