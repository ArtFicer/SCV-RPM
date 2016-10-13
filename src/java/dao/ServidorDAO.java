package dao;

import java.sql.Connection;
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
            ResultSet rs = comando.executeQuery("select = from curso");
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

}
