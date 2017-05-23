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
@Table(name = "RelatorioViagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relatorioviagem.findAll", query = "SELECT r FROM RelatorioViagem r"),
    @NamedQuery(name = "Relatorioviagem.findByCodRelatorioViagem", query = "SELECT r FROM RelatorioViagem r WHERE r.codRelatorioViagem = :codRelatorioViagem"),
    @NamedQuery(name = "Relatorioviagem.findByRelatorio", query = "SELECT r FROM RelatorioViagem r WHERE r.relatorio = :relatorio")})
public class RelatorioViagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codRelatorioViagem")
    private Integer codRelatorioViagem;
    @Basic(optional = false)
    @Column(name = "relatorio")
    private String relatorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relatorioviagemcodRelatorioViagem")
    private Collection<Viagem> viagemCollection;

    public RelatorioViagem() {
    }

    public RelatorioViagem(Integer codRelatorioViagem) {
        this.codRelatorioViagem = codRelatorioViagem;
    }

    public RelatorioViagem(Integer codRelatorioViagem, String relatorio) {
        this.codRelatorioViagem = codRelatorioViagem;
        this.relatorio = relatorio;
    }

    public Integer getCodRelatorioViagem() {
        return codRelatorioViagem;
    }

    public void setCodRelatorioViagem(Integer codRelatorioViagem) {
        this.codRelatorioViagem = codRelatorioViagem;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    @XmlTransient
    public Collection<Viagem> getViagemCollection() {
        return viagemCollection;
    }

    public void setViagemCollection(Collection<Viagem> viagemCollection) {
        this.viagemCollection = viagemCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRelatorioViagem != null ? codRelatorioViagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelatorioViagem)) {
            return false;
        }
        RelatorioViagem other = (RelatorioViagem) object;
        if ((this.codRelatorioViagem == null && other.codRelatorioViagem != null) || (this.codRelatorioViagem != null && !this.codRelatorioViagem.equals(other.codRelatorioViagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.RelatorioViagem[ codRelatorioViagem=" + codRelatorioViagem + " ]";
    }
    
}
