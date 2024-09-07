package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", LocalDate.of(2000, 5, 12), "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Ana", "Gómez", LocalDate.of(1999, 10, 25), "matriculado");

        Curso curso1 = new Curso(1, "Matemáticas", "Curso de álgebra y geometría", 5, "1.0");
        Curso curso2 = new Curso(2, "Física", "Curso de física general", 4, "1.0");

        try {
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);
            System.out.println("Estudiantes matriculados:");

            System.out.println(estudiante1);
            System.out.println(estudiante2);

            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);
            System.out.println("\nCursos agregados:");
            System.out.println(curso1);
            System.out.println(curso2);

            gestor.inscribirEstudianteCurso(estudiante1, 1);
            gestor.inscribirEstudianteCurso(estudiante2, 2);
            System.out.println("\nEstudiantes inscritos en los cursos:");
            System.out.println(estudiante1 + " inscrito en " + curso1.getNombre());
            System.out.println(estudiante2 + " inscrito en " + curso2.getNombre());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}