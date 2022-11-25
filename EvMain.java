package Actividad5.java.Evidencia;
/*  Evidencia Final    Computación en Java
*   Carlos Jared Nuñez Viera  #2886129
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
import java.io.IOException;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import fasterxml.jackson.databind.ObjectMapper;

public class EvMain {
    public static List<Usuario> usuarios;
    public static List<Cita> citas = new ArrayList();
    public static List<Medico> medics;
    public static List<Paciente> patient;
    public static Scanner leer = new Scanner(System.in);
    
    public static void main (String[] args) throws IOException{
        boolean UsrExistente;
        String user;
        String pswd;
        cargarUsuarios();
        System.out.println("\t\t\t---------------Login---------------");
        System.out.print("\t\t\t\tUsuario: ");
        user = leer.nextLine();
        System.out.print("\t\t\t\tContraseña: ");
        pswd = leer.nextLine();
        UsrExistente = validarUsr (user, pswd);
        if (UsrExistente) {
            System.out.println("\n\t\t\t\tBienvenido " + user + "\n");
            menu();
        }
        else {
            System.out.println("\n\t\t\t\tEl usuario no existe");
        }
    } //FIN DE MAIN

    public static void cargarUsuarios() {
        if (usuarios == null) {
            usuarios = new ArrayList<>();
        }

        usuarios.add(new Usuario(1, "jv", "1916"));
        usuarios.add(new Usuario(2, "LM10", "D10S"));
        usuarios.add(new Usuario(3, "Monger99", "4826"));
    }

    public static boolean validarUsr(String user, String pswd) {
        return usuarios.stream().anyMatch(x -> x.getName().equals(user) && x.getPassword().equals(pswd));
    }

    public static void menu() {
        int opcion = -1;
        while (opcion != 0) {
            Scanner leer = new Scanner(System.in);
            System.out.println(
                "\t--------MENÚ DE OPCIONES--------\n" + 
                "1.\tDar de alta a un médico\n" + "2.\tDar de alta a un paciente\n" + 
                "3.\tMostrar todas las citas creadas\n" + "4.\tMostrar todas las citas de un médico\n" + 
                "5.\tMostrar todas las citas de un paciente\n" + "6.\tCrear una cita\n" + 
                "0.\tSalir\n");
            System.out.print("Opción: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    nuevoMedico();
                    break;
                case 2:
                    nuevoPaciente();
                    break;
                case 3:
                    verCitas();
                    break;
                case 4:
                    verCitasMedico();
                    break;
                case 5:
                    verCitasPaciente();
                    break;
                case 6:
                    crearCita();
                    break;
                case 0:
                    break;
            }
        }
    }

    public static void cargarMedicos() {

        if (medics == null) {
            medics = new ArrayList<>();
        }
        medics.add(new Medico(1, "Rodolfo Hernandez", "Traumatología"));
        medics.add(new Medico(2, "Germán Berterame", "Pediatría"));
        medics.add(new Medico(3, "Rommel González", "Dermatología"));
        System.out.println("Cantidad de médicos registrados: " + medics.size());
        
    }

    public static void nuevoMedico(){
        Medico nuevo;
        ArrayList<Medico> listaMedicos;
        listaMedicos = new ArrayList();

        nuevo = new Medico();
        listaMedicos.add(nuevo);
    }

    public static void cargarPacientes() {

        if (patient == null) {
            patient = new ArrayList<>();
        }
        patient.add(new Paciente(1, "Alexis Vega"));
        patient.add(new Paciente(2, "Germán Berterame"));
        patient.add(new Paciente(3, "Rommel González"));
        System.out.println("Cantidad de pacientes registrados: " + patient.size());
        
    }

    public static void nuevoPaciente(){
        Paciente nuevo;
        ArrayList<Paciente> listaPacientes;
        listaPacientes = new ArrayList();

        nuevo = new Paciente();
        listaPacientes.add(nuevo);
    }

    public static void verCitas() {
        for (Cita cita : citas) {
            System.out.println("/\t/\t/\t/\t/\t/\t/");
            System.out.println("Título de cita:\t" + cita.getNameCita());
            System.out.println("Nombre del paciente:\t" + cita.getPaciente().getName());
            System.out.println("Nombre del médico:\t" + cita.getMedico().getName());
        }
    }

    public static void verCitasMedico(){
        String doctor;
        System.out.println("Ingresa el nombre de un médico: ");
        doctor = leer.nextLine();
        if (validarMedicos(doctor, doctor)) {
            System.out.println(citas);
        }
        else {
            System.out.println("El nombre ingresado no se encuentra en los registros");
        }

    }
    
    public static boolean validarMedicos (String name, String especialista){
        return medics.stream().anyMatch(x -> x.getName().equals(name) && x.getEspecialidad().equals(especialista));
    }

    public static void verCitasPaciente(){
        String patiente;
        System.out.println("Ingresa el nombre de un paciente: ");
        patiente = leer.nextLine();
        if (validarPaciente(patiente)) {
            System.out.println(citas);
        }
        else {
            System.out.println("El nombre ingresado no se encuentra en los registros");
        }
    }

    public static boolean validarPaciente (String name){
        return patient.stream().anyMatch(x -> x.getName().equals(name));
    }

    public static void crearCita() {
        Cita nuevo;
        Fecha fecha = new Fecha();
        ArrayList<Cita> listaCitas;
        listaCitas = new ArrayList();
        
        nuevo = new Cita();
        listaCitas.add(nuevo);
    }
}