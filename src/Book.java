public class Book {

    private String title;
    private String isbn;
    private String author;
    private int publicationYear;
    private boolean available;
    private int timesLoaned;

    // Pila de préstamos
    private Stack<LoanRecord> loanStack;
    // Cola de usuarios esperando
    private Queue<String> waitingQueue;

    // CONSTRUCTOR
    public Book(String title, String isbn, String author, int publicationYear) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.publicationYear = publicationYear;
        this.available = true;
        this.timesLoaned = 0;

        this.loanStack = new Stack<>();
        this.waitingQueue = new Queue<>();
    }

    public boolean lend(String user, String date) {
        if (available) {
            available = false;
            timesLoaned++;
            loanStack.push(new LoanRecord(user, date));
            return true;
        } else {
            waitingQueue.enqueue(user);
            return false;
        }
    }

    public boolean undoLastLoan() {
        if (loanStack.isEmpty()) return false;

        loanStack.pop();
        available = true;
        timesLoaned--;

        return true;
    }

    public LoanRecord getLastLoan() {
        return loanStack.peek();
    }

    public void returnBook() {
        available = true;

        if (!waitingQueue.isEmpty()) {
            String nextUser = waitingQueue.dequeue();
            lend(nextUser, "Asignado automáticamente");
        }
    }

    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return title + " (" + isbn + ") | " + author +
               " | Disponible: " + (available ? "Sí" : "No");
    }
    
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }
}
