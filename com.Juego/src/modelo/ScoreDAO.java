
package modelo;

import conexion.Conector;
import java.sql.ResultSet;

public class ScoreDAO implements ConsultaScore{

    @Override
    public boolean actualizar(ScoreVO s) {
        Conector c= new Conector();
        try{
            String sql="UPDATE tbl_score "+
                       "set punteo_score=punteo_score+"+s.getPunteoScore()+
                       " where id_usuario_fk="+s.getIdUsuarioFk();
            c.consultasMultiples(sql);
            
        }catch (Exception e){
            System.out.println("Error[ActScore]:"+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean insertar(ScoreVO s) {
        Conector c=new Conector();
        try{
            String sql="INSERT into tbl_score ("+
                       "punteo_score,"+
                       "id_usuario_fk)"+
                       "VALUES("+
                       s.getPunteoScore()+", "+
                       s.getIdUsuarioFk()+")";
            c.consultasMultiples(sql);
        }catch (Exception e){
            System.out.println("Error[Insertar]:"+e.getMessage());
            c.desconectar();   
            return false;
        }
        return true;
    }

    @Override
    public ScoreVO getScore(ScoreVO s) {
        Conector c=new Conector();
        ScoreVO info = new ScoreVO();
        try{
            String sql="SELECT id_score, "+
                       "punteo_score "+
                       "from tbl_score "+
                       "where id_usuario_fk="+s.getIdUsuarioFk();
            ResultSet rs=c.consultaDatos(sql);
             
            rs.next(); 
            info.setIdScore(rs.getInt(1));
            info.setPunteoScore(rs.getInt(2));
                     
            c.desconectar();
            
        }catch (Exception e){
            System.out.println("Error|getScore"+e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public boolean insertStore(ScoreVO s) {
        Conector c =new Conector();
        int conteo=0; 
        try{ 
            String sql="SELECT Count(id_score) as conteo "+ 
                       "from tbl_score "+
                       "where id_usuario_fk="+s.getIdUsuarioFk();
            ResultSet rs=c.consultaDatos(sql);
            while(rs.next()){
                conteo=rs.getInt(1);
            }
        }catch (Exception e){
            System.out.println("Error[InsScore]:"+e.getMessage());
            c.desconectar();
        }
        
        if(conteo==0){
            insertar(s);
        }
        if (conteo>0){
            actualizar(s);
        }
        c.desconectar();
        return true;
    }
    
}
