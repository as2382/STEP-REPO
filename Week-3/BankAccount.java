public class BankAccount {
    // ----------------------------
    // Static variables (shared by ALL accounts)
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    // Instance variables (unique for EACH account)
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++; // every time we create an account, count increases
    }

    // ----------------------------
    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("----------------------");
    }

    // ----------------------------
    // Instance methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println(accountHolder + " deposited $" + amount + ". New balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance for " + accountHolder);
        }
    }

    public double calculateInterest() {
        return balance * (interestRate / 100);
    }

    public void displayAccountInfo() {
        System.out.println("Account Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Estimated Interest: $" + calculateInterest());
        System.out.println("----------------------");
    }

    // ----------------------------
    // Main method
    public static void main(String[] args) {
        // Set static members (shared across all accounts)
        BankAccount.setBankName("Global Trust Bank");
        BankAccount.setInterestRate(5.0);

        // Create individual accounts (each has unique details)
        BankAccount acc1 = new BankAccount("A001", "Alice", 1000.0);
        BankAccount acc2 = new BankAccount("A002", "Bob", 2000.0);
        BankAccount acc3 = new BankAccount("A003", "Charlie", 1500.0);

        // Deposit & withdraw (instance-level operations)
        acc1.deposit(500);
        acc2.withdraw(300);
        acc3.deposit(1000);

        // Display account info (instance members are unique)
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();
        acc3.displayAccountInfo();

        // Display bank info (static members are shared)
        BankAccount.displayBankInfo();
        // Total accounts created
        System.out.println("Total bank accounts created: " + BankAccount.getTotalAccounts());
        
    }
}
