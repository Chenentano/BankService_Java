package org.example;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankService {

    private int nextAccountNumber = 0;
    private Map<String, Account> accounts;

    public BankService() {
        this.accounts = new HashMap<>();
    }

    public String createAccount(Client client) {
        String accountNumber = String.valueOf(nextAccountNumber++);
        Account account = new Account(accountNumber, BigDecimal.ZERO, client);
        accounts.put(accountNumber, account);
        return accountNumber;
    }

    public void transferAmount(String senderAccountNumber, String receiverAccountNumber, BigDecimal amount) {
        Account fromAccount = accounts.get(senderAccountNumber);
        Account receiverAccount = accounts.get(receiverAccountNumber);

        if (fromAccount != null && receiverAccount != null) {
            BigDecimal senderBalance = fromAccount.getAccountBalance();
            if (senderBalance.compareTo(amount) >= 0) {
                fromAccount.withdrawMoney(amount);
                receiverAccount.depositMoney(amount);
                System.out.println("Transfer successful: $" + amount + " transferred from account " + senderAccountNumber + " to account " + receiverAccountNumber);
            } else {
                System.out.println("Transfer failed: Insufficient funds in account " + senderAccountNumber);
            }
        } else {
            System.out.println("Transfer failed: Invalid account numbers.");
        }
    }
}