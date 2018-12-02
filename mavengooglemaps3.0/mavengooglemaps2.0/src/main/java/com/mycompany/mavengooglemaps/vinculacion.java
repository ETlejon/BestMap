/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavengooglemaps;

import static com.mycompany.mavengooglemaps.datosmysql.jTable1;
import static com.mycompany.mavengooglemaps.datosmysql.txtnombre;
import static com.mycompany.mavengooglemaps.datosmysql.txtcorreo;
import static com.mycompany.mavengooglemaps.datosmysql.txttelefono;
import static com.mycompany.mavengooglemaps.datosmysql.txtapellidos;
import static com.mycompany.mavengooglemaps.datosmysql.txtbuscar;
import static com.mycompany.mavengooglemaps.datosmysql.txtcorreo;
import static com.mycompany.mavengooglemaps.datosmysql.txtdireccion;
import static com.mycompany.mavengooglemaps.datosmysql.txtid;
import static com.mycompany.mavengooglemaps.datosmysql.txtnombre;
import static com.mycompany.mavengooglemaps.datosmysql.txttelefono;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import static com.mycompany.mavengooglemaps.datosmysql.txtdireccion;

/**
 *
 * @author VLADIVOZTOK
 */
public class vinculacion {
    DefaultTableModel model;
   static  Statement sent;
    conexion c = new conexion();
    static ResultSet resultado;
    
    
    
    
    private static String db="datos";
private static String user="root";
private static String pass="";
private static String url="jdbc:mysql://localhost:3306/"+db;
private static Connection Conn;
    
    
    
    
    
    public void Deshabilitar(){
    txtnombre.setEditable(false);
    txtcorreo.setEditable(false);
    txttelefono.setEditable(false);
}
    void Limpiar(){
    txtnombre.setText("");
    txtdireccion.setText("");
    txtcorreo.setText("");
    txttelefono.setText("");
    txtapellidos.setText("");
    txtbuscar.setText("");
    txtid.setText("");
    
    }
    
    public static Connection getConnection(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        Conn=DriverManager.getConnection(url, user, pass);
        System.out.println("Exitosa");

}catch(Exception e){
    JOptionPane.showMessageDialog(null,"Error"+e.getMessage());
}
    return Conn;
}



    
    public void Llenar(){
    try{
        Conn=getConnection();
        String [] titulos ={"id","Correo","Nombre","Apellidos", "Telefono", "Direccion"};
        String sql="select * from archivos";
        model=new DefaultTableModel(null, titulos);
        sent=Conn.createStatement();
        ResultSet rs=sent.executeQuery(sql);

        String fila []= new String [6];
        
        
        while(rs.next()){
            fila [0]=rs.getString("id");
            fila [1]=rs.getString("correo");
            fila [2]=rs.getString("nombre");
            fila [3]=rs.getString("apellidoM");
            fila [4]=rs.getString("celular");
            fila [5]=rs.getString("direccion");

            model.addRow(fila);

        }
jTable1.setModel(model);
       
    }catch(Exception e){
e.printStackTrace();
        System.err.println("Error al consultar");
    }
    
       
}
     public void guardar(){
     try {
         Conn=getConnection();
            String sql = "insert into archivos( correo ,nombre,apellidoM, celular,direccion)"
                    + "Values (?,?,?,?,?) ";
            PreparedStatement ps = Conn.prepareStatement(sql);
            ps.setString(1, txtcorreo.getText());
            ps.setString(2, txtnombre.getText());
            ps.setString(3, txtapellidos.getText());
            ps.setString(4, txttelefono.getText());
            ps.setString(5, txtdireccion.getText());

            int n = ps.executeUpdate();
            if (n > 1) {
                JOptionPane.showMessageDialog(null, "Datos guardados");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error, verifique que los datos no se repitan." );
        }
     Llenar();
     Limpiar();
}
     
     
     public void eliminar()
     {
         try{
    int fila=jTable1.getSelectedRow();
    String sql="delete from archivos where id="+jTable1.getValueAt(fila,0);
    sent=Conn.createStatement();
    int n=sent.executeUpdate(sql);
    if(n>0){
        Llenar();
        JOptionPane.showMessageDialog(null, "Datos eliminados");
        Limpiar();
    }
}catch(Exception e){
    JOptionPane.showMessageDialog(null, "Error"+e.getMessage());
}
  }
     public void clicjtable1()
     {
         
   try{
     
        int fila=jTable1.getSelectedRow();
        String sql="select * from archivos where id="+jTable1.getValueAt(fila,0);
        sent=Conn.createStatement();
        ResultSet rs=sent.executeQuery(sql);
        rs.next();
        txtcorreo.setText(rs.getString("correo"));
        txtnombre.setText(rs.getString("nombre"));
        txtapellidos.setText(rs.getString("apellidoM"));
        txttelefono.setText(rs.getString("celular"));
        txtdireccion.setText(rs.getString("direccion"));

}catch(Exception e){
    e.printStackTrace();
}
    
     }//Metodo para modificar  los datos de la base de datos 
     public void modificar() throws SQLException{
                                                  
try{
    String sql="Update archivos set correo=?, nombre=?, apellidoM=?, celular=?,direccion=?"+
            "where id=?";
    int fila=jTable1.getSelectedRow();
   String dao=(String)jTable1.getValueAt(fila,0);
   // int id= Integer.parseInt((String)jTable1.getValueAt(fila,0));
    PreparedStatement ps=Conn.prepareStatement(sql);
    ps.setString(1,txtcorreo.getText());
    ps.setString(2,txtnombre.getText());
    ps.setString(3,txtapellidos.getText());
    ps.setString(4,txttelefono.getText());//valor de campos de texto a pasar a
    //BasedeDatos
     ps.setString(5,txtdireccion.getText());

   ps.setString(6,dao);//la llamada sql se muestra en la tabla

    int n=ps.executeUpdate();
    if(n>0){
        Limpiar();
        Llenar();
        JOptionPane.showMessageDialog(null, "datos modificados");
       
    }
     }catch(Exception e){
    e.printStackTrace();
      JOptionPane.showMessageDialog(null, "error"+e.getMessage());
}
         
     }
 public  static variables buscar_reg(String correo){
        variables r = null;
        
        String q = "select * from archivos where correo LIKE '%" + correo + "%'";
        try {
            resultado = sent.executeQuery(q);
            System.out.println("Correcto");
        } catch (Exception e) {
            System.out.println(e.getMessage()+" No Correcto");
        }
        r= asignar();
        return r;
                
    }
  public static variables asignar(){
      variables r = null;
      String Nombre;
      String Apellido;
      String correo;
      String celular;
      String Direccion;
        try {
            if(resultado.last()){
                Nombre= resultado.getString("nombre");
                Apellido= resultado.getString("apellidoM");
                correo= resultado.getString("correo");      
                celular= resultado.getString("celular");
                Direccion= resultado.getString("direccion");
 
                
                r= new variables (Nombre, Apellido, correo, celular, Direccion);
            }
        } catch (Exception e) {
        }
      
      return r;
                
    }
  public void buscar2()
  {
     String  buscarn;
      String nombre = txtbuscar.getText();
       String q = "select * from archivos" + " where nombre='"+nombre+"'";
      try {
            resultado = sent.executeQuery(q);
            System.out.println("Correcto");
resultado = sent.executeQuery("SELECT id FROM archivos WHERE nombre = '"+nombre+"'");

while ( resultado.next() ) {
int inom = resultado.getInt("id");

txtid.setText(""+inom);
}
} catch (SQLException ex) {
JOptionPane.showMessageDialog(null,"Error al tratar de conectar la base, verifica tus datos de conexion");

  
}
  }
 
}
     


    


