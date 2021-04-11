import Data.Customers;
import Data.CustomersFromFile;
import Engine.Authorisation;
import Engine.Login;

public class Main {
    public static void main(String[] args){
        Customers registeredUsers = new CustomersFromFile();
        Authorisation logIn = new Login(registeredUsers);
        //logIn.logIn();
        Display.menuLoop();
    }
}
