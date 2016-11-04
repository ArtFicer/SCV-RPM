package modelo;

import dao.ServidorDAO;
import java.sql.SQLException;
import java.util.List;

public class Servidor {

    private int codServidor;
    private int matriculaSIAPE;
    private String lotadoOrgao;

    // Construtores
    public Servidor(int codServidor, int matriculaSIAPE, String lotadoOrgao) {
        this.codServidor = codServidor;
        this.matriculaSIAPE = matriculaSIAPE;
        this.lotadoOrgao = lotadoOrgao;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        ServidorDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Servidor> obterServidor() throws java.lang.ClassNotFoundException {
        return ServidorDAO.obterServidor();
    }

    //Obter Servidor
    public static Servidor obterServidor(int codServidor) throws ClassNotFoundException {
        return ServidorDAO.obterServidor(codServidor);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        ServidorDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        ServidorDAO.excluir(this);
    }

    //Set e Gets
    public int getCodServidor() {
        return codServidor;
    }

    public void setCodServidor(int codServidor) {
        this.codServidor = codServidor;
    }

    public int getMatriculaSIAPE() {
        return matriculaSIAPE;
    }

    public void setMatriculaSIAPE(int matriculaSIAPE) {
        this.matriculaSIAPE = matriculaSIAPE;
    }

    public String getLotadoOrgao() {
        return lotadoOrgao;
    }

    public void setLotadoOrgao(String lotadoOrgao) {
        this.lotadoOrgao = lotadoOrgao;
    }

}
