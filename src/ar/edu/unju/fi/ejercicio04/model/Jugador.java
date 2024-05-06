package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

public class Jugador {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String nacionalidad;
    private double estatura;
    private double peso;
    private Posicion posicion;
    
    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
}
