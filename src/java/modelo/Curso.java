package modelo;

import dao.CursoDAO;
import java.sql.SQLException;
import java.util.List;

public class Curso {

    public static Curso obterCurso(int codCurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String nome;
    private int codCurso;
    public Proposto proposto;

    // Construtores
    public Curso(int codCurso, String nome) {
        this.nome = nome;
        this.codCurso = codCurso;
    }

    public Curso(int codCurso, String nome, Proposto proposto) {
        this.nome = nome;
        this.codCurso = codCurso;
        this.proposto = proposto;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        CursoDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Curso> obterCurso() throws java.lang.ClassNotFoundException {
        return CursoDAO.obterCurso();
    }

    //Set e Gets
    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int cod_Curso) {
        this.codCurso = cod_Curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Proposto getProposto() {
        return proposto;
    }

    public void setProposto(Proposto proposto) {
        this.proposto = proposto;
    }

    public void setCodProposto(int codProposto) {
        this.proposto.setCodProposto(codProposto);
    }

}
