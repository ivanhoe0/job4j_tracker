package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int a) {
        return a - x;
    }

    public int divide(int a) {
        return a / x;
    }

    public int sunOfAllOperation(int a) {
        return sum(a) + minus(a) + divide(a) + multiply(a);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        result = sum(25);
        System.out.println(result);
        Calculator calc = new Calculator();
        result = calc.multiply(12);
        System.out.println(result);
        result = minus(122);
        System.out.println(result);
        result = calc.divide(45);
        System.out.println(result);
        result = calc.sunOfAllOperation(4);
        System.out.println(result);
    }

}
