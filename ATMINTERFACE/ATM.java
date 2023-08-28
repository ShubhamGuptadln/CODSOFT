package ATMINTERFACE;
import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;
    private Scanner scanner;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            if (!checkPin()) {
                continue;
            }
            break;
        }

        int choice;
        do {
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a Nice Day!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    // Check the PIN entered by the user
    public boolean checkPin() {
        System.out.print("\nEnter Your Pin: ");
        int enteredPin = scanner.nextInt();
        if (enteredPin != bankAccount.getPin()) {
            System.out.print("Invalid Pin!! Enter Valid Pin...");
            return false;
        }
        displayMenu();
        return true;
    }

    // ATM Menu
    private void displayMenu() {
        System.out.println();
        System.out.println("\t\t +--------------------+ \t\t");
        System.out.println("\t\t |   Welcome to ATM   | \t\t");
        System.out.println("\t\t +--------------------+ \t\t");
        System.out.println();
        System.out.println("1. Withdraw Money");
        System.out.println("2. Deposit Money");
        System.out.println("3. Check A/C Balance");
        System.out.println("4. EXIT");
        System.out.print("\nEnter your choice: ");
    }

    // Method for withdraw the money from the bank account
    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        boolean success = bankAccount.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
        checkBalance();
    }

    // Method for deposit the money in the bank account
    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        bankAccount.deposit(amount);
        System.out.println("Deposit successful.");
        checkBalance();
    }

    // Method to check the a/c balance
    private void checkBalance() {
        double balance = bankAccount.getBalance();
        System.out.println("Current balance: " + balance);
        displayMenu();
    }

    public static void main(String[] args) {
        // Create a bank account with initial balance of 10000
        BankAccount bankAccount = new BankAccount(10000);

        // Create an ATM instance with the bank account
        ATM atm = new ATM(bankAccount);

        // Start the ATM interface
        atm.start();
    }
}

