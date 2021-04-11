import Data.Customers;
import Data.CustomersFromFile;
import Engine.Authorisation;
import Engine.Login;
import Engine.LoginStub;

public class Main {
    public static void main(String[] args){
        Customers registeredUsers = new CustomersFromFile();
        // Authorisation logIn = new Login(registeredUsers);
        Authorisation logIn = new LoginStub();
        logIn.logIn();
        Display.menuLoop();
    }
}
