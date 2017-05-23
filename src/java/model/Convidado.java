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
@Table(name = "Convidado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convidado.findAll", query = "SELECT c FROM Convidado c"),
    @NamedQuery(name = "Convidado.findByCodConvidado", query = "SELECT c FROM Convidado c WHERE c.codConvidado = :codConvidado"),
    @NamedQuery(name = "Convidado.findByMatriculaSIAPE", query = "SELECT c FROM Convidado c WHERE c.matriculaSIAPE = :matriculaSIAPE")})
public class Convidado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codConvidado")
    private Integer codConvidado;
    @Basic(optional = false)
    @Column(name = "matricula_SIAPE")
    private int matriculaSIAPE;
    @JoinColumn(name = "proposto_codProposto", referencedColumnName = "codProposto")
    @ManyToOne(optional = false)
    private Proposto propostocodProposto;

    public Convidado() {
    }

    public Convidado(Integer codConvidado) {
        this.codConvidado = codConvidado;
    }

    public Convidado(Integer codConvidado, int matriculaSIAPE) {
        this.codConvidado = codConvidado;
        this.matriculaSIAPE = matriculaSIAPE;
    }

    public Integer getCodConvidado() {
        return codConvidado;
    }

    public void setCodConvidado(Integer codConvidado) {
        this.codConvidado = codConvidado;
    }

    public int getMatriculaSIAPE() {
        return matriculaSIAPE;
    }

    public void setMatriculaSIAPE(int matriculaSIAPE) {
        this.matriculaSIAPE = matriculaSIAPE;
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
        hash += (codConvidado != null ? codConvidado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convidado)) {
            return false;
        }
        Convidado other = (Convidado) object;
        if ((this.codConvidado == null && other.codConvidado != null) || (this.codConvidado != null && !this.codConvidado.equals(other.codConvidado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Convidado[ codConvidado=" + codConvidado + " ]";
    }
    
}
