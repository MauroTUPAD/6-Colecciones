package Tienda;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // (1) Crear al menos cinco productos y agregarlos
        Producto p1 = new Producto("A01", "Yerba Mate", 2500, 30, CategoriaProducto.ALIMENTOS);
        Producto p2 = new Producto("E10", "Auriculares", 9500, 12, CategoriaProducto.ELECTRONICA);
        Producto p3 = new Producto("R22", "Buzo Hoodie", 18000, 8, CategoriaProducto.ROPA);
        Producto p4 = new Producto("H05", "Cafetera", 32000, 5, CategoriaProducto.HOGAR);
        Producto p5 = new Producto("A02", "Harina 000", 1200, 50, CategoriaProducto.ALIMENTOS);

        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);
        inventario.agregarProducto(p5);

        // (2) Listar todos
        System.out.println("== LISTA DE PRODUCTOS ==");
        inventario.listarProductos();

        // (3) Buscar por ID
        System.out.println("\n== BUSCAR POR ID (E10) ==");
        inventario.buscarProductoPorId("E10").ifPresentOrElse(
                Producto::mostrarInfo,
                () -> System.out.println("No se encontró el producto.")
        );

        // (4) Filtrar por categoría
        System.out.println("\n== FILTRAR POR CATEGORÍA (ALIMENTOS) ==");
        List<Producto> alimentos = inventario.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        alimentos.forEach(Producto::mostrarInfo);

        // (5) Eliminar por ID
        System.out.println("\n== ELIMINAR POR ID (R22) ==");
        boolean elim = inventario.eliminarProducto("R22");
        System.out.println("Eliminado: " + elim);
        inventario.listarProductos();

        // (6) Actualizar stock
        System.out.println("\n== ACTUALIZAR STOCK (A01 -> 40) ==");
        boolean actualizado = inventario.actualizarStock("A01", 40);
        System.out.println("Actualizado: " + actualizado);
        inventario.listarProductos();

        // (7) Total de stock
        System.out.println("\n== TOTAL DE STOCK ==");
        System.out.println("Total de unidades: " + inventario.obtenerTotalStock());

        // (8) Producto con mayor stock
        System.out.println("\n== PRODUCTO CON MAYOR STOCK ==");
        inventario.obtenerProductoConMayorStock()
                .ifPresent(Producto::mostrarInfo);

        // (9) Filtrar por precio entre $1000 y $3000
        System.out.println("\n== FILTRAR POR PRECIO [$1000, $3000] ==");
        inventario.filtrarProductosPorPrecio(1000, 3000)
                .forEach(Producto::mostrarInfo);

        // (10) Mostrar categorías disponibles
        System.out.println("\n== CATEGORÍAS DISPONIBLES ==");
        inventario.mostrarCategoriasDisponibles();

        System.out.println("\n=== FIN DEL DEMO ===");
    }
}
