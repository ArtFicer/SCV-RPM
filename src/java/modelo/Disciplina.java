package modelo;

import dao.DisciplinaDAO;
import java.util.List;

public class Disciplina {

    private String nome;
    private int codDisciplina;

    public Disciplina(String nome, int codDisciplina) {
        this.nome = nome;
        this.codDisciplina = codDisciplina;
    }

    public static List<Disciplina> obterDisciplina() throws ClassNotFoundException {
        return DisciplinaDAO.obterDisciplina();
    }

    public Disciplina(int codDisciplina, String nome) {
        this.nome = nome;
        this.codDisciplina = codDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public void gravar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
