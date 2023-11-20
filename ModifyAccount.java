public class ModifyAccount {
    public static void main(String[] args) {
        Account myAccount = new Account("Uday Kumar", 1000);
        System.out.println("Initial Balance: " + myAccount.getBalance());
        myAccount.debit(500);
        System.out.println("Updated Balance: " + myAccount.getBalance());
        myAccount.debit(800);
        System.out.println("Balance after second debit: " + myAccount.getBalance());
    }
}
