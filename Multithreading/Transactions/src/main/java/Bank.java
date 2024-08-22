
import lombok.Setter;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class Bank {
    private final Map<String, Account> banAccount = new Hashtable<>();
    private final Map<String, Account> accounts = new Hashtable<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }


    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        if (accounts.get(fromAccountNum) != null && accounts.get(toAccountNum) != null) {
            System.out.println("Деньги " + accounts.get(fromAccountNum).getName() + " - " + accounts.get(fromAccountNum).getMoney());
            System.out.println("Деньги " + accounts.get(toAccountNum).getName() + " - " + accounts.get(toAccountNum).getMoney());
            if (amount > 50_000) {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                    synchronized (accounts) {

                        try {
                            banAccount.put(fromAccountNum, accounts.get(fromAccountNum));
                            banAccount.put(toAccountNum, accounts.get(toAccountNum));
                            System.out.println("Аккаунт " + accounts.get(fromAccountNum).getName() + " и Аккаунт " + accounts.get(toAccountNum).getName());
                            System.out.println("Были забаненны");
                            accounts.remove(fromAccountNum);
                            accounts.remove(toAccountNum);

                        } catch (NullPointerException nullPointerException) {
                            System.out.println("Аккауты в бане");
                            System.out.println((banAccount.get(fromAccountNum) != null && banAccount.get(toAccountNum) != null ?
                                    banAccount.get(fromAccountNum) + " - " + banAccount.get(toAccountNum) :
                                    banAccount.get(fromAccountNum) != null
                                            ? banAccount.get(fromAccountNum) + " в бане" :
                                            banAccount.get(toAccountNum) + " в бане" ));
                        }

                    }
                } else {
                    if (accounts.get(fromAccountNum) != null && accounts.get(toAccountNum) != null) {
                        if (accounts.get(fromAccountNum).getMoney() > amount) {
                            accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                            accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
                            System.out.println("Итог перевода: " + accounts.get(fromAccountNum).getName() + " " + accounts.get(fromAccountNum).getMoney());
                            System.out.println("Итог перевода: " + accounts.get(toAccountNum).getName() + " " + accounts.get(toAccountNum).getMoney());
                        } else System.out.println("Недостачно денег для перевода");
                    }

                }
            } else {
                if (accounts.get(fromAccountNum) != null && accounts.get(toAccountNum) != null) {
                    if (accounts.get(fromAccountNum).getMoney() > amount) {
                        accounts.get(fromAccountNum).setMoney(accounts.get(fromAccountNum).getMoney() - amount);
                        accounts.get(toAccountNum).setMoney(accounts.get(toAccountNum).getMoney() + amount);
                        System.out.println("Итог перевода: " + accounts.get(fromAccountNum).getName() + " " + accounts.get(fromAccountNum).getMoney());
                        System.out.println("Итог перевода: " + accounts.get(toAccountNum).getName() + " " + accounts.get(toAccountNum).getMoney());
                    } else System.out.println("Недостачно денег для перевода");
                }
            }
        } else if (banAccount.get(fromAccountNum) != null || banAccount.get(toAccountNum) != null) {
            System.out.println("Нельзя проводить операции с заблокированными пользователями");
        }


    }

    public void setAccounts(Account account) {
        accounts.put(account.getAccNumber(), account);
    }


    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        return 0;
    }
}
/**
 * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
 * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
 * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
 * усмотрение)
 * <p>
 * TODO: реализовать метод. Возвращает остаток на счёте.
 * <p>
 * TODO: реализовать метод. Возвращает остаток на счёте.
 * <p>
 * TODO: реализовать метод. Возвращает остаток на счёте.
 * <p>
 * TODO: реализовать метод. Возвращает остаток на счёте.
 * <p>
 * TODO: реализовать метод. Возвращает остаток на счёте.
 */


/**
 * TODO: реализовать метод. Возвращает остаток на счёте.
 */