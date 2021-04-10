import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Book> shoppingCart = new ArrayList<>();

    public void addToBasket(Book selectedBook){
        shoppingCart.add(selectedBook);
    }
}
