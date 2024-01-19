/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab1p2_michaelmartinez;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                    
                    //System.out.println(año+" "+ mes+" "+dia);
                    
                    //Para calcular la edad del usuario
                    Date hoy=new Date();
                    SimpleDateFormat fechaSimple=new SimpleDateFormat("YYYY/MM/dd");
                    String fechaHoy=fechaSimple.format(hoy);
                    String [] tokenHoy=fechaHoy.split("/");
                    int añoActual= Integer.parseInt(tokenHoy[0]);
                    int mesActual=Integer.parseInt(tokenHoy[1]);
                    int diaActual=Integer.parseInt(tokenHoy[2]);
                    //System.out.println(añoActual+" "+ mesActual+" "+diaActual);
                    
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
                    String edadEspecifica="Años:"+añoEdad+" Meses:"+ mesEdad+" Dias:"+diaEdad;
                    //System.out.println(edadEspecifica);
                    boolean validacionCorreo=correoValidacion(correo);
                    boolean validacioncontraseña=contraseñaValidacion(contraseña);
                    boolean agregar=true;
                    
                    if (añoEdad<13) {
                        System.out.println("El usuario no se pudo agregar por que no tiene la edad suficiente");
                        agregar=false;
                    }else {
                        if (validacionCorreo == false) {
                            System.out.println("El correo contiene caracteres incorrectos");
                            agregar=false;
                        } else {
                            if (validacioncontraseña == false) {
                                System.out.println("La contraseña tiene caracteres incorrectos o insuficientes");
                                agregar=false;
                            } else {
                                for (int i = 0; i < listaUsuarios.size(); i++) {
                                    if (correo.equalsIgnoreCase(listaUsuarios.get(i).correo)) {
                                        System.out.println("El correo ya existe");
                                        agregar=false;
                                    } 
                                }

                            }
                        }
                    }
                    if (agregar) {
                        System.out.println("Usuario agregado con éxito");
                        Usuario nuevoUsuario = new Usuario(nombre, apellido, edadEspecifica, correo, contraseña);
                        listaUsuarios.add(nuevoUsuario);
                    }
                    
                    //comprobación correo electrónico
                    break;
                case 2:
                    System.out.println("----USUARIOS----");
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        System.out.println(i+" ) "+listaUsuarios.get(i));
                    }
                    
                    break;
                case 3:
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        String [] token2=listaUsuarios.get(i).correo.split("@");
                        if (token2[1].equalsIgnoreCase("gmail.com")) {
                            System.out.println(i+" ) "+listaUsuarios.get(i));
                        }
                    }
                    
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        String [] token2=listaUsuarios.get(i).correo.split("@");
                        if (token2[1].equalsIgnoreCase("outlook.com")) {
                            System.out.println(i+" ) "+listaUsuarios.get(i));
                        }
                    }
                    
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        String [] token2=listaUsuarios.get(i).correo.split("@");
                        if (token2[1].equalsIgnoreCase("yahoo.com")) {
                            System.out.println(i+" ) "+listaUsuarios.get(i));
                        }
                    }
                    
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        String [] token2=listaUsuarios.get(i).correo.split("@");
                        if (token2[1].equalsIgnoreCase("icloud.com")) {
                            System.out.println(i+" ) "+listaUsuarios.get(i));
                        }
                    }
                    
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        String [] token2=listaUsuarios.get(i).correo.split("@");
                        if (token2[1].equalsIgnoreCase("protonmail.com")) {
                            System.out.println(i+" ) "+listaUsuarios.get(i));
                        }
                    }
                    for (int i = 0; i < listaUsuarios.size(); i++) {
                        String [] token2=listaUsuarios.get(i).correo.split("@");
                        if (token2[1].equalsIgnoreCase("fastmail.com")) {
                            System.out.println(i+" ) "+listaUsuarios.get(i));
                        }
                    }
                    
                    break;
                case 4:
                    bandera=false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    public static boolean correoValidacion(String correo){
        String regex = "^[a-zA-Z0-9._%&$+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }
    
    public static boolean contraseñaValidacion(String contraseña){
        String regex = "^[a-zA-Z0-9._%&$+-?<>!]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(contraseña);
        return matcher.matches();
    }
    
    
    
    
    
}
