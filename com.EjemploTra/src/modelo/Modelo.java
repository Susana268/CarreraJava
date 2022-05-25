/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Susana Gonzalez
 */
public class Modelo {

    public Modelo() {
     
    }
    private int indexPalabra;

    public int getIndexPalabra() {
        return indexPalabra;
    }

    public void setIndexPalabra(int indexPalabra) {
        this.indexPalabra = indexPalabra;
    }
    public String[] llenarCombo(){
        String[] palabra= new String[6]; 
        palabra[0]="-";
        palabra[1]="Hello";
        palabra[2]="Car";
        palabra[3]="Dog";
        palabra[4]="Red";
        palabra[5]="Run";
        
        return palabra;
    }
    
    public String traducirPalabra(){
        String es;
        switch(this.indexPalabra){
            case 1:
                es="Hola";
                break;
            case 2:
                es="Carro";
                break;
            case 3:
                es="Perro";
                break;
            case 4:
                es="Rojo";
                break;
            case 5:
                es="Correr";
                break;
            case 0:
                es="Debe de elegir una palabra";
                break;
            default:
                es="No se ha elegido nada";
                break; 
        } 
           return es; 
    }
    
    
}
