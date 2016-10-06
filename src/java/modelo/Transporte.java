package modelo;    
public class Transporte {
    private String empresa, veiculo;
    private int codTransporte;

    public Transporte(String empresa, String veiculo, int codTransporte) {
        this.empresa = empresa;
        this.veiculo = veiculo;
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

    public int getCodTransporte() {
        return codTransporte;
    }

    public void setCodTransporte(int codTransporte) {
        this.codTransporte = codTransporte;
    }
}
