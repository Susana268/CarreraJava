 
package modelo;
 
public class RespuestaVO {
    int idRespuesta;
    String descRespuesta;
    int punteo;
    int idPreguntaFk;

    public RespuestaVO() {
    }

    public RespuestaVO(int idRespuesta, String descRespuesta) {
        this.idRespuesta = idRespuesta;
        this.descRespuesta = descRespuesta;
    }

    public RespuestaVO(int idRespuesta, String descRespuesta, int punteo) {
        this.idRespuesta = idRespuesta;
        this.descRespuesta = descRespuesta;
        this.punteo = punteo;
    }

    public RespuestaVO(int idRespuesta, String descRespuesta, int punteo, int idPreguntaFk) {
        this.idRespuesta = idRespuesta;
        this.descRespuesta = descRespuesta;
        this.punteo = punteo;
        this.idPreguntaFk = idPreguntaFk;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getDescRespuesta() {
        return descRespuesta;
    }

    public void setDescRespuesta(String descRespuesta) {
        this.descRespuesta = descRespuesta;
    }

    public int getPunteo() {
        return punteo;
    }

    public void setPunteo(int punteo) {
        this.punteo = punteo;
    }

    public int getIdPreguntaFk() {
        return idPreguntaFk;
    }

    public void setIdPreguntaFk(int idPreguntaFk) {
        this.idPreguntaFk = idPreguntaFk;
    }
    public String toString(){
        return idRespuesta+"-"+descRespuesta;
    }    
    
}
