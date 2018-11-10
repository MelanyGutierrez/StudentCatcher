/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Vistas.JDListadoCursos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author romar
 */
public class Cursos {
    
   public void BuscarCurso(String buscar,DefaultTableModel Tabla)
    {  
        
        Conexion nuevaConexion = new Conexion();
        Connection conexio;
       
        try{
                nuevaConexion.Conectar();
                conexio = nuevaConexion.getConexion();
                Statement comando = conexio.createStatement(); 
                String datos[]=new String[3];
                ResultSet consulta = comando.executeQuery("select cursos.idCursos, cursos.CarreraCur, cursos.NombreCur from cursos where cursos.idCursos = '"+buscar+"'");
            if(consulta.first()){ 
                consulta.beforeFirst();
                    while(consulta.next())
                    {
                        datos[0] = consulta.getString("idCursos");
                        datos[1]= consulta.getString("CarreraCur");
                        datos[2] = consulta.getString("NombreCur");

                        Tabla.addRow(datos);
                    }
            }else{
                JOptionPane.showMessageDialog(null,"No se ha registrado un curso con este código de curso.");    
            }
            
        } catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Curso no Registrado"+ e);
           
        }
        
    }
    public String AgregarCurso(String carCur, String nomCur)
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
            comando.executeUpdate("insert into cursos() values('0','"+carCur+"','"+nomCur+"')");
            //CERRAR BASE DE DATOS      
            conex.close();
            return "Curso agregado correctamente";
            
        } catch (Exception e) {
            return "Error al ejecutar la consulta: "+e;
        }

    }
    
          
 public void  llenarCombo(JComboBox NomCom)   //pasa un fomrulario
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
            consulta = comando.executeQuery("SELECT * FROM cursos WHERE CarreraCur='Administración'");
            
            //ResultSetMetaData rsMd = consulta.getMetaData();
             //int numeroColumnas = rsMd.getColumnCount();
           
            
            // PARA A;ADIR OBJETOS DE LA CONSULTA A LA TABLA 
            String nomUni="";
            while (consulta.next())
            {
               nomUni = consulta.getString("NombreCur");
                
                //for (int y = 0; y < numeroColumnas; y++) 
                //{
                  NomCom.addItem(nomUni); // pasar los datos al combox
                //}
            }
           
           conex.close();
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la visita: "+e); 
        }      
 }
 
 public void  llenarCombo2(JComboBox NomCom)   //pasa un fomrulario
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
            consulta = comando.executeQuery("SELECT * FROM cursos WHERE CarreraCur='Derecho'");
            //ResultSetMetaData rsMd = consulta.getMetaData();
             //int numeroColumnas = rsMd.getColumnCount();
           
            
            // PARA A;ADIR OBJETOS DE LA CONSULTA A LA TABLA 
            String nomUni="";
            while (consulta.next())
            {
               nomUni = consulta.getString("NombreCur");
                
                //for (int y = 0; y < numeroColumnas; y++) 
                //{
                  NomCom.addItem(nomUni); // pasar los datos al combox
                //}
            }
           
           conex.close();
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la visita: "+e); 
        }      
 }

 public void  llenarCombo3(JComboBox NomCom)   //pasa un fomrulario
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
            consulta = comando.executeQuery("SELECT * FROM cursos WHERE CarreraCur='Medicina'");
            //ResultSetMetaData rsMd = consulta.getMetaData();
             //int numeroColumnas = rsMd.getColumnCount();
           
            
            // PARA A;ADIR OBJETOS DE LA CONSULTA A LA TABLA 
            String nomUni="";
            while (consulta.next())
            {
               nomUni = consulta.getString("NombreCur");
                
                //for (int y = 0; y < numeroColumnas; y++) 
                //{
                  NomCom.addItem(nomUni); // pasar los datos al combox
                //}
            }
           
           conex.close();
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la visita: "+e); 
        }      
 }

 
 
 public int  obteneridCurso(String Curso)   //pasa un fomrulario
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
            consulta = comando.executeQuery("select * from cursos where '"+Curso+"'= NombreCur");
            //ResultSetMetaData rsMd = consulta.getMetaData();
             //int numeroColumnas = rsMd.getColumnCount();
           
            
            // PARA A;ADIR OBJETOS DE LA CONSULTA A LA TABLA 
            int idUnidad=0;
            while (consulta.next())
            {
               idUnidad = consulta.getInt("idCursos");
               
            }
           
           conex.close();
           return idUnidad;
               
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar la visita: "+e); 
            return 0;
        }      
 }

   
  public String AsignarCurso(String idAlumno, String idCatedratico, int Curso,String fecha)
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
            comando.executeUpdate("insert into asignarcurso() values('0','"+idAlumno+"','"+idCatedratico+"','"+Curso+"','"+fecha+"')");
            //CERRAR BASE DE DATOS
            conex.close();
            return "Se ha asignado correctamente el curso";
            
        } catch (Exception e) {
            return "Error: "+e;
        }
    }  
  
  public String ModificarCurso(int idAlum, String car, String nom)
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
            comando.executeUpdate("UPDATE cursos SET idCursos='"+idAlum+"', CarreraCur='"+car+"', NombreCur='"+nom+"' where idCursos = '"+idAlum+"'");
            //CERRAR BASE DE DATOS      
            conex.close();
            return "Se ha modificado correctamente.";
            
        } catch (Exception e) {
            return "Error: "+e;
        }

    }
  
  public void ListarCurso(DefaultTableModel modelo)
    {
        Conexion nuevaConexion = new Conexion();
        Connection conex;
        ResultSet Consulta = null;
        try 
        {
            nuevaConexion.Conectar();
            conex = nuevaConexion.getConexion();
            Statement comando = conex.createStatement();
           
           // Consulta = comando.executeQuery("select cliente.idCliente ,cliente.apellidos, cliente.nombre, cliente.direccion, cliente.telefono from cliente where cliente.apellidos='"+buscar+"'");
           Consulta = comando.executeQuery("SELECT * FROM cursos");
                String consulta[] = new String[3];
            while(Consulta.next()==true)
            {
                consulta[0]=Consulta.getString(1);
                consulta[1]=Consulta.getString(2);
                consulta[2]=Consulta.getString(3);
               
                modelo.addRow(consulta);
            }
            
               JDListadoCursos.tablita.setModel(modelo);
      }catch(NullPointerException ex){ 
            JOptionPane.showMessageDialog(null,"ERROR"+ ex);
      } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Curso no encontrado"+ e);
      }
    
    }  
  
    public String EliminarCurso(int idCur)
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
            comando.executeUpdate("DELETE FROM cursos WHERE idCursos='"+idCur+"'");
            //CERRAR BASE DE DATOS      
            conex.close();
            return "Se ha eliminado correctamente.";
            
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
   
    public void mostrarDatosA(int idAlumno, JTextField Nombre,JTextField Apellidos,JTextField Telefono,JTextField Direccion)
    {    
       
        Conexion nuevaConexion = new Conexion();
        Connection conexio;
       
        try 
        {
            nuevaConexion.Conectar();
            conexio = nuevaConexion.getConexion();
            Statement comando = conexio.createStatement(); 
            //String datos[]=new String[5];
            ResultSet consulta = comando.executeQuery("select alumnos.nombre , alumnos.apellido, alumnos.telefono , alumnos.direccion from alumnos where alumnos.idAlumnos ='"+idAlumno+"'");
            
            while(consulta.next()){
      
            String nombre= consulta.getString("nombre");
            String apellido=consulta.getString("apellido");
            String telefono=consulta.getString("telefono");
            String direccion=consulta.getString("direccion");

            Nombre.setText(nombre);
            Apellidos.setText(apellido);
            Telefono.setText(telefono);
            Direccion.setText(direccion);}
               
        } 
        
        catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, "No se encuentra en el sistema"+ e);
           
        }
        
    }    

    public void mostrarDatosC(String Apellido,JTextField Codigo, JTextField Nombre,JTextField Apellidos,JTextField Telefono,JTextField Direccion)
    {    
      
        Conexion nuevaConexion = new Conexion();
        Connection conexio;
       
        try 
        {
            nuevaConexion.Conectar();
            conexio = nuevaConexion.getConexion();
            Statement comando = conexio.createStatement(); 
            //String datos[]=new String[5];
            ResultSet consulta = comando.executeQuery("select catedratico.idCatedratico , catedratico.nombre, catedratico.apellido , catedratico.telefono,catedratico.direccion from catedratico where catedratico.apellido ='"+Apellido+"'");
            
            while(consulta.next())
            {
                
        int codigo = consulta.getInt("idCatedratico");
        String nombre= consulta.getString("nombre");
        String apellido=consulta.getString("apellido");
        String telefono=consulta.getString("telefono");
        String direccion=consulta.getString("direccion");
       
        Codigo.setText(Integer.toString(codigo));
        Nombre.setText(nombre);
        Apellidos.setText(apellido);
        Telefono.setText(telefono);
        Direccion.setText(direccion);
                
                
            }
               
        } 
        
        catch (SQLException e) 
        {
            
            JOptionPane.showMessageDialog(null, "El Cliente no Esta en el Sistema"+ e);
           
            
        }
        
    }
    
    
    
}
