/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.ProfessorDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author pe-ri
 */
public class Professor {
    int codProfessor;
    String nomeProfessor;
    int coordenador;
    
    
    public Professor(int codProfessor, String nomeProfessor, int coordenador) {
        this.codProfessor = codProfessor;
        this.nomeProfessor = nomeProfessor;
        this.coordenador = coordenador;
    }
    
     public static List<Professor> obterProfessor() throws java.lang.ClassNotFoundException {
        return ProfessorDAO.obterProfessor();
    }

    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public int getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(int coordenador) {
        this.coordenador = coordenador;
    }
    
    public void gravar()throws SQLException, ClassNotFoundException  {
        ProfessorDAO.gravar(this);
    }
    
    
}
