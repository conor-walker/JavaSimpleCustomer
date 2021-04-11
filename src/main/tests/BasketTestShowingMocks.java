import Data.Book;
import Engine.Basket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BasketTestShowingMocks {
    @Test
    public void addBookUpdatesPriceWhenValid(){
        Basket testBasket = new Basket();
        Book testBook = mock(Book.class);
        when(testBook.getPrice()).thenReturn("5.99");

        testBasket.addToBasket(testBook);

        assertEquals(testBasket.totalPrice(),5.99);
    }

    @Test
    public void addBookUpdatesBasketSizeWhenValid(){
        Basket testBasket = new Basket();
        Book testBook = mock(Book.class);

        testBasket.addToBasket(testBook);
        testBasket.addToBasket(testBook);
        testBasket.addToBasket(testBook);

        assertEquals(testBasket.getSize(),3);
    }
}
