package org.example;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        // Creating clients
        Client client0 = new Client("Bastian", "Bas", 0);
        Client client1 = new Client("Rocky", "Rockstar", 1);

        // Creating a bank service
        BankService bankService = new BankService();

        // Creating accounts for clients
        String accountNumber1 = bankService.createAccount(client0);
        String accountNumber2 = bankService.createAccount(client1);

        // Depositing initial funds
        BigDecimal initialFunds = new BigDecimal("444.44");
        bankService.transferAmount(null,accountNumber1, initialFunds);

        // Transfer money from account1 to account2
        BigDecimal transferAmount = new BigDecimal("222.22");
        bankService.transferAmount(accountNumber1, accountNumber2, transferAmount);

    }
}