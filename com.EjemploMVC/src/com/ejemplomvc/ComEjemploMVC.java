
package com.ejemplomvc;

import controlador.Controlador;
import modelo.ModeloLogico;
import vista.FrmOperaciones;


public class ComEjemploMVC {


    public static void main(String[] args) {
        FrmOperaciones ope = new FrmOperaciones();
        ModeloLogico ml = new ModeloLogico();
        Controlador c = new Controlador(ope,ml);
        ope.setVisible(true);
        ope.setLocationRelativeTo(null);
        ope.setResizable(false);
    }
    
}
