package modelo;

import dao.SecretariaDAO;
import java.sql.SQLException;

public class Secretaria {
   private String nome, email;
   private int cpf, senha, codSecretaria;

    public Secretaria(String nome, String email, int cpf, int senha, int codSecretaria) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getCodSecretaria() {
        return codSecretaria;
    }

    public void setCodSecretaria(int codSecretaria) {
        this.codSecretaria = codSecretaria;
    }
    
    public void gravar()throws SQLException, ClassNotFoundException  {
        SecretariaDAO.gravar(this);
    }
}
