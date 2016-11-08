package modelo;

import dao.PoloDAO;
import java.sql.SQLException;
import java.util.List;

public class Polo {

    private int codPolo;
    private int codTransporte;
    private String cidade;
    private String logradouro;
    private String bairro;
    private int numero;
    private int telefone;
    private String email;
    
    //codPolo,codTransporte,cidade,logradouro,bairro,numero,telefone,email
       
    // Construtores
    public Polo(int codPolo, int codTransporte, String cidade, String logradouro, String bairro, int numero, int telefone, String email) {
        this.codPolo = codPolo;
        this.codTransporte = codTransporte;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.numero = numero;
        this.telefone = telefone;
        this.email = email;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        PoloDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Polo> obterPolo() throws java.lang.ClassNotFoundException {
        return PoloDAO.obterPolo();
    }

    //Obter Polo
    public static Polo obterPolo(int codPolo) throws ClassNotFoundException {
        return PoloDAO.obterPolo(codPolo);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        PoloDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        PoloDAO.excluir(this);
    }

    //Set e Gets
    public int getCodPolo() {
        return codPolo;
    }

    public void setCodPolo(int codPolo) {
        this.codPolo = codPolo;
    }

    public int getCodTransporte() {
        return codTransporte;
    }

    public void setCodTransporte(int transporte) {
        this.codTransporte = codTransporte;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
