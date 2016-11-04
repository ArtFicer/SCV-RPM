package modelo;

import dao.OfertaDAO;
import java.sql.SQLException;
import java.util.List;

public class Oferta {

    private int codOferta;
    private int ano;
    // Construtores

    public Oferta(int codOferta, int ano) {
        this.codOferta = codOferta;
        this.ano = ano;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        OfertaDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Oferta> obterOferta() throws java.lang.ClassNotFoundException {
        return OfertaDAO.obterOferta();
    }

    //Obter Oferta
    public static Oferta obterOferta(int codOferta) throws ClassNotFoundException {
        return OfertaDAO.obterOferta(codOferta);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        OfertaDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        OfertaDAO.excluir(this);
    }

    //Set e Gets
    public int getCodOferta() {
        return codOferta;
    }

    public void setCodOferta(int codOferta) {
        this.codOferta = codOferta;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

}
