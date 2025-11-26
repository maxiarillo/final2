public class LoanRecord {
    private String user;
    private String date;

    public LoanRecord(String user, String date) {
        this.user = user;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Usuario: " + user + " | Fecha: " + date;
    }
}
