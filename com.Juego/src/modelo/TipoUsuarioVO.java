
package modelo;

public class TipoUsuarioVO {
    int idTipoUsuario;
    String nombreTipoUsuario;

    public TipoUsuarioVO() {
    }

    public TipoUsuarioVO(int idTipoUsuario,String nombreTipoUsuario ){
        this.idTipoUsuario=idTipoUsuario;
        this.nombreTipoUsuario=nombreTipoUsuario;
    }
    
    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombreTipoUsuario() {
        return nombreTipoUsuario;
    }

    public void setNombreTipoUsuario(String nombreTipoUsuario) {
        this.nombreTipoUsuario = nombreTipoUsuario;
    }
    
    public String toString(){
        return idTipoUsuario+"-"+nombreTipoUsuario;
    }
}
