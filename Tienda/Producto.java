package Tienda;
import java.util.Objects;

public class Producto {
    private String id;                 // Identificador único
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    // Constructor completo
    public Producto(String id, String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    // Constructor sobrecargado (ejemplo de flexibilidad)
    public Producto(String id, String nombre, CategoriaProducto categoria) {
        this(id, nombre, 0.0, 0, categoria);
    }

    // Encapsulamiento (getters/setters)
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public CategoriaProducto getCategoria() { return categoria; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPrecio(double precio) { this.precio = precio; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setCategoria(CategoriaProducto categoria) { this.categoria = categoria; }

    // Muestra info en consola
    public void mostrarInfo() {
        System.out.printf("ID: %s | Nombre: %s | Precio: $%.2f | Stock: %d | Categoría: %s (%s)%n",
                id, nombre, precio, cantidad, categoria.name(), categoria.getDescripcion());
    }

    // toString para depuración
    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", categoria=" + categoria +
                '}';
    }

    // Igualdad por id (clave única)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(id, producto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
