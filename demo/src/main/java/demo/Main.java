package demo;

public class Main {
    public static void main(String[] args) {

        //Paintwalls question
        // int paintcost[] = {2,3,4,2};
        // int painttime[] = {1,1,1,1};
        // Painters p = new Painters();
        // int cost = p.paintwalls(paintcost, painttime);
        // System.out.println("The total cost is " + cost);

        //To do List app
        // Todo todo = new Todo();
        // todo.todo_app();

        //Merge sort using thread pool 
        // int[] array = {12, 4, 5, 6, 7, 3, 1, 15, 10, 9, 8, 11, 2, 14, 13};
        // Threadpoolmergesort threadsort = new Threadpoolmergesort();        
        // threadsort.thread(array);

        //Bank simulation using threads
        // Bank bank = new Bank(1000);
        // Account ac1 = new Account(bank);
        // Account ac2 = new Account(bank);
        // Thread th1 = new Thread(ac1);
        // Thread th2 = new Thread(ac2);
        // th1.start();
        // th2.start();
        // try{
        //     th1.join();
        //     th2.join();
        // }
        // catch(InterruptedException e){
        //     e.printStackTrace();
        // }
        // System.out.println("Final balance: $"+ bank.getbalance());

        //count_vowels_permutation
        count_vowels vowelscount = new count_vowels();
        vowelscount.countvowelPermutation(5);
    }
}