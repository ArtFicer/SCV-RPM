package modelo;
public class Disciplina {
    private String nome;
    private int codDisciplina;

    public Disciplina(String nome, int codDisciplina) {
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
}
