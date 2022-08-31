package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель данных - счет в банке, который имеет баланс и реквизиты счета.
 * @version 1.0
 */
public class Account {
    /**
     * Переменная в которой хранится информация о реквизите счета
     */
    private String requisite;
    /**
     * Переменная хранит текущий баланс счета
     */
    private double balance;

    /**
     * Конструктор для создания объекта класса Account
     * @param requisite реквизиты для создаваемого объекта
     * @param balance баланс создаваемого объекта
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
