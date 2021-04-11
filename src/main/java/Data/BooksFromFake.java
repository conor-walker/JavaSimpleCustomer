package Data;

import java.util.ArrayList;
import java.util.List;

public class BooksFromFake implements Inventory {
    List<Book> listOfBooks = new ArrayList<>();

    public List<Book> getAllInventory() {
        listOfBooks.add(new Book("1","2","3","4"));
        listOfBooks.add(new Book("TestName","TestAuthor","TestGenre","TestPrice"));
        return listOfBooks;
    }

    public int getSize() {
        return getAllInventory().size();
    }
}
