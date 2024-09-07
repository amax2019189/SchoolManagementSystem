package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void inscribirEstudiante(Curso curso, Estudiante estudiante) {
        inscripciones.putIfAbsent(curso, new ArrayList<>());
        inscripciones.get(curso).add(estudiante);
    }

    public ArrayList<Estudiante> obtenerEstudiantesInscritos(Curso curso) {
        return inscripciones.getOrDefault(curso, new ArrayList<>());
    }
}
