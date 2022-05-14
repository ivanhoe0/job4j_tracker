package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void going() {
        System.out.println("Bus go");
    }

    @Override
    public void passengers(int amount) {
        System.out.println(amount);
    }

    @Override
    public float refuel(float amount) {
        return 50 * amount;
    }
}
