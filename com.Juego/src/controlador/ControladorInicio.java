
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.TipoUsuarioDAO;
import modelo.TipoUsuarioVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FrmAvanzado;
import vista.FrmInicio;
import vista.FrmIntermedio;
import vista.FrmPrincipiante;
import vista.FrmUsuario;

public class ControladorInicio implements ActionListener {
    FrmInicio vIn = new FrmInicio();
    FrmUsuario vUs = new FrmUsuario();
    FrmPrincipiante vPr = new FrmPrincipiante();
    FrmIntermedio vInt = new FrmIntermedio();
    FrmAvanzado vAvan = new FrmAvanzado();
    UsuarioVO uvo = new UsuarioVO();
    UsuarioDAO udao= new UsuarioDAO();
    TipoUsuarioVO tvo = new TipoUsuarioVO();
    TipoUsuarioDAO tdao = new TipoUsuarioDAO();
    String adonde;
    
    public ControladorInicio (FrmInicio vIn,
                              FrmUsuario vUs,
                              FrmPrincipiante vPr,
                              FrmIntermedio vInt,
                              FrmAvanzado vAvan){
        
        this.vIn=vIn;
        this.vUs=vUs;
        this.vPr=vPr;
        this.vInt=vInt;
        this.vAvan=vAvan;
        vIn.btnIngresarIn.addActionListener(this);
        vIn.btnCancelarIn.addActionListener(this);
        vIn.txtIdUsuario.setVisible(false);
    }
    
    public void confirmaAcceso(){
        vUs.setVisible(true);
        vUs.setLocationRelativeTo(null);
        vUs.setResizable(false); 
       
    }
    public void principianteAcceso(){
        vPr.setVisible(true);
        vPr.setLocationRelativeTo(null);
        vPr.setResizable(false);
        
        vPr.txtSum1Res.setText("");
        vPr.txtSum2Res.setText("");
        vPr.txtRes1Res.setText("");
        vPr.txtRes2Res.setText("");
        vPr.txtMul1Res.setText("");
        vPr.txtDivl1Res.setText("");
        
    }

    public void intermedioAcceso(){
        vInt.setVisible(true);
        vInt.setLocationRelativeTo(null);
        vInt.setResizable(false);
    }
    
    public void avanzadoAcceso(){
        vAvan.setVisible(true);
        vAvan.setLocationRelativeTo(null);
        vAvan.setResizable(false);
        vAvan.txtNumero.setText("");
    }

    public void confirmaUsuario(){          
        this.uvo.setUser(this.vIn.txtUsuario.getText());
        this.uvo.setPassword(String.valueOf(this.vIn.txtPassword.getPassword()));
        
        UsuarioVO info = udao.getUsuario(uvo); 
        
        if (uvo.getPassword().equals(info.getPassword())){
            vIn.txtIdUsuario.setText(String.valueOf(info.getIdUsuario()));
            System.out.println("id txt conf "+this.vIn.txtIdUsuario.getText());
            this.tvo.setIdTipoUsuario(info.getIdTipoUsuarioFk());
            TipoUsuarioVO infoTipo= tdao.seleccionar(tvo);
            
            this.adonde=infoTipo.getNombreTipoUsuario();

            switch (adonde){
                case "Administrador":
                    this.confirmaAcceso();
                    break;
                case "Principiante":
                    this.principianteAcceso();
                    break;
                case "Intermedio":
                    this.intermedioAcceso();
                    break;
                case "Avanzado":
                    this.avanzadoAcceso();
                    break;
                default:
                    break;
            }
        }else {
            vIn.jopInicio.showMessageDialog(vIn,"Usuario o Password Incorrectos");
        }   
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vIn.btnIngresarIn){
            this.confirmaUsuario();
        }
        if(e.getSource()==this.vIn.btnCancelarIn){
            vIn.dispose();
        }

    }
    
}
