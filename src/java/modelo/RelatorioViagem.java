package modelo;

import dao.RelatorioViagemDAO;
import java.sql.SQLException;
import java.util.List;

public class RelatorioViagem {

    private int codRelatorioViagem;
    private String relatorio;

    // Construtores
    public RelatorioViagem(int codRelatorioViagem, String relatorio) {
        this.codRelatorioViagem = codRelatorioViagem;
        this.relatorio = relatorio;
    }
    
    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        RelatorioViagemDAO.excluir(this);
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        RelatorioViagemDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<RelatorioViagem> obterRelatorioViagem() throws java.lang.ClassNotFoundException, SQLException {
        return RelatorioViagemDAO.obterRelatorioViagem();
    }

    //Obter RelatorioViagem
    public static RelatorioViagem obterRelatorioViagem(int codRelatorioViagem) throws ClassNotFoundException, SQLException {
        return RelatorioViagemDAO.obterRelatorioViagem(codRelatorioViagem);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        RelatorioViagemDAO.alterar(this);
    }

    //Set e Gets
    public int getCodRelatorioViagem() {
        return codRelatorioViagem;
    }

    public void setCodRelatorioViagem(int codRelatorioViagem) {
        this.codRelatorioViagem = codRelatorioViagem;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

}
