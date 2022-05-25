
package com.ejemplotra;

import controlador.Controlador;
import modelo.Modelo;
import vista.FrmTraductor;


public class ComEjemploTra {


    public static void main(String[] args) {

    FrmTraductor ft = new FrmTraductor();
    Modelo m=new Modelo();
    Controlador c = new Controlador(ft,m);
    
    ft.setVisible(true);
    ft.setLocationRelativeTo(null);
    
    }
    
}
