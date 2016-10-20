package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Convidado;

public class ConvidadoDAO {

    public static List<Convidado> obterConvidado() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Convidado> convidados = new ArrayList<Convidado>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()) {
                Convidado convidado = new Convidado(
                        rs.getInt("codConvidado"),
                        rs.getInt("matriculaSIAPE")
                );
                convidados.add(convidado);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return convidados;
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
        public static void gravar(Convidado convidado) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into convidado (codConvidado, Proposto_codProposto, matricula_SIAPE) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, convidado.getCodConvidado());
            comando.setInt(2, convidado.getCodProposto());
            comando.setInt(3, convidado.getMatriculaSIAPE());
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
