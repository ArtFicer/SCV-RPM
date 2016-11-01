package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.Proposto;
import dao.PropostoDAO;

public class CadastroRapidoDAO {

    public static List<Proposto> obterProposto() throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Proposto> propostos = new ArrayList<Proposto>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from proposto");
            while (rs.next()) {
                Proposto proposto = new Proposto(
                        rs.getInt("codProposto"),
                        rs.getString("nome")
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
    
    public static Proposto obterProposto(int codProposto) throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Proposto Proposto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from proposto where codProposto ="+codProposto);
            rs.first();
            
            Proposto = new Proposto(
                    rs.getInt("codProposto"),
                    rs.getString("nome"));
            Proposto.setCodProposto(rs.getInt("proposto"));
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return Proposto;
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

    public static void gravar(Proposto proposto) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into proposto (codProposto, nome) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, proposto.getCodProposto());
            comando.setString(2, proposto.getNome());
//            if(proposto.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,proposto.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    public static void alterar(Proposto proposto) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update proposto set nome = ? where codProposto = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, proposto.getNome());
            comando.setInt(2,proposto.getCodProposto());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
}
