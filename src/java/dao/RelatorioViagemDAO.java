package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.RelatorioViagem;

public class RelatorioViagemDAO {

    //obter
    //obter listas
    public static List<RelatorioViagem> obterRelatorioViagem() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<RelatorioViagem> relatorioViagens = new ArrayList<RelatorioViagem>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from relatorioviagem");
            while (rs.next()) {
                RelatorioViagem relatorioViagem = new RelatorioViagem(
                        rs.getInt("codRelatorioViagem"), rs.getString("relatorio") 
                );
                relatorioViagens.add(relatorioViagem);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return relatorioViagens;
    }
    
    //Obter normal
    public static RelatorioViagem obterRelatorioViagem(int codRelatorioViagem) throws  ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        RelatorioViagem relatorioViagem = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from relatorioviagem where codRelatorioViagem ="+codRelatorioViagem);
            rs.first();
            
            relatorioViagem = new RelatorioViagem(
                 rs.getInt("codRelatorioViagem"), rs.getString("relatorio")
            );
            relatorioViagem.setCodRelatorioViagem(rs.getInt("codRelatorioViagem"));
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return relatorioViagem;
    }

    //Fechar Conexão
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

    //Gravar    
    public static void gravar(RelatorioViagem relatorioViagem) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into relatorioviagem (codRelatorioViagem, relatorio) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, relatorioViagem.getCodRelatorioViagem());
            comando.setString(2, relatorioViagem.getRelatorio());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    //Alterar
    public static void alterar(RelatorioViagem relatorioViagem) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update relatorioviagem set relatorio = ? where codRelatorioViagem = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, relatorioViagem.getRelatorio());
            comando.setInt(2, relatorioViagem.getCodRelatorioViagem());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
    }
    
    //Excluir
        public static void excluir(RelatorioViagem relatorioViagem) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from relatorioviagem where codRelatorioViagem = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, relatorioViagem.getCodRelatorioViagem());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
}
    
}

