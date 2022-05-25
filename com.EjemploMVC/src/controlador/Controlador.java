

package controlador;
//importo la clase porque esta en otro paquete
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import vista.FrmOperaciones;
import modelo.ModeloLogico;
// implementa 
public class Controlador implements ActionListener {
    //Creacion de objetos a los cuales va a tener acceso el controlador
    FrmOperaciones vista = new FrmOperaciones();
    ModeloLogico modelo = new ModeloLogico();
//Constructor
    public Controlador(FrmOperaciones vista,
                        ModeloLogico modelo){
        this.vista = vista;
        this.modelo= modelo; 
        //reservamos el espacio para la accion
        this.vista.btnSumar.addActionListener(this);
        this.vista.btnRestar.addActionListener(this);
        this.vista.btnMultiplicar.addActionListener(this);
        this.vista.btnDividir.addActionListener(this);
    }
    // Funcionamiento del controlador
    private void sum(){
        //Proceso controlador para trasladar los datos al modelo
        this.modelo.setN1(Double.parseDouble(this.vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(this.vista.txtN2.getText()));
        //Proceso controlador para recibir y trasladar la respuesta a la vista
        vista.jOptionPane1.showMessageDialog(this.vista,modelo.suma());
    }
    private void rest(){
        this.modelo.setN1(Double.parseDouble(vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(vista.txtN2.getText()));
        vista.jOptionPane1.showMessageDialog(this.vista,modelo.resta());
    }
    //creo el metodo para el funcionamiento del controlador
    private void mult(){
        this.modelo.setN1(Double.parseDouble(vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(vista.txtN2.getText()));
        vista.jOptionPane1.showMessageDialog(this.vista, modelo.multiplicar());
    }
    private void div(){
        this.modelo.setN1(Double.parseDouble(vista.txtN1.getText()));
        this.modelo.setN2(Double.parseDouble(vista.txtN2.getText()));
        vista.jOptionPane1.showMessageDialog(this.vista,modelo.dividir());
    }
    //Metodo abstracto de la implementacion del listener
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vista.btnSumar) 
            this.sum();
        if(e.getSource()== vista.btnRestar)
            this.rest();
        if(e.getSource()== vista.btnMultiplicar)
            this.mult();
        if(e.getSource()== vista.btnDividir)
            this.div();
    
    }
    
    
}
