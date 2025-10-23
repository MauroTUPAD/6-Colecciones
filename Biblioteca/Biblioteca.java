package Biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private String nombre;
    private final ArrayList<Libro> libros = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    // agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor)
    public boolean agregarLibro(String isbn, String titulo, int anio, Autor autor) {
        if (buscarLibroPorIsbn(isbn).isPresent()) return false;
        return libros.add(new Libro(isbn, titulo, anio, autor));
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }
        libros.forEach(Libro::mostrarInfo);
    }

    public Optional<Libro> buscarLibroPorIsbn(String isbn) {
        return libros.stream().filter(l -> l.getIsbn().equalsIgnoreCase(isbn)).findFirst();
    }

    public boolean eliminarLibro(String isbn) {
        return libros.removeIf(l -> l.getIsbn().equalsIgnoreCase(isbn));
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public List<Libro> filtrarLibrosPorAnio(int anio) {
        return libros.stream().filter(l -> l.getAnioPublicacion() == anio).collect(Collectors.toList());
    }

    public void mostrarAutoresDisponibles() {
        // Autores únicos en la colección
        libros.stream()
              .map(Libro::getAutor)
              .distinct()
              .forEach(Autor::mostrarInfo);
    }
}
