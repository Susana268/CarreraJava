
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogico;
import vista.FrmCalculadora;

public class Controlador implements ActionListener {
    FrmCalculadora vista = new FrmCalculadora();
    ModeloLogico modelo = new ModeloLogico();

    public Controlador(FrmCalculadora vista,ModeloLogico modelo) {
        this.vista=vista;
        this.modelo=modelo;
        //Reservamos espacio para la accion   
        this.vista.btnIgual.addActionListener(this);
        this.vista.btnSuma.addActionListener(this);
        this.vista.btnResta.addActionListener(this); 
        this.vista.btnMulti.addActionListener(this); 
        this.vista.btnDivision.addActionListener(this); 
        this.vista.btnSen.addActionListener(this);
        this.vista.btnCos.addActionListener(this);
        this.vista.btnTan.addActionListener(this);
        this.vista.btnAbs.addActionListener(this);
        this.vista.btnExp.addActionListener(this);
        this.vista.btnMod.addActionListener(this);
        this.vista.btnRed.addActionListener(this);
        this.vista.btnC.addActionListener(this);
        this.vista.btn1.addActionListener(this);
        this.vista.btn2.addActionListener(this);
        this.vista.btn3.addActionListener(this);
        this.vista.btn4.addActionListener(this);
        this.vista.btn5.addActionListener(this);
        this.vista.btn6.addActionListener(this);
        this.vista.btn7.addActionListener(this);
        this.vista.btn8.addActionListener(this);
        this.vista.btn9.addActionListener(this);
        this.vista.btn0.addActionListener(this);
        this.vista.btnPunto.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
    }
    
    public void operacion(){
        if (this.vista.txtDato.getText().isEmpty() ){
            this.modelo.setValor2(0);
        }else { 
            this.modelo.setValor2(Double.parseDouble(vista.txtDato.getText()));
        }  
        if(this.modelo.operador=="+"){
            this.vista.txtDato.setText(String.valueOf(modelo.suma())  );
        // this.vista.jOptionPane1.showMessageDialog(this.vista,modelo.suma());
        }
        if(this.modelo.operador=="-"){
        this.vista.txtDato.setText(String.valueOf(modelo.resta()));
        }
        if(this.modelo.operador=="*"){
        this.vista.txtDato.setText(String.valueOf(modelo.multi()));
        }
        if(this.modelo.operador=="/"){
        this.vista.txtDato.setText(String.valueOf(modelo.divi()));
        }
        if(this.modelo.operador=="Sen"){
        this.vista.txtDato.setText(String.valueOf(modelo.sen()));
        }
        if(this.modelo.operador=="Cos"){
        this.vista.txtDato.setText(String.valueOf(modelo.cos()));
        }
        if(this.modelo.operador=="Tan"){
        this.vista.txtDato.setText(String.valueOf(modelo.tan()));
        }
        if(this.modelo.operador=="Abs"){
        this.vista.txtDato.setText(String.valueOf(modelo.abs()));
        }
        if(this.modelo.operador=="X2"){
        this.vista.txtDato.setText(String.valueOf(modelo.potencia()));
        }
        if(this.modelo.operador=="≈"){
        this.vista.txtDato.setText(String.valueOf(modelo.redon()));
        }
        if(this.modelo.operador=="Mod"){
        this.vista.txtDato.setText(String.valueOf(modelo.modulo()));
        } 
    }    
    
    public void grabar(){ 
        int cierre=  vista.fcEmergente.showSaveDialog(vista);
        if (cierre!=vista.fcEmergente.CANCEL_OPTION){
        modelo.setTexto(modelo.getValor1()+" "+modelo.operador+" "+modelo.getValor2()+" = "+vista.txtDato.getText());
 
        modelo.setRuta(vista.fcEmergente.getSelectedFile().toString());
        modelo.guardar();
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista.btnIgual){ 
            this.operacion();
        }
        if (e.getSource()==vista.btnC){
            this.modelo.limpia();
            this.vista.txtDato.setText(modelo.texto);
        }
        if (e.getSource()==vista.btnSuma) {
            this.modelo.setOperador(vista.btnSuma.getText());
            if (vista.txtDato.getText().isEmpty() ){
                this.modelo.setValor1(0);
            }else {
                this.modelo.setValor1(Double.parseDouble(vista.txtDato.getText()));
            }
            this.vista.txtDato.setText(""); 
            modelo.texto="";
        }
        if  (e.getSource()==vista.btnResta)  {  
            this.modelo.setOperador(vista.btnResta.getText());
            if (vista.txtDato.getText().isEmpty() ){
                this.modelo.setValor1(0);
            }else {
            this.modelo.setValor1(Double.parseDouble(vista.txtDato.getText()));
            }
            this.vista.txtDato.setText("");
            modelo.texto="";
        }
        if  (e.getSource()==vista.btnMulti)  {  
            this.modelo.setOperador(vista.btnMulti.getText());
            if (vista.txtDato.getText().isEmpty() ){
                this.modelo.setValor1(0);
            }else {
            this.modelo.setValor1(Double.parseDouble(vista.txtDato.getText()));
            }
            this.vista.txtDato.setText("");
            modelo.texto="";
        }
        if  (e.getSource()==vista.btnDivision)  {  
            this.modelo.setOperador(vista.btnDivision.getText());
            if (vista.txtDato.getText().isEmpty() ){
                this.modelo.setValor1(0);
            }else {
            this.modelo.setValor1(Double.parseDouble(vista.txtDato.getText()));
            }
            this.vista.txtDato.setText("");
            modelo.texto="";
        }
        if (e.getSource()==vista.btnMod){
            this.modelo.setOperador(vista.btnMod.getText());
            if (vista.txtDato.getText().isEmpty() ){
                this.modelo.setValor1(0);
            }else {
            this.modelo.setValor1(Double.parseDouble(vista.txtDato.getText()));
            }
            this.vista.txtDato.setText("");
            modelo.texto="";
        }
        if(e.getSource()==vista.btnSen){
            this.modelo.setOperador(vista.btnSen.getText());
        }
        if(e.getSource()==vista.btnCos){
            this.modelo.setOperador(vista.btnCos.getText());
        }
        if(e.getSource()==vista.btnTan){
            this.modelo.setOperador(vista.btnTan.getText());
        } 
        if(e.getSource()==vista.btnAbs){
            this.modelo.setOperador(vista.btnAbs.getText());
        } 
        if(e.getSource()==vista.btnExp){
            this.modelo.setOperador(vista.btnExp.getText());
        } 
        if(e.getSource()==vista.btnRed){
            this.modelo.setOperador(vista.btnRed.getText());
        }
        if (e.getSource()==vista.btn1){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn1.getText()));
        }
        if (e.getSource()==vista.btn2){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn2.getText()));
        }
        if (e.getSource()==vista.btn3){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn3.getText()));
        }
        if (e.getSource()==vista.btn4){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn4.getText()));
        }
        if (e.getSource()==vista.btn5){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn5.getText()));
        }
        if (e.getSource()==vista.btn6){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn6.getText()));
        }
        if (e.getSource()==vista.btn7){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn7.getText()));
        }
        if (e.getSource()==vista.btn8){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn8.getText()));
        }
        if (e.getSource()==vista.btn9){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn9.getText()));
        }
        if (e.getSource()==vista.btn0){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btn0.getText()));
        }
        if (e.getSource()==vista.btnPunto){ 
            this.vista.txtDato.setText(modelo.LlenaTexto(vista.btnPunto.getText()));
        }
        if (e.getSource()==vista.btnGuardar){
            this.grabar();
        }
    }
    
    
}
