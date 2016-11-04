package modelo;

import dao.CadastroRapidoDAO;
import java.sql.SQLException;
import java.util.List;

public class CadastroRapido {

    private String nome;
    private int codCadastroRapido;
    public Proposto proposto;

    // Construtores
    public CadastroRapido(int codCadastroRapido, String nome) {
        this.nome = nome;
        this.codCadastroRapido = codCadastroRapido;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        CadastroRapidoDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<CadastroRapido> obterCadastroRapido() throws java.lang.ClassNotFoundException {
        return CadastroRapidoDAO.obterCadastroRapido();
    }

    //Obter CadastroRapido
    public static CadastroRapido obterCadastroRapido(int codCadastroRapido) throws ClassNotFoundException {
        return CadastroRapidoDAO.obterCadastroRapido(codCadastroRapido);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        CadastroRapidoDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        CadastroRapidoDAO.excluir(this);
    }

    //Set e Gets
    public int getCodCadastroRapido() {
        return codCadastroRapido;
    }

    public void setCodCadastroRapido(int cod_CadastroRapido) {
        this.codCadastroRapido = cod_CadastroRapido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Proposto getProposto() {
        return proposto;
    }

    public void setProposto(Proposto proposto) {
        this.proposto = proposto;
    }

    public void setCodProposto(int codProposto) {
        this.proposto.setCodProposto(codProposto);
    }

}
