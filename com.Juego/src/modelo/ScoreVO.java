
package modelo;

public class ScoreVO {
    int idScore;
    int punteoScore;
    int idUsuarioFk;

    public ScoreVO() {
    }

    public int getIdScore() {
        return idScore;
    }

    public void setIdScore(int idScore) {
        this.idScore = idScore;
    }

    public int getPunteoScore() {
        return punteoScore;
    }

    public void setPunteoScore(int punteoScore) {
        this.punteoScore = punteoScore;
    }

    public int getIdUsuarioFk() {
        return idUsuarioFk;
    }

    public void setIdUsuarioFk(int idUsuarioFk) {
        this.idUsuarioFk = idUsuarioFk;
    }
    
}
