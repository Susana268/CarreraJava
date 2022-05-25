
package com.actividadcalcu;

import controlador.Controlador;
import java.util.Date;
import modelo.ModeloLogico;
import vista.FrmCalculadora;

public class ComActividadCalcu {

    public static void main(String[] args) {
        FrmCalculadora fmr = new FrmCalculadora();
        ModeloLogico ml = new ModeloLogico();
        Controlador cl = new Controlador(fmr,ml);
        Date objDate = new Date();
        fmr.txtFecha.setText(objDate.toString());
        fmr.setVisible(true);
        fmr.setLocationRelativeTo(null);
        fmr.setResizable(false);
                
    }
    
}
