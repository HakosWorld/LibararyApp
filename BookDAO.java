import java.util.HashMap;
import lib.Book;

public class BookDAO {
    private HashMap<String, Book> books = new HashMap<>();
    private HashMap<String, Book> purchasedBooks = new HashMap<>();
    private HashMap<String, Book> borrowedBooks = new HashMap<>();

    public String addBook(Book book) {
        if (!books.containsKey(book.getISBN())) {
            books.put(book.getISBN(), book);
            return "Book added successfully.";
        } else {
            return "Book already exists.";
        }
    }

    public String deleteBook(String ISBN) {
        if (books.containsKey(ISBN)) {
            books.remove(ISBN);
            return "Book deleted successfully.";
        } else {
            return "Book not found.";
        }
    }

    public String purchaseBook(String ISBN) {
        if (books.containsKey(ISBN)) {
            Book book = books.remove(ISBN);
            purchasedBooks.put(ISBN, book);
            return "Book purchased successfully.";
        } else {
            return "Book not available for purchase.";
        }
    }

    public String borrowBook(String ISBN) {
        if (books.containsKey(ISBN)) {
            Book book = books.remove(ISBN);
            borrowedBooks.put(ISBN, book);
            return "Book borrowed successfully.";
        } else {
            return "Book not available for borrowing.";
        }
    }

    public String returnBook(String ISBN) {
        if (borrowedBooks.containsKey(ISBN)) {
            Book book = borrowedBooks.remove(ISBN);
            books.put(ISBN, book);
            return "Book returned successfully.";
        } else {
            return "Book not found in borrowed list.";
        }
    }
}
