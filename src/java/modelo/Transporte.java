package modelo;

import dao.TransporteDAO;
import java.sql.SQLException;
import java.util.List;

public class Transporte {

    private int codTransporte;
    private String empresa;
    private String veiculo;

    // Construtores
    public Transporte(int codTransporte, String empresa, String veiculo) {
        this.codTransporte = codTransporte;
        this.empresa = empresa;
        this.veiculo = veiculo;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        TransporteDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Transporte> obterTransporte() throws java.lang.ClassNotFoundException, SQLException {
        return TransporteDAO.obterTransporte();
    }

    //Obter Transporte
    public static Transporte obterTransporte(int codTransporte) throws ClassNotFoundException, SQLException {
        return TransporteDAO.obterTransporte(codTransporte);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        TransporteDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        TransporteDAO.excluir(this);
    }

    //Set e Gets
    public int getCodTransporte() {
        return codTransporte;
    }

    public void setCodTransporte(int codTransporte) {
        this.codTransporte = codTransporte;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

}
