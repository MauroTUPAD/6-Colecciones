package Biblioteca;

public class MainBiblioteca {
    public static void main(String[] args) {
        // 1) Creamos una biblioteca
        Biblioteca biblio = new Biblioteca("Biblioteca Central");

        // 2) Crear al menos tres autores
        Autor a1 = new Autor("AU01", "J. L. Borges", "Argentina");
        Autor a2 = new Autor("AU02", "U. Eco", "Italia");
        Autor a3 = new Autor("AU03", "I. Asimov", "EE.UU.");

        // 3) Agregar 5 libros asociados
        biblio.agregarLibro("ISBN-001", "Ficciones", 1944, a1);
        biblio.agregarLibro("ISBN-002", "El Aleph", 1949, a1);
        biblio.agregarLibro("ISBN-003", "El nombre de la rosa", 1980, a2);
        biblio.agregarLibro("ISBN-004", "Fundación", 1951, a3);
        biblio.agregarLibro("ISBN-005", "Yo, Robot", 1950, a3);

        // 4) Listar todos
        System.out.println("== LISTA DE LIBROS ==");
        biblio.listarLibros();

        // 5) Buscar por ISBN
        System.out.println("\n== BUSCAR POR ISBN (ISBN-003) ==");
        biblio.buscarLibroPorIsbn("ISBN-003").ifPresentOrElse(
                Libro::mostrarInfo,
                () -> System.out.println("No se encontró el libro.")
        );

        // 6) Filtrar por año
        System.out.println("\n== LIBROS DEL AÑO 1951 ==");
        biblio.filtrarLibrosPorAnio(1951).forEach(Libro::mostrarInfo);

        // 7) Eliminar por ISBN y relistar
        System.out.println("\n== ELIMINAR (ISBN-002) ==");
        System.out.println("Eliminado: " + biblio.eliminarLibro("ISBN-002"));
        biblio.listarLibros();

        // 8) Cantidad total
        System.out.println("\n== CANTIDAD DE LIBROS ==");
        System.out.println("Total: " + biblio.obtenerCantidadLibros());

        // 9) Autores disponibles
        System.out.println("\n== AUTORES DISPONIBLES ==");
        biblio.mostrarAutoresDisponibles();

        System.out.println("\n=== FIN DEMO BIBLIOTECA ===");
    }
}
