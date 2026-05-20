package operations.client;

import operations.bank.AccountCreation;
import operations.bank.Bank;

import java.util.Scanner;

public class Client {

    private final Scanner scanner = new Scanner(System.in);
    private final Bank myBank = new Bank();

    public void startMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Show Balance\n2. Deposit\n3. Withdraw\n4. MYZAR\n5. New Member\n6. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    double currentBalance = myBank.getBalance();
                    System.out.println("****************");
                    System.out.printf("Current Balance $%.2f\n", currentBalance);
                    System.out.println("****************");
                }
                case 2 -> {
                    try {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();

                        if (myBank.deposit(amount)) {
                            System.out.println("Deposit successful!");
                        } else {
                            System.out.println("Error: Please enter a positive number.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter a number.");
                        scanner.next();
                    }
                }
                case 3 -> {
                    try {
                        System.out.println("How much would you like to withdraw? ");
                        double amount = scanner.nextDouble();

                        if (myBank.withdraw(    amount)) {
                            System.out.println("Withdraw successful! Please take your cash.");
                        } else {
                            System.out.println("Error: Invalid amount or insufficient funds.");
                            System.out.printf("Available Balance: $%.2f\n", myBank.getBalance());
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input! Please enter a numeric value.");
                        scanner.next();
                    }
                }
                case 4 -> {
                    try {
                        operations.ai.Myzar.askAi();
                    } catch (Exception e){
                        System.out.println("Sorry but MYZAR can't help with that.");
                    }
                }
                case 5 -> {
                    try {
                        AccountCreation accountCreation = new AccountCreation();
                        accountCreation.information();
                        System.out.println("New member added successfully!");
                    } catch (Exception e) {
                        System.out.println("Error creating new member: " + e.getMessage());
                    }
                }
                case 6 -> isRunning = false;

                default -> System.out.println("Invalid choice.");
            }
        }
    }
}