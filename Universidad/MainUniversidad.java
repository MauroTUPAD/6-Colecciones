package Universidad;

public class MainUniversidad {
    public static void main(String[] args) {
        Universidad uni = new Universidad("UNLaR");

        // Altas
        Profesor pr1 = new Profesor("P01", "Ana Rodríguez", "Matemática");
        Profesor pr2 = new Profesor("P02", "Luis García", "Programación");

        Curso c1 = new Curso("MAT101", "Álgebra I");
        Curso c2 = new Curso("PROG2",  "Programación II");
        Curso c3 = new Curso("EDA",    "Estructuras de Datos");

        uni.agregarProfesor(pr1);
        uni.agregarProfesor(pr2);
        uni.agregarCurso(c1);
        uni.agregarCurso(c2);
        uni.agregarCurso(c3);

        // Asignaciones (invariante bidireccional)
        uni.asignarProfesorACurso("MAT101", "P01");
        uni.asignarProfesorACurso("PROG2", "P02");
        uni.asignarProfesorACurso("EDA",   "P02");

        System.out.println("== PROFESORES ==");
        uni.listarProfesores();

        System.out.println("\n== CURSOS ==");
        uni.listarCursos();

        // Cambio de profesor en un curso
        System.out.println("\n== REASIGNACIÓN (EDA -> Ana) ==");
        uni.asignarProfesorACurso("EDA", "P01");
        uni.listarCursos();

        // Baja de curso (rompe relación)
        System.out.println("\n== ELIMINAR CURSO (PROG2) ==");
        uni.eliminarCurso("PROG2");
        uni.listarCursos();

        // Baja de profesor (deja cursos sin profe)
        System.out.println("\n== ELIMINAR PROFESOR (P01) ==");
        uni.eliminarProfesor("P01");
        uni.listarProfesores();
        uni.listarCursos();

        System.out.println("\n=== FIN DEMO UNIVERSIDAD ===");
    }
}
