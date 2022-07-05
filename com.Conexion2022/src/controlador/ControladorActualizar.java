
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import modelo.Extras;

import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmActualizar;  

public class ControladorActualizar implements ActionListener,WindowListener,MouseListener{
    FrmActualizar vAc = new FrmActualizar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorActualizar (FrmActualizar vAc,PaisVO pvo,PaisDAO pdao){
        this.vAc = vAc;
        this.pvo = pvo;
        this.pdao = pdao;
        vAc.btnCancelarAct.addActionListener(this);
        vAc.btnRegistrarAct.addActionListener(this);
        vAc.addWindowListener(this);
        vAc.tblActualizar.addMouseListener(this);

    }
    
    private void actualizar(){ 
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("id del Pais");
        m.addColumn("Nombre Pais");
        m.addColumn("Capital Pais");
        m.addColumn("Poblacion del Pais");
        for(PaisVO pvo: pdao.consultar()){
            m.addRow(new Object[]{
                pvo.getIdPais(),
                pvo.getNombrePais(),
                pvo.getCapitalPais(),
                pvo.getPoblacionPais()
            });
        }
        vAc.tblActualizar.setModel(m);
    }
    
    private void seleccionar(){
        int row = vAc.tblActualizar.getSelectedRow();
        int col = vAc.tblActualizar.getSelectedColumn();
        vAc.txtIdPais.setText(String.valueOf(vAc.tblActualizar.getValueAt(row, 0)));
        vAc.txtNombrePais.setText(String.valueOf(vAc.tblActualizar.getValueAt(row, 1)));
        vAc.txtCapitalPais.setText(String.valueOf(vAc.tblActualizar.getValueAt(row, 2)));
        vAc.txtPoblacionPais.setText(String.valueOf(vAc.tblActualizar.getValueAt(row, 3)));
    }
    
    private void registrarPaisAct(){
        this.pvo.setIdPais(Integer.parseInt(this.vAc.txtIdPais.getText()));
        this.pvo.setNombrePais(this.vAc.txtNombrePais.getText());
        this.pvo.setCapitalPais(this.vAc.txtCapitalPais.getText());
        this.pvo.setPoblacionPais(Long.parseLong(this.vAc.txtPoblacionPais.getText()));
        this.pvo.setFechaActPais(Extras.fechaHoy());
        
        if (pdao.actualizar(pvo)==true){
            vAc.jopActualizar.showMessageDialog(vAc,"Datos Registrados Correctamentes");
              this.vAc.txtIdPais.setText("");
              this.vAc.txtNombrePais.setText("");
              this.vAc.txtCapitalPais.setText("");
              this.vAc.txtPoblacionPais.setText("");
              
        }else {
            vAc.jopActualizar.showMessageDialog(vAc,"Error, Datos no registrados"); 
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vAc.btnRegistrarAct){
            if(!this.vAc.txtIdPais.getText().equals("")&&
               !this.vAc.txtNombrePais.getText().equals("")&&
               !this.vAc.txtCapitalPais.getText().equals("")&&
               !this.vAc.txtPoblacionPais.getText().equals("") 
               )
            {
              this.registrarPaisAct();  
              this.actualizar();
            }
            else {   
                this.vAc.jopActualizar.showMessageDialog(vAc, "Debe de llenar todos los campos");
            }
        }
        
        if(e.getSource()==vAc.btnCancelarAct){
            vAc.dispose();
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

    @Override
    public void mouseClicked(MouseEvent e) { 
        // if (e.getClickCount()==2)
        this.seleccionar();
    }

    @Override
    public void mousePressed(MouseEvent e) { 
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
