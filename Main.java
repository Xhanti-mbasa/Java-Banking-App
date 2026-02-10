import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // JAVA BANKING PROGRAM


        // DISPLAY VARIABLES
        double balance = 0;
        boolean isRunning = true;
        int choice;

        // DISPLAY MENU
        while(isRunning){
            System.out.println("***************");
            System.out.println("BANKING PROGRAM");
            System.out.println("***************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("***************");

            // GET AND PROCESS USERS CHOICE
            System.out.print("Enter your choice (1-4): ");
            choice = scanner.nextInt();

            switch(choice){
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> System.out.println("WITHDRAW");
                case 4 -> isRunning = false;
                default -> System.out.println("INVALID CHOICE");
            }
        }
        // showBalance()



        // withdraw()
        //Betty waz her
        //EXIT MESSAGE
        scanner.close();
    }
    // showBalance()
    static void showBalance(double balance){
        System.out.println("***************");
        System.out.printf("$%.2f\n", balance); //Limit the decimal places to 2 by using $.2%f (% is just a place holder.
    }
    // deposit()
    static double deposit(){
        double amount;
        System.out.print("Enter an amount to be deposited; \n");
        amount = scanner.nextDouble();

        if(amount < 0){
            System.out.print("Amount can't be  negitave\n");
            return 0;
        }
        else{
            return amount;
        }
    }

}