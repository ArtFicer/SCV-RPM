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
    public static List<Historico> obterHistorico() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Historico> historicos = new ArrayList<Historico>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from historico");
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
    
    //obter para dao
    public static Historico obterHistorico(int codHistorico)  throws  ClassNotFoundException {
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
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return historico;
    }

    //fechar conexão
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
        public static void gravar(Historico historico) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into historico (codHistorico) values (?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, historico.getCodHistorico());
//            if(historico.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,historico.getProposto().getCodProposto());
//            }
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
            String sql = "update historico (codHistorico) values (?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, historico.getCodHistorico());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
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
        }
}
}
