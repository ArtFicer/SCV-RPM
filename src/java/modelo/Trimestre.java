package modelo;

import dao.TrimestreDAO;
import java.sql.SQLException;
import java.util.List;

public class Trimestre {

    private int codTrimestre;
    private int numeroTrimestre;

    // Construtores
    public Trimestre(int codTrimestre, int numeroTrimestre) {
        this.codTrimestre = codTrimestre;
        this.numeroTrimestre = numeroTrimestre;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        TrimestreDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Trimestre> obterTrimestre() throws java.lang.ClassNotFoundException {
        return TrimestreDAO.obterTrimestre();
    }

    //Obter Trimestre
    public static Trimestre obterTrimestre(int codTrimestre) throws ClassNotFoundException {
        return TrimestreDAO.obterTrimestre(codTrimestre);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        TrimestreDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        TrimesteDAO.excluir(this);
    }

    //Set e Gets
    public int getCodTrimestre() {
        return codTrimestre;
    }

    public void setCodTrimestre(int codTrimestre) {
        this.codTrimestre = codTrimestre;
    }

    public int getNumeroTrimestre() {
        return numeroTrimestre;
    }

    public void setNumeroTrimestre(int numeroTrimestre) {
        this.numeroTrimestre = numeroTrimestre;
    }

}
