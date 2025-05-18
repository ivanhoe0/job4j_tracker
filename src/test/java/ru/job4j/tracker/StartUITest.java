package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new Exit()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "New item name", "1"}
        );
        List<UserAction> actions = List.of(
                new EditAction(output),
                new Exit()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = List.of(
                new DeleteAction(output),
                new Exit()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Test"));
        String newName = "Edited item";
        List<UserAction> actions = List.of(
                new EditAction(output),
                new Exit()
        );
        String[] answers = {
                "0", String.valueOf(item.getId()), newName, "1"
        };
        Input input = new StubInput(answers);
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0. Edit item" + ln
                + "1. Exit Program" + ln
                + "===== Edit item =====" + ln
                + "Заявка изменена успешно." + ln
                + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindAllActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("Test1"));
        Item two = tracker.add(new Item("Test2"));
        List<UserAction> actions = List.of(
                new ShowAllAction(output),
                new Exit()
        );
        String[] answers = {
                "0", "1"
        };
        Input input = new StubInput(answers);
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(
                output.toString(), is(
                        "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                        + "===== Show all Items =====" + ln
                        + one + ln
                        + two + ln
                        + "Menu:" + ln
                        + "0. Show all items" + ln
                        + "1. Exit Program" + ln
                ));
    }

    @Test
    public void whenFindByNameActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Test"));
        List<UserAction> actions = List.of(
                new FindByNameAction(output),
                new Exit()
        );
        String[] answers = {
                "0", item.getName(), "1"
        };
        Input input = new StubInput(answers);
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0. Find item by name" + ln
                + "1. Exit Program" + ln
                + "===== Find by name =====" + ln
                + item + ln
                + "Menu:" + ln
                + "0. Find item by name" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenFindByIdActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Test"));
        List<UserAction> actions = List.of(
                new FindByIdAction(output),
                new Exit()
        );
        String[] answers = {
                "0", String.valueOf(item.getId()), "1"
        };
        Input input = new StubInput(answers);
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
                + "===== Find by id ======" + ln
                + item + ln
                + "Menu:" + ln
                + "0. Find item by id" + ln
                + "1. Exit Program" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new Exit());
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Exit Program" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Exit Program" + ln
                )
        );
    }

}