import java.util.Scanner;

@SuppressWarnings("ClassEscapesDefinedScope")
public class Main {/// The Main Class

//    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //Java Banking System
        //Created an object of userInfo class
        UserInfo userInfo = new UserInfo();
        //Calling run() method with the help of Reference object of UserInfo class
        userInfo.run();


    }

    public static void process(User user) {
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean isRunning = true;

        while (isRunning) {

            //Displaying Options on screen
            System.out.println("\nWelcome " + user.getUserName());
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Quit");

            //Taking user choice
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                //show balance
                case 1 -> System.out.printf("Rs%.2f\n", user.getBalance());
                //Making deposit
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amt = sc.nextDouble();
                    /// Only if amount is > 0
                    if (amt > 0) user.deposit(amt);//calling depsit method from User class
                    else System.out.println("Invalid amount.");
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amt = sc.nextDouble();
                    if (amt < 0) System.out.println("Invalid amount.");
                    else if (!user.withdraw(amt)) System.out.println("INSUFFICIENT BALANCE");//Calling withdraw method from User class
                }

                case 4 -> {
                    isRunning = false;
                    System.out.println("Logged out successfully.\n");
                }
                default -> System.out.println("INVALID CHOICE");
            }
        }
    }



    /// ---------These are my pre implemented logics which are not in use, implemented while learning---------- ///

/*    //showBalance()
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
    }*/
}