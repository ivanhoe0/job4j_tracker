package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                tmp.add(start + el);
                start += el + "/";
            }
        }
        rsl.addAll(tmp);
        return rsl;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }

    public static void main(String[] args) {
        List<String> deps = Arrays.asList(
                "K2/SK2",
                "K1/SK1/SSK1",
                "K2/SK2",
                "K2/SK2/SSK1"
        );
        sortAsc(deps);
        System.out.println(fillGaps(deps));
    }
}
