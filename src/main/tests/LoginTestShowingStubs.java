import Data.Book;
import Data.Customers;
import Data.CustomersFromStub;
import Engine.Basket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LoginTestShowingStubs {
    Customers testCustomers = new CustomersFromStub();

    @Test
    public void addBook_whenValid_updatesPrice(){
        Basket testBasket = new Basket();
        Book testBook = mock(Book.class);
        when(testBook.getPrice()).thenReturn("5.99");

        testBasket.addToBasket(testBook);

        assertEquals(testBasket.totalPrice(),5.99);
    }

    @Test
    public void addBook_whenValid_updatesBasketSize(){
        Basket testBasket = new Basket();
        Book testBook = mock(Book.class);

        testBasket.addToBasket(testBook);
        testBasket.addToBasket(testBook);
        testBasket.addToBasket(testBook);

        assertEquals(testBasket.getSize(),3);
    }
}
