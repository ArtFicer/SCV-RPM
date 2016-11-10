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

    //obter
    //obter listas
    public static List<Servidor> obterServidores() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Servidor> servidores = new ArrayList<Servidor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from servidor");
            while (rs.next()) {
                Servidor servidor = new Servidor(
                        rs.getInt("codServidor"),
                        rs.getInt("matricula_SIAPE"),
                        rs.getString("lotado_Orgao")
                        
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
    
    //Obter normal
    public static Servidor obterServidor(int codServidor) throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Servidor servidor = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from servidor where codServidor ="+codServidor);
            rs.first();
            
            servidor = new Servidor(
                    rs.getInt("codServidor"),
                        rs.getInt("matriculaSIAPE"),
                        rs.getString("lotadoOrgao")
            );
            servidor.setCodServidor(rs.getInt("codServidor"));
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return servidor;
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

    //gravar    
    public static void gravar(Servidor servidor) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into servidor (codServidor, matricula_SIAPE,lotado_Orgao) values (?,?,?)";
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

    //alterar
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
    
    //exlcuir
    public static void excluir(Servidor servidor) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from curso where codServidor = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, servidor.getCodServidor());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
}
    
}
