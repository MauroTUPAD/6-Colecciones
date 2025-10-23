package Universidad;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor; // puede ser null

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }

    // Invariante: sincronizar ambos lados
    public void setProfesor(Profesor p) {
        if (this.profesor == p) return; // nada que hacer
        // quitar de profesor previo
        if (this.profesor != null) {
            Profesor anterior = this.profesor;
            this.profesor = null;
            anterior.getCursos().remove(this);
        }
        // asignar nuevo y agregar en su lista
        this.profesor = p;
        if (p != null && !p.getCursos().contains(this)) {
            p.getCursos().add(this);
        }
    }

    public void mostrarInfo() {
        String prof = (profesor == null) ? "Sin profesor" : profesor.getNombre();
        System.out.printf("Curso [%s] %s | Profesor: %s%n", codigo, nombre, prof);
    }

    @Override public String toString() {
        return "[" + codigo + "] " + nombre;
    }
}
