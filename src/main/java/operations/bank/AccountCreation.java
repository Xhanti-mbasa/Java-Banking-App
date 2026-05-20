package operations.bank;

import java.time.Year;
import java.util.Scanner;
import java.util.*;
import java.lang.*;

public class AccountCreation {
    public void information() {


        String name = "";
        String lastname = "";
        String streetname = "";
        int day = 0;
        int month = 0;
        int year = 0;
        long IdNumber = 0;

        Scanner scanner = new Scanner(System.in);
        int currentyear = Year.now().getValue();


        while (name.isEmpty() || lastname.isEmpty() || streetname.isEmpty() || day <= 0 || month <= 0 || year <= 0 || IdNumber <= 0) {
            if (name.isEmpty()) {
                System.out.println("Name : ");
                name = scanner.nextLine();
            }

            if (lastname.isEmpty()) {
                System.out.println("Last Name :");
                lastname = scanner.nextLine();
            }

            if (streetname.isEmpty()) {
                System.out.println(" Street Name :");
                streetname = scanner.nextLine();
            }

            if (day <= 0 || day > 31) {
                System.out.println("Day: ");
                try {
                    day = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: The day entered must be a valid day of the month between 1 and 31");
                    day = 0;
                }
            }
            if (month <= 0 || month > 12) {
                System.out.println("Month: ");
                try {
                    month = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: The month entered must be a valid month between 1 and 12");
                    month = 0;
                }
            }
            if (year <= 0 || (currentyear - year) < 16) {
                System.out.println("Year: ");
                try {
                    year = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: That's either not a valid year format i.e 1900 - 2025 or you're not old enough.");
                    year = 0;
                }
            }
            if (IdNumber <= 0 || String.valueOf(IdNumber).length() != 13) {
                System.out.println("ID Number: ");
                String idInput = scanner.nextLine();
                if (idInput.length() == 13) {
                    try {
                        IdNumber = Long.parseLong(idInput);
                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: ID must contain only numbers");
                        IdNumber = 0;
                    }
                } else {
                    System.out.println("ERROR: ID must be exactly 13 digits");
                    IdNumber = 0;
                }
            }
        }
    }
}
