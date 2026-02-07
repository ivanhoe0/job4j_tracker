package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class DeleteActionTest {

    @Test
    void whenItemWasDeletedSuccessfully() {
        Output output = new StubOutput();
        Store store = new MemTracker();
        store.add(new Item("ItemForDelete"));
        DeleteAction deleteAction = new DeleteAction(output);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(input, store);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "===== Delete item =====" + ln
                + "Заявка удалена успешно." + ln
        );

    }
}