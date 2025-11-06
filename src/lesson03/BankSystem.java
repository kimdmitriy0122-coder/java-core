package lesson03;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Data
public class BankSystem {
    private static final List<Account> accounts = new ArrayList<>();

    public Account getAccountInfo(int accountNumber) {
        /**
         * getAccountInfo с параметром Account не нужен, т.к. тогда можно просто sout(account)
         * */
        return accounts.stream().filter(account -> account.getAccountNumber() == accountNumber).findFirst().orElse(null);
    }
    public void addAccount(Account account) {
        accounts.add(account);
    }
    public void addAccount(int accountNumber, double balance, String fio) {
        accounts.add(new Account(accountNumber, balance, fio));
    }
    public void deleteAccount(Account account) {
        if(accounts.size() == 0)
            throw new NoAccountsAvailableException();
        accounts.remove(account);
    }
    public void deleteAccount(int accountNumber) {
        accounts.removeIf(account -> account.getAccountNumber() == accountNumber);
    }
    public void replenishAccount(Account account, double sum){
        Account c = accounts.get(accounts.indexOf(account));
        if(c == null)
            throw new NoSuchAccountException();
        c.setBalance(c.getBalance() + sum);
    }
    public void replenishAccount(int accountNumber, double sum){
        Account c = accounts.stream().filter(account -> account.getAccountNumber() == accountNumber).findFirst().orElse(null);
        if(c == null)
            throw new NoSuchAccountException();
        c.setBalance(c.getBalance() + sum);
    }
    public void transferMoneyBetweenAccounts(int fromAccountNumber, int toAccountNumber, double sum){
        Account accountA = accounts.stream().filter(account -> account.getAccountNumber() == fromAccountNumber).findFirst().orElse(null);
        Account accountB = accounts.stream().filter(account -> account.getAccountNumber() == toAccountNumber).findFirst().orElse(null);
        if(accountA == null || accountB == null)
            throw new NoSuchAccountException();
        accountA.setBalance(accountA.getBalance() - sum);
        accountB.setBalance(accountB.getBalance() + sum);
    }
    public void transferMoneyBetweenAccounts(Account a, Account b, double sum){
        Account accountA = accounts.get(accounts.indexOf(a));
        Account accountB = accounts.get(accounts.indexOf(b));
        if(accountA == null || accountB == null)
            throw new NoSuchAccountException();
        accountA.setBalance(accountA.getBalance() - sum);
        accountB.setBalance(accountB.getBalance() + sum);
    }
    @Data
    @AllArgsConstructor
    class Account {
        private int  accountNumber;
        private double balance;
        private String fio;
    }

    class NoAccountsAvailableException extends RuntimeException {
        private String message = "No accounts available";
    }

    class NoSuchAccountException extends NoSuchElementException {
        private String message = "No such account";
    }
}

