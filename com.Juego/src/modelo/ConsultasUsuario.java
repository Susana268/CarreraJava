
package modelo;

import java.util.ArrayList;

public interface ConsultasUsuario {
    public boolean insertar(UsuarioVO u);
    public ArrayList<UsuarioVO> consultar();
    public boolean actualizar(UsuarioVO u);
    public boolean eliminar(UsuarioVO u);
    public UsuarioVO getUsuario (UsuarioVO u);
    public boolean actTipo (UsuarioVO u);
    public void reporte();
}
