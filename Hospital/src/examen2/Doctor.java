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
import java.util.*;

public class Doctor extends Persona {

    private int cedula;
    private String especialidad;
    private List<Paciente> listapacientes;

    public Doctor(String nombre, String fechanacimiento, int edad, int cedula, String especialidad) {
        super(nombre, fechanacimiento, edad);
        this.cedula = cedula;
        this.listapacientes = new ArrayList<>();
    }

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }

    /**
     * @param cedula the cedula to set
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * @return the listapacientes
     */
    public List<Paciente> getListapacientes() {
        return listapacientes;
    }

    /**
     * @param listapacientes the listapacientes to set
     */
    public void setListapacientes(List<Paciente> listapacientes) {
        this.listapacientes = listapacientes;
    }

    public boolean agregarPaciente(Paciente paciente) {
        if (listapacientes.size() == 10) {
            return false;
        }
        listapacientes.add(paciente);
        return true;
    }
    
    public boolean validarpacientes(Paciente paciente){
        if(listapacientes.isEmpty()){
            return false;
        }
        return true;
    }
@Override
    public void imprimir() {
         System.out.println("NOMBRE: "+getNombre());
        System.out.println("NUMERO DE CEDULA: " + getCedula());
    }
}
