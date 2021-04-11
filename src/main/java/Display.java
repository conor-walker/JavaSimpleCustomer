import Data.Book;
import Data.Books;
import Engine.Basket;
import Engine.ReadDelimitedFile;

import java.util.List;
import java.util.Scanner;

public class Display {
    public static Scanner userInput = new Scanner(System.in);
    public static Basket currentCart = new Basket();
    private static final Books currentStock = new Books(new ReadDelimitedFile());
    private static final List<Book> stock = currentStock.getAllInventory();

    public static void mainMenu(){
        System.out.println("Please select your option:");
        System.out.println("1: View books");
        System.out.println("2: View Cart");
        System.out.println("3: Checkout");
        System.out.println("4: Logout");
    }

    public static void displayItems(){
        int id = 1;
        for (Book book : stock) {
            System.out.println(id + ": " + book.toString());
            id++;
        }
    }

    public static int userInt(int lowerBound,int upperBound){
        int selection;
        do{
            while (!userInput.hasNextInt()){
                userInput.next();
            }
            selection = userInput.nextInt();
        } while(selection > upperBound || selection < lowerBound);
        return selection;
    }

    public static void selectItem(){
        displayItems();
        System.out.println("Please select an item to buy:");
        int selection = userInt(0,stock.size());
        currentCart.addToBasket(stock.get(selection - 1));
        System.out.println("Item added!\n");
    }

    public static void menuLoop (){
        do {
            mainMenu();
            int selection = userInt(1,4);
            switch(selection){
                case(1):
                    selectItem();
                    break;
                case(2):
                    System.out.println(currentCart.toString());
                    break;
                case(3):
                    currentCart.checkoutBasket();
                    leaveStore();
                case(4):
                    leaveStore();
                default:
                    System.out.println("Invalid selection - please try again!" +"\n");
            }
        } while(true);
    }

    public static void leaveStore(){
        System.out.println("Thanks for shopping!");
        System.exit(0);
    }
}
