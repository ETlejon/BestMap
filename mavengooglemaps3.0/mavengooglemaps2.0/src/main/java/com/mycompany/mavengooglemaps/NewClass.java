/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavengooglemaps;

/**
 *
 * @author Alejandro
 */
public class NewClass {
 public static boolean V1 (String letras)
   {
    if (letras.matches("([ ]?[A-Za-z]+){1,10}?"))
    {
        return true;
     
    }
    else {
        return false;
    }
   }   
  public static boolean V2 (String Direccion)
   {
       if (Direccion.matches("([ ]?[A-Za-z]+){1,10}?,?[ ]?#?[0-9]+,?[ ]?[A-Z]?[a-z]+"))
       {
           return true;
       }
       else {
           return false;
       }
   } 

 public static boolean V3 (String correo)
   {
       if (correo.matches("[_A-Z-a-z0-9-]+(\\.[_a-z0-9-]+)*@+[a-z]+.+[a-z]"))
       {
           return true;
       }
       else {
           return false;
       }
   } 
 public static boolean V4 (String numero)
   {
       if (numero.matches("[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]")){
           return true;
       }
       else {
           return false;
       }
   } 
}


