
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;
import modelo.ScoreDAO;
import modelo.ScoreVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmInicio;
import vista.FrmPrincipiante;

public class ControladorPrin implements ActionListener,WindowListener {
    FrmPrincipiante vPr = new FrmPrincipiante();
    FrmInicio vIn = new FrmInicio();
    ScoreDAO sdao = new ScoreDAO();
    ScoreVO svo = new ScoreVO();
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();
    int punteo=0;
    
    public ControladorPrin(FrmPrincipiante vPr,FrmInicio vIn){
        this.vPr = vPr;
        this.vIn = vIn;
        vPr.btnConfirmarPri.addActionListener(this);
        vPr.btnCancelarPri.addActionListener(this);
        vPr.addWindowListener(this);
        
    }

    public void actualizar(){
        int ini=1;
        int fin=10;
        int valor1;
        int valor2;
        Random aleatorio = new Random();
        valor1 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtSum1Ca1.setText(Integer.toString(valor1)); 
        valor2 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtSum1Ca2.setText(Integer.toString(valor2));
        vPr.txtSum1OK.setText(Integer.toString(valor1+valor2));
        vPr.txtSum1OK.setVisible(false);
                 
        valor1 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtSum2Ca1.setText(Integer.toString(valor1)); 
        valor2 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtSum2Ca2.setText(Integer.toString(valor2));
        vPr.txtSum2OK.setText(Integer.toString(valor1+valor2));
        vPr.txtSum2OK.setVisible(false);
        
        valor1 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtRes1Ca1.setText(Integer.toString(valor1));
        valor2 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtRes1Ca2.setText(Integer.toString(valor2));
        vPr.txtRes1OK.setText(Integer.toString(valor1-valor2));
        vPr.txtRes1OK.setVisible(false);
        
        valor1 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtRes2Ca1.setText(Integer.toString(valor1));
        valor2 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtRes2Ca2.setText(Integer.toString(valor2));
        vPr.txtRes2OK.setText(Integer.toString(valor1-valor2));
        vPr.txtRes2OK.setVisible(false);
        
        valor1 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtMul1Ca1.setText(Integer.toString(valor1));
        valor2 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtMul1Ca2.setText(Integer.toString(valor2));
        vPr.txtMul1OK.setText(Integer.toString(valor1*valor2));
        vPr.txtMul1OK.setVisible(false);
        
        valor1 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtDiv1Ca1.setText(Integer.toString(valor1));
        valor2 = aleatorio.nextInt(fin-ini+1)+ini;
        vPr.txtDiv1Ca2.setText(Integer.toString(valor2));
        vPr.txtDiv1OK.setText(Integer.toString(valor1/valor2));
        vPr.txtDiv1OK.setVisible(false);
        
        vPr.lbCheck.setVisible(false);
        vPr.lbCross.setVisible(false);
        
    }
    public void comprobar(){
    
    if (!(vPr.txtSum1Res.getText().equals(vPr.txtSum1OK.getText()))||
        !(vPr.txtSum2Res.getText().equals(vPr.txtSum2OK.getText()))||
        !(vPr.txtRes1Res.getText().equals(vPr.txtRes1OK.getText()))||
        !(vPr.txtRes2Res.getText().equals(vPr.txtRes2OK.getText()))||
        !(vPr.txtMul1Res.getText().equals(vPr.txtMul1OK.getText()))||
        !(vPr.txtDivl1Res.getText().equals(vPr.txtDiv1OK.getText()))
       ) {
            vPr.txtSum1OK.setVisible(true);
            vPr.txtSum2OK.setVisible(true);
            vPr.txtRes1OK.setVisible(true);
            vPr.txtRes2OK.setVisible(true);
            vPr.txtMul1OK.setVisible(true);
            vPr.txtDiv1OK.setVisible(true);
            vPr.lbCross.setVisible(true);
            punteo=0;
            ingresaScore();
        } else{
            vPr.lbCheck.setVisible(true);
            punteo=5;
            ingresaScore();
            uvo.setIdUsuario(Integer.parseInt(this.vIn.txtIdUsuario.getText()));
            uvo.setIdTipoUsuarioFk(3);
            udao.actTipo(uvo);
                    
        }
            vPr.dispose();
    }
    
    public void ingresaScore(){ 
        this.svo.setIdUsuarioFk(Integer.parseInt(this.vIn.txtIdUsuario.getText()));
        this.svo.setPunteoScore(punteo);  
        if(sdao.insertStore(svo)==true){
            vPr.jopPrincipiante.showMessageDialog(vPr,"Se ingreso su punteo "+punteo);
        }else{
            vPr.jopPrincipiante.showMessageDialog(vPr,"Error al ingreso su punteo ");            
        }       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vPr.btnCancelarPri){
            vPr.dispose();
        }
        if(e.getSource()==this.vPr.btnConfirmarPri){
            this.comprobar();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.actualizar();
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
        this.actualizar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
