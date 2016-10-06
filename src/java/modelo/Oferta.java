package modelo;
public class Oferta {
    private int ano, codOferta;

    public Oferta(int ano, int codOferta) {
        this.ano = ano;
        this.codOferta = codOferta;
    }
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCodOferta() {
        return codOferta;
    }

    public void setCodOferta(int codOferta) {
        this.codOferta = codOferta;
    }
}
