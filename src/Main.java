import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Java Banking System
        UserInfo userInfo = new UserInfo();

        userInfo.run();


    }

    public static void process(User user) {
        boolean isRunning = true;
        Scanner sc = new Scanner(System.in);
        int choice;

        while (isRunning) {
            System.out.println("\nWelcome " + user.getUserName());
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.printf("Rs%.2f\n", user.getBalance());
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amt = sc.nextDouble();
                    if (amt > 0) user.deposit(amt);
                    else System.out.println("Invalid amount.");
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amt = sc.nextDouble();
                    if (amt < 0) System.out.println("Invalid amount.");
                    else if (!user.withdraw(amt)) System.out.println("INSUFFICIENT BALANCE");
                }
                case 4 -> {
                    isRunning = false;
                    System.out.println("Logged out successfully.\n");
                }
                default -> System.out.println("INVALID CHOICE");
            }
        }
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
        UserInfo userInfo = new UserInfo();
        System.out.println("Thank you! Have a nice day, Exited...");
        userInfo.run();
    }
}