
package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PaisDAO implements ConsultasPais {

    @Override
    public boolean insertar(PaisVO p) {
        Conector c = new Conector();
        try {
            c.conectar();
            String query = "INSERT INTO pais (nombre_pais, "+
                           "capital_pais, "+
                           "poblacion_pais, "+
                           "fecha_ingreso_pais ) "+
                           "VALUES ( '"+p.getNombrePais()+"', '"+
                                        p.getCapitalPais()+"', "+
                                        p.getPoblacionPais()+", '"+
                                        p.getFechaIngPais()+"')";
        c.consultasMultiples(query);
        }catch (Exception e){
            System.err.println("Error{MInsert}: "+e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<PaisVO> consultar() {
        Conector c = new Conector();
        ArrayList<PaisVO> info = new ArrayList<>();
        try {
            c.conectar();
            String query="SELECT id_pais,"+
                         "nombre_pais,"+
                         "capital_pais,"+
                         "poblacion_pais "+
                         "from pais";
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                PaisVO pvo = new PaisVO();
                pvo.setIdPais(rs.getInt(1));
                pvo.setNombrePais(rs.getString(2));
                pvo.setCapitalPais(rs.getString(3));
                pvo.setPoblacionPais(rs.getLong(4)); 
                info.add(pvo);
            }
            c.desconectar();
        }catch (Exception e){
            System.err.println("Error{MMostrar]: "+ e.getMessage());
            c.desconectar();
        }
        
        return info;
    }

    @Override
    public boolean actualizar(PaisVO p) {
        Conector c = new Conector(); 
        try{
            c.conectar();   
            String query="Update pais "+
                         "set nombre_pais= '"+p.getNombrePais()+"',"+
                             "capital_pais= '"+p.getCapitalPais()+"',"+
                             "poblacion_pais= "+p.getPoblacionPais()+" ,"+
                             "fecha_actualiza_pais= '"+p.getFechaActPais()+"' "+
                         "Where id_pais= "+p.getIdPais();
            c.consultasMultiples(query);
        }catch (Exception e){
            System.out.println("Error{Actualizar}"+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean eliminar(PaisVO p) {
        Conector c=new Conector();
        try{
            c.conectar();
            String query= "DELETE from pais where id_pais= "+p.getIdPais();
            c.consultasMultiples(query);
            
        }catch (Exception e){
            System.out.println("Error {Eliminar}"+e.getMessage()); 
            c.desconectar();
        }
        c.desconectar();
        return true;
    }
    
}
