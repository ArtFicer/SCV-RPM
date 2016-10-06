package modelo;

import dao.ClassNotFoundExeception;
import dao.ServidorDAO;
import java.util.List;

public class Servidor {

    public static List<Servidor> obterServidor() throws ClassNotFoundExeception, ClassNotFoundException {
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
    
}
