// Natalia Acevedo
// CEN-3024C
// last updated 10/29/2023
// Book
// The function of this class is to define what a book is based on 3 key factors.--
//-- The factors are the ID, Title, and Author of the book.
class Book {
    private int id;
    private String title;
    private String author;
    private int barcode;
  //Here it Defines what are the ID's, Title's, barcode, and author's of the books are.
    public Book(int id, String title, String author, int barcode) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.barcode = barcode;
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

	public void setBarcode(int i) {
		// TODO Auto-generated method stub
		
	}

	public Object getDueDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDueDate(Date dueDate) {
		// TODO Auto-generated method stub
		
	}
}

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBookByBarcode(int barcode) {
        for (Book book : books) {
            if (book.getBarcode() == barcode) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean removeBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean checkOutBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (book.getBarcode() != 0) {
                    return false; // Book is already checked out
                }
                book.setBarcode(1); // Set some value to indicate it's checked out
                return true;
            }
        }
        return false;
    }

    public void checkInBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.setBarcode(0); // Set the barcode back to 0 to indicate it's checked in
            }
        }
    }

	public void displayBooks() {
		// TODO Auto-generated method stub
		
	}

	public Object getBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeBookById(int bookId) {
		// TODO Auto-generated method stub
		
	}
}
