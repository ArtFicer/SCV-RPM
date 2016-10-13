package dao;

import java.sql.Connection;
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
            ResultSet rs = comando.executeQuery("select = from curso");
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

}
