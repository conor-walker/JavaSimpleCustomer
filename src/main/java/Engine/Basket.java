package Engine;

import Data.Book;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Book> shoppingCart = new ArrayList<>();

    public void addToBasket(Book selectedBook){
        try{
            shoppingCart.add(selectedBook);
        }
        catch(Exception e){
            System.out.println("An unexpected error occurred!");
        }
    }

    public String toString(){
        if(shoppingCart.size() == 0){
            return "Basket is empty - go shopping!";
        }
        StringBuilder basketContents = new StringBuilder();
        int id = 1;
        for(Book book : shoppingCart){
            basketContents.append(id).append(": ").append(book.toString()).append("\n");
            id++;
        }
        return basketContents.toString();
    }

    public int getSize(){
        return shoppingCart.size();
    }

    public double totalPrice(){
        double total = 0.0;
        for (Book book : shoppingCart){
            total = total + Double.parseDouble(book.getPrice());
        }
        return total;
    }

    public void checkoutBasket(){
        System.out.println("You have purchased " + shoppingCart.size() + " items for £" + totalPrice());
        System.out.println("Items purchased:");
        System.out.println(toString());
    }
}
