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
@Table(name = "Viagem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viagem.findAll", query = "SELECT v FROM Viagem v"),
    @NamedQuery(name = "Viagem.findByCodViagem", query = "SELECT v FROM Viagem v WHERE v.codViagem = :codViagem"),
    @NamedQuery(name = "Viagem.findByDestino", query = "SELECT v FROM Viagem v WHERE v.destino = :destino"),
    @NamedQuery(name = "Viagem.findByDataViagem", query = "SELECT v FROM Viagem v WHERE v.dataViagem = :dataViagem"),
    @NamedQuery(name = "Viagem.findByHorarioSaida", query = "SELECT v FROM Viagem v WHERE v.horarioSaida = :horarioSaida"),
    @NamedQuery(name = "Viagem.findByStatusConfirmacao", query = "SELECT v FROM Viagem v WHERE v.statusConfirmacao = :statusConfirmacao"),
    @NamedQuery(name = "Viagem.findByStatusConclusao", query = "SELECT v FROM Viagem v WHERE v.statusConclusao = :statusConclusao")})
public class Viagem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codViagem")
    private Integer codViagem;
    @Basic(optional = false)
    @Column(name = "destino")
    private String destino;
    @Basic(optional = false)
    @Column(name = "data_viagem")
    private String dataViagem;
    @Basic(optional = false)
    @Column(name = "horario_saida")
    private String horarioSaida;
    @Basic(optional = false)
    @Column(name = "status_confirmacao")
    private String statusConfirmacao;
    @Basic(optional = false)
    @Column(name = "status_conclusao")
    private String statusConclusao;
    @JoinColumn(name = "polo_codPolo", referencedColumnName = "codPolo")
    @ManyToOne(optional = false)
    private Polo polocodPolo;
    @JoinColumn(name = "proposto_codProposto", referencedColumnName = "codProposto")
    @ManyToOne(optional = false)
    private Proposto propostocodProposto;
    @JoinColumn(name = "relatorioviagem_codRelatorioViagem", referencedColumnName = "codRelatorioViagem")
    @ManyToOne(optional = false)
    private RelatorioViagem relatorioviagemcodRelatorioViagem;
    @JoinColumn(name = "transporte_codTransporte", referencedColumnName = "codTransporte")
    @ManyToOne(optional = false)
    private Transporte transportecodTransporte;

    public Viagem() {
    }

    public Viagem(Integer codViagem) {
        this.codViagem = codViagem;
    }

    public Viagem(Integer codViagem, String destino, String dataViagem, String horarioSaida, String statusConfirmacao, String statusConclusao) {
        this.codViagem = codViagem;
        this.destino = destino;
        this.dataViagem = dataViagem;
        this.horarioSaida = horarioSaida;
        this.statusConfirmacao = statusConfirmacao;
        this.statusConclusao = statusConclusao;
    }

    public Integer getCodViagem() {
        return codViagem;
    }

    public void setCodViagem(Integer codViagem) {
        this.codViagem = codViagem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataViagem() {
        return dataViagem;
    }

    public void setDataViagem(String dataViagem) {
        this.dataViagem = dataViagem;
    }

    public String getHorarioSaida() {
        return horarioSaida;
    }

    public void setHorarioSaida(String horarioSaida) {
        this.horarioSaida = horarioSaida;
    }

    public String getStatusConfirmacao() {
        return statusConfirmacao;
    }

    public void setStatusConfirmacao(String statusConfirmacao) {
        this.statusConfirmacao = statusConfirmacao;
    }

    public String getStatusConclusao() {
        return statusConclusao;
    }

    public void setStatusConclusao(String statusConclusao) {
        this.statusConclusao = statusConclusao;
    }

    public Polo getPolocodPolo() {
        return polocodPolo;
    }

    public void setPolocodPolo(Polo polocodPolo) {
        this.polocodPolo = polocodPolo;
    }

    public Proposto getPropostocodProposto() {
        return propostocodProposto;
    }

    public void setPropostocodProposto(Proposto propostocodProposto) {
        this.propostocodProposto = propostocodProposto;
    }

    public RelatorioViagem getRelatorioviagemcodRelatorioViagem() {
        return relatorioviagemcodRelatorioViagem;
    }

    public void setRelatorioviagemcodRelatorioViagem(RelatorioViagem relatorioviagemcodRelatorioViagem) {
        this.relatorioviagemcodRelatorioViagem = relatorioviagemcodRelatorioViagem;
    }

    public Transporte getTransportecodTransporte() {
        return transportecodTransporte;
    }

    public void setTransportecodTransporte(Transporte transportecodTransporte) {
        this.transportecodTransporte = transportecodTransporte;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codViagem != null ? codViagem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viagem)) {
            return false;
        }
        Viagem other = (Viagem) object;
        if ((this.codViagem == null && other.codViagem != null) || (this.codViagem != null && !this.codViagem.equals(other.codViagem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Viagem[ codViagem=" + codViagem + " ]";
    }
    
}
