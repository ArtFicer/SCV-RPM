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
    public static List<DeclaracaoNotaTecnica> obterDeclaracaoNotaTecnica() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<DeclaracaoNotaTecnica> declaracaoNotaTecnicas = new ArrayList<DeclaracaoNotaTecnica>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from declaracaoNotaTecnica");
            while (rs.next()) {
                DeclaracaoNotaTecnica declaracaoNotaTecnica = new DeclaracaoNotaTecnica(
                        rs.getInt("codDeclaracaoNotaTecnica"),
                        rs.getString("redigir")
                        );
                declaracaoNotaTecnicas.add(declaracaoNotaTecnica);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return declaracaoNotaTecnicas;
    }
    
    //obter normal
    public static DeclaracaoNotaTecnica obterDeclaracaoNotaTecnica(int codDeclaracaoNotaTecnica)  throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        DeclaracaoNotaTecnica declaracaoNotaTecnica = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from declaracaoNotaTecnica where codDeclaracaoNotaTecnica ="+codDeclaracaoNotaTecnica);
            rs.first();
            
            declaracaoNotaTecnica = new DeclaracaoNotaTecnica(
                    rs.getInt("codDeclaracaoNotaTecnica"),
                    rs.getString("redigir")
            );
            declaracaoNotaTecnica.setCodDeclaracaoNotaTecnica(rs.getInt("codDeclaracaoNotaTecnica"));
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return declaracaoNotaTecnica;
    }

    //Fechar conexão
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

    //Gravar
    public static void gravar(DeclaracaoNotaTecnica declaracaoNotaTecnica) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into declaracaoNotaTecnica (codDeclaracaoNotaTecnica, redigir) values (?,?)";
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
            String sql = "update declaracaoNotaTecnica (codDeclaracaoNotaTecnica, redigir) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, declaracaoNotaTecnica.getCodDeclaracaoNotaTecnica());
            comando.setString(2, declaracaoNotaTecnica.getRedigir());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
    
    //Excluir
}
