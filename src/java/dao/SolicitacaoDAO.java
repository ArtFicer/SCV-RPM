package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            ResultSet rs = comando.executeQuery("select = from solicitacao");
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

        public static void gravar(Solicitacao solicitacao) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into solicitacao (codSolicitacao, assunto,texto) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, solicitacao.getCodSolicitacao());
            comando.setString(2, solicitacao.getAssunto());
            comando.setString(3, solicitacao.getTexto());
//            if(solicitacao.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,solicitacao.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }
    public static void alterar(Solicitacao solicitacao) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update solicitacao (codSolicitacao, assunto,texto) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, solicitacao.getCodSolicitacao());
            comando.setString(2, solicitacao.getAssunto());
            comando.setString(3, solicitacao.getTexto());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }

}
