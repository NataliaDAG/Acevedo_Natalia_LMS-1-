// Natalia Acevedo
// CEN-3024C
// last updated 10/8/2023
// libraryManagmentSystem
// The function of this class is that it is the main menu of the program it provides the user the option to select one of the--
//-- 4 main options and connects the other two classes that are Book.java and Library.java. It also server as the place where--
//-- you can input the information of the new book that you would like to add to the library list in this class.
// This class is the Main Method class
import java.util.Scanner;

public class libraryManagmentSystem {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        //Main menu options for the library program.
        while (true) {
            System.out.println("1. Show current book library");
            System.out.println("2. Use the ID of a book to check it out");
            System.out.println("3. Add a new book to the library");
            System.out.println("4. Remove a book by barcode");
            System.out.println("5. Remove a book by title");
            System.out.println("6. Check out a book by title");
            System.out.println("7. Check in a book by title");
            System.out.println("8. Shut down the library");
            System.out.print("Please enter one of the eight number choices above: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
            case 1:// Option 1 gives the option to view the books currently available in the library.
                library.displayBooks();
                break;
            case 2:// Option two gives the option to check out a book from the library that is not already checked out by the current user.
                System.out.print("Enter the ID of the book to check out: ");
                int bookId = scanner.nextInt();
                library.removeBookById(bookId);
                break;
            case 3:// This gives the option to add a new book to the library to make it available for check out.
                System.out.print("Enter the ID of the new book: ");
                int newBookId = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter the title of the new book: ");
                String newBookTitle = scanner.nextLine();
                System.out.print("Enter the author of the new book: ");
                String newBookAuthor = scanner.nextLine();
                library.addBook(new Book(newBookId, newBookTitle, newBookAuthor));
                break;
            case 4:// Option 4 asks the user for the barcode of the book they would like to remove 
            	System.out.print("Enter the barcode of the book to remove: ");
                int barcode = scanner.nextInt();
                library.removeBookByBarcode(barcode);
                break;
            case 5:// Option 5 asks the user for the title of the book they would like to remove
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter the title of the book to remove: ");
                String titleToRemove = scanner.nextLine();
                library.removeBookByTitle(titleToRemove);
                break;
            case 6:// Option 6 asks the user for the title of the book they would like to check out
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter the title of the book to check out: ");
                String titleToCheckOut = scanner.nextLine();
                library.checkOutBookByTitle(titleToCheckOut);
                break;
            case 7:// Option 7 asks the user for the title of the book they would like to check in
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter the title of the book to check in: ");
                String titleToCheckIn = scanner.nextLine();
                library.checkInBookByTitle(titleToCheckIn);
                break;
            case 8:// Option 8 gives the user the option to shutdown and leave the library software.
                System.out.println("Shutting down...");
                scanner.close();
                System.exit(0);
            default:// Here it will output the user to to back and pick only one of the 8 previous options because the option the entered is not a valid menu option. 
                System.out.println("Choice is not one of the number options please pick one of the options above!");
            }
        }
    }
}

