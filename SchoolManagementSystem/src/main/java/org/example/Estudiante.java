package org.example;

import java.time.LocalDate;

public class Estudiante extends Persona{
    private LocalDate fechaDeNacimiento;
    private String estado;

    public Estudiante(int id, String nombre, String apellido, LocalDate fechaDeNacimiento, String estado) {
        super(id, nombre, apellido);
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.estado = estado;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Estudiante: " + getNombre() + " " + getApellido() + ", Estado: " + estado;
    }
}