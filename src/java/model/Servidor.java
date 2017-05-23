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
@Table(name = "Servidor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servidor.findAll", query = "SELECT s FROM Servidor s"),
    @NamedQuery(name = "Servidor.findByCodServidor", query = "SELECT s FROM Servidor s WHERE s.codServidor = :codServidor"),
    @NamedQuery(name = "Servidor.findByMatriculaSIAPE", query = "SELECT s FROM Servidor s WHERE s.matriculaSIAPE = :matriculaSIAPE"),
    @NamedQuery(name = "Servidor.findByLotadoOrgao", query = "SELECT s FROM Servidor s WHERE s.lotadoOrgao = :lotadoOrgao")})
public class Servidor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codServidor")
    private Integer codServidor;
    @Basic(optional = false)
    @Column(name = "matricula_SIAPE")
    private int matriculaSIAPE;
    @Basic(optional = false)
    @Column(name = "lotado_Orgao")
    private String lotadoOrgao;
    @JoinColumn(name = "proposto_codProposto", referencedColumnName = "codProposto")
    @ManyToOne(optional = false)
    private Proposto propostocodProposto;

    public Servidor() {
    }

    public Servidor(Integer codServidor) {
        this.codServidor = codServidor;
    }

    public Servidor(Integer codServidor, int matriculaSIAPE, String lotadoOrgao) {
        this.codServidor = codServidor;
        this.matriculaSIAPE = matriculaSIAPE;
        this.lotadoOrgao = lotadoOrgao;
    }

    public Integer getCodServidor() {
        return codServidor;
    }

    public void setCodServidor(Integer codServidor) {
        this.codServidor = codServidor;
    }

    public int getMatriculaSIAPE() {
        return matriculaSIAPE;
    }

    public void setMatriculaSIAPE(int matriculaSIAPE) {
        this.matriculaSIAPE = matriculaSIAPE;
    }

    public String getLotadoOrgao() {
        return lotadoOrgao;
    }

    public void setLotadoOrgao(String lotadoOrgao) {
        this.lotadoOrgao = lotadoOrgao;
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
        hash += (codServidor != null ? codServidor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servidor)) {
            return false;
        }
        Servidor other = (Servidor) object;
        if ((this.codServidor == null && other.codServidor != null) || (this.codServidor != null && !this.codServidor.equals(other.codServidor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Servidor[ codServidor=" + codServidor + " ]";
    }
    
}
