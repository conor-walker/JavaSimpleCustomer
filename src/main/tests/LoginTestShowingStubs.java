import Data.Book;
import Data.Customers;
import Data.CustomersFromStub;
import Engine.Basket;
import Engine.Login;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginTestShowingStubs {
    Customers testCustomers = new CustomersFromStub();

    @Test
    public void verifyPasswordReturnsTrueWhenEqual(){
        Login testLogin = new Login(testCustomers);

        boolean passwordValid = testLogin.verifyPassword("test","test");

        assertTrue(passwordValid);
    }

    @Test
    public void verifyPasswordReturnsFalseWhenUnequal(){
        Login testLogin = new Login(testCustomers);

        boolean passwordValid = testLogin.verifyPassword("test","12345");

        assertFalse(passwordValid);
    }

    @Test
    public void getPasswordReturnsCorrectWhenUserExists(){
        Login testLogin = new Login(testCustomers);

        String usersPassword = testLogin.getPassword("test@test.com");

        assertEquals(usersPassword, "test");
    }

    @Test
    public void getPasswordReturnsEmptyWhenUserDoesntExist(){
        Login testLogin = new Login(testCustomers);

        String usersPassword = testLogin.getPassword("nonexistentUser");

        assertEquals(usersPassword, "");
    }

}
