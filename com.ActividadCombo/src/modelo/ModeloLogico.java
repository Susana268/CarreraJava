 
package modelo;
 
public class ModeloLogico {
    public String palabraEsp;
    public String palabraIng;
    String matriz[][]=new String[11][2];
    
    public void setPalabraEsp(String palabraEsp) {
        this.palabraEsp = palabraEsp;
    }

    public void setPalabraIng(String palabraIng) {
        this.palabraIng = palabraIng;
    }

    public void setMatriz(String[][] matriz) {
        this.matriz = matriz;
    }
   
    public ModeloLogico() {
    }

    public String getPalabraEsp() {
        return palabraEsp;
    }

    public String getPalabraIng() {
        return palabraIng;
    }
    
    public void llenar(){
        this.matriz[0][0]="Hola";
        this.matriz[0][1]="Hi";
        this.matriz[1][0]="Buenos Dias";
        this.matriz[1][1]="Good Morning";
        this.matriz[2][0]="Buenas Noches";
        this.matriz[2][1]="Good evening";
        this.matriz[3][0]="Adios";
        this.matriz[3][1]="By";
        this.matriz[4][0]="Lunes";
        this.matriz[4][1]="Monday";
        this.matriz[5][0]="Martes";
        this.matriz[5][1]="Tuesday";
        this.matriz[6][0]="Miercoles";
        this.matriz[6][1]="Wednesday";
        this.matriz[7][0]="Jueves";
        this.matriz[7][1]="Thuesday";
        this.matriz[8][0]="Viernes";
        this.matriz[8][1]="Friday";
        this.matriz[9][0]="Sabado";
        this.matriz[9][1]="Saturday";
        this.matriz[10][0]="Domingo";
        this.matriz[10][1]="Sunday";
    }   
    public String traducir(){
        for(int i=0;i<matriz.length;i++){
            if (matriz[i][0]==this.palabraEsp){
                this.palabraIng=matriz[i][1];
            }
        }
        return this.palabraIng;        
        }
  
    
}
