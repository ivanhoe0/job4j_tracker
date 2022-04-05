package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student vasya = new Student();
        vasya.setFio("Иванов Василий Петрович");
        vasya.setGroup("4-204б");
        vasya.setEnrollment(new Date());
        System.out.println("ФИО: " + vasya.getFio() + "\nГруппа: " + vasya.getGroup() + "\nДата поступления: " + vasya.getEnrollment());
    }
}
