 
package com.ejemploeditor;
 
import controlador.Controlador;
import modelo.Modelo;
import vista.FrmAreaTexto;

public class ComEjemploEditor {

 
    public static void main(String[] args) {
        FrmAreaTexto frm = new FrmAreaTexto();
        Modelo mod = new Modelo();
        Controlador con= new Controlador(frm,mod);
        frm.setVisible(true);
        frm.setResizable(false);
        frm.setLocationRelativeTo(null);
        
    }
    
}
