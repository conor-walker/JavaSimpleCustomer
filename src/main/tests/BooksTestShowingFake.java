import Data.Book;
import Data.Books;
import Engine.InventoryStock;
import Engine.ReadDelimitedFileFake;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BooksTestShowingFake {
    // Uses faked inventory data to test Books functionality
    InventoryStock fakeData = new ReadDelimitedFileFake();

    @Test
    public void getAllInventoryFillsArray(){
        Books testBooks = new Books(fakeData);

        List<Book> testData = testBooks.getAllInventory();

        assertNotNull(testData);
        assertNotEquals(testData.size(),0);
    }

    @Test
    public void getSizeReturnsRightSize(){
        Books testBooks = new Books(fakeData);
        testBooks.getAllInventory(); //adds fake data to inventory list

        int size = testBooks.getSize();

        assertEquals(size,2);
    }


    @Test
    public void addToListAddsToArray(){
        Books testBooks = new Books(fakeData);
        List<String[]> testList = new ArrayList<>();
        testList.add(new String[]{"1","2","3","4"});

        testBooks.addToList(testList);

        assertEquals(testBooks.getSize(), 1);
    }

    @Test
    public void arrayToBookCreatesValidBook(){
        String[] bookData = new String[]{"1","2","3","4"};

        Book newBook = Books.arrayToBook(bookData);

        assertNotNull(newBook);
    }

    @Test
    public void arrayToBookGivesNullBookWhenDataBad(){
        String[] bookData = new String[]{"1","2"};

        Book newBook = Books.arrayToBook(bookData);

        assertNull(newBook);
    }
}
