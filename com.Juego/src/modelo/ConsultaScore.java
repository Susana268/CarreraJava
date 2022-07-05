
package modelo;

public interface ConsultaScore {
    public boolean actualizar(ScoreVO s); 
    public boolean insertar(ScoreVO s);
    public ScoreVO getScore(ScoreVO s);
    public boolean insertStore(ScoreVO s);
}
