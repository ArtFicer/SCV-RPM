package modelo;

import dao.OfertaDAO;
import java.sql.SQLException;
import java.util.List;

public class Oferta {

    public static List<Oferta> obterOferta() throws ClassNotFoundException {
        return OfertaDAO.obterOferta();
    }
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
    
    public void gravar()throws SQLException, ClassNotFoundException  {
        OfertaDAO.gravar(this);
    }
}
