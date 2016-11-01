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

    public static List<Historico> obterHistorico() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Historico> historicos = new ArrayList<Historico>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from disciplina");
            while (rs.next()) {
                Historico historico = new Historico(rs.getInt("codHistorico")
                );
                historicos.add(historico);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return historicos;
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

        public static void gravar(Historico historico) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into historico (codHistorico, nome) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, historico.getCodHistorico());
//            if(disciplina.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,disciplina.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }


            public static void alterar(Historico disciplina) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update disciplina set nome = ? where codHistorico = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, disciplina.getNome());
            comando.setInt(2,disciplina.getCodHistorico());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
}
