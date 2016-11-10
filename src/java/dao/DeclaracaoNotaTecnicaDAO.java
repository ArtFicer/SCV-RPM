package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.DeclaracaoNotaTecnica;

public class DeclaracaoNotaTecnicaDAO {

    //obter
    //obter listas
    public static List<DeclaracaoNotaTecnica> obterDeclaracaoNotaTecnica() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<DeclaracaoNotaTecnica> declaracaoNotaTecnicas = new ArrayList<DeclaracaoNotaTecnica>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from declaracaonotatecnica");
            while (rs.next()) {
                DeclaracaoNotaTecnica declaracaoNotaTecnica = new DeclaracaoNotaTecnica(
                        rs.getInt("codDeclaracaoNotaTecnica"),
                        rs.getString("redigir")
                        );
                declaracaoNotaTecnicas.add(declaracaoNotaTecnica);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return declaracaoNotaTecnicas;
    }
    
    //obter normal
    public static DeclaracaoNotaTecnica obterDeclaracaoNotaTecnica(int codDeclaracaoNotaTecnica)  throws  ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        DeclaracaoNotaTecnica declaracaoNotaTecnica = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from declaracaonotatecnica where codDeclaracaoNotaTecnica ="+codDeclaracaoNotaTecnica);
            rs.first();
            
            declaracaoNotaTecnica = new DeclaracaoNotaTecnica(
                    rs.getInt("codDeclaracaoNotaTecnica"),
                    rs.getString("redigir")
            );
            declaracaoNotaTecnica.setCodDeclaracaoNotaTecnica(rs.getInt("codDeclaracaoNotaTecnica"));
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return declaracaoNotaTecnica;
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
    public static void gravar(DeclaracaoNotaTecnica declaracaoNotaTecnica) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into declaracaonotatecnica (codDeclaracaoNotaTecnica, redigir) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, declaracaoNotaTecnica.getCodDeclaracaoNotaTecnica());
            comando.setString(2, declaracaoNotaTecnica.getRedigir());
//            if(declaracaoNotaTecnica.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,declaracaoNotaTecnica.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
    }

    //Alterar
    public static void alterar(DeclaracaoNotaTecnica declaracaoNotaTecnica) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update declaracaonotatecnica set redigir=? where codDeclaracaoNotaTecnica = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, declaracaoNotaTecnica.getRedigir());
            comando.setInt(2, declaracaoNotaTecnica.getCodDeclaracaoNotaTecnica());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
    }
    
    //Excluir
     public static void excluir(DeclaracaoNotaTecnica declaracaoNotaTecnica) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from declaracaonotatecnica where codDeclaracaoNotaTecnica = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, declaracaoNotaTecnica.getCodDeclaracaoNotaTecnica());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
}
}
