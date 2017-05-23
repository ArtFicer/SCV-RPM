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
@Table(name = "Polo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Polo.findAll", query = "SELECT p FROM Polo p"),
    @NamedQuery(name = "Polo.findByCodPolo", query = "SELECT p FROM Polo p WHERE p.codPolo = :codPolo"),
    @NamedQuery(name = "Polo.findByCidade", query = "SELECT p FROM Polo p WHERE p.cidade = :cidade"),
    @NamedQuery(name = "Polo.findByLogradouro", query = "SELECT p FROM Polo p WHERE p.logradouro = :logradouro"),
    @NamedQuery(name = "Polo.findByBairro", query = "SELECT p FROM Polo p WHERE p.bairro = :bairro"),
    @NamedQuery(name = "Polo.findByNumero", query = "SELECT p FROM Polo p WHERE p.numero = :numero"),
    @NamedQuery(name = "Polo.findByTelefone", query = "SELECT p FROM Polo p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Polo.findByEmail", query = "SELECT p FROM Polo p WHERE p.email = :email")})
public class Polo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codPolo")
    private Integer codPolo;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "telefone")
    private int telefone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "polocodPolo")
    private Collection<Oferta> ofertaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "polocodPolo")
    private Collection<Viagem> viagemCollection;

    public Polo() {
    }

    public Polo(Integer codPolo) {
        this.codPolo = codPolo;
    }

    public Polo(Integer codPolo, String cidade, String logradouro, String bairro, int numero, int telefone, String email) {
        this.codPolo = codPolo;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getCodPolo() {
        return codPolo;
    }

    public void setCodPolo(Integer codPolo) {
        this.codPolo = codPolo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @XmlTransient
    public Collection<Oferta> getOfertaCollection() {
        return ofertaCollection;
    }

    public void setOfertaCollection(Collection<Oferta> ofertaCollection) {
        this.ofertaCollection = ofertaCollection;
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
        hash += (codPolo != null ? codPolo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polo)) {
            return false;
        }
        Polo other = (Polo) object;
        if ((this.codPolo == null && other.codPolo != null) || (this.codPolo != null && !this.codPolo.equals(other.codPolo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Polo[ codPolo=" + codPolo + " ]";
    }
    
}
