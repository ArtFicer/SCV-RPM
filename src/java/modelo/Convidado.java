package modelo;
import dao.ConvidadoDAO;
import java.sql.SQLException;
import java.util.List;

public class Convidado {

    private int codConvidado;
    private Proposto proposto;
    private int matricula_SIAPE;

    // Construtores
    public Convidado(int codConvidado, Proposto proposto, int matricula_SIAPE) {
        this.codConvidado = codConvidado;
        this.proposto = proposto;
        this.matricula_SIAPE = matricula_SIAPE;
    }
     
    
    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        ConvidadoDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Convidado> obterConvidado() throws java.lang.ClassNotFoundException {
        return ConvidadoDAO.obterConvidado();
    }
    
    //Obter Convidado
    public static Convidado obterConvidado(int codConvidado) throws ClassNotFoundException {
        return ConvidadoDAO.obterConvidado(codConvidado);
    }
    
    //Alterar
    public void alterar () throws SQLException, ClassNotFoundException{
        ConvidadoDAO.alterar(this);
    }

   
    //Sets Gets
    public int getCodConvidado() {
        return codConvidado;
    }

    public void setCodConvidado(int codConvidado) {
        this.codConvidado = codConvidado;
    }

    public Proposto getProposto() {
        return proposto;
    }

    public void setProposto(Proposto proposto) {
        this.proposto = proposto;
    }

    public int getMatricula_SIAPE() {
        return matricula_SIAPE;
    }

    public void setMatricula_SIAPE(int matricula_SIAPE) {
        this.matricula_SIAPE = matricula_SIAPE;
    }

    
}
