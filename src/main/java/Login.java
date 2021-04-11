import java.util.List;
import java.util.Scanner;

public class Login {
    private Scanner userInput = new Scanner(System.in);
    private Customer currentUser;

    private String input(String message) {
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
            System.out.println("You are not a user");
        }
        else if (password.equals(input("Enter password"))){
            System.out.println("You are logged in. Welcome, " + currentUser.getFirstName() + "!");
        }
        else {
            System.out.println("Wrong password, no second chances");
        }
    }
}