package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscByName() {
        Comparator<Job> cmp = new JobAscByName();
        int rsl = cmp.compare(
                new Job("Test Task", 2),
                new Job("A", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> cmp = new JobDescByName();
        int rsl = cmp.compare(
                new Job("Test Task", 2),
                new Job("A", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> cmp = new JobDescByPriority();
        int rsl = cmp.compare(
                new Job("Test Task", 2),
                new Job("A", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> cmp = new JobAscByPriority();
        int rsl = cmp.compare(
                new Job("Test Task", 2),
                new Job("A", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscByPriorityAndName() {
        Comparator<Job> cmp = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmp.compare(
                new Job("Test Task", 2),
                new Job("A", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscByPriorityAndName2() {
        Comparator<Job> cmp = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = cmp.compare(
                new Job("Test Task", 1),
                new Job("A", 2)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByNameAndDescByPriority() {
        Comparator<Job> cmp = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmp.compare(
                new Job("Test Task", 1),
                new Job("A", 2)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}