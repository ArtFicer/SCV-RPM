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
@Table(name = "Curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByCodCurso", query = "SELECT c FROM Curso c WHERE c.codCurso = :codCurso"),
    @NamedQuery(name = "Curso.findByNome", query = "SELECT c FROM Curso c WHERE c.nome = :nome")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codCurso")
    private Integer codCurso;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "oferta_codOferta", referencedColumnName = "codOferta")
    @ManyToOne(optional = false)
    private Oferta ofertacodOferta;
    @JoinColumn(name = "trimestre_codTrimestre", referencedColumnName = "codTrimestre")
    @ManyToOne(optional = false)
    private Trimestre trimestrecodTrimestre;

    public Curso() {
    }

    public Curso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public Curso(Integer codCurso, String nome) {
        this.codCurso = codCurso;
        this.nome = nome;
    }

    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Oferta getOfertacodOferta() {
        return ofertacodOferta;
    }

    public void setOfertacodOferta(Oferta ofertacodOferta) {
        this.ofertacodOferta = ofertacodOferta;
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
        hash += (codCurso != null ? codCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codCurso == null && other.codCurso != null) || (this.codCurso != null && !this.codCurso.equals(other.codCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Curso[ codCurso=" + codCurso + " ]";
    }
    
}
