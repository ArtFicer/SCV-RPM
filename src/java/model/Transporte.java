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
@Table(name = "Transporte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transporte.findAll", query = "SELECT t FROM Transporte t"),
    @NamedQuery(name = "Transporte.findByCodTransporte", query = "SELECT t FROM Transporte t WHERE t.codTransporte = :codTransporte"),
    @NamedQuery(name = "Transporte.findByEmpresa", query = "SELECT t FROM Transporte t WHERE t.empresa = :empresa"),
    @NamedQuery(name = "Transporte.findByVeiculo", query = "SELECT t FROM Transporte t WHERE t.veiculo = :veiculo")})
public class Transporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codTransporte")
    private Integer codTransporte;
    @Basic(optional = false)
    @Column(name = "empresa")
    private String empresa;
    @Basic(optional = false)
    @Column(name = "veiculo")
    private String veiculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transportecodTransporte")
    private Collection<Viagem> viagemCollection;

    public Transporte() {
    }

    public Transporte(Integer codTransporte) {
        this.codTransporte = codTransporte;
    }

    public Transporte(Integer codTransporte, String empresa, String veiculo) {
        this.codTransporte = codTransporte;
        this.empresa = empresa;
        this.veiculo = veiculo;
    }

    public Integer getCodTransporte() {
        return codTransporte;
    }

    public void setCodTransporte(Integer codTransporte) {
        this.codTransporte = codTransporte;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
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
        hash += (codTransporte != null ? codTransporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transporte)) {
            return false;
        }
        Transporte other = (Transporte) object;
        if ((this.codTransporte == null && other.codTransporte != null) || (this.codTransporte != null && !this.codTransporte.equals(other.codTransporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Transporte[ codTransporte=" + codTransporte + " ]";
    }
    
}
