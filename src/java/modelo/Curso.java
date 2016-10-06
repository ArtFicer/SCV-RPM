package modelo;

import modelo.ClassNotFoundExeception;
import dao.CursoDAO;
import java.util.List;


public class Curso {

    private String nome;
    private int codCurso;
    
    public Curso (int codCurso, String nome) {
        this.nome = nome;
        this.codCurso = codCurso;
    }

    public static List<Curso> obterCurso() throws ClassNotFoundException, dao.ClassNotFoundExeception{
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

    
}
