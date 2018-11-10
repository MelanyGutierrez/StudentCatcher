
package Modelos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection conn;   // su importacion es:   import java.sql.Connection;:
    String resp;
    
    public String Conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");  // el nombre del conector
           // su importacion es:   import java.sql.Connection;:
           
           //CONECTARSE A LA BASE DE DATOS Y SI LO LOGRA LA CONEXION SE GUARDA EN conn
           conn = DriverManager.getConnection("jdbc:mysql://localhost/escuela","root","");  //locasion de labase de datos, usuario y contraseña
            return "Se conectó a la base de Datos dbbancos";
        }
        catch(Exception e)
        {
            return "Ocurrió un error en la consulta: "+e;
        }
    }
    
    public Connection getConexion()
    {
        return conn;
    }
    
}
