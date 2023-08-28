package ATMINTERFACE;
//Shubham Gupta

public class BankAccount {
    private double balance;
    private static final int PIN = 4321;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public int getPin() {
        return PIN;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

