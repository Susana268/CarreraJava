 
package com.juego;

import conexion.Conector;
import controlador.ControladorAvan;
import controlador.ControladorInicio;
import controlador.ControladorInsertar;
import controlador.ControladorInter;
import controlador.ControladorPrin;
import modelo.PreguntaDAO;
import modelo.PreguntaVO;
import modelo.RespuestaDAO;
import modelo.RespuestaVO;
import modelo.TipoUsuarioDAO;
import modelo.TipoUsuarioVO;
import modelo.TraductorDAO;
import modelo.TraductorVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAvanzado;
import vista.FrmInicio;
import vista.FrmIntermedio;
import vista.FrmPrincipiante;
import vista.FrmUsuario;

 
public class ComJuego {

    public static void main(String[] args) {
//        Prueba Conexion 
//        Conector c= new Conector();
//        c.conectar();

     //Vistas
     FrmInicio fm = new FrmInicio();
     FrmUsuario fu = new FrmUsuario();
     FrmPrincipiante fp = new FrmPrincipiante();
     FrmIntermedio fi = new FrmIntermedio();
     FrmAvanzado fa = new FrmAvanzado();
     //Modelo
     UsuarioVO uvo = new UsuarioVO();
     UsuarioDAO udao = new UsuarioDAO();
     TipoUsuarioVO tvo = new TipoUsuarioVO();
     TipoUsuarioDAO tdao = new TipoUsuarioDAO();
     PreguntaVO pvo = new PreguntaVO();
     PreguntaDAO pdao = new PreguntaDAO();
     RespuestaVO rvo = new RespuestaVO();
     RespuestaDAO rdao = new RespuestaDAO(); 
     TraductorVO trvo = new TraductorVO();
     TraductorDAO trdao = new TraductorDAO();
     
     //Controlador
     ControladorInicio cIn = new ControladorInicio(fm,fu,fp,fi,fa);
     ControladorInsertar cInsert = new ControladorInsertar(fu,uvo,udao);
     ControladorPrin cPrin = new ControladorPrin(fp,fm);
     ControladorInter cInter = new ControladorInter(fi,fm,rvo,rdao);
     ControladorAvan cAvan = new ControladorAvan(fa,fm,trvo,trdao);
     fm.setVisible(true);
     fm.setLocationRelativeTo(null);
     fm.setResizable(false);
    }
    
}
