 
package com.actividadmenu;
 
import controlador.Controlador;
import modelo.ModeloLogico;
import vista.FrmMenu;

public class ComActividadMenu {
 
    public static void main(String[] args) {
        FrmMenu fr = new FrmMenu();
        ModeloLogico md = new ModeloLogico();
        Controlador cn = new Controlador(fr,md);
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setLocationRelativeTo(null);
    }
    
}
