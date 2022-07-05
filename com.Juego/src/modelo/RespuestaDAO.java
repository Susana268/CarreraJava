
package modelo;

import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RespuestaDAO implements ConsultasRespuesta{
    
    @Override
    public ArrayList<RespuestaVO> getRespuesta(PreguntaVO p) {
        Conector c = new Conector();
        ArrayList<RespuestaVO> info = new ArrayList<>();
        try{
            String query="SELECT id_respuesta, "+
                         "desc_respuesta, "+
                         "punteo ,"+
                         "id_pregunta_fk "+
                         "from tbl_respuesta "+
                         "where id_pregunta_fk="+p.getIdPregunta();
            ResultSet rs=c.consultaDatos(query);
            while (rs.next()){
            RespuestaVO rvo = new RespuestaVO();
            rvo.setIdRespuesta(rs.getInt(1));
            rvo.setDescRespuesta(rs.getString(2));
            rvo.setPunteo(rs.getInt(3)); 
            rvo.setIdPreguntaFk(rs.getInt(4));
            info.add(rvo);
        }
        c.desconectar();
        }catch (Exception e){
            System.out.println("Error|llena Respuesta"+e.getMessage());
            c.desconectar();
        }
        return info;
    }
    
}
