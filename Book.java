// Natalia Acevedo
// Natalia Acevedo
// CEN-3024C
// last updated 10/8/2023
// Book
// The function of this class is to define what a book is based on 3 key factors.--
//-- The factors are the ID, Title, and Author of the book.
public class Book {
	private int id;
    private String title;
    private String author;
    private int barcode;
    //Here it Defines what are the ID's, Title's, barcode, and author's of the books are.
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public int getBarcode() {
        return barcode;
    }
}
