
package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PreguntaDAO implements ConsultasPregunta{

    @Override
    public PreguntaVO getPregunta(PreguntaVO p) {
        Conector c = new Conector();
        PreguntaVO info = new PreguntaVO();
        try{
            String query="Select id_pregunta,"+
                         "desc_pregunta "+
                         "from tbl_pregunta "+
                         "where id_pregunta="+p.getIdPregunta();
            ResultSet rs=c.consultaDatos(query);
            rs.next(); 
            info.setIdPregunta(rs.getInt(1));
            info.setDescPregunta(rs.getString(2)); 
            
            c.desconectar();
        }catch (Exception e){
            System.out.println("Error|llenaPregunta"+e.getMessage());
            c.desconectar();
        }
        return info;
    }
  
}
