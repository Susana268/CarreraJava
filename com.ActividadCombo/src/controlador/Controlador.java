 
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogico;
import vista.FrmTraductor;

public class Controlador implements ActionListener{
   FrmTraductor vista = new FrmTraductor();
   ModeloLogico modelo = new ModeloLogico();

    public Controlador(FrmTraductor vista,ModeloLogico modelo) {
        this.vista=vista;
        this.modelo=modelo;
        this.vista.btnTraducir.addActionListener(this);
    }
    private void llena(){
        modelo.llenar();
    }
    private void traduc(){ 
        this.modelo.setPalabraEsp(this.vista.cmbPalabras.getSelectedItem().toString());
        vista.jOptionPane1.showMessageDialog(vista, modelo.traducir());
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            
        if(e.getSource()== vista.btnTraducir){
            this.llena();
            this.traduc();
        }
    }
   
}
