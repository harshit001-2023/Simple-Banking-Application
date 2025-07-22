//User Registration and Logins System created by Harshit


import java.util.ArrayList;
import java.util.Scanner;

class User {

    //Encapsulation concept making all variables private and final so no one change it
    private final String userName;
    private final String passWord;
    private double balance; // <-- added

    //Created a constructor
    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.balance = 0.0;
    }

    //Getter for each variable
    public String getUserName() {
        return userName;
    }
    public String getPassWord() {
        return passWord;
    }

    public double getBalance() {
        return balance;
    }

    //Method called deposit adding and Incrementing balance
    public void deposit(double amount) {
        balance += amount;
    }

    //Method withdraw having a if statement checking amount is greater than balance returning false
    //and Decrementing the amount from the balance
    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
}



public class UserInfo{
    //Using ArrayList for its dynamic behavior
    private final ArrayList<User> users = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    // Method for registration of User
    public void register(){
        System.out.println("_____Registration_____");
        //Taking Username from the user
        System.out.println("Enter the Username: ");//Taking Username
        String username = sc.nextLine();

        //Checking whether the Username is already exists or not
        for(User user : users){//Checking each user
            if(user.getUserName().equals(username)){//Confirming user with saved user
                System.out.println("Username is already exists");
            }
            return;
        }

        //Taking new Password from the user
        System.out.println("Enter the Password: ");
        String password = sc.nextLine();

        //Adding new User's Username and Password to the ArrayList
        users.add(new User(username, password));//Adding User login info to the ArrayList()
        System.out.println("Registration Successful!");
        //Calling login method
        login();
    }

    //Method for implementing User Login logic
    public void login(){
        //Login Console
        System.out.println("_____Login_____");

        //Asking for user's username and password
        System.out.println("Enter your Username: ");
        String username = sc.nextLine();

        System.out.println("Enter your Password: ");
        String password = sc.nextLine();

        for(User user : users){//Comparing user info with saved userinfo with ArrayList users
            if(user.getUserName().equals(username) && user.getPassWord().equals(password)){/// Comparing each username and password with the existing username and password
                System.out.println("User login Successful...");
                Main.process(user);//Calling Internal account process from Main.java for each user
            }
        }
        System.out.println("Invalid Username or Password!");//Message will show if login info not match
    }

    //This is showing the console interface and gives all the options
    public void run() {
        //running the operation till it is true
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consumes newline

            /// Switch statement for better option handling
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
