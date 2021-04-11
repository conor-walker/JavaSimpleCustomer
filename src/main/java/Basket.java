import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Book> shoppingCart = new ArrayList<>();

    public void addToBasket(Book selectedBook){
        shoppingCart.add(selectedBook);
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

    public void checkoutBasket(){
        double total = 0.0;
        for (Book book : shoppingCart){
            total = total + Double.parseDouble(book.getPrice());
        }
        System.out.println("You have purchased " + shoppingCart.size() + " items for £" + total);
        System.out.println("Items purchased:");
        this.toString();
    }
}
