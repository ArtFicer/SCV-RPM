package modelo;

import dao.TrimestreDAO;
import java.sql.SQLException;
import java.util.List;

public class Trimestre {

    public static List<Trimestre> obterTrimestre() throws ClassNotFoundException {
        return TrimestreDAO.obterTrimestre();
    }
    private int numeroTrimestre, codTrimeste;

    public Trimestre(int numeroTrimestre, int codTrimeste) {
        this.numeroTrimestre = numeroTrimestre;
        this.codTrimeste = codTrimeste;
    }

    
    public int getNumeroTrimestre() {
        return numeroTrimestre;
    }

    public void setNumeroTrimestre(int numeroTrimestre) {
        this.numeroTrimestre = numeroTrimestre;
    }

    public int getCodTrimeste() {
        return codTrimeste;
    }

    public void setCodTrimeste(int codTrimeste) {
        this.codTrimeste = codTrimeste;
    }
    
    public void gravar()throws SQLException, ClassNotFoundException  {
        TrimestreDAO.gravar(this);
    }
}
