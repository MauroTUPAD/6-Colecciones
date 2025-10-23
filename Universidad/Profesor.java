package Universidad;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String id;
    private String nombre;
    private String especialidad;
    private final List<Curso> cursos = new ArrayList<>();

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public List<Curso> getCursos() { return cursos; }

    // Mantiene bidireccionalidad si el curso no tenía profesor o era otro
    public void agregarCurso(Curso c) {
        if (c == null || cursos.contains(c)) return;
        cursos.add(c);
        if (c.getProfesor() != this) {
            c.setProfesor(this); // sincroniza el otro lado
        }
    }

    public void eliminarCurso(Curso c) {
        if (c == null) return;
        if (cursos.remove(c)) {
            if (c.getProfesor() == this) {
                c.setProfesor(null); // sincroniza el otro lado
            }
        }
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("El profesor no dicta cursos.");
            return;
        }
        cursos.forEach(cur -> System.out.printf("- %s: %s%n", cur.getCodigo(), cur.getNombre()));
    }

    public void mostrarInfo() {
        System.out.printf("Profesor [%s] %s | %s | Cursos: %d%n",
                id, nombre, especialidad, cursos.size());
    }

    @Override public String toString() {
        return nombre + " (" + especialidad + ")";
    }
}
