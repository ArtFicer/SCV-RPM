package modelo;

import dao.ViagemDAO;
import java.sql.SQLException;
import java.util.List;

public class Viagem {

    private int codViagem;
    private int codDeclaracaoNotaTecnica;
    private int codRelatorioViagem;
    private int codProposto;
    private int codPolo;
    private String destino;
    private String dataViagem;
    private int horarioSaida;
    private String statusConfirmacao;
    private String statusConclusao;
    private int codTransporte;

    public Viagem(int codViagem, int codDeclaracaoNotaTecnica, int codRelatorioViagem, int codProposto, int codPolo, String destino, String dataViagem, int horarioSaida, String statusConfirmacao, String statusConclusao, int codTransporte) {
        this.codViagem = codViagem;
        this.codDeclaracaoNotaTecnica = codDeclaracaoNotaTecnica;
        this.codRelatorioViagem = codRelatorioViagem;
        this.codProposto = codProposto;
        this.codPolo = codPolo;
        this.destino = destino;
        this.dataViagem = dataViagem;
        this.horarioSaida = horarioSaida;
        this.statusConfirmacao = statusConfirmacao;
        this.statusConclusao = statusConclusao;
        this.codTransporte = codTransporte;
    }

    // Construtores
    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        ViagemDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Viagem> obterViagem() throws java.lang.ClassNotFoundException {
        return ViagemDAO.obterViagem();
    }

    //Obter Viagem
    public static Viagem obterViagem(int codViagem) throws ClassNotFoundException {
        return ViagemDAO.obterViagem(codViagem);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        ViagemDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        ViagemDAO.excluir(this);
    }

    //Set e Gets

    public int getCodViagem() {
        return codViagem;
    }

    public void setCodViagem(int codViagem) {
        this.codViagem = codViagem;
    }

    public int getCodDeclaracaoNotaTecnica() {
        return codDeclaracaoNotaTecnica;
    }

    public void setCodDeclaracaoNotaTecnica(int codDeclaracaoNotaTecnica) {
        this.codDeclaracaoNotaTecnica = codDeclaracaoNotaTecnica;
    }

    public int getCodRelatorioViagem() {
        return codRelatorioViagem;
    }

    public void setCodRelatorioViagem(int codRelatorioViagem) {
        this.codRelatorioViagem = codRelatorioViagem;
    }

    public int getCodProposto() {
        return codProposto;
    }

    public void setCodProposto(int codProposto) {
        this.codProposto = codProposto;
    }

    public int getCodPolo() {
        return codPolo;
    }

    public void setCodPolo(int codPolo) {
        this.codPolo = codPolo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(String dataViagem) {
        this.dataViagem = dataViagem;
    }

    public int getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(int horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getStatusConfirmacao() {
        return statusConfirmacao;
    }

    public void setStatusConfirmacao(String statusConfirmacao) {
        this.statusConfirmacao = statusConfirmacao;
    }

    public String getStatusConclusao() {
        return statusConclusao;
    }

    public void setStatusConclusao(String statusConclusao) {
        this.statusConclusao = statusConclusao;
    }

    public int getCodTransporte() {
        return codTransporte;
    }

    public void setCodTransporte(int codTransporte) {
        this.codTransporte = codTransporte;
    }
    
}
