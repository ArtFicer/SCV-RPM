package modelo;

import dao.PropostoDAO;
import java.sql.SQLException;
import java.util.List;

public class Proposto {

    public static List<Proposto> obterProposto() throws ClassNotFoundException {
        return PropostoDAO.obterProposto();
    }
    private int codProposto, cpf, dataNascimento, email, telefone, celular, numero, agencia, conta, senha;
    private String setor, nome, logradouro, complemento, bairro, cidade, uf, cep, rg, titulacaoMaxima, banco, cargo, tipoProposto;

    public Proposto(int codProposto, int cpf, int dataNascimento, int email, int telefone, int celular, int numero, int agencia, int conta, int senha, String setor, String nome, String logradouro, String complemento, String bairro, String cidade, String uf, String cep, String rg, String titulacaoMaxima, String banco, String cargo, String tipoProposto) {
        this.codProposto = codProposto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.numero = numero;
        this.agencia = agencia;
        this.conta = conta;
        this.senha = senha;
        this.setor = setor;
        this.nome = nome;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.rg = rg;
        this.titulacaoMaxima = titulacaoMaxima;
        this.banco = banco;
        this.cargo = cargo;
        this.tipoProposto = tipoProposto;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(int dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTipoProposto() {
        return tipoProposto;
    }

    public void setTipoProposto(String tipoProposto) {
        this.tipoProposto = tipoProposto;
    }

    public int getCodProposto() {
        return codProposto;
    }

    public void setCodProposto(int codProposto) {
        this.codProposto = codProposto;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        PropostoDAO.gravar(this);
    }
}
