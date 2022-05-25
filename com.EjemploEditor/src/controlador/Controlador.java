
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelo;
import vista.FrmAreaTexto;


public class Controlador implements ActionListener {
    FrmAreaTexto vista=new FrmAreaTexto();
    Modelo modelo = new Modelo();

    public Controlador(FrmAreaTexto vista,
            Modelo modelo) {
        
        this.vista = vista;
        this.modelo=modelo;
        
        this.vista.miAbrir.addActionListener(this);       
        this.vista.miGuardar.addActionListener(this);
        this.vista.miNegrita.addActionListener(this);
    }

    private void guardar(){
        int cierre=  vista.fcEmergente.showSaveDialog(vista);
        if (cierre!=vista.fcEmergente.CANCEL_OPTION){
        modelo.setTexto(vista.txtArea.getText());
        modelo.setRuta(vista.fcEmergente.getSelectedFile().toString());
        modelo.guardar();
        }
    }
    private void abrir(){
        int cierre = vista.fcEmergente.showOpenDialog(vista);
        if(cierre!=vista.fcEmergente.CANCEL_OPTION) {
        modelo.setRuta(vista.fcEmergente.getSelectedFile().toString());
//       modelo.abrir();
//        vista.txtArea.setText(modelo.getTexto());
        vista.txtArea.setText(modelo.abrir());
        }
    }    
    private void negrita(){
        vista.txtArea.setFont(this.modelo.negrita());
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.miGuardar)
            this.guardar();
        if(e.getSource()==vista.miAbrir)
            this.abrir();
        if(e.getSource()==vista.miNegrita)    
            this.negrita();
            
        
    }
    
    
    
}
