public class Bank {
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public boolean Withdraw(double amount) {
        //Math for withdrawing.
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            return true; //succes
        }
        return false; //failed
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }
}
