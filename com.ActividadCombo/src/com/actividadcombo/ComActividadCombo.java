 
package com.actividadcombo;
 
import controlador.Controlador;
import modelo.ModeloLogico;
import vista.FrmTraductor;

public class ComActividadCombo {
 
    public static void main(String[] args) {
      FrmTraductor frm = new FrmTraductor();
      ModeloLogico mod = new ModeloLogico();
      Controlador con = new Controlador(frm,mod);
      frm.setVisible(true);
      frm.setLocationRelativeTo(null);
      frm.setResizable(false);
    }
    
}
