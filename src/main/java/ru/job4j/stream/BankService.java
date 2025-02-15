package ru.job4j.stream;

import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users;

    public BankService(Map<User, List<Account>> users) {
        this.users = users;
    }

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(u -> u.passport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        return users.get(user).stream()
                .filter(a -> a.requisite().equals(requisite))
                .findFirst()
                .orElse(null);
    }
}
