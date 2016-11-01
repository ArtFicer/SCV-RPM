package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Transporte;

public class TransporteDAO {

    public static List<Transporte> obterTransporte() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Transporte> transportes = new ArrayList<Transporte>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from transporte");
            while (rs.next()) {
                Transporte transporte = new Transporte(rs.getString("empresa"),
                        rs.getString("veiculo"),
                        rs.getInt("codTransporte")
                );
                transportes.add(transporte);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return transportes;
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

        public static void gravar(Transporte transporte) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into transporte (codTransporte, empresa, veiculo) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, transporte.getCodTransporte());
            comando.setString(2, transporte.getEmpresa());
            comando.setString(3, transporte.getVeiculo());
//            if(transporte.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,transporte.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    public static void alterar(Transporte transporte) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update transporte (codTransporte, empresa, veiculo) values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, transporte.getCodTransporte());
            comando.setString(2, transporte.getEmpresa());
            comando.setString(3, transporte.getVeiculo());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
}
