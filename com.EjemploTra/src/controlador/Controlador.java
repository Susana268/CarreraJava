
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import modelo.Modelo;
import vista.FrmTraductor;

public class Controlador implements ActionListener,WindowListener  {
    FrmTraductor vista = new FrmTraductor();
    Modelo modelo = new Modelo();

    public Controlador(FrmTraductor vista, Modelo modelo) {
        this.vista=vista;
        this.modelo=modelo;
        
        this.vista.btnTraductor.addActionListener(this);
        this.vista.addWindowListener(this);
    }
    
    private void llenado(){ 
        for(String item:modelo.llenarCombo()){
            this.vista.cbxPalabras.addItem(item);
        }
        
    }
    
    private void traducirPalabra(){
        this.modelo.setIndexPalabra(this.vista.cbxPalabras.getSelectedIndex());
        this.vista.txtPalabraTraducida.setText(this.modelo.traducirPalabra());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vista.btnTraductor){
            this.traducirPalabra();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.llenado();
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
     }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }

   
    
    
    
}
