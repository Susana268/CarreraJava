 
package controlador;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloLogico;
import vista.FrmMenu; 

public class Controlador implements ActionListener{
    FrmMenu vista = new FrmMenu();
    ModeloLogico modelo = new ModeloLogico();

    public Controlador (FrmMenu vista,ModeloLogico modelo) {
        
        this.vista=vista;
        this.modelo=modelo;
        this.vista.miAbrir.addActionListener(this);
        this.vista.miGruardar.addActionListener(this);
        this.vista.miMayuscula.addActionListener(this);
        this.vista.miMinuscula.addActionListener(this);
        this.vista.miNegrita.addActionListener(this);
        
    }

    public void abrir(){
        int cierre = vista.fcEmergente.showOpenDialog(vista);
        if (cierre!=vista.fcEmergente.CANCEL_OPTION){
            modelo.setRuta(vista.fcEmergente.getSelectedFile().toString());
            vista.txtArea.setText(modelo.abrir());
        }
    }
    public void guardar(){
        int cierre = vista.fcEmergente.showSaveDialog(vista);
        if (cierre!=vista.fcEmergente.CANCEL_OPTION){
            modelo.setTexto(vista.txtArea.getText());
            modelo.setRuta(vista.fcEmergente.getSelectedFile().toString());
            modelo.guardar();
        }
    }
    public void negrita(){
        vista.txtArea.setFont(this.modelo.negrita());
    }
    
    public void mayuscula(){ 
        vista.txtArea.setText(modelo.mayuscula(vista.txtArea.getText()));
    }
    public void minuscula(){
        vista.txtArea.setText(modelo.minuscula(vista.txtArea.getText()));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista.miAbrir){
            abrir();
        }
        if (e.getSource()==vista.miGruardar){
            guardar();
        }
        if (e.getSource()==vista.miNegrita){
            negrita();
        }
        if (e.getSource()==vista.miMayuscula){
            mayuscula();
        }
        if (e.getSource()==vista.miMinuscula){
            minuscula();
        }
    }
    
}
