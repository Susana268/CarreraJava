
package modelo;

import java.io.FileWriter;
import java.io.PrintWriter;


public class ModeloLogico {
    public double valor1;
    public double valor2;
    public String operador;
    public double resultado;
    public String texto="";
    private String ruta;

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public ModeloLogico() {
    }
    public String LlenaTexto(String valor){
        this.texto+=valor;  
        return this.texto;
    }
    public void limpia(){
        this.texto="";
        this.valor1=0.0;
        this.valor2=0.0;
    }
    
    public void guardar(){
        FileWriter fw;
        PrintWriter pw;
        try{
            fw=new FileWriter(ruta+".txt");
            pw = new PrintWriter(fw);
            pw.println(this.texto);
            fw.close();
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
    
    public double suma(){
        this.resultado=this.valor1+this.valor2;
        return this.resultado;
    }
    public double resta(){
        this.resultado=this.valor1-this.valor2;
        return this.resultado;
    }
    public double multi(){
        this.resultado=this.valor1*this.valor2;
        return this.resultado;
    }
    public double divi(){
        if (this.valor2!=0){
            this.resultado=this.valor1/this.valor2;
        }else {
            this.resultado=0;        
                }
        return this.resultado;
    }
    public double sen(){
        this.resultado=Math.sin(valor2);
        return this.resultado;
    }
    public double cos(){
        this.resultado=Math.cos(valor2);
        return this.resultado;
    }
    public double tan(){
        this.resultado =Math.tan(valor2);
        return this.resultado;
    }
    public double abs(){
        this.resultado =Math.abs(valor2);
        return this.resultado;
    }
    public double potencia(){
        this.resultado=Math.pow(valor2, 2);
        return this.resultado;
    }
    public double modulo(){
        this.resultado=this.valor1%this.valor2;
        return this.resultado;
    }
    public double redon(){
        this.resultado=Math.round(this.valor2); 
        return this.resultado;
    }
}
