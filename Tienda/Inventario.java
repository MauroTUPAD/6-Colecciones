package Tienda;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Inventario {
    private final ArrayList<Producto> productos = new ArrayList<>();

    // 1) Agregar
    public boolean agregarProducto(Producto p) {
        if (p == null) return false;
        if (buscarProductoPorId(p.getId()).isPresent()) return false; // evita duplicados
        return productos.add(p);
    }

    // 2) Listar
    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }
        productos.forEach(Producto::mostrarInfo);
    }

    // 3) Buscar por ID
    public Optional<Producto> buscarProductoPorId(String id) {
        return productos.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst();
    }

    // 4) Eliminar por ID
    public boolean eliminarProducto(String id) {
        return productos.removeIf(p -> p.getId().equalsIgnoreCase(id));
    }

    // 5) Actualizar stock
    public boolean actualizarStock(String id, int nuevaCantidad) {
        return buscarProductoPorId(id).map(p -> {
            p.setCantidad(nuevaCantidad);
            return true;
        }).orElse(false);
    }

    // 6) Filtrar por categoría
    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        return productos.stream()
                .filter(p -> p.getCategoria() == categoria)
                .collect(Collectors.toList());
    }

    // 7) Total de stock (suma de cantidades)
    public int obtenerTotalStock() {
        return productos.stream().mapToInt(Producto::getCantidad).sum();
    }

    // 8) Producto con mayor stock
    public Optional<Producto> obtenerProductoConMayorStock() {
        return productos.stream().max(Comparator.comparingInt(Producto::getCantidad));
    }

    // 9) Filtrar por rango de precios [min, max]
    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        double a = Math.min(min, max), b = Math.max(min, max);
        return productos.stream()
                .filter(p -> p.getPrecio() >= a && p.getPrecio() <= b)
                .collect(Collectors.toList());
    }

    // 10) Mostrar categorías disponibles
    public void mostrarCategoriasDisponibles() {
        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.printf("- %s: %s%n", c.name(), c.getDescripcion());
        }
    }
}
