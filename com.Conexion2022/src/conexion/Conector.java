
package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conector {
    //Declaracion de variables para la conexion
    private String driver = "com.mysql.jdbc.Driver";
    private String host = "127.0.0.1";
    private String user = "root";
    private String pass="";
    private String db = "dbconector";
    private String cadena;
    
    // Declaracion de objetos para la conexion
    Connection connection;
    Statement statement;
    
    //Declaracion de metodos para la conexion
    public void conectar(){
        this.cadena="jdbc:mysql://"+this.host+"/"+this.db;
        try{   
            Class.forName(this.driver).newInstance();
            this.connection=DriverManager.getConnection(this.cadena, this.user, this.pass);
        } catch (Exception e){
            System.err.println("Error[MCon]: "+e.getMessage());
        }
            
    }
    
    public void desconectar(){
        try{
            this.connection.close();
        }catch (Exception e){
            System.err.println("Error[MDes]: "+e.getMessage());
        }
    }
    
    // Metodo para realizar los querys insert, update, delete
    public int consultasMultiples (String query){
        int resultado;
        try{
            this.conectar();
            this.statement=this.connection.createStatement();
            resultado= this.statement.executeUpdate(query);            
        }catch (Exception e){
            System.err.println("Error[MCM]: "+e.getMessage());
            return 0;
        }
        return resultado; 
    }
    
    // Metodo para realizar Select
    public ResultSet consultaDatos(String consulta){
        try{
            this.conectar();
            ResultSet resultado = null;
            this.statement=this.connection.createStatement();
            resultado= this.statement.executeQuery(consulta);
            return resultado;
        }catch(Exception e){
            System.err.println("Error[MCD]: "+e.getMessage());
            return null;
        } 
    }
 
}
