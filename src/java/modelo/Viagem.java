package modelo;

import dao.ViagemDAO;
import java.util.List;

public class Viagem {

    public static List<Viagem> obterViagem() throws ClassNotFoundException {
        return ViagemDAO.obterViagem();
    }
    private String destino, statusConfirmacao, statusConclusao;
    private int data, horarioSaida, codViagem;

    public Viagem(String destino, String statusConfirmacao, String statusConclusao, int data, int horarioSaida, int codViagem) {
        this.destino = destino;
        this.statusConfirmacao = statusConfirmacao;
        this.statusConclusao = statusConclusao;
        this.data = data;
        this.horarioSaida = horarioSaida;
        this.codViagem = codViagem;
    }

    
    public int getCodViagem() {
        return codViagem;
    }

    public void setCodViagem(int codViagem) {
        this.codViagem = codViagem;
    }

    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(int horarioSaida) {
        this.horarioSaida = horarioSaida;
    }
 
}
