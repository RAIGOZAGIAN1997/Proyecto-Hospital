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
import java.util.List;

class Examen2 {

    static List<Doctor> listadoctores = new ArrayList<>();
    static List<Paciente> listapacientes = new ArrayList<>();
    static Scanner cadenas = new Scanner(System.in);
    static Scanner enteros = new Scanner(System.in);
    
    public static void main(String Args[]) {
        int opcion;
        boolean salirmenuprincipal = false;
        System.out.println();
        while (!salirmenuprincipal) {
            System.out.println("<<BIENVENIDO AL HOSPITAL>>");
            System.out.println();
            System.out.println("1-DOCTOR");
            System.out.println("2-PACIENTE");
            System.out.println("3-MOSTRAR DOCTORES");
            System.out.println("4-MOSTRAR PACIENTES");
            System.out.println("5-PACIENTES SIN CONSULTAR");
            System.out.println("6-PACIENTES CONSULTANDO");
            System.out.println("7-CONSULTA");
            System.out.println("8-CONSULTA TERMINADA");
            System.out.println("9-BUSQUEDA PACIENTE POR DOCTOR");
            System.out.println("10-SALIR");
            System.out.println();
            System.out.print("SELECCIONA UNA OPCION: ");
            opcion = enteros.nextInt();
            System.out.println();
            switch (opcion) {
                case 1:
                    boolean salirdoctores = false;
                    while (!salirdoctores) {
                        System.out.println("----DOCTOR----");
                        System.out.println("1- ALTA");
                        System.out.println("2- BAJA");
                        System.out.println("3- MODIFICAR");
                        System.out.println("4- REGRESAR A LA PANTALLA ANTERIOR");
                        System.out.println();
                        System.out.print("SELECCIONA UNA OPCION: ");
                        opcion = enteros.nextInt();
                        System.out.println();
                        switch (opcion) {
                            case 1:
                                AgregarDoctor();
                                break;
                            case 2:
                                Eliminardoctor();
                                break;
                            case 3:
                                EditarDoctor();
                                break;
                            case 4:
                                salirdoctores = true;
                                break;
                        }
                    }
                    salirdoctores = false;
                    break;
                case 2:
                    boolean salirpacientes = false;
                    while (!salirpacientes) {
                        System.out.println("----PACIENTES----");
                        System.out.println("1- ALTA");
                        System.out.println("2- BAJA");
                        System.out.println("3- MODIFICAR");
                        System.out.println("4- REGRESAR A LA PANTALLA ANTERIOR");
                        System.out.println();
                        System.out.print("SELECCIONA UNA OPCION: ");
                        opcion = enteros.nextInt();
                        System.out.println();
                        switch (opcion) {
                            case 1:
                                AgregarPaciente();
                                break;
                            case 2:
                                EliminarPaciente();

                                break;
                            case 3:
                                EditarPaciente();
                                break;

                            case 4:
                                salirpacientes = true;
                                System.out.println();
                                break;
                        }
                    }
                    salirpacientes = false;
                    break;
                case 3:
                    encontrardoctores();
                    imprimirdoctores();
                    break;
                case 4:
                    encontrarpacientes();
                    imprimirpacientes();
                    break;
                case 5:
                  Pacientesinconsultar();
                    break;
                case 6:
                    PacientesConsultando();
                    break;
                case 7:
                    AsignarMedicoConsulta();
                    break;
                case 8:
                    ConsultaTerminada();
                    break;
                case 9:
                    imprimirConsulttas();
                    break;
                case 10: 
                    salirmenuprincipal = true;
                    System.out.println("VUELVA PRONTO\n");
                    break;
            }
        }
    }

    public static void AgregarDoctor() {
        System.out.println("----AGREGAR DOCTOR----");
        System.out.print("INTRODUCE EL NOMBRE DEL DOCTOR: ");
        String nombredoctor = cadenas.nextLine();
        System.out.print("INTRODUCE FECHA NACIMIENTO DEL DOCTOR: ");
        String Fechadenacimiento = cadenas.nextLine();
        System.out.print("INTRODUCE LA EDAD DEL DOCTOR: ");
        int edad = enteros.nextInt();
        System.out.print("INTRODUCE LA CEDULA DEL DOCTOR: ");
        int cedula = enteros.nextInt();
        System.out.print("INTRODUCE LA ESPECIALIDAD DEL DOCTOR: ");
        String especialidad = cadenas.nextLine();
        Doctor doctor = new Doctor(nombredoctor, Fechadenacimiento, edad, cedula, especialidad);
        listadoctores.add(doctor);
    }

    public static void AgregarPaciente() {
        System.out.print("INTRODUCE EL NOMBRE DEL PACIENTE: ");
        String nombrepaciente = cadenas.nextLine();
        System.out.print("INTRODUCE FECHA NACIMIENTO DEL PACIENTE: ");
        String fechanacimiento = cadenas.nextLine();
        System.out.print("INTRODUCE LA EDAD DEL PACIENTE: ");
        int edad = enteros.nextInt();
        System.out.print("INTRODUCE LA ENFERMEDAD DEL PACIENTE: ");
        String enfermedad = cadenas.nextLine();
        System.out.print("INTRODUCE EL NUMERO DE PACIENTE: ");
        int numeropaciente = enteros.nextInt();
        Paciente paciente = new Paciente(nombrepaciente, fechanacimiento, edad, enfermedad, numeropaciente);
        listapacientes.add(paciente);

    }

    public static void imprimirdoctores() {
        System.out.println("----IMPRIMIR LISTA DOCTORES-----");
        for (Doctor doctores : listadoctores) {
            doctores.imprimir();
        }
    }

    public static void Eliminardoctor() {
        System.out.println();
        System.out.println("----DAR DE BAJA DOCTOR-----");
        System.out.println();
        System.out.print("INGRESE LA CEDULA DEL DOCTOR A ELIMINAR: ");
        int ceduladoctor = cadenas.nextInt();
        for (int i = 0; i < listadoctores.size(); i++) {
            if (ceduladoctor == listadoctores.get(i).getCedula()) {
                listadoctores.remove(i);
                System.out.println();
                System.out.print("SE HA ELIMINADO EL DOCTOR CON EXITO");
            }
        }
        System.out.println();
        System.out.println();
    }

    public static void imprimirpacientes() {
        System.out.println("----IMPRIMIR LISTA PACIENTES-----");
        for (Paciente pacientes : listapacientes) {
            pacientes.imprimir();
        }
    }

    public static void EditarPaciente() {
        boolean aux = false;
        for (Paciente paciente : listapacientes) {
            paciente.imprimir();
            
        }
        System.out.print("\nINTRODUCE EL NUMERO DE PACIENTE  QUE DESEA EDITAR: ");
        int numeropaciente = enteros.nextInt();

        for (Paciente paciente : listapacientes) {

            if (numeropaciente == paciente.getNumeropaciente()) { //si el ID ingresado coincide, podemos editar sus datos
                aux = true;
                System.out.println("EL PACIENTE HA SIDO ENCONTRADO PARA MODIFICAR");

                System.out.print("INTRODUCE EL NOMBRE DEL PACIENTE: ");
                paciente.setNombre(cadenas.nextLine());
            }

            if (!aux) {
                System.out.print("\n\t\t ¡PACIENTE NO ENCONTRADO!");
            }

        }
    }

    public static void EditarDoctor() {
           boolean aux = false;
        System.out.println("----MODIFICAR DOCTOR-----");
        for (Doctor doctor : listadoctores) {
            doctor.imprimir();
        }
        System.out.print("\nINTRODUCE LA CEDULA DEL DOCTOR QUE DESEA EDITAR: ");
        int ceduladoctor = enteros.nextInt();

        for (Doctor doctor : listadoctores) {

            if (ceduladoctor == doctor.getCedula()) { //si el ID ingresado coincide, podemos editar sus datos
                aux = true;
                System.out.println("EL DOCTOR HA SIDO ENCONTRADO PARA MODIFICAR");
                System.out.print("INTRODUCE EL NOMBRE DEL DOCTOR: ");
                doctor.setNombre(cadenas.nextLine());
            }
        }

            if (!aux) {
                System.out.print("\n\t\t ¡LA CEDULA DEL DOCTOR NO EXISTE!\n");
            }
    }
    public static void EliminarPaciente() {
        boolean aux = false;
        System.out.println();
        System.out.println("----DAR DE BAJA PACIENTE-----");
        System.out.println();
        System.out.print("INGRESA EL NUMERO DE PACIENTE PARA ELIMINAR: ");
        int numerodelpaciente = enteros.nextInt();

        for (int i = 0; i < listapacientes.size(); i++) {
            if (numerodelpaciente == listapacientes.get(i).getNumeropaciente()) {
                aux = true;
                listapacientes.remove(i);
                System.out.println();
                System.out.print("SE HA ELIMINADO EL PACIENTE CON EXITO!");
            }
        }
            if(!aux){
                System.out.println("\n\t\t ¡EL NUMERO DEL PACIENTE NO EXISTE!\"");
            }
        System.out.println();
        System.out.println();
    }

    public static void AsignarMedicoConsulta() {
        boolean aux = false, aux2 = false;
        int indexPaciente = 0;
        System.out.println("INGRESE EL NUMERO DEL PACIENTE: ");
        int IDpa = enteros.nextInt();

        for (int i = 0; i < listapacientes.size(); i++) {
            if (IDpa == listapacientes.get(i).getNumeropaciente()) {
                if (listapacientes.get(i).isDisponibilidad()) {
                    indexPaciente = i;
                    aux = true;
                    listapacientes.get(i).setDisponibilidad(false);
                }
            }
        }
        if(!aux){
            System.out.println("EL NUMERO DEL PACIENTE NO EXISTE");
        }

        if (aux) {
            System.out.println("INGRESE LA CEDULA DEL DOCTOR A ASIGNAR PARA CONSULTA DEL PACIENTE: ");
            int ID = enteros.nextInt();
            for (int i = 0; i < listadoctores.size(); i++) {
                if (ID == listadoctores.get(i).getCedula()) {
                    if (listadoctores.get(i).agregarPaciente(listapacientes.get(indexPaciente))) {
                        System.out.println("DOCTOR ASIGNADO AL PACIENTE DE MANERA SATISFACTORIA.");
                        aux2 = true;
                    }
                }
            }

            if (!aux2) {
                System.out.println("EL DOCTOR YA TIENE ASIGNADO EL MAXIMO DE PACIENTES.");
            }
        }

    }

    public static void imprimirConsulttas() {
        System.out.println("INGRESE LA CEDULA DEL DOCTOR PARA MOSTRAR LOS PACIENTES QUE TIENE A SU CUIDADO: ");
        int ID = enteros.nextInt();
        
        for(Doctor d : listadoctores){
            if(ID == d.getCedula()){
                System.out.println("EL DOCTOR " + d.getNombre() + " TIENE ASIGNADOS A: ");
                for(Paciente p : d.getListapacientes()){
                    System.out.println("\t\t" + p.getNombre());
                }
            }
        }
    }
    public static void ConsultaTerminada(){
         boolean aux = false;
        int indexPaciente = 0;
        System.out.println("INGRESE EL NUMERO DEL PACIENTE: ");
        int IDpa = enteros.nextInt();

        for (int i = 0; i < listapacientes.size(); i++) {
            if (IDpa == listapacientes.get(i).getNumeropaciente()) {
                    indexPaciente = i;
                    aux = true;
                }
            }
        if (aux) {
            System.out.println("INGRESE LA CEDULA DEL DOCTOR PARA ELIMINAR EL PACIENTE: ");
            int ID = enteros.nextInt();
            for (int i = 0; i < listadoctores.size(); i++) {
                if (ID == listadoctores.get(i).getCedula()) {
       for(int j =0; j<listadoctores.get(i).getListapacientes().size(); j++){
           if(IDpa == listadoctores.get(i).getListapacientes().get(i).getNumeropaciente())
               listadoctores.get(i).getListapacientes().get(i).setDisponibilidad(true);
           listadoctores.get(i).getListapacientes().remove(i);
                        System.out.println("EL PACIENTE HA TERMINADO SU CONSULTA SATISFACTORIAMENTE");
                    }
                }
            }
    }
    }
    
    public static void Pacientesinconsultar(){
         boolean aux = false;
          System.out.println("PACIENTES SIN CONSULTAR");
        for(Paciente p: listapacientes){
            if(p.isDisponibilidad()){
                aux = true;
                System.out.println("\t\t" +p.getNombre());
            }
        }
            if(!aux){
                System.out.println("NO HAY PACIENTES SIN CONSULTAR\n");
            }
    }
    public static void PacientesConsultando(){
        boolean aux = false;
          System.out.println("PACIENTES CONSULTANDO");
        for(Paciente p: listapacientes){
            if(!p.isDisponibilidad()){
                aux = true;
                System.out.println("\t\t" +p.getNombre());
            }
        }
            if(!aux){
                System.out.println("NO HAY PACIENTES CONSULTANDO \n");
            }
        
    }
    public static void encontrarpacientes(){
           if(listapacientes.isEmpty()){
               System.out.println("NO HAY PACIENTES\n");
               
           }
        }
    public static void encontrardoctores(){
        if(listadoctores.isEmpty()){
            System.out.println("NO HAY DOCTORES\n");
    }
    }
    }
        

