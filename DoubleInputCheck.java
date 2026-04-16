import java.util.InputMismatchException;
import java.util.Scanner;

public class DoubleInputCheck {
    public static double getValidDouble(Scanner scanner, String prompt) {
        double input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            try {
                input = scanner.nextDouble();
                scanner.nextLine();

                if (input >= 0) {
                    isValid = true;
                } else {
                    System.out.println("Error: Input cannot be negative.");
                }
            } catch (InputMismatchException e) {
                String badInput = scanner.nextLine();
                System.out.println("Error: Invalid input '" + badInput + "', please enter a valid number.");
            }
        }
        return input;
    }
}