public class Library {
    private String name;
    private LinkedList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new LinkedList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getIsbn().equalsIgnoreCase(isbn)) return b;
        }
        return null;
    }

    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    public LinkedList<Book> getAvailableBooks() {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).isAvailable()) result.add(books.get(i));
        }
        return result;
    }

    public LinkedList<Book> getLoanedBooks() {
        LinkedList<Book> result = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            if (!books.get(i).isAvailable()) result.add(books.get(i));
        }
        return result;
    }

    public String getStatistics() {
        return "Total libros: " + books.size() +
               "\nDisponibles: " + getAvailableBooks().size() +
               "\nPrestados: " + getLoanedBooks().size();
    }
}
