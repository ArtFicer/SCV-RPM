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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Oferta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Oferta.findAll", query = "SELECT o FROM Oferta o"),
    @NamedQuery(name = "Oferta.findByCodOferta", query = "SELECT o FROM Oferta o WHERE o.codOferta = :codOferta"),
    @NamedQuery(name = "Oferta.findByAno", query = "SELECT o FROM Oferta o WHERE o.ano = :ano")})
public class Oferta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codOferta")
    private Integer codOferta;
    @Basic(optional = false)
    @Column(name = "ano")
    private int ano;
    @JoinColumn(name = "polo_codPolo", referencedColumnName = "codPolo")
    @ManyToOne(optional = false)
    private Polo polocodPolo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ofertacodOferta")
    private Collection<Curso> cursoCollection;

    public Oferta() {
    }

    public Oferta(Integer codOferta) {
        this.codOferta = codOferta;
    }

    public Oferta(Integer codOferta, int ano) {
        this.codOferta = codOferta;
        this.ano = ano;
    }

    public Integer getCodOferta() {
        return codOferta;
    }

    public void setCodOferta(Integer codOferta) {
        this.codOferta = codOferta;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Polo getPolocodPolo() {
        return polocodPolo;
    }

    public void setPolocodPolo(Polo polocodPolo) {
        this.polocodPolo = polocodPolo;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOferta != null ? codOferta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oferta)) {
            return false;
        }
        Oferta other = (Oferta) object;
        if ((this.codOferta == null && other.codOferta != null) || (this.codOferta != null && !this.codOferta.equals(other.codOferta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Oferta[ codOferta=" + codOferta + " ]";
    }
    
}
