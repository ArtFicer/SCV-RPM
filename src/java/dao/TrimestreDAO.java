package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Trimestre;

public class TrimestreDAO {

    //obter
    //obter listas
    public static List<Trimestre> obterTrimestre() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Trimestre> trimestres = new ArrayList<Trimestre>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from trimestre");
            while (rs.next()) {
                Trimestre trimestre = new Trimestre(
                        rs.getInt("codTrimestre"),
                        rs.getInt("numeroTrimestre")
                        
                );
                trimestres.add(trimestre);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return trimestres;
    }
    
    //Obter normal
    public static Trimestre obterTrimestre(int codTrimestre) throws  ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Trimestre trimestre = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from trimestre where codTrimestre ="+codTrimestre);
            rs.first();
            
            trimestre = new Trimestre(
                    rs.getInt("codTrimestre"),
                        rs.getInt("numeroTrimestre")
                        
            );
            trimestre.setCodTrimestre(rs.getInt("codTrimestre"));
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return trimestre;
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
    public static void gravar(Trimestre trimestre) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into trimestre (codTrimestre, numero_trimestre) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, trimestre.getCodTrimestre());
            comando.setInt(2, trimestre.getNumeroTrimestre());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }


    //Alterar        
    public static void alterar(Trimestre trimestre) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update trimestre set numero_trimestre = ? where codTrimestre = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, trimestre.getNumeroTrimestre());
            comando.setInt(2, trimestre.getCodTrimestre());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
    }
        
    //Excluir
    public static void excluir(Trimestre trimestre) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from trimestre where codTrimestre = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, trimestre.getCodTrimestre());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
}
    
}
