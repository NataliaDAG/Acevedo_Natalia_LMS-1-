// Natalia Acevedo
// CEN-3024C
// last updated 10/8/2023
// library
// The function of this class is to provide details to the main class on how the list should look like.--
//-- Also it provide information on how to remove a book from the list to the main class.
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
	private List<Book> books;
	private List<Integer> checkedOutBooks;
    // Here is where the books are set into a list and are defined as a list when you ask the program to list the books that are .
    public Library() {
        books = new ArrayList<>();
        checkedOutBooks = new ArrayList<>();
    }
    // addBook helps define Book and book for the book class
    public void addBook(Book book) {
        books.add(book);
    }
    // Here is the program that helps with removing a book from the list and confirms that the book that the user has picked by ID has been checked out by the user.
    public void removeBookById(int id) {
    	if (!checkedOutBooks.contains(id)) {
    	Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getId() == id) {
                iterator.remove();
                checkedOutBooks.add(id);
                System.out.println("Book with ID " + id + " has been checked out. Hope you enjoy your reading!");
                return;
            }
        }// Here it informs the user when a book that they have already checked out is not available anymore in the list.
        System.out.println("Book with ID " + id + " is not currently available for check out. Please check the list for books that are currently available for you to check out.");
    }else {
        System.out.println("Book with ID " + id + " is already checked out.");
    }
}
    public void removeBookByBarcode(int barcode) { //Here the library will tell the main LMS how to remove a book with a barcode from the library
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getBarcode() == barcode) {
                iterator.remove();
                System.out.println("Book with barcode " + barcode + " has been removed from the library.");
                return;
            }
        }
        System.out.println("Book with barcode " + barcode + " was not found in the library.");
    }

    public void removeBookByTitle(String title) { //Here the library will tell the main LMS how to remove a book by title alone and confirm it
        Iterator<Book> iterator = books.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.getTitle().equalsIgnoreCase(title)) {
                iterator.remove();
                System.out.println("Book with title \"" + title + "\" has been removed from the library.");
                return;
            }
        }
        System.out.println("Book with title \"" + title + "\" was not found in the library.");
    }

    public void checkOutBookByTitle(String title) { //Here the library will tell the main LMS how to check out a book by title alone and confirm it
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!checkedOutBooks.contains(book.getId())) {
                    checkedOutBooks.add(book.getId());
                    System.out.println("Book with title \"" + title + "\" has been checked out.");
                } else {
                    System.out.println("Book with title \"" + title + "\" is already checked out.");
                }
                return;
            }
        }
        System.out.println("Book with title \"" + title + "\" was not found in the library.");
    }

    public void checkInBookByTitle(String title) {
        for (Book book : books) { // here it checks if the book has been checked in or checked out
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (checkedOutBooks.contains(book.getId())) {
                    checkedOutBooks.remove((Integer) book.getId());
                    System.out.println("Book with title \"" + title + "\" has been checked in.");
                } else {
                    System.out.println("Book with title \"" + title + "\" is not checked out.");
                }
                return;
            }
        }
        System.out.println("Book with title \"" + title + "\" was not found in the library.");
    }
    // Here it prints out the format of how the list view should look like for all the books.
    public void displayBooks() {
        for (Book book : books) {
        	System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Barcode: " + book.getBarcode());
        }
    }
}
