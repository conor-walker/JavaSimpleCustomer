import java.util.ArrayList;
import java.util.List;

public class BooksFromFile implements Inventory{
    List<Book> listOfBooks = new ArrayList<>();

    public List<Book> getAllInventory(){
        ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
        List<String[]> fileData = readDelimitedFile.getFileData("items.csv");
        addToList(fileData);
        return listOfBooks;
    }

    private void addToList(List<String[]> bookList){
        for(String[] book : bookList){
            listOfBooks.add(arrayToBook(book));
        }
    }

    private Book arrayToBook(String[] bookInfo){
        return new Book(bookInfo[0],bookInfo[1],bookInfo[2],bookInfo[3]);
    }

    public int getSize(){
        return listOfBooks.size();
    }
}
