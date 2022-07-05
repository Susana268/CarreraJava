
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
import vista.FrmEliminar;

public class ControladorEliminar implements ActionListener,WindowListener,MouseListener{
    FrmEliminar vEl = new FrmEliminar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();
    
    public ControladorEliminar(FrmEliminar vEl,PaisVO pvo,PaisDAO pdao) {
        this.vEl = vEl;
        this.pvo = pvo;
        this.pdao = pdao;
        vEl.btnCancelarElm.addActionListener(this);
        vEl.btnRegistrarElm.addActionListener(this);
        vEl.addWindowListener(this);
        vEl.tblEliminar.addMouseListener(this);
        
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
        vEl.tblEliminar.setModel(m);
    }
    
    private void seleccionar(){
        int row = vEl.tblEliminar.getSelectedRow();
        int col = vEl.tblEliminar.getSelectedColumn();
        vEl.txtIdPais.setText(String.valueOf(vEl.tblEliminar.getValueAt(row, 0)));
        vEl.txtNombrePais.setText(String.valueOf(vEl.tblEliminar.getValueAt(row, 1)));
        vEl.txtCapitalPais.setText(String.valueOf(vEl.tblEliminar.getValueAt(row, 2)));
        vEl.txtPoblacionPais.setText(String.valueOf(vEl.tblEliminar.getValueAt(row, 3)));
    }
    
    private void registrarPaisElm(){
        this.pvo.setIdPais(Integer.parseInt(this.vEl.txtIdPais.getText()));
        this.pvo.setNombrePais(this.vEl.txtNombrePais.getText());
        this.pvo.setCapitalPais(this.vEl.txtCapitalPais.getText());
        this.pvo.setPoblacionPais(Long.parseLong(this.vEl.txtPoblacionPais.getText())); 
        this.pvo.setFechaActPais(Extras.fechaHoy());   
        if (pdao.eliminar(pvo)==true){
            vEl.jopEliminar.showMessageDialog(vEl,"Datos Eliminados Correctamentes");
              this.vEl.txtIdPais.setText("");
              this.vEl.txtNombrePais.setText("");
              this.vEl.txtCapitalPais.setText("");
              this.vEl.txtPoblacionPais.setText("");
              
        }else {
            vEl.jopEliminar.showMessageDialog(vEl,"Error, Datos no registrados"); 
        }
    }   
       
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource()==vEl.btnRegistrarElm){
            if(!this.vEl.txtIdPais.getText().equals("") 
               )
            {
              this.registrarPaisElm();  
              this.actualizar();
            }
            else {   
                this.vEl.jopEliminar.showMessageDialog(vEl, "Debe de llenar todos los campos");
            }
        }
        
        if(e.getSource()==vEl.btnCancelarElm){
            vEl.dispose();
        }
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.actualizar();
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
