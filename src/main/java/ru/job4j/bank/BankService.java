package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.*;

/**
 * Класс описывает работу банка, которую он проводит с клиентами и их счетами (добавление нового клиента в базу,
 * заведение клиенту счета, поиск клиента по паспортным данным, перевод денег со счета на счет).
 * @version 1.0
 */
public class BankService {
    /**
     * Список счетов каждого клиента хранится в колекции типа ArrayList.
     * Хранение пар клиент - список счетов клиента осуществляется при помощи колекции типа HashMap.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод проверяет на наличие указанного клиента в хранилище счетов и если его там нет то добавляет его.
     * @param user клиент для добавления
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод находит клиента по указанным паспортным данным и добавляет указанный счет в список счетов этого клиента
     * @param passport паспортные данные клиента которму добавляется новый счет
     * @param account счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !users.get(user).contains(account)) {
            users.get(user).add(account);
        }
    }

    /**
     * Метод принимает на вход паспортные данные клиента и ищет его в хранилище.
     * @param passport указанные паспортные данные
     * @return возвращает пользоваетлся с указанными паспортными данными или null если пользователя с такими данными нет
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспортные данные и реквизиты счета и ищет у клиента с указанными паспортными данными указанный счет.
     * @param passport паспортные данные клиента
     * @param requisite реквизиты счета
     * @return возвращает счет или null если пользователя с такими паспортными данными не существует или если счета с такими реквищитами не найдено
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход паспортные данные и реквизиты счета клиента со счета которого будет происходить списание денег,
     * паспортные данные и реквизиты счета клиента на счет которого эти денежные средства будут переведены, а также сумму перевода.
     * Метод проверяет доступна ли указанная сумма списания на счете клиента.
     * @param srcPassport паспортные данные клиента со счета которого будут переведены деньги
     * @param srcRequisite реквизиты счета с которого будут переведены деньги
     * @param destPassport паспортные данные клиента на счет которого будут переведены деньги
     * @param destRequisite реквизиты счета на который будут переведены деньги
     * @param amount сумма перевода
     * @return возваращет true если сумма списания меньше чем доступные средства указанного
     * клиента и false если сумма превышает доступные средства или по указанным данным не удалось найти счета для списания или пополнения
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount && destAccount != null) {
            rsl = true;
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            destAccount.setBalance(destAccount.getBalance() + amount);
        }
        return rsl;
    }

    /**
     * Метод позволяет получить счета у клиента переданного на вход
     * @param user клиент счета которого необходимо получить
     * @return возвращает список счетов указанного клиента в виде коллекции List
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
