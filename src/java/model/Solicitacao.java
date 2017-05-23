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
@Table(name = "Solicitacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitacao.findAll", query = "SELECT s FROM Solicitacao s"),
    @NamedQuery(name = "Solicitacao.findByCodSolicitacao", query = "SELECT s FROM Solicitacao s WHERE s.codSolicitacao = :codSolicitacao"),
    @NamedQuery(name = "Solicitacao.findByAssunto", query = "SELECT s FROM Solicitacao s WHERE s.assunto = :assunto"),
    @NamedQuery(name = "Solicitacao.findByTexto", query = "SELECT s FROM Solicitacao s WHERE s.texto = :texto")})
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codSolicitacao")
    private Integer codSolicitacao;
    @Basic(optional = false)
    @Column(name = "assunto")
    private String assunto;
    @Basic(optional = false)
    @Column(name = "texto")
    private String texto;
    @JoinColumn(name = "proposto_codProposto", referencedColumnName = "codProposto")
    @ManyToOne(optional = false)
    private Proposto propostocodProposto;

    public Solicitacao() {
    }

    public Solicitacao(Integer codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }

    public Solicitacao(Integer codSolicitacao, String assunto, String texto) {
        this.codSolicitacao = codSolicitacao;
        this.assunto = assunto;
        this.texto = texto;
    }

    public Integer getCodSolicitacao() {
        return codSolicitacao;
    }

    public void setCodSolicitacao(Integer codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
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
        hash += (codSolicitacao != null ? codSolicitacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.codSolicitacao == null && other.codSolicitacao != null) || (this.codSolicitacao != null && !this.codSolicitacao.equals(other.codSolicitacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Solicitacao[ codSolicitacao=" + codSolicitacao + " ]";
    }
    
}
