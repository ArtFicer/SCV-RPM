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

    public static List<RelatorioViagem> obterEscreverRelatorio() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<RelatorioViagem> escreverRelatorios = new ArrayList<RelatorioViagem>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from relatorioViagem");
            while (rs.next()) {
                RelatorioViagem escreverRelatorio = new RelatorioViagem(
                        rs.getInt("codRelatorioViagem"), rs.getString("relatorio") 
                );
                escreverRelatorios.add(escreverRelatorio);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return escreverRelatorios;
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

        public static void gravar(RelatorioViagem relatorioViagem) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into relatorioviagem (codRelatorioViagem, relatorio) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, relatorioViagem.getCodRelatorioViagem());
            comando.setString(2, relatorioViagem.getRelatorio());
//            if(relatorioViagem.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,relatorioViagem.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    public static void alterar(RelatorioViagem relatorioViagem) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update relatorioviagem (codRelatorioViagem, relatorio) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, relatorioViagem.getCodRelatorioViagem());
            comando.setString(2, relatorioViagem.getRelatorio());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
}
