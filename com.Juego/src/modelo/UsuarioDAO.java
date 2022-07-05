 
package modelo;
 
import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class UsuarioDAO implements ConsultasUsuario {
    public JasperViewer jv;
    
    
    @Override
    public boolean insertar(UsuarioVO u) {
        Conector c = new Conector();
        try{
            c.conectar();
            String query="INSERT INTO tbl_usuario ("+
                    "nombre_usuario, "+
                    "apellido_usuario, "+
                    "edad_usuario, "+
                    "user, "+
                    "password, "+
                    "estado, "+
                    "id_tipo_usuario_fk )"+
                    "values('"+
                    u.getNombreUsuario()+"', '"+
                    u.getApellidoUsuario()+"', "+
                    u.getEdadUsuario()+", '"+
                    u.getUser()+"', '"+
                    u.getPassword()+"', '"+
                    u.getEstado()+"', "+
                    u.getIdTipoUsuarioFk()+")"; 
            c.consultasMultiples(query);
        }catch (Exception e){
            System.out.println("Error[MInsert]:"+e.getMessage());
            c.desconectar();
            return(false);
        }
        c.desconectar();
        return(true);
    }

    @Override
    public ArrayList<UsuarioVO> consultar() {
        Conector c = new Conector();
        ArrayList<UsuarioVO> info = new ArrayList();
        try{
            c.conectar();
            String query="SELECT id_usuario,"+
                    "nombre_usuario,"+
                    "apellido_usuario,"+
                    "edad_usuario,"+
                    "user,"+
                    "password,"+
                    "estado,"+
                    "id_tipo_usuario_fk "+
                    "from tbl_usuario";
            ResultSet rs= c.consultaDatos(query);
            while (rs.next()){
                UsuarioVO uvo = new UsuarioVO();
                uvo.setIdUsuario(rs.getInt(1));
                uvo.setNombreUsuario(rs.getString(2));
                uvo.setApellidoUsuario(rs.getString(3));
                uvo.setEdadUsuario(rs.getInt(4));
                uvo.setUser(rs.getString(5)); 
                uvo.setPassword(rs.getString(6));
                uvo.setEstado(rs.getString(7));
                uvo.setIdTipoUsuarioFk(rs.getInt(8));
                info.add(uvo);
            }
            c.desconectar();
            }catch(Exception e){
            System.out.println("Error[MMostrar]:"+e.getMessage());
            c.desconectar(); 
        }
        return info;
   }

    @Override
    public boolean actualizar(UsuarioVO u) {
        Conector c=new Conector();
        try{
            String query="UPDATE tbl_usuario "+
                    "SET nombre_usuario='"+u.getNombreUsuario()+"',"+
                    "apellido_usuario='"+u.getApellidoUsuario()+"',"+
                    "edad_usuario='"+u.getEdadUsuario()+"',"+
                    "user='"+u.getUser()+"',"+
                    "password='"+u.getPassword()+"',"+
                    "estado='"+u.getEstado()+"',"+
                    "id_tipo_usuario_fk="+u.getIdTipoUsuarioFk()+
                    " WHERE id_usuario="+u.getIdUsuario();
            c.consultasMultiples(query);
                     
        }catch(Exception e){
            System.out.println("Error[Actualizar]:"+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean eliminar(UsuarioVO u) {
        Conector c= new Conector();
        try{
            c.conectar();   
            String query="DELETE FROM tbl_usuario "+
                    "WHERE id_usuario="+u.getIdUsuario();
            c.consultasMultiples(query);
        }catch(Exception e){
            System.out.println("Error[Eliminar]:"+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
        return(true);
    }

    @Override
    public UsuarioVO getUsuario(UsuarioVO u) {
        Conector c = new Conector();
        UsuarioVO info = new UsuarioVO();
        try{ 
            
            String query="SELECT "+
                    "id_usuario, "+
                    "user,"+
                    "password,"+
                    "estado,"+
                    "id_tipo_usuario_fk "+
                    "from tbl_usuario "+
                    "where user='"+u.getUser()+"'";
            ResultSet rs= c.consultaDatos(query);
            rs.next();  
            info.setIdUsuario(rs.getInt(1));
            info.setUser(rs.getString(2));
            info.setPassword(rs.getString(3));
            info.setEstado(rs.getString(4));
            info.setIdTipoUsuarioFk(rs.getInt(5));
            c.desconectar();                  
        }catch(Exception e){
            System.out.println("Error[Comprueba]:"+e.getMessage());
            c.desconectar();            
        }
        return info;
    }

    @Override
    public boolean actTipo(UsuarioVO u) {
        Conector c=new Conector();
        try{
            String query="UPDATE tbl_usuario "+
                    "SET id_tipo_usuario_fk="+u.getIdTipoUsuarioFk()+
                    " WHERE id_usuario="+u.getIdUsuario();
            c.consultasMultiples(query);
                     
        }catch(Exception e){
            System.out.println("Error[Actualizar]:"+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
        return true;        
        
    }

    @Override
    public void reporte() { //Generacion de reporte
        Conector c= new Conector();
        try{
            c.conectar();
            JasperReport reporte; 
            //Ruta del reporte
            //String ruta= "C:\\Users\\Susana Gonzalez\\OneDrive\\Documentos\\CarreraJava\\NetB\\com.Juego\\src\\reporte\\R1.jasper";
            //System.out.println("ruta  "+ ruta);         
            //Asignacion de ruta
            //reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta); 
            //JasperPrint jp=JasperFillManager.fillReport(ruta, null,c.connection); 
            
            String ruta= "/reporte/reporteUsuarios.jasper";
            reporte = (JasperReport) JRLoader.loadObject(getClass().getResource(ruta));
            JasperPrint jp=JasperFillManager.fillReport(reporte, null,c.connection); 
            
            JasperViewer jv=new JasperViewer(jp,false);
            this.jv =jv;
            
        }catch (Exception e){
            System.err.println("Error [MReporte}:"+e.getMessage());
        }
    }
    
}
