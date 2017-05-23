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
@Table(name = "Proposto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proposto.findAll", query = "SELECT p FROM Proposto p"),
    @NamedQuery(name = "Proposto.findByCodProposto", query = "SELECT p FROM Proposto p WHERE p.codProposto = :codProposto"),
    @NamedQuery(name = "Proposto.findByNome", query = "SELECT p FROM Proposto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Proposto.findBySetor", query = "SELECT p FROM Proposto p WHERE p.setor = :setor"),
    @NamedQuery(name = "Proposto.findByCpf", query = "SELECT p FROM Proposto p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Proposto.findByDataNascimento", query = "SELECT p FROM Proposto p WHERE p.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Proposto.findByEmail", query = "SELECT p FROM Proposto p WHERE p.email = :email"),
    @NamedQuery(name = "Proposto.findByTelefone", query = "SELECT p FROM Proposto p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Proposto.findByCelular", query = "SELECT p FROM Proposto p WHERE p.celular = :celular"),
    @NamedQuery(name = "Proposto.findByLogradouro", query = "SELECT p FROM Proposto p WHERE p.logradouro = :logradouro"),
    @NamedQuery(name = "Proposto.findByNumero", query = "SELECT p FROM Proposto p WHERE p.numero = :numero"),
    @NamedQuery(name = "Proposto.findByComplemento", query = "SELECT p FROM Proposto p WHERE p.complemento = :complemento"),
    @NamedQuery(name = "Proposto.findByBairro", query = "SELECT p FROM Proposto p WHERE p.bairro = :bairro"),
    @NamedQuery(name = "Proposto.findByCidade", query = "SELECT p FROM Proposto p WHERE p.cidade = :cidade"),
    @NamedQuery(name = "Proposto.findByUf", query = "SELECT p FROM Proposto p WHERE p.uf = :uf"),
    @NamedQuery(name = "Proposto.findByCep", query = "SELECT p FROM Proposto p WHERE p.cep = :cep"),
    @NamedQuery(name = "Proposto.findByTitulacaoMaxima", query = "SELECT p FROM Proposto p WHERE p.titulacaoMaxima = :titulacaoMaxima"),
    @NamedQuery(name = "Proposto.findByBanco", query = "SELECT p FROM Proposto p WHERE p.banco = :banco"),
    @NamedQuery(name = "Proposto.findByAgencia", query = "SELECT p FROM Proposto p WHERE p.agencia = :agencia"),
    @NamedQuery(name = "Proposto.findByConta", query = "SELECT p FROM Proposto p WHERE p.conta = :conta"),
    @NamedQuery(name = "Proposto.findByCargo", query = "SELECT p FROM Proposto p WHERE p.cargo = :cargo")})

public class Proposto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codProposto")
    private Integer codProposto;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "setor")
    private String setor;
    @Basic(optional = false)
    @Column(name = "cpf")
    private int cpf;
    @Basic(optional = false)
    @Column(name = "data_nascimento")
    private String dataNascimento;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "telefone")
    private int telefone;
    @Basic(optional = false)
    @Column(name = "celular")
    private int celular;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @Column(name = "complemento")
    private String complemento;
    @Basic(optional = false)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @Column(name = "uf")
    private String uf;
    @Basic(optional = false)
    @Column(name = "cep")
    private int cep;
    @Basic(optional = false)
    @Column(name = "titulacao_maxima")
    private String titulacaoMaxima;
    @Basic(optional = false)
    @Column(name = "banco")
    private String banco;
    @Basic(optional = false)
    @Column(name = "agencia")
    private int agencia;
    @Basic(optional = false)
    @Column(name = "conta")
    private int conta;
    @Basic(optional = false)
    @Column(name = "cargo")
    private String cargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propostocodProposto")
    private Collection<Servidor> servidorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propostocodProposto")
    private Collection<Convidado> convidadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propostocodProposto")
    private Collection<Viagem> viagemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propostocodProposto")
    private Collection<Solicitacao> solicitacaoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propostocodProposto")
    private Collection<Secretaria> secretariaCollection;

    public Proposto() {
    }

    public Proposto(Integer codProposto) {
        this.codProposto = codProposto;
    }

    public Proposto(Integer codProposto, String nome, String setor, int cpf, String dataNascimento, String email, int telefone, int celular, String logradouro, int numero, String complemento, String bairro, String cidade, String uf, int cep, String titulacaoMaxima, String banco, int agencia, int conta, String cargo) {
        this.codProposto = codProposto;
        this.nome = nome;
        this.setor = setor;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.titulacaoMaxima = titulacaoMaxima;
        this.banco = banco;
        this.agencia = agencia;
        this.conta = conta;
        this.cargo = cargo;
    }

    public Integer getCodProposto() {
        return codProposto;
    }

    public void setCodProposto(Integer codProposto) {
        this.codProposto = codProposto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getTitulacaoMaxima() {
        return titulacaoMaxima;
    }

    public void setTitulacaoMaxima(String titulacaoMaxima) {
        this.titulacaoMaxima = titulacaoMaxima;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @XmlTransient
    public Collection<Servidor> getServidorCollection() {
        return servidorCollection;
    }

    public void setServidorCollection(Collection<Servidor> servidorCollection) {
        this.servidorCollection = servidorCollection;
    }

    @XmlTransient
    public Collection<Convidado> getConvidadoCollection() {
        return convidadoCollection;
    }

    public void setConvidadoCollection(Collection<Convidado> convidadoCollection) {
        this.convidadoCollection = convidadoCollection;
    }

    @XmlTransient
    public Collection<Viagem> getViagemCollection() {
        return viagemCollection;
    }

    public void setViagemCollection(Collection<Viagem> viagemCollection) {
        this.viagemCollection = viagemCollection;
    }

    @XmlTransient
    public Collection<Solicitacao> getSolicitacaoCollection() {
        return solicitacaoCollection;
    }

    public void setSolicitacaoCollection(Collection<Solicitacao> solicitacaoCollection) {
        this.solicitacaoCollection = solicitacaoCollection;
    }

    @XmlTransient
    public Collection<Secretaria> getSecretariaCollection() {
        return secretariaCollection;
    }

    public void setSecretariaCollection(Collection<Secretaria> secretariaCollection) {
        this.secretariaCollection = secretariaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProposto != null ? codProposto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proposto)) {
            return false;
        }
        Proposto other = (Proposto) object;
        if ((this.codProposto == null && other.codProposto != null) || (this.codProposto != null && !this.codProposto.equals(other.codProposto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Proposto[ codProposto=" + codProposto + " ]";
    }
    
}
