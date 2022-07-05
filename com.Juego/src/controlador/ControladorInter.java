
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import modelo.PreguntaDAO;
import modelo.PreguntaVO;
import modelo.RespuestaDAO;
import modelo.RespuestaVO;
import modelo.ScoreDAO;
import modelo.ScoreVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmInicio;
import vista.FrmIntermedio;

public class ControladorInter implements ActionListener,WindowListener,ItemListener{
    FrmIntermedio vInt = new FrmIntermedio(); 
    FrmInicio vIn = new FrmInicio();
    PreguntaDAO pdao = new PreguntaDAO();
    PreguntaVO pvo = new PreguntaVO();    
    RespuestaDAO rdao = new RespuestaDAO();     
    RespuestaVO rvo = new RespuestaVO();
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();
    ScoreDAO sdao = new ScoreDAO();
    ScoreVO svo = new ScoreVO();
    
    int pregunta=1;
    int punteo=0;
    
    public ControladorInter(FrmIntermedio vInt,
                            FrmInicio vIn,
                            RespuestaVO rvo,
                            RespuestaDAO rdao) {
        this.vInt=vInt;
        this.vIn=vIn;
        vInt.btnCancelarInt.addActionListener(this);
        vInt.btnConfirmarInt.addActionListener(this);
        vInt.btnSiguiente.addActionListener(this);
        vInt.addWindowListener(this);
        vInt.cbxRespuestas.addItemListener(this); 
    }

    public void Actualizar(int pregunta){
        System.out.println("pregunta "+pregunta);
        pvo.setIdPregunta(pregunta);
        PreguntaVO info = pdao.getPregunta(pvo);
        vInt.txtPregunta.setText(info.getDescPregunta());
        llenaRespuesta(); 
        vInt.lbCheck.setVisible(false);
        vInt.lbCross.setVisible(false);
        vInt.respuesta.setVisible(false);
        vInt.respuestaOK.setVisible(false);
        vInt.txtMsjRespuestaOK.setVisible(false);
        
    }
    
    public void llenaRespuesta(){
        RespuestaDAO rdao = new RespuestaDAO();
        ArrayList<RespuestaVO> info = rdao.getRespuesta(pvo);
        vInt.cbxRespuestas.removeAllItems();
        for(int i=0;i<info.size();i++){
            vInt.cbxRespuestas.addItem(new RespuestaVO(info.get(i).getIdRespuesta(),
                                                       info.get(i).getDescRespuesta(),
                                                        info.get(i).getPunteo(),
                                                        info.get(i).getIdPreguntaFk()));
            if(info.get(i).getPunteo()==1){
                vInt.respuestaOK.setText(Integer.toString(info.get(i).getIdRespuesta()));
            }
         
        }
        vInt.btnSiguiente.setVisible(false);
        vInt.btnConfirmarInt.setVisible(true);
    }
    public void comprobar(){
         if (!(vInt.respuesta.getText().equals(vInt.respuestaOK.getText()))){
            vInt.respuestaOK.setVisible(true);
            vInt.lbCross.setVisible(true);
            vInt.txtMsjRespuestaOK.setVisible(true);
        } else{
            vInt.lbCheck.setVisible(true);       
            punteo++;
        }
        
         if (pregunta==5){
            ingresaScore();
            if (punteo>=5){
                uvo.setIdUsuario(Integer.parseInt(this.vIn.txtIdUsuario.getText()));
                uvo.setIdTipoUsuarioFk(4);
                udao.actTipo(uvo);
            }
            pregunta=1;
            punteo=0;
            vInt.dispose();
        } else {  
            vInt.btnSiguiente.setVisible(true);
            vInt.btnConfirmarInt.setVisible(false);
        }
    }
    
        public void ingresaScore(){ 
        this.svo.setIdUsuarioFk(Integer.parseInt(this.vIn.txtIdUsuario.getText()));
        this.svo.setPunteoScore(punteo);  
        if(sdao.insertStore(svo)==true){
            vInt.jopIntermedio.showMessageDialog(vInt,"Se ingreso su punteo "+punteo);
        }else{
            vInt.jopIntermedio.showMessageDialog(vInt,"Error al ingresar su punteo ");            
        }       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vInt.btnCancelarInt){
            pregunta=1;
            punteo=0;
            vInt.dispose();
        }
        if(e.getSource()==this.vInt.btnConfirmarInt){
            this.comprobar();
        }
        if(e.getSource()==this.vInt.btnSiguiente){
            vInt.btnSiguiente.setVisible(false);
            if (pregunta<5){
            pregunta++;
            this.Actualizar(pregunta);
            }
            
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        pregunta=1;
        this.Actualizar(pregunta);
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
        this.Actualizar(pregunta);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==ItemEvent.SELECTED){ 
            int id = this.vInt.cbxRespuestas.getItemAt(vInt.cbxRespuestas.getSelectedIndex()).getIdRespuesta() ;
            this.vInt.respuesta.setText(String.valueOf(id)); 
           }        
        
    }
    
}
