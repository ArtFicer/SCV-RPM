package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Curso;

public class CursoDAO {

    public static List<Curso> obterCurso() throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Curso> cursos = new ArrayList<Curso>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from curso");
            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("codCurso"),
                        rs.getString("nome")
                );
                cursos.add(curso);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return cursos;
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
