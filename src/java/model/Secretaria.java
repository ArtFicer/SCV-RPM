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
@Table(name = "Secretaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Secretaria.findAll", query = "SELECT s FROM Secretaria s"),
    @NamedQuery(name = "Secretaria.findByCodSecretaria", query = "SELECT s FROM Secretaria s WHERE s.codSecretaria = :codSecretaria"),
    @NamedQuery(name = "Secretaria.findByNome", query = "SELECT s FROM Secretaria s WHERE s.nome = :nome"),
    @NamedQuery(name = "Secretaria.findByEmail", query = "SELECT s FROM Secretaria s WHERE s.email = :email"),
    @NamedQuery(name = "Secretaria.findBySenha", query = "SELECT s FROM Secretaria s WHERE s.senha = :senha")})
public class Secretaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codSecretaria")
    private Integer codSecretaria;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "senha")
    private String senha;
    @JoinColumn(name = "proposto_codProposto", referencedColumnName = "codProposto")
    @ManyToOne(optional = false)
    private Proposto propostocodProposto;

    public Secretaria() {
    }

    public Secretaria(Integer codSecretaria) {
        this.codSecretaria = codSecretaria;
    }

    public Secretaria(Integer codSecretaria, String nome, String email, String senha) {
        this.codSecretaria = codSecretaria;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getCodSecretaria() {
        return codSecretaria;
    }

    public void setCodSecretaria(Integer codSecretaria) {
        this.codSecretaria = codSecretaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Proposto getPropostocodProposto() {
        return propostocodProposto;
    }

    public void setPropostocodProposto(Proposto propostocodProposto) {
        this.propostocodProposto = propostocodProposto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSecretaria != null ? codSecretaria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Secretaria)) {
            return false;
        }
        Secretaria other = (Secretaria) object;
        if ((this.codSecretaria == null && other.codSecretaria != null) || (this.codSecretaria != null && !this.codSecretaria.equals(other.codSecretaria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Secretaria[ codSecretaria=" + codSecretaria + " ]";
    }

}
