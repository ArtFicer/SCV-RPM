package modelo;
import dao.ConvidadoDAO;
import java.sql.SQLException;
import java.util.List;

public class Convidado {

    private int codConvidado;
    private int codProposto;
    private int matricula_SIAPE;

    // Construtores
    public Convidado(int codConvidado,int codProposto, int matricula_SIAPE) {
        this.codConvidado = codConvidado;
        this.codProposto = codProposto;
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

    public int getCodProposto() {
        return codProposto;
    }

    public void setCodProposto(int codProposto) {
        this.codProposto = codProposto;
    }

    public int getMatricula_SIAPE() {
        return matricula_SIAPE;
    }

    public void setMatricula_SIAPE(int matricula_SIAPE) {
        this.matricula_SIAPE = matricula_SIAPE;
    }

    
}
