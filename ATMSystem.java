//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute
import java.util.Scanner;

public class ATMSystem {
    private static double balance = 1000.0; // Default balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        String pin = "1234";
        String enteredPin;

        System.out.println("Welcome to the Java ATM!");
        System.out.print("Enter your PIN: ");
        enteredPin = scanner.nextLine();

        if (!enteredPin.equals(pin)) {
            System.out.println("Incorrect PIN. Access denied.");
            return;
        }

        do {
            System.out.println("\n====== ATM Menu ======");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void checkBalance() {
        System.out.printf("Your current balance is: ₹%.2f%n", balance);
    }

    public static void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("₹%.2f deposited successfully.%n", amount);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    public static void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("₹%.2f withdrawn successfully.%n", amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
