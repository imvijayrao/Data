package demo;

import java.util.ArrayList;
import java.util.Scanner;

public class Todo {
    
    private static ArrayList<String> tasks = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public void todo_app(){
        int choice;

        do{
            System.out.println("===== To-Do List Application =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1: 
                    addTask();
                    break;

                case 2: 
                    viewTasks();
                    break;

                case 3: 
                    markTaskAsDone();
                    break;

                case 4: 
                    deletetask();
                    break;

                case 0:
                    System.out.println("Exiting the application. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }while(choice!=0);

        sc.close();
    }

    private static void addTask(){
        System.out.print("Enter the task: ");
        String task = sc.nextLine();
        tasks.add(task);
    }

    private static void viewTasks(){
        System.out.println("===== Tasks =====");
        for(int i=0;i<tasks.size();i++){
            System.out.println((i+1)+". "+tasks.get(i));
        }
        System.out.println("=================");
    }

    private static void markTaskAsDone(){
        viewTasks();
        System.out.print("Enter the task number to mark as done: ");
        int taskno = sc.nextInt();
        if(isvalidtaskno(taskno)){
            String task = tasks.get(taskno-1);
            tasks.set(taskno-1,"[Done] "+task);
            System.out.println("Task marked as done!");
        }
        else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private static void deletetask(){
        viewTasks();
        System.out.print("Enter the task number to delete: ");
        int taskno = sc.nextInt();
        if(isvalidtaskno(taskno)){
            tasks.remove(taskno-1);
            System.out.println("Task deleted successfully!");
        }
        else {
            System.out.println("Invalid task number. Please try again.");
        }
    }

    private static boolean isvalidtaskno(int taskno){
        return taskno >=1 && taskno <= tasks.size();
    }
}
