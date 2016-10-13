package modelo;

import dao.SolicitacaoDAO;
import java.util.List;

public class Solicitacao {

    public static List<Solicitacao> obterSolicitacao() throws ClassNotFoundException {
        return SolicitacaoDAO.obterSolicitacao();
    }
    private String assunto, texto;
    private int codSolicitacao;

    public Solicitacao(String assunto, String texto, int codSolicitacao) {
        this.assunto = assunto;
        this.texto = texto;
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

    public int getCodSolicitacao() {
        return codSolicitacao;
    }

    public void setCodSolicitacao(int codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }
}
