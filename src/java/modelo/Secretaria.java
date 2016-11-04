package modelo;

import dao.SecretariaDAO;
import java.sql.SQLException;
import java.util.List;

public class Secretaria {

    private int codSecretaria;
    private String nome;
    private int cpf;
    private String email;
    private String senha;
    // Construtores

    public Secretaria(int codSecretaria, String nome, int cpf, String email, String senha) {
        this.codSecretaria = codSecretaria;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        SecretariaDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Secretaria> obterSecretaria() throws java.lang.ClassNotFoundException {
        return SecretariaDAO.obterSecretaria();
    }

    //Obter Secretaria
    public static Secretaria obterSecretaria(int codSecretaria) throws ClassNotFoundException {
        return SecretariaDAO.obterSecretaria(codSecretaria);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        SecretariaDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        SecretariaDAO.excluir(this);
    }

    //Set e Gets
    public int getCodSecretaria() {
        return codSecretaria;
    }

    public void setCodSecretaria(int codSecretaria) {
        this.codSecretaria = codSecretaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
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

}
