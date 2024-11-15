import java.util.Scanner;

class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        this.balance = initialBalance;

    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance = balance+amount;
            System.out.println("Deposit successful and the final balance is " +balance);
        }
        else{
            System.out.println("Invalid deposit amount");
        }
    }
    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance = balance - amount;
                System.out.println("Withdrawl successful " + "New balance " + balance);
                return true;
            } else {
                System.out.println("Insufficient balance for withdrawl " + "current balance is : " + balance);

            }
        } else {
            System.out.println("Invalid withdrawl amount. Please enter a positive amount");
        }
        return false;

    }
}

class ATM{
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount){
        this.bankAccount = bankAccount;
    }
    public void displayMenu(){
        System.out.println("ATM Menu");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawl");
        System.out.println("4. Exit");
    }
    public void run(){
        Scanner sc = new Scanner(System.in);
        while(true){
            displayMenu();
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                System.out.println("Current Balance :" + bankAccount.getBalance());
                break;

                case 2:
                System.out.println("Enter the deposit amount");
                double depositAmount = sc.nextDouble();
                bankAccount.deposit(depositAmount);
                break;

                case 3:
                System.out.println("Enter the withdrawl amount");
                double withdrawlAmount = sc.nextDouble();
                boolean withdrawSuccess = bankAccount.withdraw(withdrawlAmount);
                if(withdrawSuccess){
                    System.out.println("Withdrawl successful");
                }
                break;

                case 4:
                System.out.println("Thank you for using ATM. Goodbye!");
                return;

                default:
                    System.out.println("Invalid choice: Please try again");



            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(4000);
        ATM atm = new ATM(userAccount);
        atm.run();

    }
}
