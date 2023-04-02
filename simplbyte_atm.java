import java.util.ArrayList;
import java.util.Scanner;

public class simplbyte_atm {

    // Initialize account balance
    private static double balance = 0;

    // Keep track of transaction history
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Display options menu
        boolean quit = false;
        do {
            System.out.println("Please select an option:");
            System.out.println("1. View transaction history");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    viewTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ₹");
                    double withdrawAmount = input.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ₹");
                    double depositAmount = input.nextDouble();
                    deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter amount to transfer: ₹");
                    double transferAmount = input.nextDouble();
                    System.out.print("Enter recipient's account number: ");
                    int recipientAccountNumber = input.nextInt();
                    transfer(transferAmount, recipientAccountNumber);
                    break;
                case 5:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (!quit);

        System.out.println("Thank you for using this ATM.");
    }

    // View transaction history
    private static void viewTransactionHistory() {
        System.out.println("Transaction history:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    // Withdraw from account
    private static void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            String transaction = "Withdraw: ₹" + amount;
            transactionHistory.add(transaction);
            System.out.println("Withdrawal successful. New balance: ₹" + balance);
        }
    }

    // Deposit into account
    private static void deposit(double amount) {
        balance += amount;
        String transaction = "Deposit: ₹" + amount;
        transactionHistory.add(transaction);
        System.out.println("Deposit successful. New balance: ₹" + balance);
    }

    // Transfer between accounts
    private static void transfer(double amount, int recipientAccountNumber) {
        if (balance < amount) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            String transaction = "Transfer: ₹" + amount + " to account #" + recipientAccountNumber;
            transactionHistory.add(transaction);
            System.out.println("Transfer successful. New balance: ₹" + balance);
        }
    }
}