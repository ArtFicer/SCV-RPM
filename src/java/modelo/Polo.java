package modelo;

import dao.PoloDAO;
import java.sql.SQLException;
import java.util.List;

public class Polo {

    public static List<Polo> obterPolo() throws ClassNotFoundException {
        return PoloDAO.obterPolo();
    }
    private String cidade, logradouro, bairro, telefone, email;
    private int numero, modelo, codPolo;

    public Polo(String cidade, String logradouro, String bairro, String telefone, String email, int numero, int modelo, int codPolo) {
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.telefone = telefone;
        this.email = email;
        this.numero = numero;
        this.modelo = modelo;
        this.codPolo = codPolo;
    }

    public int getCodPolo() {
        return codPolo;
    }

    public void setCodPolo(int codPolo) {
        this.codPolo = codPolo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        PoloDAO.gravar(this);
    }
}
