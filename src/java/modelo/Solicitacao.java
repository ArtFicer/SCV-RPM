package modelo;

import dao.SolicitacaoDAO;
import java.sql.SQLException;
import java.util.List;

public class Solicitacao {

    private int codSolicitacao;
    private String assunto;
    private String texto;

    // Construtores
    public Solicitacao(int codSolicitacao, String assunto, String texto) {
        this.codSolicitacao = codSolicitacao;
        this.assunto = assunto;
        this.texto = texto;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        SolicitacaoDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Solicitacao> obterSolicitacao() throws java.lang.ClassNotFoundException, SQLException {
        return SolicitacaoDAO.obterSolicitacao();
    }

    //Obter Solicitacao
    public static Solicitacao obterSolicitacao(int codSolicitacao) throws ClassNotFoundException, SQLException {
        return SolicitacaoDAO.obterSolicitacao(codSolicitacao);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        SolicitacaoDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        SolicitacaoDAO.excluir(this);
    }

    //Set e Gets
    public int getCodSolicitacao() {
        return codSolicitacao;
    }

    public void setCodSolicitacao(int codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
