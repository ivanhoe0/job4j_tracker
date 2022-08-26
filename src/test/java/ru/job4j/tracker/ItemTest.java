package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {
    @Test
    public void whenAscendingSort() {
        List<Item> items = Arrays.asList(
          new Item("Test1"),
          new Item("Test5"),
          new Item("Test3"),
          new Item("Test8")
        );
        List<Item> expected = Arrays.asList(
                new Item("Test1"),
                new Item("Test3"),
                new Item("Test5"),
                new Item("Test8")
        );
        Collections.sort(items, new ItemAscByName());
        assertEquals(items, expected);
    }

    @Test
    public void whenDescendingSort() {
        List<Item> items = Arrays.asList(
                new Item("Test1"),
                new Item("Test5"),
                new Item("Test3"),
                new Item("Test8")
        );
        List<Item> expected = Arrays.asList(
                new Item("Test8"),
                new Item("Test5"),
                new Item("Test3"),
                new Item("Test1")
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(items, expected);
    }
}