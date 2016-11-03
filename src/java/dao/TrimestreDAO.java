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

    public static List<Trimestre> obterTrimestre() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Trimestre> trimestres = new ArrayList<Trimestre>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from trimestre");
            while (rs.next()) {
                Trimestre trimestre = new Trimestre(
                        rs.getInt("codTrimestre"),
                        rs.getInt("numeroTrimestre")
                        
                );
                trimestres.add(trimestre);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return trimestres;
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

        public static void gravar(Trimestre trimestre) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into trimestre (codTrimestre, numero_trimestre) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, trimestre.getCodTrimestre());
            comando.setInt(2, trimestre.getNumeroTrimestre());
//            if(trimestre.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,trimestre.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }


            public static void alterar(Trimestre trimestre) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update trimestre (codTrimestre, numero_trimestre) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, trimestre.getCodTrimestre());
            comando.setInt(2, trimestre.getNumeroTrimestre());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
        
}
