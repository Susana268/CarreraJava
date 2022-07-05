
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import modelo.TipoUsuarioDAO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmUsuario;


public class ControladorInsertar implements ActionListener,WindowListener,MouseListener,ItemListener {
    FrmUsuario vUs = new FrmUsuario();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao = new UsuarioDAO();
    TipoUsuarioVO tvo = new TipoUsuarioVO();
    TipoUsuarioDAO tdao = new TipoUsuarioDAO();
    
    public ControladorInsertar(FrmUsuario vUs,
                               UsuarioVO uvo,
                               UsuarioDAO udao) {
        this.vUs=vUs;
        this.uvo=uvo;
        this.udao=udao;
        vUs.btnIngresar.addActionListener(this);
        vUs.btnActualizar.addActionListener(this);
        vUs.btnEliminar.addActionListener(this);
        vUs.btnCancelar.addActionListener(this);
        vUs.addWindowListener(this);
        vUs.tblMostrar.addMouseListener(this);
        vUs.cbxTipoUsuario.addItemListener(this);
        vUs.lblReporte.addMouseListener(this);
    }

    public void actualizar(){
        llenaTipoUsuario();
        DefaultTableModel m = new DefaultTableModel(); 
        m.setColumnCount(0);
        m.addColumn("id Usuario");
        m.addColumn("Nombre Usuario");
        m.addColumn("Apellido Usuario");
        m.addColumn("Edad");
        m.addColumn("User");
        m.addColumn("Password");
        m.addColumn("Estado");
        m.addColumn("Tipo Usuario");
        for(UsuarioVO uvo:udao.consultar()){
           m.addRow(new Object[]{ 
            uvo.getIdUsuario(),
            uvo.getNombreUsuario(),
            uvo.getApellidoUsuario(),
            uvo.getEdadUsuario(),
            uvo.getUser(),
            uvo.getPassword(),
            uvo.getEstado(),
            uvo.getIdTipoUsuarioFk()
        });        
        }
        vUs.tblMostrar.setModel(m);
    }
    
    //Llena Lista de Tipos de usuario
    public void llenaTipoUsuario(){
        TipoUsuarioDAO tdao = new TipoUsuarioDAO();
        ArrayList<TipoUsuarioVO> info = tdao.getTipoUsuario();
        vUs.cbxTipoUsuario.removeAllItems();
        for(int i = 0;i<info.size();i++){
            vUs.cbxTipoUsuario.addItem(new TipoUsuarioVO(info.get(i).getIdTipoUsuario(),
                                                         info.get(i).getNombreTipoUsuario()));
        }
    }
    public void insertarUsuario(){
        this.uvo.setNombreUsuario(this.vUs.txtNombre.getText());
        this.uvo.setApellidoUsuario(this.vUs.txtApellido.getText());
        this.uvo.setEdadUsuario(Integer.parseInt(this.vUs.txtEdad.getText()));
        this.uvo.setUser(this.vUs.txtUsuario.getText());
        this.uvo.setPassword(String.valueOf(this.vUs.jpaPassword.getPassword()));
        this.uvo.setEstado(this.vUs.txtEstado.getText());
        this.uvo.setIdTipoUsuarioFk(Integer.parseInt(this.vUs.txtIdTipoUsuarioFk.getText()));
        if (udao.insertar(uvo)==true){
            vUs.jopUsuairo.showMessageDialog(vUs,"Datos Registrados Correctamente");
            this.vUs.txtNombre.setText("");
            this.vUs.txtApellido.setText("");
            this.vUs.txtEdad.setText("");
            this.vUs.txtUsuario.setText("");
            this.vUs.jpaPassword.setText("");
            this.vUs.txtEstado.setText(""); 
            this.vUs.txtIdTipoUsuarioFk.setText("");
        }else{
            vUs.jopUsuairo.showMessageDialog(vUs, "Error, Datos no registrados");
        }
    }    
    public void registrarUsuario(){
        this.uvo.setIdUsuario(Integer.parseInt(this.vUs.txtIdUsuario.getText()));
        this.uvo.setNombreUsuario(this.vUs.txtNombre.getText());
        this.uvo.setApellidoUsuario(this.vUs.txtApellido.getText());
        this.uvo.setEdadUsuario(Integer.parseInt(this.vUs.txtEdad.getText()));
        this.uvo.setUser(this.vUs.txtUsuario.getText());
        this.uvo.setPassword(String.valueOf(this.vUs.jpaPassword.getPassword()));
        this.uvo.setEstado(this.vUs.txtEstado.getText());
        this.uvo.setIdTipoUsuarioFk(Integer.parseInt(this.vUs.txtIdTipoUsuarioFk.getText()));
        if (udao.actualizar(uvo)==true){
            vUs.jopUsuairo.showMessageDialog(vUs,"Datos Registrados Correctamente");
            this.vUs.txtIdUsuario.setText("");
            this.vUs.txtNombre.setText("");
            this.vUs.txtApellido.setText("");
            this.vUs.txtEdad.setText("");
            this.vUs.txtUsuario.setText("");
            this.vUs.jpaPassword.setText("");
            this.vUs.txtEstado.setText(""); 
            this.vUs.txtIdTipoUsuarioFk.setText("");
        }else{
            vUs.jopUsuairo.showMessageDialog(vUs, "Error, Datos no registrados");
        }        
    }
    
    public void eliminarUsuario(){
        this.uvo.setIdUsuario(Integer.parseInt(this.vUs.txtIdUsuario.getText()));
        if (udao.eliminar(uvo)==true){
            vUs.jopUsuairo.showMessageDialog(vUs,"Datos Eliminados Correctamente");
            this.vUs.txtIdUsuario.setText("");
            this.vUs.txtNombre.setText("");
            this.vUs.txtApellido.setText("");
            this.vUs.txtEdad.setText("");
            this.vUs.txtUsuario.setText("");
            this.vUs.jpaPassword.setText("");
            this.vUs.txtEstado.setText(""); 
            this.vUs.txtIdTipoUsuarioFk.setText("");
        }else {
            vUs.jopUsuairo.showMessageDialog(vUs, "Error, Datos no registrados");
        }
    }
    
    public void seleccionar(){
        int row=vUs.tblMostrar.getSelectedRow();
        vUs.txtIdUsuario.setText(String.valueOf(vUs.tblMostrar.getValueAt(row, 0)));
        vUs.txtNombre.setText(String.valueOf(vUs.tblMostrar.getValueAt(row, 1)));
        vUs.txtApellido.setText(String.valueOf(vUs.tblMostrar.getValueAt(row, 2)));
        vUs.txtEdad.setText(String.valueOf(vUs.tblMostrar.getValueAt(row, 3)));
        vUs.txtUsuario.setText(String.valueOf(vUs.tblMostrar.getValueAt(row, 4)));
        vUs.jpaPassword.setText(String.valueOf(vUs.tblMostrar.getValueAt(row, 5)));
        vUs.txtEstado.setText(String.valueOf(vUs.tblMostrar.getValueAt(row, 6)));
        vUs.txtIdTipoUsuarioFk.setText(String.valueOf(vUs.tblMostrar.getValueAt(row, 7)));
        
    }
    
    private void reporte(){
        udao.reporte();
        udao.jv.setDefaultCloseOperation(vUs.DISPOSE_ON_CLOSE);
        udao.jv.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.vUs.btnIngresar){    
        if (!this.vUs.txtNombre.getText().equals("")&&
               !this.vUs.txtApellido.getText().equals("")&&
               !this.vUs.txtEdad.getText().equals("")&&
               !this.vUs.txtUsuario.getText().equals("")&&
               !this.vUs.jpaPassword.getPassword().equals("")&&
               !this.vUs.txtEstado.getText().equals("") 
            )
            {
                this.insertarUsuario();
                this.actualizar();
            }else {
                this.vUs.jopUsuairo.showMessageDialog(vUs, "Debe lletar todos los campos");
            }
        }
        if (e.getSource()==this.vUs.btnActualizar){
           if (!this.vUs.txtNombre.getText().equals("")&&
               !this.vUs.txtApellido.getText().equals("")&&
               !this.vUs.txtEdad.getText().equals("")&&
               !this.vUs.txtUsuario.getText().equals("")&&
               !this.vUs.jpaPassword.getPassword().equals("")&&
               !this.vUs.txtEstado.getText().equals("") 
            ){
               this.registrarUsuario();
               this.actualizar();
           }
        
        }
        if (e.getSource()==this.vUs.btnEliminar){
            if(!this.vUs.txtIdUsuario.getText().equals("")){
                this.eliminarUsuario();
                this.actualizar();
            }else {
                this.vUs.jopUsuairo.showMessageDialog(vUs,"Debe de seleccionar un usuario");
            }
                     
        }
          
        if(e.getSource()==this.vUs.btnCancelar){
            vUs.dispose();
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
        if(e.getSource()==vUs.lblReporte){
            if(e.getClickCount()==2){
                this.reporte();
            }
        } else {
        this.seleccionar();
        }
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

    @Override
    public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange()==ItemEvent.SELECTED){ 
            int id = this.vUs.cbxTipoUsuario.getItemAt(vUs.cbxTipoUsuario.getSelectedIndex()).getIdTipoUsuario() ;
            this.vUs.txtIdTipoUsuarioFk.setText(String.valueOf(id)); 
            }
    }

}
    
