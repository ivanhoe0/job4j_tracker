package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle buss = new Buss();
        Vehicle train = new Train();
        Vehicle[] vehicles = {plane, buss, train};
        for (Vehicle transports : vehicles) {
            transports.move();
        }

    }
}
