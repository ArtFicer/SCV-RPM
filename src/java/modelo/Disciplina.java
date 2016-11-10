package modelo;

import dao.DisciplinaDAO;
import java.sql.SQLException;
import java.util.List;

public class Disciplina {

    private int codDisciplina;
    private String nome;

    // Construtores
    public Disciplina(int codDisciplina, String nome) {
        this.codDisciplina = codDisciplina;
        this.nome = nome;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        DisciplinaDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Disciplina> obterDisciplina() throws java.lang.ClassNotFoundException, SQLException {
        return DisciplinaDAO.obterDisciplina();
    }

    //Obter Disciplina
    public static Disciplina obterDisciplina(int codDisciplina) throws ClassNotFoundException, SQLException {
        return DisciplinaDAO.obterDisciplina(codDisciplina);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        DisciplinaDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        DisciplinaDAO.excluir(this);
    }

    //Set e Gets
    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
