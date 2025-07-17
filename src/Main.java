import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Java Banking System

        //Declare Variable
        double balance = 0;
        boolean isRunning = true;
        int choice;
        while(isRunning){
            //Display Menu
            System.out.println("Welcome to Bank of Harshit");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Quit");

            //Get and Process User choice

            System.out.println("Please enter you choice ");
            choice = sc.nextInt();


            switch (choice) {
                //Use '->'(Only run particular line) instead
                // ':'(Runs all line from that particular Line
                // if break not used
                case 1 -> showBalance(balance);
                case 2 -> balance += deposit();
                case 3 -> balance -= withdraw(balance);
                case 4 -> {
                    isRunning = false;
                    exit(); //For quiting the loop
                }
                default -> System.out.println("INVALID CHOICE");
            }
        }
        sc.close();
    }
    //showBalance()
    static void showBalance(double balance){
        System.out.printf("Rs%.2f\n", balance);
    }

    //deposit()
    static double deposit(){
        double amount;
        System.out.println("Enter an amount to be Deposited: ");
        amount = sc.nextDouble();

        if(amount < 0){
            System.out.println("Amount can't be negative");
            return 0;
        } else{
            return amount;
        }

    }

    //withdraw()
    static double withdraw(double balance){
        double amount;
        System.out.println("Enter amount to be withdrawn: ");
        amount = sc.nextDouble();

        if(amount > balance){
            System.out.println("INSUFFICIENT BALANCE");
            return 0;
        } else if (amount < 0){
            System.out.println("Amount can't be negative");
            return 0;
        } else {
            return amount;
        }
    }

    //Exit Message
    static void exit(){
        System.out.println("Thank you! Have a nice day, Exited...");
    }
}