
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.ScoreDAO;
import modelo.ScoreVO;
import modelo.TraductorDAO;
import modelo.TraductorVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAvanzado;
import vista.FrmInicio;
 

public class ControladorAvan implements ActionListener, WindowListener, ItemListener {
    FrmAvanzado vAvan = new FrmAvanzado();
    FrmInicio vIn = new FrmInicio();        
    TraductorVO trvo = new TraductorVO();
    TraductorDAO trdao = new TraductorDAO();
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();
    ScoreDAO sdao = new ScoreDAO();
    ScoreVO svo = new ScoreVO();
    int loopNumero=1;
    int traNumero=1; 
    int punteo=0; 
    int punteoFinal=0;
    
    public ControladorAvan(FrmAvanzado vAvan,
                            FrmInicio vIn,
                            TraductorVO trvo,
                            TraductorDAO trdao) {
        this.vAvan=vAvan;
        this.vIn=vIn;
        vAvan.btnConfirmarAv1.addActionListener(this);
        vAvan.btnConfirmarAv2.addActionListener(this);
        vAvan.btnCancelarAva.addActionListener(this);
        vAvan.btnSiguiente.addActionListener(this);
        vAvan.addWindowListener(this);
        
    }
    public void Actualizar(){
        int M=0;
        int N=14;  

        vAvan.txtNumeroOK.setText(String.valueOf(  Math.round(Math.random()*(N-M+1)+M) ) );
        System.out.println("Numero "+vAvan.txtNumeroOK.getText());
        vAvan.lbCheck1.setVisible(false);
        vAvan.lbCheck2.setVisible(false);
        vAvan.lbCross1.setVisible(false);
        vAvan.lbCross2.setVisible(false);
        vAvan.lbCross3.setVisible(false);
        vAvan.lbCross4.setVisible(false);
        vAvan.txtIntento1.setVisible(false);
        vAvan.txtIntento2.setVisible(false);
        vAvan.txtRespuestaOK.setVisible(false);
        vAvan.txtMsjRespuestaOK.setVisible(false);
        vAvan.txtNumeroOK.setVisible(false);
        vAvan.txtPunteo.setVisible(false); 
        
    }
    public void comprobar(){
        if (!(vAvan.txtNumero.getText().equals(vAvan.txtNumeroOK.getText() ))){
            if (loopNumero==1){
                vAvan.lbCross1.setVisible(true);
                vAvan.txtIntento1.setVisible(true);
                vAvan.txtNumero.setText("");
                loopNumero++;
            }else if (loopNumero==2){
                vAvan.lbCross2.setVisible(true);
                vAvan.txtIntento2.setVisible(true);
                vAvan.txtIntento1.setVisible(false);
                vAvan.txtNumero.setText("");
                loopNumero++;
            }else if (loopNumero==3){
                vAvan.lbCross3.setVisible(true);
                vAvan.txtIntento2.setVisible(false);
                vAvan.txtNumeroOK.setVisible(true);
                llenaTraductor(traNumero);
            }
        } else{
            vAvan.lbCheck1.setVisible(true);
            vAvan.txtIntento1.setVisible(false);
            vAvan.txtIntento2.setVisible(false);
            punteo=5;
            ingresaScore();
            punteo=0;
            llenaTraductor(traNumero);
            
        }
            vAvan.setVisible(true);       
    }
    
    public void comprobarTraductor(){
        if (!(vAvan.txtEspañol.getText().equals(vAvan.txtRespuestaOK.getText() ))){
            vAvan.lbCross4.setVisible(true);
            vAvan.txtRespuestaOK.setVisible(true);
            vAvan.txtMsjRespuestaOK.setVisible(true);
        }else {
            vAvan.lbCheck2.setVisible(true); 
            punteo=punteo+(Integer.parseInt(vAvan.txtPunteo.getText()));
              }
        if (traNumero>=3){
            ingresaScore();
            if (punteo>=3){
                uvo.setIdUsuario(Integer.parseInt(this.vIn.txtIdUsuario.getText()));
                uvo.setIdTipoUsuarioFk(2);
                udao.actTipo(uvo);
                this.svo.setIdUsuarioFk(Integer.parseInt(this.vIn.txtIdUsuario.getText()));
                ScoreVO info = sdao.getScore(svo);
                punteoFinal=info.getPunteoScore(); 
                vAvan.jopAvanzado.showMessageDialog(vAvan,"Usted Gano el juego con "+punteoFinal+" puntos");
            }
            vAvan.dispose();
       }else {
        vAvan.btnSiguiente.setVisible(true);
        vAvan.btnConfirmarAv2.setVisible(false); 
        }  
    }
    
    public void llenaTraductor(int traNumero){ 
        trvo.setIdPalabra(traNumero);
        TraductorVO info = trdao.getTraductor(trvo);
        vAvan.txtIngles.setText(info.getPalabraIngles());
        vAvan.txtEspañol.setText("");
        vAvan.txtRespuestaOK.setText(info.getPalabraEspaniol());
        vAvan.txtPunteo.setText(Integer.toString(info.getPunteo()));
        vAvan.lbCross4.setVisible(false);
        vAvan.lbCheck2.setVisible(false);
        vAvan.txtRespuestaOK.setVisible(false);
        vAvan.txtPunteo.setVisible(false);
        vAvan.txtMsjRespuestaOK.setVisible(false);
        
        vAvan.btnSiguiente.setVisible(false);
        vAvan.btnConfirmarAv2.setVisible(true); 
    }
    
        public void ingresaScore(){      
        this.svo.setIdUsuarioFk(Integer.parseInt(this.vIn.txtIdUsuario.getText()));
        this.svo.setPunteoScore(punteo); 
        if(sdao.insertStore(svo)==true){
            vAvan.jopAvanzado.showMessageDialog(vAvan,"Se ingreso su punteo "+punteo);
        }else{
            vAvan.jopAvanzado.showMessageDialog(vAvan,"Error al ingresar su punteo ");            
        }       
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vAvan.btnCancelarAva){
            loopNumero=1;
            traNumero=1; 
            punteo=0; 
            punteoFinal=0;
            
            vAvan.dispose();
        }
        if(e.getSource()==this.vAvan.btnConfirmarAv1){
            this.comprobar();
        }
        if(e.getSource()==this.vAvan.btnConfirmarAv2){
            this.comprobarTraductor();
        }
        if(e.getSource()==this.vAvan.btnSiguiente){
            this.traNumero++;
            llenaTraductor(traNumero);
            vAvan.setVisible(true);
            if (traNumero>=3){
                vAvan.btnSiguiente.setVisible(false);
                
                
            }
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        loopNumero=1;
        traNumero=1; 
        punteo=0; 
        punteoFinal=0;
        this.Actualizar();
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        this.Actualizar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }
    
}
