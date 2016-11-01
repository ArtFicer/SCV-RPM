package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Servidor;

public class ServidorDAO {

    public static List<Servidor> obterServidor() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Servidor> servidores = new ArrayList<Servidor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from servidor");
            while (rs.next()) {
                Servidor servidor = new Servidor(rs.getInt("matriculaSIAPE"),
                        rs.getString("lotadoOrgao"),
                        rs.getInt("codServidor")
                );
                servidores.add(servidor);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return servidores;
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

        public static void gravar(Servidor servidor) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into servidor (codServidor, Matricula_SIAPE,lotado_Orgao) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, servidor.getCodServidor());
            comando.setInt(2, servidor.getMatriculaSIAPE());
            comando.setString(3, servidor.getLotadoOrgao());
//            if(servidor.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,servidor.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    public static void alterar(Servidor servidor) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update servidor (codServidor, Matricula_SIAPE,lotado_Orgao) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, servidor.getCodServidor());
            comando.setInt(2, servidor.getMatriculaSIAPE());
            comando.setString(3, servidor.getLotadoOrgao());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
}
