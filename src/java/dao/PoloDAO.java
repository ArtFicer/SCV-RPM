package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Polo;

public class PoloDAO {

    public static List<Polo> obterPolo() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Polo> polos = new ArrayList<Polo>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()) {
                Polo polo = new Polo(
                        rs.getString("cidade"),
                        rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getInt("numero"),
                        rs.getInt("modelo"),
                        rs.getInt("codPolo")
                );
                polos.add(polo);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return polos;
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

        public static void gravar(Polo polo) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into polo (codOferta,Transporte_codTransporte, cidade,logradouro,bairro,numero,telefone,email) values (?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, polo.getCodOferta());
            comando.setInt(2, polo.getCodTransporte());
            comando.setString(3, polo.getCidade());
            comando.setString(4, polo.getLogradouro());
            comando.setString(5, polo.getBairro());
            comando.setInt(6, polo.getNumero());
            comando.setString(7, polo.getTelefone());
            comando.setString(8, polo.getEmail());
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
