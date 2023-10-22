package demo;

public class Account implements Runnable{
    private Bank bank;

    public Account(Bank bank){
        this.bank = bank;
    }

    @Override
    public void run() {
        double amount = Math.random() * 100;
        bank.deposit(amount);
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        amount = Math.random() * 50;
        bank.withdraw(amount);
        try{
            Thread.sleep(100);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
