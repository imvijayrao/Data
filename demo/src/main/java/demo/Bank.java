package demo;
public class Bank {
    private double balance;

    public Bank(double balance){
        this.balance = balance;
    }

    public synchronized void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited: $"+amount+", New Balance: $"+balance);
    }

    public synchronized void withdraw(double amount){
        if(amount<=balance) {
            balance -= amount;
            System.out.println("Withdrawn: $"+amount+", New Balance: $"+balance);
        }
        else {
            System.out.println("Insufficient funds for withdrawal: $" + amount);
        }
    }

    public double getbalance(){
        return balance;
    }
 
}
