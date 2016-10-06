package modelo;
public class EscreverRelatorio {
    private String relatorio;
    private int codEscreverRelatorio;

    public EscreverRelatorio(String relatorio, int codEscreverRelatorio) {
        this.relatorio = relatorio;
        this.codEscreverRelatorio = codEscreverRelatorio;
    }
    
    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public int getCodEscreverRelatorio() {
        return codEscreverRelatorio;
    }

    public void setCodEscreverRelatorio(int codEscreverRelatorio) {
        this.codEscreverRelatorio = codEscreverRelatorio;
    }
}
