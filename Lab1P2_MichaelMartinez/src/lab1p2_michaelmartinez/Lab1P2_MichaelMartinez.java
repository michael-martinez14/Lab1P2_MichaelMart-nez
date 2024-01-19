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
                    String [] token=fecha.split("/");
                    int año= Integer.parseInt(token[0]);
                    int mes=Integer.parseInt(token[1]);
                    int dia=Integer.parseInt(token[2]);
                    SimpleDateFormat fechaConvertida=new SimpleDateFormat(fecha);
                    System.out.print("Ingrese el correo electrónico del usuario: ");
                    String correo=entrada.next();
                    System.out.print("Ingrese la contraseña del usuario: ");
                    String contraseña=entrada.next();
                    Usuario nuevoUsuario= new Usuario(nombre,apellido,fechaConvertida,correo,contraseña);
                    listaUsuarios.add(nuevoUsuario);
                    System.out.println(año+" "+ mes+" "+dia);
                    
                    //Para calcular la edad del usuario
                    Date hoy=new Date();
                    SimpleDateFormat fechaSimple=new SimpleDateFormat("YYYY/MM/dd");
                    String fechaHoy=fechaSimple.format(hoy);
                    String [] tokenHoy=fechaHoy.split("/");
                    int añoActual= Integer.parseInt(tokenHoy[0]);
                    int mesActual=Integer.parseInt(tokenHoy[1]);
                    int diaActual=Integer.parseInt(tokenHoy[2]);
                    System.out.println(añoActual+" "+ mesActual+" "+diaActual);
                    
                    int añoEdad=0;
                    int mesEdad=0;
                    int diaEdad=0;
                    if (mesActual<mes && diaActual>dia) {
                        añoEdad=añoActual-año-1;
                        mesEdad=(12-mes)+mesActual;
                        diaEdad=diaActual-dia;
                    }else if (mesActual<mes && diaActual<dia) {
                        añoEdad=añoActual-año-1;
                        mesEdad=(12-mes)+mesActual-1;
                        diaEdad=(31-dia)+diaActual;
                    }else if(mesActual>mes && diaActual<dia) {
                        añoEdad=añoActual-año;
                        mesEdad=(12-mesActual)+mes+1;
                        diaEdad=(31-dia)+diaActual;
                    }else{
                        añoEdad=añoActual-año;
                        mesEdad=mesActual-mes;
                        diaEdad=diaActual-dia;
                    }
                    System.out.println(añoEdad+" "+ mesEdad+" "+diaEdad);
                    break;
                case 2:
                    
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        SimpleDateFormat fechaUsuarios=listaUsuarios.get(i).getFecha();
                        
                    }
                    
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
