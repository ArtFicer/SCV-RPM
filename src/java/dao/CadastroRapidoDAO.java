package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import modelo.CadastroRapido;

public class CadastroRapidoDAO {

    public static List<CadastroRapido> obterCadastroRapido() throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<CadastroRapido> cursos = new ArrayList<CadastroRapido>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from proposto");
            while (rs.next()) {
                CadastroRapido cadastroRapido = new CadastroRapido(
                        rs.getInt("codProposto"),
                        rs.getString("nome")
                );
                cadastroRapido.add(cadastroRapido);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cadastroRapido;
    }
    
    public static CadastroRapido obterCadastroRapido(int codCadastroRapido) throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        CadastroRapido cadastroRapido = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from proposto where codProposto ="+codCadastroRapido);
            rs.first();
            
            cadastroRapido = new CadastroRapido(
                    rs.getInt("codProposto"),
                    rs.getString("nome"),
                    null
            );
            CadastroRapido.setCadastroRapido(rs.getInt("proposto"));
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cadastroRapido;
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

    public static void gravar(CadastroRapido cadastroRapido) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into curso (codProposto, nome) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, cadastroRapido.getCodProposto());
            comando.setString(2, CadastroRapido.getNome());
//            if(curso.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,curso.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }


}
