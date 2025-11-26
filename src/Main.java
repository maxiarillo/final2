public class Main {
    public static void main(String[] args) {

        Library lib = new Library("Biblioteca Central");

        Book b1 = new Book("El Quijote", "111", "Cervantes", 1605);

        lib.addBook(b1);

        System.out.println("\n=== PRUEBA DEL SISTEMA ===");

        System.out.println("\n1) PRÉSTAMO A JUAN");
        b1.lend("Juan", "2025-11-25");
        System.out.println("Último préstamo: " + b1.getLastLoan());

        System.out.println("\n2) INTENTO DE PRÉSTAMO DE MARÍA (se agrega a la cola)");
        b1.lend("María", "2025-11-25");

        System.out.println("\n3) DESHACER EL PRÉSTAMO");
        b1.undoLastLoan();

        System.out.println("\n4) PRÉSTAMO A PEDRO");
        b1.lend("Pedro", "2025-11-25");

        System.out.println("\n5) DEVOLVER LIBRO — debe asignarse a María");
        b1.returnBook();
        System.out.println("Último préstamo después de devolver: " + b1.getLastLoan());

        System.out.println("\n=== ESTADÍSTICAS ===");
        System.out.println(lib.getStatistics());
    }
}
