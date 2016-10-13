package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Solicitacao;

public class SolicitacaoDAO {

    public static List<Solicitacao> obterSolicitacao() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()) {
                Solicitacao solicitacao = new Solicitacao(rs.getString("assunto"),
                        rs.getString("texto"),
                        rs.getInt("codSolicitacao")
                );
                solicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return solicitacoes;
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
