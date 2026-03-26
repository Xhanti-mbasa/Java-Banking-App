import java.util.Scanner;

public class Client {
    private Scanner scanner = new Scanner(System.in);
    private Bank myBank = new Bank();

    public void startMenu() {
        case 2 -> {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();

            if (myBank.deposit(amount)) {
                System.out.println("Deposit succesful!");
            } else {
                System.out.println("Error: Please enter a positive number.");
            }
        }
    }
}