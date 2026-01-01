package system.BankingSystem;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        boolean running = true;
        showMenu();
        while(running){

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1 -> System.out.println("Login feature");
                case 2 -> System.out.println("create account feature");
                case 0 -> {
                    System.out.println("exiting...");
                    running = false;
                }
            }
        }

    }

    public static void showMenu(){
        System.out.println("=============================");
        System.out.println("    Welcome to MyBank");
        System.out.println("=============================");
        System.out.println("1. Login");
        System.out.println("2. Create Account");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Transfer");
        System.out.println("6. View Balance");
        System.out.println("7. Transaction History");
        System.out.println("0. Exit");
        System.out.println("=============================");
        System.out.print("Enter choice: ");
    }
}
