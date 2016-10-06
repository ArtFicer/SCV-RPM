package modelo;


public class DeclaracaoNotaTecnica {
    private String redigir;
    private int codDeclaracaoNotaTecnica;
    
    public DeclaracaoNotaTecnica(String redigir, int codDeclaracaoNotaTecnica) {
        this.redigir = redigir;
        this.codDeclaracaoNotaTecnica = codDeclaracaoNotaTecnica;
    }
    
    public String getRedigir() {
        return redigir;
    }

    public void setRedigir(String redigir) {
        this.redigir = redigir;
    }

    public int getCodDeclaracaoNotaTecnica() {
        return codDeclaracaoNotaTecnica;
    }

    public void setCodDeclaracaoNotaTecnica(int codDeclaracaoNotaTecnica) {
        this.codDeclaracaoNotaTecnica = codDeclaracaoNotaTecnica;
    }
}
