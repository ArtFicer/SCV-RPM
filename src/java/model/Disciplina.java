/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author asus note
 */
@Entity
@Table(name = "Disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findByCodDisciplina", query = "SELECT d FROM Disciplina d WHERE d.codDisciplina = :codDisciplina"),
    @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome")})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codDisciplina")
    private Integer codDisciplina;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "trimestre_codTrimestre", referencedColumnName = "codTrimestre")
    @ManyToOne(optional = false)
    private Trimestre trimestrecodTrimestre;

    public Disciplina() {
    }

    public Disciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public Disciplina(Integer codDisciplina, String nome) {
        this.codDisciplina = codDisciplina;
        this.nome = nome;
    }

    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Trimestre getTrimestrecodTrimestre() {
        return trimestrecodTrimestre;
    }

    public void setTrimestrecodTrimestre(Trimestre trimestrecodTrimestre) {
        this.trimestrecodTrimestre = trimestrecodTrimestre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDisciplina != null ? codDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.codDisciplina == null && other.codDisciplina != null) || (this.codDisciplina != null && !this.codDisciplina.equals(other.codDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Disciplina[ codDisciplina=" + codDisciplina + " ]";
    }
    
}
