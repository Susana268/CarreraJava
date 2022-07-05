 
package modelo;
 
public class UsuarioVO {
    int idUsuario;
    String nombreUsuario;
    String apellidoUsuario;
    int edadUsuario;
    String user;
    String password;
    String estado;
    int idTipoUsuarioFk;

    public UsuarioVO() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public int getEdadUsuario() {
        return edadUsuario;
    }

    public void setEdadUsuario(int edadUsuario) {
        this.edadUsuario = edadUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdTipoUsuarioFk() {
        return idTipoUsuarioFk;
    }

    public void setIdTipoUsuarioFk(int idTipoUsuarioFk) {
        this.idTipoUsuarioFk = idTipoUsuarioFk;
    }
    
}
