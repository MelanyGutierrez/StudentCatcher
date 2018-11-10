/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Modelos.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Operador
 */
public class Usuarios {
        String usuario;
    String pass;
    
    public Usuarios()//Constructor
    {
        
    }
    
    
 public void  VerificarUsuario(String usuario, String pass, JDialog form, int suma)   //pasa un fomrulario
 {
      //CONECTAR A LA BASE DE DATOS
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet consulta = null; //GAURDA EL RESULTADO DE LA TABLA 
        
        try 
        {
            nuevaConexion.Conectar();    //estamos conectando a la base de datos 
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();   //comando que permite ejecutar la consulta
           
            //EJECUTAR LA CONSULTA  
            consulta = comando.executeQuery("select * from usuarios where user='"+usuario+"' and pass='"+pass+"'");
            
           String us="";
           String cont="";
           while(consulta.next()==true)
           {
               us =consulta.getString("user");
               cont=consulta.getString("pass");
           }
           
           if (suma > 0)
           {
             if(us.equals(usuario) && cont.equals(pass))
               {
                     JOptionPane.showMessageDialog(null, "Bienvenido "); 
                     form.dispose();
                     
               }
               
               else JOptionPane.showMessageDialog(null, "Invalido ");   
           }
           else JOptionPane.showMessageDialog(null, "Complete los campos de texto ");
           
           conex.close();
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: "+e); 
        }
        
 }

    
}
