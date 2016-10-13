package modelo;
import dao.ConvidadoDAO;
import java.util.List;


public class Convidado {

    public static List<Convidado> obterConvidado() throws ClassNotFoundException, java.lang.ClassNotFoundException {
        return ConvidadoDAO.obterConvidado();
    }
    private int matriculaSIAPE;
    int codConidado;

    public Convidado(int matriculaSIAPE, int codConidado) {
        this.matriculaSIAPE = matriculaSIAPE;
        this.codConidado = codConidado;
    }

    public int getCodConidado() {
        return codConidado;
    }

    public void setCodConidado(int codConidado) {
        this.codConidado = codConidado;
    }
    
    public int getMatriculaSIAPE() {
        return matriculaSIAPE;
    }

    public void setMatriculaSIAPE(int matriculaSIAPE) {
        this.matriculaSIAPE = matriculaSIAPE;
    }
}
