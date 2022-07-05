
package com.conexion2022;

import conexion.Conector;
import controlador.ControladorActualizar;
import controlador.ControladorEliminar;
import controlador.ControladorInsertar;
import controlador.ControladorMenu;
import controlador.ControladorMostrar;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;
import vista.FrmEliminar;
import vista.FrmInsertar;
import vista.FrmMenu;
import vista.FrmMostrar;

//Recordar poner campos public
// Colocar a las pantallas secundarias propiedad Dispose
// Tablas: no permita modificar tablas  table_header desparcar reordenar 
// Tablas: Personalizar codigo DefaultTableModel dtm = new DefaultTableModel();
// Iconos en flaticon

public class ComConexion2022 {

    public static void main(String[] args) {
        // prueba de conexion
//        Conector c= new Conector();
//        c.conectar();

        //Vistas
        FrmMenu fm = new FrmMenu();
        FrmInsertar fi= new FrmInsertar();
        FrmMostrar fmo= new FrmMostrar();
        FrmActualizar fac= new FrmActualizar();
        FrmEliminar fel= new FrmEliminar();
        //Modelo
        PaisVO pvo = new PaisVO();
        PaisDAO pdao = new PaisDAO();
        //Controladores
        ControladorMenu cm = new ControladorMenu(fm,fi,fmo,fac,fel);
        ControladorInsertar ci = new ControladorInsertar(fi,pvo,pdao);
        ControladorMostrar cmo = new ControladorMostrar(fmo,pvo,pdao);
        ControladorActualizar cac = new ControladorActualizar(fac,pvo,pdao);
        ControladorEliminar cel = new ControladorEliminar(fel,pvo,pdao);
        
        fm.setVisible(true);
        fm.setLocationRelativeTo(null);
        fm.setResizable(false);
        
    }
    
}
