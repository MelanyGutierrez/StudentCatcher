/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Vistas.JDListadoAlumnos;
import Vistas.JDListadoCatedraticos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author romar
 */
public class Catedratico {
     
    public String AgregarCatedratico(String nom, String apell, String tel, String direc, String cor)
    {
         //CONECTAR A LA BASE DE DATOS
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        
        try 
        {
            nuevaConexion.Conectar();  //estamos conectando a la base de datos 
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();   //comando que permite ejecutar la consulta
            
            //EJECUTAR LA CONSULTA DE INSERCCION
            comando.executeUpdate("insert into catedratico() values('0','"+nom+"','"+apell+"','"+tel+"','"+direc+"','"+cor+"')");
            //CERRAR BASE DE DATOS      
            conex.close();
            return "Se ha agregado el catedrático.";
            
        } catch (Exception e) {
            return "Error: "+e;
        }

    }
    
    
    public void ListarCatedraticos(DefaultTableModel modelo)
    {
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet Consulta = null;
        try{
            nuevaConexion.Conectar();
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
           
           Consulta = comando.executeQuery("SELECT * FROM catedratico");
                String consulta[] = new String[6];
            while(Consulta.next()==true)
            {
                consulta[0]=Consulta.getString(1);
                consulta[1]=Consulta.getString(2);
                consulta[2]=Consulta.getString(3);
                consulta[3]=Consulta.getString(4);
                consulta[4]=Consulta.getString(5);
                consulta[5]=Consulta.getString(6);
                modelo.addRow(consulta);
            }
            
            
               JDListadoCatedraticos.tablita.setModel(modelo);
            
      } catch (NullPointerException ex) {
          
      } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Catedratico no encontrado"+ e);
      } 
    
    }
   
    

    public void BuscarCatedratico(String buscar,DefaultTableModel Tabla)
    {  
        
        Conexion nuevaConexion = new Conexion();
        Connection conexio;
       
        try{
            nuevaConexion.Conectar();
            conexio = nuevaConexion.getConexion();
            Statement comando = conexio.createStatement(); 
            String datos[]=new String[6];
            ResultSet consulta = comando.executeQuery("select catedratico.idCatedratico, catedratico.nombre, catedratico.apellido, catedratico.telefono, catedratico.direccion, catedratico.correo from catedratico where catedratico.idCatedratico = '"+buscar+"'");
            
            if(consulta.next()){
                
                consulta.beforeFirst();
                while(consulta.next())
                {
                    datos[0] = consulta.getString("idCatedratico");
                    datos[1]= consulta.getString("nombre");
                    datos[2] = consulta.getString("apellido");
                    datos[3] = consulta.getString("telefono");
                    datos[4] = consulta.getString("direccion");
                    datos[5] = consulta.getString("correo");

                    Tabla.addRow(datos);
                }
            }else{
                JOptionPane.showMessageDialog(null,"No existe un catedrático con este ID.");
            }     
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Catedratico no Registrado"+ e);
        }
        
    }    
    
    

    public void BuscarCatedraticoApellido(String buscar,DefaultTableModel Tabla)
    {  
        
        Conexion nuevaConexion = new Conexion();
        Connection conexio;
    
        try {
                nuevaConexion.Conectar();
                conexio = nuevaConexion.getConexion();
                Statement comando = conexio.createStatement(); 
                String datos[]=new String[6];
                ResultSet consulta = comando.executeQuery("select catedratico.idCatedratico, catedratico.nombre, catedratico.apellido, catedratico.telefono, catedratico.direccion, catedratico.correo from catedratico where catedratico.apellido = '"+buscar+"'");

            if(consulta.first()){
                
                consulta.beforeFirst();
                while(consulta.next())
                {
                    datos[0] = consulta.getString("idCatedratico");
                    datos[1]= consulta.getString("nombre");
                    datos[2] = consulta.getString("apellido");
                    datos[3] = consulta.getString("telefono");
                    datos[4] = consulta.getString("direccion");
                    datos[5] = consulta.getString("correo");
                    Tabla.addRow(datos);
                }
            }else{
                JOptionPane.showMessageDialog(null,"No se ha registrado un catedrático con este apellido.");
            
            }
            
        }catch (SQLException e){

                JOptionPane.showMessageDialog(null, "Catedratico no Registrado"+ e);

        }
        
    }     
    
   
    public String ModificarCatedratico(int idCat, String nom, String apell,String tel,String direc, String cor)
    {
         //CONECTAR A LA BASE DE DATOS
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        
        try 
        {
            nuevaConexion.Conectar();  //estamos conectando a la base de datos 
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();   //comando que permite ejecutar la consulta
            
            //EJECUTAR LA CONSULTA DE INSERCCION
            comando.executeUpdate("UPDATE catedratico SET idCatedratico='"+idCat+"', nombre='"+nom+"',apellido='"+apell+"',telefono='"+tel+"',direccion='"+direc+"',correo='"+cor+"' where idCatedratico = '"+idCat+"'");
            //CERRAR BASE DE DATOS      
            conex.close();
            return "Los datos del catedrático han sido modificados correctamente.";
            
        } catch (Exception e) {
            return "Error: "+e;
        }

    }
     
        
     public String EliminarCatedratico(int codigo)
    {
         //CONECTAR A LA BASE DE DATOS
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        
        try 
        {
            nuevaConexion.Conectar();  //estamos conectando a la base de datos 
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();   //comando que permite ejecutar la consulta
            
            //EJECUTAR LA CONSULTA DE INSERCCION
            comando.executeUpdate("DELETE FROM catedratico WHERE idCatedratico='"+codigo+"'");
            //CERRAR BASE DE DATOS      
            conex.close();
            return "Catedratico Eliminado correctamente";
            
        } catch (Exception e) {
            return "Error al ejecutar la consulta: "+e;
        }

    }
    
    
    
     public void LimpiarLista(DefaultTableModel Modelo)
    {
        int filas = Modelo.getRowCount();
        for(int i =0;i<filas;i++)
        {
            Modelo.removeRow(0);
        }
    }
    
}
