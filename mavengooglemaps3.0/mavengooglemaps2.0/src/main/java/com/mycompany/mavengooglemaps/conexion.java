/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavengooglemaps;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author VLADIVOZTOK
 */
public class conexion {
    
public static void connect(){
String url = "jdbc:mysql://localhost:3306/datos";
String user = "root";
String pass = "";
JOptionPane.showInputDialog("Conectando..."); 
//System.out.println("Conectando...");
try(Connection conexion = (Connection) DriverManager.getConnection(url, user,pass)){
//System.out.println("Conectado!!");
JOptionPane.showInputDialog("Conectado¡"); 
 
}catch(SQLException e){
//System.out.println(e.getMessage());
JOptionPane.showInputDialog(e.getMessage()); 
}
Statement sent ;
}
    
}
