/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author asus note
 */
@Entity
@Table(name = "Trimestre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trimestre.findAll", query = "SELECT t FROM Trimestre t"),
    @NamedQuery(name = "Trimestre.findByCodTrimestre", query = "SELECT t FROM Trimestre t WHERE t.codTrimestre = :codTrimestre"),
    @NamedQuery(name = "Trimestre.findByNumeroTrimestre", query = "SELECT t FROM Trimestre t WHERE t.numeroTrimestre = :numeroTrimestre")})
public class Trimestre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codTrimestre")
    private Integer codTrimestre;
    @Basic(optional = false)
    @Column(name = "numero_trimestre")
    private int numeroTrimestre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimestrecodTrimestre")
    private Collection<Curso> cursoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trimestrecodTrimestre")
    private Collection<Disciplina> disciplinaCollection;

    public Trimestre() {
    }

    public Trimestre(Integer codTrimestre) {
        this.codTrimestre = codTrimestre;
    }

    public Trimestre(Integer codTrimestre, int numeroTrimestre) {
        this.codTrimestre = codTrimestre;
        this.numeroTrimestre = numeroTrimestre;
    }

    public Integer getCodTrimestre() {
        return codTrimestre;
    }

    public void setCodTrimestre(Integer codTrimestre) {
        this.codTrimestre = codTrimestre;
    }

    public int getNumeroTrimestre() {
        return numeroTrimestre;
    }

    public void setNumeroTrimestre(int numeroTrimestre) {
        this.numeroTrimestre = numeroTrimestre;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @XmlTransient
    public Collection<Disciplina> getDisciplinaCollection() {
        return disciplinaCollection;
    }

    public void setDisciplinaCollection(Collection<Disciplina> disciplinaCollection) {
        this.disciplinaCollection = disciplinaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTrimestre != null ? codTrimestre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trimestre)) {
            return false;
        }
        Trimestre other = (Trimestre) object;
        if ((this.codTrimestre == null && other.codTrimestre != null) || (this.codTrimestre != null && !this.codTrimestre.equals(other.codTrimestre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Trimestre[ codTrimestre=" + codTrimestre + " ]";
    }
    
}
