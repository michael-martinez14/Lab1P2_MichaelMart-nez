/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_michaelmartinez;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Michael Martínez
 */
public class Lab1P2_MichaelMartinez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner entrada=new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios=new ArrayList();
        boolean bandera=true;
        int opcionMenu=0;
        while (bandera) {
            System.out.println("1. Registrar usuario");
            System.out.println("2. Listar todo");
            System.out.println("3. Listar por dominio");
            System.out.println("4. Salir");
            System.out.print("Ingrese la opción a ejecutar: ");
            opcionMenu=entrada.nextInt();
            switch (opcionMenu) {
                case 1:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombre=entrada.next();
                    System.out.print("Ingrese el apellido del usuario: ");
                    String apellido=entrada.next();
                    System.out.print("Ingrese la fecha de nacimiento del usuario (YYYY/MM/dd): ");
                    String fecha= entrada.next();
                    SimpleDateFormat fechaConvertida=new SimpleDateFormat(fecha);
                    System.out.print("Ingrese el correo electrónico del usuario: ");
                    String correo=entrada.next();
                    System.out.print("Ingrese la contraseña del usuario: ");
                    String contraseña=entrada.next();
                    Usuario nuevoUsuario= new Usuario(nombre,apellido,fechaConvertida,correo,contraseña);
                    listaUsuarios.add(nuevoUsuario);
                    
                    break;
                case 2:
                    Date fechaActual=new Date();
                    System.out.println(fechaActual);
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    bandera=false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
}
