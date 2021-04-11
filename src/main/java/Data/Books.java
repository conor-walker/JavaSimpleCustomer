package Data;

import Engine.InventoryStock;

import java.util.ArrayList;
import java.util.List;

public class Books {
    private List<Book> listOfBooks = new ArrayList<>();
    private InventoryStock storeStock;

    public Books(InventoryStock stock){
        this.storeStock = stock;
    }

    public List<Book> getAllInventory(){
        List<String[]> fileData = storeStock.getFileData("items.csv");
        addToList(fileData);
        return listOfBooks;
    }

    public void addToList(List<String[]> bookList){
        for(String[] book : bookList){
            listOfBooks.add(arrayToBook(book));
        }
    }

    public static Book arrayToBook(String[] bookInfo){
        try{
            return new Book(bookInfo[0],bookInfo[1],bookInfo[2],bookInfo[3]);
        }
        catch(Exception e){
            System.out.println("Incorrect data for book");
            return null;
        }
    }

    public int getSize(){
        return listOfBooks.size();
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }
}
