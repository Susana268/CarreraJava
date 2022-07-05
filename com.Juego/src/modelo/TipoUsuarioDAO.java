
package modelo;

import conexion.Conector;
import java.sql.ResultSet; 
import java.util.ArrayList;

public class TipoUsuarioDAO implements ConsultasTipoUsuario{

    
    @Override
    public ArrayList<TipoUsuarioVO> getTipoUsuario() {
        Conector c = new Conector();
        ArrayList<TipoUsuarioVO> info = new ArrayList<>();
        try{
            String query="Select id_tipo_usuario,"+
                         "nombre_tipo_usuario "+
                         "from tbl_tipo_usuario";
            ResultSet rs=c.consultaDatos(query); 
            while (rs.next()){
                TipoUsuarioVO tvo = new TipoUsuarioVO();
                tvo.setIdTipoUsuario(rs.getInt(1));
                tvo.setNombreTipoUsuario(rs.getString(2));
                info.add(tvo);
            }
            c.desconectar();
        }catch (Exception e){
            System.out.println("Error|llenaTipo "+e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public TipoUsuarioVO seleccionar(TipoUsuarioVO t) {
        Conector c= new Conector();
        TipoUsuarioVO info = new TipoUsuarioVO();
        try{
            String query="Select id_tipo_usuario,"+
                         "nombre_tipo_usuario "+
                         "from tbl_tipo_usuario "+
                         "where id_tipo_usuario="+t.getIdTipoUsuario();
            ResultSet rs=c.consultaDatos(query);
            rs.next();
            info.setIdTipoUsuario(rs.getInt(1));
            info.setNombreTipoUsuario(rs.getString(2));
            c.desconectar();
        }catch (Exception e){
           System.out.println("Error|selecTipo "+e.getMessage());
           c.desconectar(); 
        }
        return info;

    }
  
}
