public class Account {
    private String accountName;
    private double balance;
    public Account(String accountName, double initialBalance) {
        this.accountName = accountName;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        }
    }
    public double getBalance() {
        return balance;
    }
    public void credit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Credited: " + amount);
        } else {
            System.out.println("Invalid credit amount. Amount must be greater than 0.");
        }
    }
    public void debit(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Debited: " + amount);
            } else {
                System.out.println("Debit amount exceeded account balance. Balance unchanged.");
            }
        } else {
            System.out.println("Invalid debit amount. Amount must be greater than 0.");
        }
    }
}
