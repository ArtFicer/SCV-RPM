package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Trimestre;

public class TrimestreDAO {

    public static List<Trimestre> obterTrimestre() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Trimestre> trimestres = new ArrayList<Trimestre>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()) {
                Trimestre trimestre = new Trimestre(rs.getInt("numeroTrimeste"),
                        rs.getInt("codTrimestre")
                );
                trimestres.add(trimestre);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return trimestres;
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
