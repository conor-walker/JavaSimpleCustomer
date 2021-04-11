public class Book {
    private String bookName;
    private String author;
    private String genre;
    private String price;

    public Book(String bookName, String author, String genre, String price) {
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getPrice() {
        return price;
    }

    public String toString(){
        return this.bookName + " by " + this.author + ". Price: £" + this.price + ". Category: " + this.genre;
    }
}
