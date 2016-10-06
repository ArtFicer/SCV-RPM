package modelo;
public class Servidor {
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
