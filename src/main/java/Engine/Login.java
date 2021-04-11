package Engine;

import Data.Customer;
import Data.Customers;
import Data.CustomersFromFile;

import java.util.List;
import java.util.Scanner;

public class Login implements Authorisation{
    private Customer currentUser;
    List<Customer> listOfCustomers;

    public Login(Customers registeredUsers){
        this.listOfCustomers = registeredUsers.getAllCustomers();
    }

    private String input(String message) {
        Scanner userInput = new Scanner(System.in);
        System.out.println(message);
        return userInput.nextLine();
    }

    private String getPassword(String emailAddress) {
        Customers allCustomers = new CustomersFromFile();
        String password = "";
        List<Customer> listOfCustomers = allCustomers.getAllCustomers();
        for (Customer customer : listOfCustomers) {
            if (customer.getEmailAddress().equals(emailAddress)) {
                password = customer.getPassword();
                currentUser = customer;
            }
        }
        return password;
    }

    public void logIn() {
        String emailAddress = input("Enter email address");
        String password = getPassword(emailAddress);
        if (password.equals("")) {
        System.out.println("You are not a registered user. Exiting...");
            System.exit(0);
        }
        do{
            if (password.equals(input("Enter password"))){
                System.out.println("You are logged in. Welcome, " + currentUser.getFirstName() + "!");
                break;
            }
            System.out.println("Incorrect password - please try again");
        } while (true);
    }
}