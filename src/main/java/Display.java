import Data.Book;
import Data.BooksFromFile;
import Engine.Basket;

import java.util.Scanner;

public class Display {
    public static Scanner userInput = new Scanner(System.in);
    public static Basket currentCart = new Basket();

    public static void mainMenu(){
        System.out.println("Please select your option:");
        System.out.println("1: View books");
        System.out.println("2: View Cart");
        System.out.println("3: Checkout");
        System.out.println("4: Logout");
    }

    public static int displayItems(){
        BooksFromFile currentStock = new BooksFromFile();
        int id = 1;
        for (Book book :currentStock.getAllInventory()){
            System.out.println(id + ": " + book.toString());
            id++;
        }
        return currentStock.getSize();
    }

    public static void selectItem(){
        displayItems();
        BooksFromFile currentStock = new BooksFromFile();
        var stock = currentStock.getAllInventory();
        System.out.println("Please select an item to buy");
        int selection;
        while (!userInput.hasNextInt()){
            userInput.next();
        }
        selection = userInput.nextInt();
        currentCart.addToBasket(stock.get(selection - 1));
    }

    public static void menuLoop (){
        String selection;
        do{
            selection = "";
            mainMenu();
            selection = userInput.nextLine();
            switch(selection){
                case("1"):
                    selectItem();
                    break;
                case("2"):
                    System.out.println(currentCart.toString());
                    break;
                case("3"):
                    currentCart.checkoutBasket();
                    break;
                case("4"):
                    leaveStore();
                default:
                    System.out.println("Invalid selection - please try again!" +"\n");
            }
            userInput.nextLine();
        } while(!selection.equals("4"));
    }

    public static void leaveStore(){
        System.out.println("Thanks for shopping!");
        System.exit(0);
    }
}
