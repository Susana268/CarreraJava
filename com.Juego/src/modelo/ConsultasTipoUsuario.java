
package modelo;

import java.util.ArrayList;

public interface ConsultasTipoUsuario {
        public ArrayList<TipoUsuarioVO> getTipoUsuario();  
        public TipoUsuarioVO seleccionar(TipoUsuarioVO tvo);
}
