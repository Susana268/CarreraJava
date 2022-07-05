
package modelo;

public class PreguntaVO {
   int idPregunta;
   String descPregunta;

    public PreguntaVO() {
    }

    public PreguntaVO(int idPregunta, String descPregunta) {
        this.idPregunta = idPregunta;
        this.descPregunta = descPregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getDescPregunta() {
        return descPregunta;
    }

    public void setDescPregunta(String descPregunta) {
        this.descPregunta = descPregunta;
    }
   
}
