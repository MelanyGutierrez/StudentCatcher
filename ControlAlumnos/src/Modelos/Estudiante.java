/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Vistas.JDListadoAlumnos;
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
public class Estudiante {
    
    public String AgregarEstudiante(String nom, String apell, String tel,String direc, String correo)
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
            comando.executeUpdate("insert into alumnos() values('0','"+nom+"','"+apell+"','"+tel+"','"+direc+"','"+correo+"')");
            //CERRAR BASE DE DATOS      
            conex.close();
            return "El alumno se ha agregado correctamente.";
            
        } catch (Exception e) {
            return "Error: "+e;
        }

    }
         
    

    public void ListarAlumno(DefaultTableModel modelo)
    {
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet Consulta = null;
        try 
        {
            nuevaConexion.Conectar();
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
           
            Consulta = comando.executeQuery("SELECT * FROM alumnos");
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
            
            
               JDListadoAlumnos.tablita.setModel(modelo);
      }catch(NullPointerException ex){ 
            
      } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Alumno no encontrado"+ e);
      }
    
    }  


    public void BuscarAlumno(String buscar,DefaultTableModel Tabla)
    {  
       
        Conexion nuevaConexion = new Conexion();
        Connection conexio;
       
        try{
            nuevaConexion.Conectar();
            conexio = nuevaConexion.getConexion();
            Statement comando = conexio.createStatement(); 
            String datos[]=new String[8];
            ResultSet consulta = comando.executeQuery("select alumnos.idAlumnos, alumnos.nombre, alumnos.apellido, alumnos.telefono, alumnos.direccion, alumnos.correo from alumnos where alumnos.idAlumnos = '"+buscar+"'");
           
            if(consulta.next()){
                
                consulta.beforeFirst();
                while(consulta.next())
                    {

                        datos[0] = consulta.getString("idAlumnos");
                        datos[1]= consulta.getString("nombre");
                        datos[2] = consulta.getString("apellido");
                        datos[3] = consulta.getString("telefono");
                        datos[4] = consulta.getString("direccion");
                        datos[5] = consulta.getString("correo");

                        Tabla.addRow(datos);
                    }
            }else{
                
                JOptionPane.showMessageDialog(null,"No se ha registrado un alumno con este carnet.");
            }  
           
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Alumno no Registrado"+ e);
        }
    }
    
    public String ModificarEstudiante(int idAlum, String nom, String apell, String tel, String direc, String cor)
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
            comando.executeUpdate("UPDATE alumnos SET idAlumnos='"+idAlum+"', nombre='"+nom+"', apellido='"+apell+"', telefono='"+tel+"', direccion='"+direc+"', correo='"+cor+"' where idAlumnos = '"+idAlum+"'");
            //CERRAR BASE DE DATOS      
            conex.close();
            return "Se ha modificado correctamente.";
            
        } catch (Exception e) {
            return "Error: "+e;
        }

    }
    
    
     public String EliminarEstudiante(int idAlum)
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
            comando.executeUpdate("DELETE FROM alumnos WHERE idAlumnos='"+idAlum+"'");
            //CERRAR BASE DE DATOS      
            conex.close();
            return "Se ha eliminado al alumno correctamente.";
            
        } catch (Exception e) {
            return "Error: "+e;
        }

    }
    
    
     public void LimpiarLista(DefaultTableModel Modelo){
        int filas = Modelo.getRowCount();
        for(int i =0;i<filas;i++)
        {
            Modelo.removeRow(0);
        }
    }
     
    
  
}

    

