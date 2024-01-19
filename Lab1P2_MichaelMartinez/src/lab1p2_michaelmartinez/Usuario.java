/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab1p2_michaelmartinez;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Michael Martínez
 */
public class Usuario {
    String nombre;
    String Apellido;
    SimpleDateFormat fecha;
    String correo;
    String contraseña;

    public Usuario(String nombre, String Apellido, SimpleDateFormat fecha, String correo, String contraseña) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.fecha = fecha;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public SimpleDateFormat getFecha() {
        return fecha;
    }

    public void setFecha(SimpleDateFormat fecha) {
        this.fecha = fecha;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Apellido: " + Apellido + " | Fecha:" + fecha + " | Correo:" + correo + " | Contraseña: " + contraseña;
    }
    
    
    
    
}
