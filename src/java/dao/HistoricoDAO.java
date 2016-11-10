package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Historico;

public class HistoricoDAO {

    //obter
    //obter listas
    public static List<Historico> obterHistorico() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Historico> historicos = new ArrayList<Historico>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from historico");
            while (rs.next()) {
                Historico historico = new Historico(rs.getInt("codHistorico")
                );
                historicos.add(historico);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return historicos;
    }
    
    //obter para dao
    public static Historico obterHistorico(int codHistorico)  throws  ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Historico historico = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from historico where codHistorico ="+codHistorico);
            rs.first();
            
            historico = new Historico(
                    rs.getInt("codHistorico")
            );
            historico.setCodHistorico(rs.getInt("codHistorico"));
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return historico;
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

    //Gravar
        public static void gravar(Historico historico) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into historico (codHistorico) values (?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, historico.getCodHistorico());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }


        //Alterar
            public static void alterar(Historico historico) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update historico set codHistorico = ? where codDisciplina = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, historico.getCodHistorico());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
    }

    //Excluir
             public static void excluir(Historico historico) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from historico where codHistorico = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, historico.getCodHistorico());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
}
}
