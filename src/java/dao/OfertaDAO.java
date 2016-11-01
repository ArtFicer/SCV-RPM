package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Oferta;

public class OfertaDAO {

    public static List<Oferta> obterOferta() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Oferta> ofertas = new ArrayList<Oferta>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from oferta");
            while (rs.next()) {
                Oferta oferta = new Oferta(
                        rs.getInt("codOferta"),
                        rs.getInt("ano")
                );
                ofertas.add(oferta);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return ofertas;
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

        public static void gravar(Oferta oferta) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into oferta (codOferta, ano) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, oferta.getCodOferta());
            comando.setInt(2, oferta.getAno());
//            if(oferta.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,oferta.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }


            public static void alterar(Oferta oferta) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update oferta set nome = ? where codOferta = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, oferta.getNome());
            comando.setInt(2,oferta.getCodOferta());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
}
