
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Extras;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmInsertar;

public class ControladorInsertar implements ActionListener{

    FrmInsertar vIn = new FrmInsertar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorInsertar(FrmInsertar vIn, PaisVO pvo, PaisDAO pdao){
            this.vIn = vIn;
            this.pvo = pvo;
            this.pdao = pdao;
            
            vIn.btnRegitrarPais.addActionListener(this);
            vIn.btnCancelarRegitro.addActionListener(this);
            
    }
    private void registrarPais(){
        this.pvo.setNombrePais(this.vIn.txtNombrePais.getText());
        this.pvo.setCapitalPais(this.vIn.txtCapitalPais.getText());
        this.pvo.setPoblacionPais(Long.parseLong(this.vIn.txtPoblacionPais.getText()));
        this.pvo.setFechaIngPais(Extras.fechaHoy());
    
        if (pdao.insertar(pvo)==true){
            vIn.jopMensaje.showMessageDialog(vIn,"Datos Registrados Correctamentes");
            this.vIn.txtNombrePais.setText("");
            this.vIn.txtCapitalPais.setText("");
            this.vIn.txtPoblacionPais.setText("");
        }else {
            vIn.jopMensaje.showMessageDialog(vIn,"Error, Datos no registrados");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vIn.btnRegitrarPais){
            if(!this.vIn.txtNombrePais.getText().equals("")&&
               !this.vIn.txtCapitalPais.getText().equals("")&&
               !this.vIn.txtPoblacionPais.getText().equals("")     
              )
            {
            this.registrarPais();
            }
            else {
                this.vIn.jopMensaje.showMessageDialog(vIn, "Debe de llenar todos los campos");
            }
        }
        if(e.getSource()==vIn.btnCancelarRegitro){
            vIn.dispose();
        }
    }
    
}
