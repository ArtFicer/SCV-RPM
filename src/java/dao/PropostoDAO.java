package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Proposto;

public class PropostoDAO {

    public static List<Proposto> obterProposto() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Proposto> propostos = new ArrayList<Proposto>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()) {
                Proposto proposto = new Proposto(
                        rs.getInt("codProposto"),
                        rs.getInt("cpf"),
                        rs.getInt("dataNascimento"),
                        rs.getInt("email"),
                        rs.getInt("telefone"),
                        rs.getInt("celular"),
                        rs.getInt("numero"),
                        rs.getInt("agencia"),
                        rs.getInt("conta"),
                        rs.getInt("senha"),
                        rs.getString("setor"),
                        rs.getString("nome"),
                        rs.getString("logradouro"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getString("cep"),
                        rs.getString("rg"),
                        rs.getString("titulacaoMaxima"),
                        rs.getString("banco"),
                        rs.getString("cargo"),
                        rs.getString("tipodeproposto")
                );
                propostos.add(proposto);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return propostos;
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
