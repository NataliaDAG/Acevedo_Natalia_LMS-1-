// Natalia Acevedo
// CEN-3024C
// last updated 9/6/2023
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
    // Here it prints out the format of how the list view should look like for all the books.
    public void displayBooks() {
        for (Book book : books) {
        	System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}
