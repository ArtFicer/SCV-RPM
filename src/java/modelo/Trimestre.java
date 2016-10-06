package modelo;
public class Trimestre {
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
