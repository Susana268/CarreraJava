
package modelo;

import conexion.Conector;
import java.sql.ResultSet;

public class TraductorDAO implements ConsultaTraductor{

    @Override
    public TraductorVO getTraductor(TraductorVO t) {
        Conector c = new Conector();
        TraductorVO info = new TraductorVO();
        try{
            String query="SELECT palabra_ingles,palabra_espaniol,punteo "+
                "from tbl_traductor "+
                "where id_palabra="+t.getIdPalabra();
            ResultSet rs=c.consultaDatos(query);
                        rs.next(); 
            info.setPalabraEspaniol(rs.getString(1));
            info.setPalabraIngles(rs.getString(2)); 
            info.setPunteo(rs.getInt(3));
            
            c.desconectar();
            
        }catch (Exception e){
            System.out.println("Error|llenaTraductor"+e.getMessage());
            c.desconectar();
        }
        return info;       
    }  
}
