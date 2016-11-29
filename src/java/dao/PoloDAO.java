package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Polo;
import modelo.Transporte;


public class PoloDAO {

    //Obter
    //obter Listas
    public static List<Polo> obterPolo() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Polo> polos = new ArrayList<Polo>();
        Transporte transporte = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from polo join transporte on polo.codTransporte = transporte.codTransporte");
            while (rs.next()) {
                
                transporte = new Transporte(rs.getInt("codTransporte"), rs.getString("empresa"), rs.getString("veiculo"));
                Polo polo = new Polo(
                        rs.getInt("codPolo"),
                        transporte,
                        rs.getString("cidade"),
                        rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getInt("numero"),
                        rs.getInt("telefone"),
                        rs.getString("email")
                );
                polos.add(polo);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return polos;
    }
    //Obter normal
    public static Polo obterPolo(int codPolo) throws  ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Polo polo = null;
        Transporte transporte = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from polo join transporte on polo.codTransporte = transporte.codTransporte where codPolo = "+codPolo);
            rs.first();
            transporte = new Transporte(rs.getInt("codTransporte"), rs.getString("empresa"), rs.getString("veiculo"));
            polo = new Polo(
                    rs.getInt("codPolo"),
                    transporte,
                    rs.getString("cidade"),
                    rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getInt("numero"),
                    rs.getInt("telefone"),
                    rs.getString("email")
            );
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return polo;
    }

    //Fechar conexão
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
    public static void gravar(Polo polo) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into polo (codPolo,codTransporte, cidade,logradouro,bairro,numero,telefone,email) values (?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, polo.getCodPolo());
            comando.setInt(2, polo.getCodTransporte().getCodTransporte());
            comando.setString(3, polo.getCidade());
            comando.setString(4, polo.getLogradouro());
            comando.setString(5, polo.getBairro());
            comando.setInt(6, polo.getNumero());
            comando.setInt(7, polo.getTelefone());
            comando.setString(8, polo.getEmail());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    //Alterar
    public static void alterar(Polo polo) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update polo set codTransporte = ?, cidade = ?,logradouro = ?,bairro = ?,numero = ?,telefone = ?,email = ? where codPolo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, polo.getCodTransporte().getCodTransporte());
            comando.setString(2, polo.getCidade());
            comando.setString(3, polo.getLogradouro());
            comando.setString(4, polo.getBairro());
            comando.setInt(5, polo.getNumero());
            comando.setInt(6, polo.getTelefone());
            comando.setString(7, polo.getEmail());
            comando.setInt(8, polo.getCodPolo());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
    }
    //Excluir
       public static void excluir(Polo polo) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from polo where codPolo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, polo.getCodPolo());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
}
}
