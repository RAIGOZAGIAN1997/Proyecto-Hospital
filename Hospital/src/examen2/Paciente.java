/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2;

/**
 *
 * @author GIAN
 */
public class Paciente extends Persona {

    private String enfermedad;
    private int numeropaciente;
    private boolean disponibilidad;

    Paciente(String nombre, String fechanacimiento, int edad, String enfermedad, int numeropaciente) {
        super(nombre, fechanacimiento, edad);
        this.enfermedad = enfermedad;
        this.numeropaciente = numeropaciente;
        this.disponibilidad = true;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int getNumeropaciente() {
        return numeropaciente;
    }

    public void setNumeropaciente(int numeropaciente) {
        this.numeropaciente = numeropaciente;
    }

    /**
     * @return the disponibilidad
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    /**
     * @param disponibilidad the disponibilidad to set
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @Override
    public void imprimir() {
         System.out.println("NOMBRE: "+getNombre());
        System.out.println("NUMERO DE PACIENTE: " + getNumeropaciente());
    }
}
