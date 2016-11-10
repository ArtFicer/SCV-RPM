package modelo;

import dao.DeclaracaoNotaTecnicaDAO;
import java.sql.SQLException;
import java.util.List;

public class DeclaracaoNotaTecnica {

    private int codDeclaracaoNotaTecnica;
    private String redigir;

    // Construtores
    public DeclaracaoNotaTecnica(int codDeclaracaoNotaTecnica, String redigir) {
        this.codDeclaracaoNotaTecnica = codDeclaracaoNotaTecnica;
        this.redigir = redigir;
    }

    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        DeclaracaoNotaTecnicaDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<DeclaracaoNotaTecnica> obterDeclaracaoNotaTecnica() throws java.lang.ClassNotFoundException, SQLException {
        return DeclaracaoNotaTecnicaDAO.obterDeclaracaoNotaTecnica();
    }

    //Obter DeclaracaoNotaTecnica
    public static DeclaracaoNotaTecnica obterDeclaracaoNotaTecnica(int codDeclaracaoNotaTecnica) throws ClassNotFoundException, SQLException {
        return DeclaracaoNotaTecnicaDAO.obterDeclaracaoNotaTecnica(codDeclaracaoNotaTecnica);
    }

    //Alterar
    public void alterar() throws SQLException, ClassNotFoundException {
        DeclaracaoNotaTecnicaDAO.alterar(this);
    }

    //Excluir
    public void Excluir() throws SQLException, ClassNotFoundException {
        DeclaracaoNotaTecnicaDAO.excluir(this);
    }

    //Set e Gets
    public int getCodDeclaracaoNotaTecnica() {
        return codDeclaracaoNotaTecnica;
    }

    public void setCodDeclaracaoNotaTecnica(int codDeclaracaoNotaTecnica) {
        this.codDeclaracaoNotaTecnica = codDeclaracaoNotaTecnica;
    }

    public String getRedigir() {
        return redigir;
    }

    public void setRedigir(String redigir) {
        this.redigir = redigir;
    }

}
