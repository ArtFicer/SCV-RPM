package dao;

import java.sql.Connection;
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

}
