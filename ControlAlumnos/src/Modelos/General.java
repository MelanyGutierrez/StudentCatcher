/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Vistas.JDCatedratioCurso;
import Vistas.JDCursoListado;
import Vistas.JDListadoCatedraticos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author romar
 */
public class General {
    
    
    
    public void ListadoGeneral(String idAlu ,DefaultTableModel modelo)
    {
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet Consulta = null;
        try{
            nuevaConexion.Conectar();
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
            Consulta = comando.executeQuery("SELECT alumnos.idAlumnos,alumnos.nombre,alumnos.apellido, cursos.NombreCur, catedratico.nombre,catedratico.apellido FROM alumnos, catedratico, cursos, asignarcurso WHERE alumnos.idAlumnos = '"+idAlu+"' AND alumnos.idAlumnos = asignarcurso.idAlumno AND catedratico.idCatedratico = asignarcurso.idCatedratico AND cursos.idCursos = asignarcurso.idAsignar");
            String consulta[] = new String[6];
            
            if(Consulta.next()){
                
                Consulta.beforeFirst();
                while(Consulta.next()==true){
                    consulta[0]=Consulta.getString("alumnos.idAlumnos");
                    consulta[1]=Consulta.getString("alumnos.nombre");
                    consulta[2]=Consulta.getString("alumnos.apellido");
                    consulta[3]=Consulta.getString("cursos.NombreCur");
                    consulta[4]=Consulta.getString("catedratico.nombre");
                    consulta[5]=Consulta.getString("catedratico.apellido");

                    modelo.addRow(consulta);

                }

                   JDListadoCatedraticos.tablita.setModel(modelo);
            }else{
                
                JOptionPane.showMessageDialog(null,"No se ha registrado un alumno con este carnet.");
            }  
        }catch(NullPointerException ex){
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error: "+ e);
      } 
    
    }
    

    public void ListadoCatedraticoCur(String idCated ,DefaultTableModel modelo)
    {
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet Consulta = null;
        try 
        {
            nuevaConexion.Conectar();
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
            Consulta = comando.executeQuery("SELECT catedratico.idCatedratico, catedratico.nombre,catedratico.apellido, cursos.NombreCur FROM catedratico, cursos, asignarcurso WHERE catedratico.idCatedratico ='"+idCated+"' AND catedratico.idCatedratico=asignarcurso.idCatedratico AND cursos.idCursos=asignarcurso.idCurso");
            String consulta[] = new String[4];
            
            if(Consulta.next()){
                
                Consulta.beforeFirst();
                while(Consulta.next()==true)
                {
                    consulta[0]=Consulta.getString("idCatedratico");
                    consulta[1]=Consulta.getString("nombre");
                    consulta[2]=Consulta.getString("apellido");
                    consulta[3]=Consulta.getString("cursos.NombreCur");
                    modelo.addRow(consulta);

                }
                   JDCatedratioCurso.tablita.setModel(modelo);
            }else{
                
                JOptionPane.showMessageDialog(null,"No se ha registrado un catedrático con este ID.");
            } 
           
      } catch (Exception e) {
            JOptionPane.showMessageDialog(null," no encontrado"+ e);
      } 
    
    }    
    
    
    
    public void BusquedaCursosLista(String NomCur ,DefaultTableModel modelo)
    {
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet Consulta = null;
        try 
        {
            nuevaConexion.Conectar();
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
            Consulta = comando.executeQuery("SELECT cursos.NombreCur, alumnos.nombre, alumnos.apellido, catedratico.nombre, catedratico.apellido FROM alumnos ,catedratico, cursos, asignarcurso WHERE cursos.NombreCur ='"+NomCur+"' AND cursos.idCursos = asignarcurso.idCurso AND catedratico.idCatedratico = asignarcurso.idCatedratico and alumnos.idAlumnos = asignarcurso.idAlumno");
            String consulta[] = new String[5];
            
            if(Consulta.next()){
                
                Consulta.beforeFirst();
                while(Consulta.next()==true)
                {
                    consulta[0]=Consulta.getString("cursos.NombreCur");
                    consulta[1]=Consulta.getString("alumnos.nombre");
                    consulta[2]=Consulta.getString("alumnos.apellido");
                    consulta[3]=Consulta.getString("catedratico.nombre");
                    consulta[4]=Consulta.getString("catedratico.apellido");

                    modelo.addRow(consulta);

                }
                   JDCursoListado.tablita.setModel(modelo);
            
            }else{
                
                JOptionPane.showMessageDialog(null,"No se ha registrado un curso con este nombre.");
            }  
           
      } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Error: "+ e);
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
