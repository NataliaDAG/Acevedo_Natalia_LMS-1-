// Natalia Acevedo
// CEN-3024C
// last updated 10/29/2023
// this class is the main LMS GUI
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
//this is how the main menu of the program will run like
public class LibraryManagementSystemGUI {
    private JFrame frame;
    private Library library;

    private JTextArea textArea;
    private JTextField fileNameField;
    private JTextField barcodeField;
    private JTextField titleField;
    private JButton addButton;
    private JButton removeBarcodeButton;
    private JButton removeTitleButton;
    private JButton checkoutButton;
    private JButton checkinButton;
// this is the format in which it will run
    public LibraryManagementSystemGUI() {
        frame = new JFrame("Library Management System");
        library = new Library();

        textArea = new JTextArea(20, 50);
        textArea.setEditable(false);

        fileNameField = new JTextField(20);
        barcodeField = new JTextField(10);
        titleField = new JTextField(20);

        addButton = new JButton("Add Book");
        removeBarcodeButton = new JButton("Remove by Barcode");
        removeTitleButton = new JButton("Remove by Title");
        checkoutButton = new JButton("Check Out");
        checkinButton = new JButton("Check In");

        frame.setLayout(new FlowLayout());
        frame.add(new JLabel("Enter File Name: "));
        frame.add(fileNameField);
        frame.add(addButton);
        frame.add(new JLabel("Barcode: "));
        frame.add(barcodeField);
        frame.add(removeBarcodeButton);
        frame.add(new JLabel("Title: "));
        frame.add(titleField);
        frame.add(removeTitleButton);
        frame.add(checkoutButton);
        frame.add(checkinButton);
        frame.add(new JScrollPane(textArea));
        frame.add(new JButton("Exit"));
        // here the buttons are given instructions 
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                if (!fileName.isEmpty()) {
                    loadBooksFromFile(fileName);
                }
            }
        });

        removeBarcodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String barcodeStr = barcodeField.getText();
                if (!barcodeStr.isEmpty()) {
                    int barcode = Integer.parseInt(barcodeStr);
                    removeBookByBarcode(barcode);
                }
            }
        });

        removeTitleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                if (!title.isEmpty()) {
                    removeBookByTitle(title);
                }
            }
        });

        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                if (!title.isEmpty()) {
                    checkOutBookByTitle(title);
                }
            }
        });

        checkinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                if (!title.isEmpty()) {
                    checkInBookByTitle(title);
                }
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    // here it loads books in a list from the file name that was asked for and provides the list
    private void loadBooksFromFile(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    int id = Integer.parseInt(parts[0]);
                    String title = parts[1];
                    String author = parts[2];
                    int barcode = Integer.parseInt(parts[3]);
                    library.addBook(new Book(id, title, author, barcode));
                }
            }
            reader.close();
            updateTextArea("Books loaded from file: " + fileName);
        } catch (IOException e) {
            updateTextArea("Error: File not found");
        }
    }

    private void removeBookByBarcode(int barcode) {
        if (library.removeBookByBarcode(barcode)) {
            updateTextArea("Book with barcode " + barcode + " has been removed.");
        } else {
            updateTextArea("Error: Book with barcode " + barcode + " not found.");
        }
    }

    private void removeBookByTitle(String title) {
        if (library.removeBookByTitle(title)) {
            updateTextArea("Book with title \"" + title + "\" has been removed.");
        } else {
            updateTextArea("Error: Book with title \"" + title + "\" not found.");
        }
    }

    private void checkOutBookByTitle(String title) {
        if (library.checkOutBookByTitle(title)) {
            updateTextArea("Book with title \"" + title + "\" has been checked out.");
        } else {
            updateTextArea("Error: Book with title \"" + title + "\" is already checked out.");
        }
    }

    private void checkInBookByTitle(String title) {
        library.checkInBookByTitle(title);
        updateTextArea("Book with title \"" + title + "\" has been checked in.");
    }

    private void updateTextArea(String message) {
        textArea.append(message + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LibraryManagementSystemGUI();
            }
        });
    }
}
