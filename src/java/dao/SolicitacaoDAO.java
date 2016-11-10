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

    //obter
    //obter listas
    public static List<Solicitacao> obterSolicitacao() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from solicitacao");
            while (rs.next()) {
                Solicitacao solicitacao = new Solicitacao(
                        rs.getInt("codSolicitacao"),
                        rs.getString("assunto"),
                        rs.getString("texto")
                        
                );
                solicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return solicitacoes;
    }
    
    //Obter normal
    public static Solicitacao obterSolicitacao(int codSolicitacao) throws  ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Solicitacao solicitacao = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from solicitacao where codSolicitacao ="+codSolicitacao);
            rs.first();
            
            solicitacao = new Solicitacao(
                    rs.getInt("codSolicitacao"),
                        rs.getString("assunto"),
                        rs.getString("texto")
            );
            solicitacao.setCodSolicitacao(rs.getInt("codSolicitacao"));
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return solicitacao;
    }

    //fechar conexão
    public static void fecharConexao(Connection conexao, Statement comando) throws SQLException {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    //gravar    
    public static void gravar(Solicitacao solicitacao) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into solicitacao (codSolicitacao, assunto,texto) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, solicitacao.getCodSolicitacao());
            comando.setString(2, solicitacao.getAssunto());
            comando.setString(3, solicitacao.getTexto());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }
    
    //alterar
    public static void alterar(Solicitacao solicitacao) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update solicitacao set assunto = ?,texto = ? where codSolicitacao = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, solicitacao.getAssunto());
            comando.setString(2, solicitacao.getTexto());
            comando.setInt(3, solicitacao.getCodSolicitacao());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
    }
    
    //excluir

    public static void excluir(Solicitacao solicitacao) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from curso where codSolicitacao = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, solicitacao.getCodSolicitacao());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
}
    
}
