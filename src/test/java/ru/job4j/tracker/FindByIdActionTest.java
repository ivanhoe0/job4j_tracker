package ru.job4j.tracker;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class FindByIdActionTest {
    @Test
    void whenFindSuccessfully() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item item = new Item("ItemForFind");
        store.add(item);
        FindByIdAction action = new FindByIdAction(output);
        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);
        String ln = System.lineSeparator();
        assertThat(action.execute(input, store)).isTrue();
        assertThat(output.toString()).isEqualTo("===== Find by id ======" + ln
        + item + ln);
    }

    @Test
    void whenItemIsNotFound() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        Item item = new Item("ItemForFind");
        store.add(item);
        FindByIdAction action = new FindByIdAction(output);
        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(10);
        String ln = System.lineSeparator();
        assertThat(action.execute(input, store)).isTrue();
        assertThat(output.toString()).isEqualTo("===== Find by id ======" + ln
                + "Заявка с введенным id: " + 10 + " не найдена." + ln);
    }
}