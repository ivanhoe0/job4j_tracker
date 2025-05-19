package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceItemAndFindByIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("item1");
        Item itemTwo = new Item("itemForReplace");
        tracker.add(itemOne);
        tracker.replace(itemOne.getId(), itemTwo);
        assertThat(tracker.findById(itemTwo.getId())).isEqualTo(itemTwo);
    }

    @Test
    public void whenDeleteItemAndFindByIdThenMustBeNull() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        tracker.delete(item.getId());
        assertThat(tracker.findById(item.getId())).isNull();
    }

    @Test
    public void whenFindALlItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("item1");
        Item itemTwo = new Item("item2");
        Item itemThree = new Item("item3");
        tracker.add(itemOne);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        List<Item> expected = List.of(
                itemOne,
                itemTwo,
                itemThree
        );
        assertThat(tracker.findAll()).isEqualTo(expected);
    }

    @Test
    public void whenFindItemByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item itemOne = new Item("item1");
        tracker.add(itemOne);
        assertThat(tracker.findByName(itemOne.getName())).isEqualTo(List.of(itemOne));
    }
}