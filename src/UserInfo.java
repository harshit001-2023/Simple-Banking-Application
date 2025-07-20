//User Registration and Logins System created by Harshit


import java.util.ArrayList;
import java.util.Scanner;

class User {
    private final String userName;
    private final String passWord;
    private double balance; // <-- added

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
        this.balance = 0.0;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassWord() {
        return passWord;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        return true;
    }
}



public class UserInfo{
    private final ArrayList<User> users = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);
    Main main = new Main();

    public void register(){
        System.out.println("_____Registration_____");
        System.out.println("Enter the Username: ");//Taking Username
        String username = sc.nextLine();

        //Checking whether the Username is already exists or not
        for(User user : users){//Checking each user
            if(user.getUserName().equals(username)){//Confirming user with saved user
                System.out.println("Username is already exists");
            }
            return;
        }

        System.out.println("Enter the Password: ");
        String password = sc.nextLine();

        users.add(new User(username, password));//Adding User login info to the ArrayList()
        System.out.println("Registration Successful!");
        //Calling login method
        login();
    }

    public void login(){
        //Login Console
        System.out.println("_____Login_____");
        System.out.println("Enter your Username: ");
        String username = sc.nextLine();

        System.out.println("Enter your Password: ");
        String password = sc.nextLine();

        for(User user : users){//Comparing user info with saved userinfo with ArrayList users
            if(user.getUserName().equals(username) && user.getPassWord().equals(password)){
                System.out.println("User login Successful...");
                Main.process(user);//Calling Internal account process from Main.java
            }
        }
        System.out.println("Invalid Username or Password!");
    }

    public void run() {
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

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
