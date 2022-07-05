
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.PaisDAO;
import modelo.PaisVO;
import vista.FrmMostrar;

public class ControladorMostrar implements ActionListener,
                                            WindowListener{

    FrmMostrar vMo = new FrmMostrar();
    PaisVO pvo = new PaisVO();
    PaisDAO pdao = new PaisDAO();

    public ControladorMostrar(FrmMostrar vMo, PaisVO pvo, PaisDAO pdao) {
        this.vMo=vMo;
        this.pvo = pvo;
        this.pdao = pdao;
        vMo.btnCancelarMos.addActionListener(this);
        vMo.addWindowListener(this);
    
    }
    private void mostrar(){
        DefaultTableModel m = new DefaultTableModel();
        m.setColumnCount(0);
        m.addColumn("Id del Pais");
        m.addColumn("Nombre Pais");
        m.addColumn("Capital Pais");
        m.addColumn("Poblacion del Pais");
        
        for(PaisVO pvo : pdao.consultar() ){
            m.addRow(new Object[]{  pvo.getIdPais(),
                                    pvo.getNombrePais(),
                                    pvo.getCapitalPais(),
                                    pvo.getPoblacionPais()});
        }
                
                
        vMo.tblMostrar.setModel(m);
        TableColumn cCero= vMo.tblMostrar.getColumnModel().getColumn(0);
        cCero.setMaxWidth(75);
        cCero.setMinWidth(75);
        TableColumn cUno= vMo.tblMostrar.getColumnModel().getColumn(1);
        cUno.setMaxWidth(100);
        cUno.setMinWidth(100);
        TableColumn cDos= vMo.tblMostrar.getColumnModel().getColumn(2);
        cDos.setMaxWidth(100);
        cDos.setMinWidth(100);  
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vMo.btnCancelarMos){
            vMo.dispose();
        } 
    }

    @Override
    public void windowOpened(WindowEvent e) {
        this.mostrar();
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
        this.mostrar();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
