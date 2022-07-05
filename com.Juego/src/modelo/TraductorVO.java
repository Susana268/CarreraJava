
package modelo;


public class TraductorVO {
    int idPalabra;
    String palabraIngles;
    String palabraEspaniol;
    int punteo;

    public TraductorVO() {
    }

    public int getIdPalabra() {
        return idPalabra;
    }

    public void setIdPalabra(int idPalabra) {
        this.idPalabra = idPalabra;
    }

    public String getPalabraIngles() {
        return palabraIngles;
    }

    public void setPalabraIngles(String palabraIngles) {
        this.palabraIngles = palabraIngles;
    }

    public String getPalabraEspaniol() {
        return palabraEspaniol;
    }

    public void setPalabraEspaniol(String palabraEspaniol) {
        this.palabraEspaniol = palabraEspaniol;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }
    
}
