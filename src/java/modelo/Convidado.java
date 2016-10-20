package modelo;
import dao.ConvidadoDAO;
import java.sql.SQLException;
import java.util.List;


public class Convidado {

    public static List<Convidado> obterConvidado() throws ClassNotFoundException, java.lang.ClassNotFoundException {
        return ConvidadoDAO.obterConvidado();
    }
    private int matriculaSIAPE;
    int codConvidado;
    Proposto codProposto;

    public Proposto getCodProposto() {
        return codProposto;
    }

    public void setCodProposto(Proposto codProposto) {
        this.codProposto = codProposto;
    }
    
    
    public Convidado(int matriculaSIAPE, int codConidado) {
        this.matriculaSIAPE = matriculaSIAPE;
        this.codConvidado = codConidado;
    }

    public int getCodConvidado() {
        return codConvidado;
    }

    public void setCodConvidado(int codConvidado) {
        this.codConvidado = codConvidado;
    }
    
    public int getMatriculaSIAPE() {
        return matriculaSIAPE;
    }

    public void setMatriculaSIAPE(int matriculaSIAPE) {
        this.matriculaSIAPE = matriculaSIAPE;
    }

    public void gravar()throws SQLException, ClassNotFoundException  {
        ConvidadoDAO.gravar(this);
    }
}
