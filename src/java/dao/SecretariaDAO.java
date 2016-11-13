package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Secretaria;

public class SecretariaDAO {

    //obter
    //obter listas
    public static List<Secretaria> obterSecretaria() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Secretaria> secretarias = new ArrayList<Secretaria>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from secretaria");
            while (rs.next()) {
                Secretaria secretaria = new Secretaria(
                        rs.getInt("codSecretaria"),
                        rs.getString("nome"),
                        rs.getInt("cpf"),
                        rs.getString("email"),
                        rs.getString("senha")
                        
                );
                secretarias.add(secretaria);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return secretarias;
    }
    
    //Obter normal
    public static Secretaria obterSecretaria(int codSecretaria) throws  ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Secretaria secretaria = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from secretaria where codSecretaria ="+codSecretaria);
            rs.first();
            
            secretaria = new Secretaria(
                   rs.getInt("codSecretaria"),
                        rs.getString("nome"),
                        rs.getInt("cpf"),
                        rs.getString("email"),
                        rs.getString("senha")
            );
            secretaria.setCodSecretaria(rs.getInt("codSecretaria"));
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return secretaria;
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
    public static void gravar(Secretaria secretaria) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into secretaria (codSecretaria, nome,cpf,email,senha) values (?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, secretaria.getCodSecretaria());
            comando.setString(2, secretaria.getNome());
            comando.setInt(3, secretaria.getCpf());
            comando.setString(4, secretaria.getEmail());
            comando.setString(5, secretaria.getSenha());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }
    
    //alterar    
    public static void alterar(Secretaria secretaria) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update secretaria set nome = ?,cpf = ?,email = ?,senha = ? where codSecretaria = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, secretaria.getNome());
            comando.setInt(2, secretaria.getCpf());
            comando.setString(3, secretaria.getEmail());
            comando.setString(4, secretaria.getSenha());
            comando.setInt(5, secretaria.getCodSecretaria());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
    }
    
    //excluir
        public static void excluir(Secretaria secretaria) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from secretaria where codSecretaria = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, secretaria.getCodSecretaria());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
}
    
}


