package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> names = new HashMap<>();
        names.put("ewf@yandex.ru", "Ivanov Ivan");
        names.put("dostoevskiy.@mail.ru", "Dostoevskiy Fedor Michailovich");
        for (String key : names.keySet()) {
            String value = names.get(key);
            System.out.println("Key = " + key + "; value = " + value);
        }
    }
}
