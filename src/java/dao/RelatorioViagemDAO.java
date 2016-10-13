package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.RelatorioViagem;

public class RelatorioViagemDAO {

    public static List<RelatorioViagem> obterEscreverRelatorio() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<RelatorioViagem> escreverRelatorios = new ArrayList<RelatorioViagem>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()) {
                RelatorioViagem escreverRelatorio = new RelatorioViagem(
                        rs.getString("relatorio"), rs.getInt("codEscreverRelatorio")
                );
                escreverRelatorios.add(escreverRelatorio);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return escreverRelatorios;
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
