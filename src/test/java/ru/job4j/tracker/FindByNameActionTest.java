package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class FindByNameActionTest {
    @Test
    void whenFindSuccessfully() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item item = new Item("ItemForFind");
        store.add(item);
        FindByNameAction action = new FindByNameAction(output);
        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("ItemForFind");
        String ln = System.lineSeparator();
        assertThat(action.execute(input, store)).isTrue();
        assertThat(output.toString()).isEqualTo("===== Find by name =====" + ln
                + item + ln);
    }

    @Test
    void whenNotFound() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item item = new Item("ItemForFind");
        store.add(item);
        FindByNameAction action = new FindByNameAction(output);
        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn("Test");
        String ln = System.lineSeparator();
        assertThat(action.execute(input, store)).isTrue();
        assertThat(output.toString()).isEqualTo("===== Find by name =====" + ln
                + "Заявки с именем " + "Test" + " не найдены" + ln);
    }
}