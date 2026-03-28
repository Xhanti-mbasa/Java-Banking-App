import java.util.Scanner;

public class Client {

    private Scanner scanner = new Scanner(System.in);
    private Bank myBank = new Bank();

    public void startMenu() {
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Show Balance\n2. Deposit\n4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
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
                case 4 -> isRunning = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}