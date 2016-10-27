package modelo;

import dao.ServidorDAO;
import java.sql.SQLException;
import java.util.List;

public class Servidor {

    public static List<Servidor> obterServidor() throws ClassNotFoundException {
        return ServidorDAO.obterServidor();
    }
    private int matriculaSIAPE;
    private String lotadoOrgao;
    private int codModelo;

    public Servidor(int matriculaSIAPE, String lotadoOrgao, int codModelo) {
        this.matriculaSIAPE = matriculaSIAPE;
        this.lotadoOrgao = lotadoOrgao;
        this.codModelo = codModelo;
    }

    
    public int getCodModelo() {
        return codModelo;
    }

    public void setCodModelo(int codModelo) {
        this.codModelo = codModelo;
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
    public void gravar()throws SQLException, ClassNotFoundException  {
        ServidorDAO.gravar(this);
    }

    public int getCodServidor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
