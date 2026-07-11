package operations.client;

import operations.bank.AccountCreation;
import operations.bank.Bank;
import java.util.logging.Logger;


import java.util.Scanner;

public class Client {
      Logger logger = Logger.getLogger(getClass().getName());


    private final Scanner scanner = new Scanner(System.in);
    private final Bank myBank = new Bank();

    public void startMenu() {
        boolean isRunning = true;

        while (isRunning) {
            logger.info("1. Show Balance\n2. Deposit\n3. Withdraw\n4. MYZAR\n5. New Member\n6. Exit");
    logger.info("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    double currentBalance = myBank.getBalance();
                    logger.info("****************");
                    System.out.printf("Current Balance $%.2f\n", currentBalance);
                    logger.info("****************");
                }
                case 2 -> {
                    try {
                        logger.info("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();

                        if (myBank.deposit(amount)) {
                            logger.info("Deposit successful!");
                        } else {
                            logger.info("Error: Please enter a positive number.");
                        }
                    } catch (Exception e) {
                        logger.info("Invalid input! Please enter a number.");
                        scanner.next();
                    }
                }
                case 3 -> {
                    try {
                        logger.info("How much would you like to withdraw? ");
                        double amount = scanner.nextDouble();

                        if (myBank.withdraw(    amount)) {
                            logger.info("Withdraw successful! Please take your cash.");
                        } else {
                            logger.info("Error: Invalid amount or insufficient funds.");
                            logger.info("Available Balance: $" + String.format("%.2f", myBank.getBalance()));
                        }
                    } catch (Exception e) {
                        logger.info("Invalid input! Please enter a numeric value.");
                        scanner.next();
                    }
                }
                /*case 4 -> {
                    // TODO: Fix Myzar.askAi() when google-genai dependency is available
                    // try {
                    //     operations.ai.Myzar.askAi();
                    // } catch (Exception e){
                    //     logger.info("Sorry but MYZAR can't help with that.");
                    // }
                    System.out.println("MYZAR AI feature is temporarily unavailable.");
                } */
                case 5 -> {
                    try {
                        AccountCreation accountCreation = new AccountCreation();
                        accountCreation.information();
                        logger.info("New member added successfully!");
                    } catch (Exception e) {
                        logger.info("Error creating new member: " + e.getMessage());
                    }
                }
                case 6 -> isRunning = false;

                default -> logger.info("Invalid choice.");
            }
        }
    }
}

