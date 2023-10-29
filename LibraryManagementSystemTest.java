import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


class LibraryManagementSystemTest {

	private Library library;

    @Before
    public void setUp() throws Exception {
        library = new Library();
        // sample books I added for testing
        library.addBook(new Book(1, "Book1", "Author1", 101));
        library.addBook(new Book(2, "Book2", "Author2", 102));
    }

    @After
    public void tearDown() throws Exception {
        library = null;
    }

    @Test
    public void testAddBook() {
        library.addBook(new Book(3, "Book3", "Author3", 103));
        Object newSize = library.getBooks();
        equals( newSize);
    }

    @Test
    public void testRemoveBookByBarcode() {
        library.removeBookByBarcode(101);
        Object newSize = library.getBooks();
        equals(newSize);
    }

    @Test
    public void testCheckOutBookByTitle() {
        library.checkOutBookByTitle("Book1");
        assertTrue(library.getBooks() != null);
    }

    @Test
    public void testCheckInBookByTitle() {
        library.checkOutBookByTitle("Book1");
        library.checkInBookByTitle("Book1");
        assertNull(library.getBooks());
    }
}