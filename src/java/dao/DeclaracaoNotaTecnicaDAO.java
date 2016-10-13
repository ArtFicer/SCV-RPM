package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DeclaracaoNotaTecnica;

public class DeclaracaoNotaTecnicaDAO {

    public static List<DeclaracaoNotaTecnica> obterDeclaracaoNotaTecnica() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<DeclaracaoNotaTecnica> declaracaoNotaTecnicas = new ArrayList<DeclaracaoNotaTecnica>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()) {
                DeclaracaoNotaTecnica declaracaoNotaTecnica = new DeclaracaoNotaTecnica(
                        rs.getString("redigir"),
                        rs.getInt("codDeclaracaoNotaTecnica")
                );
                declaracaoNotaTecnicas.add(declaracaoNotaTecnica);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return declaracaoNotaTecnicas;
    }

    public static void fecharConexao(Connection conexao, Statement comando) {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
        }
    }

}
