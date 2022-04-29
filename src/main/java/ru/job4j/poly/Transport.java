package ru.job4j.poly;

public interface Transport {
    void going();

    void passengers(int amount);

    float refuel(float amount);
}
