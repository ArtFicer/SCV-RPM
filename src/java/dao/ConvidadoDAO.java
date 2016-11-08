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

    //Obter
    //Obter Lista
    public static List<Convidado> obterConvidado() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Convidado> convidados = new ArrayList<Convidado>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from convidado");
            while (rs.next()) {
                Convidado convidado = new Convidado(
                        rs.getInt("codConvidado"),
                        rs.getInt("codProposto"),
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
    //Obter Normal
    public static Convidado obterConvidado(int codConvidado)throws  ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        Convidado convidado = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from convidado where codConvidado =" + codConvidado);
            rs.first();

            convidado = new Convidado(
                    rs.getInt("codConvidado"),
                    rs.getInt("codProposto"),
                    rs.getInt("matricula_SIAPE")
            );
            convidado.setCodConvidado(rs.getInt("codConvidado"));
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return convidado;
    }

    //Fechar Conexão
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
    public static void gravar(Convidado convidado) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "insert into convidado (codConvidado, proposto_codProposto, matricula_SIAPE) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, convidado.getCodConvidado());
            comando.setInt(2, convidado.getCodProposto());
            comando.setInt(3, convidado.getMatricula_SIAPE());
//            if(convidado.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,convidado.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException e) {
            throw e;
        }
    }

    //Alterar
    public static void alterar(Convidado convidado) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String sql = "update convidado set codConvidado = ?, matricula_SIAPE = ? where codConvidado = ? ";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, convidado.getCodProposto());
            comando.setInt(2, convidado.getMatricula_SIAPE());
            comando.setInt(3, convidado.getCodConvidado());
            comando.execute();
            comando.close();
            conexao.close();
        } catch (SQLException | ClassNotFoundException ex) {
        }
    }
    //Excluir
     public static void excluir(Convidado convidado) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from convidado where codConvidado = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, convidado.getCodConvidado());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
}
}
