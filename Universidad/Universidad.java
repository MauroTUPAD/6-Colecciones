package Universidad;

import java.util.*;

public class Universidad {
    private String nombre;
    private final List<Profesor> profesores = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public Universidad(String nombre) { this.nombre = nombre; }

    public boolean agregarProfesor(Profesor p) {
        if (p == null || buscarProfesorPorId(p.getId()) != null) return false;
        return profesores.add(p);
    }

    public boolean agregarCurso(Curso c) {
        if (c == null || buscarCursoPorCodigo(c.getCodigo()) != null) return false;
        return cursos.add(c);
    }

    public Profesor buscarProfesorPorId(String id) {
        return profesores.stream().filter(x -> x.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        return cursos.stream().filter(x -> x.getCodigo().equalsIgnoreCase(codigo)).findFirst().orElse(null);
    }

    public boolean asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso c = buscarCursoPorCodigo(codigoCurso);
        Profesor p = buscarProfesorPorId(idProfesor);
        if (c == null || p == null) return false;
        c.setProfesor(p); // usa la lógica bidireccional central
        return true;
    }

    public void listarProfesores() {
        if (profesores.isEmpty()) { System.out.println("Sin profesores."); return; }
        profesores.forEach(Profesor::mostrarInfo);
    }

    public void listarCursos() {
        if (cursos.isEmpty()) { System.out.println("Sin cursos."); return; }
        cursos.forEach(Curso::mostrarInfo);
    }

    // Bajas que rompen relaciones según reglas
    public boolean eliminarCurso(String codigo) {
        Curso c = buscarCursoPorCodigo(codigo);
        if (c == null) return false;
        c.setProfesor(null); // romper relación
        return cursos.remove(c);
    }

    public boolean eliminarProfesor(String id) {
        Profesor p = buscarProfesorPorId(id);
        if (p == null) return false;
        // dejar null los cursos que dictaba
        new ArrayList<>(p.getCursos()).forEach(cur -> cur.setProfesor(null));
        return profesores.remove(p);
    }
}
