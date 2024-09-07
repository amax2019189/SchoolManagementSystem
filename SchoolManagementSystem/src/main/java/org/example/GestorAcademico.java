package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Curso, ArrayList<Estudiante>> inscripciones;

    public GestorAcademico() {
        estudiantes = new ArrayList<>();
        cursos = new ArrayList<>();
        inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws Exception {
        if (!estudiantes.contains(estudiante)) {
            estudiantes.add(estudiante);
        }else {
            throw new Exception("El estudiante ya esta matriculado.");
        }
    }

    @Override
    public void agregarCurso(Curso curso) throws Exception {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }else {
            throw new Exception("El curso ya existe.");
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        Curso curso = buscarCursoPorId(idCurso);
        if (curso != null && inscripciones.containsKey(curso)) {
            ArrayList<Estudiante> estudiantesInscritos = inscripciones.get(curso);
            if (estudiantesInscritos.contains(estudiante)) {
                throw new EstudianteYaInscritoException("El estudiante ya esta incrito en este curso.");
            }else {
                estudiantesInscritos.add(estudiante);
            }
        }else {
            ArrayList<Estudiante> nuevaLista = new ArrayList<>();
            nuevaLista.add(estudiante);
            inscripciones.put(curso, nuevaLista);
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        Curso curso = buscarCursoPorId(idCurso);
        if (curso != null && inscripciones.containsKey(curso)) {
            ArrayList<Estudiante> estudiantesInscritos = inscripciones.get(curso);
            Estudiante estudiante = buscarEstudiantePorId(idEstudiante);
            if (estudiantesInscritos.contains(estudiante)) {
                estudiantesInscritos.remove(estudiante);
            } else {
                throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
            }
        } else {
            throw new EstudianteNoInscritoEnCursoException("El ID del curso no es válido.");
        }
    }

    private Curso buscarCursoPorId(int idCurso) {
        for (Curso curso : cursos) {
            if (curso.getId() == idCurso) {
                return curso;
            }
        }
        return null;
    }

    private Estudiante buscarEstudiantePorId(int idEstudiante) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == idEstudiante) {
                return estudiante;
            }
        }
        return null;
    }
}
