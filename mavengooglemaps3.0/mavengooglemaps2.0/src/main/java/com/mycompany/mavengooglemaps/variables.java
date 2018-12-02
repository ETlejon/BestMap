/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavengooglemaps;

/**
 *
 * @author alexander
 */
public class variables {
    String Nombre;
    String Apellido;
    String celular;
    String Correo;
    String direccion;
    public variables(String Nombre, String Apellido , String correo, String celular, String direccion) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Correo = correo;
        this.celular = celular;
        this.direccion = direccion;
    }

    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }
     public String getcorreo() {
        return Correo;
    }

    public void setcorreo(String correo) {
        this.Correo = correo;
    }
    


public String getcelular() {
        return celular;
    }

    public void setcelular(String celular) {
        this.celular = celular;
    }

public String getdireccion() {
        return direccion;
    }

    public void setdireccion(String Direccion) {
        this.direccion = Direccion;
    }
}