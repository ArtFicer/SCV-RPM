package modelo;

import dao.ClassNotFoundExeception;
import dao.TrimestreDAO;
import java.util.List;

public class Trimestre {

    public static List<Trimestre> obterTrimestre() throws ClassNotFoundExeception, ClassNotFoundException {
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
}
