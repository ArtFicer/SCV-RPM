/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Professor;

/**
 *
 * @author pe-ri
 */
public class ProfessorDAO {

    public static List<Professor> obterProfessor()  throws  ClassNotFoundException {
       Connection conexao = null;
        Statement comando = null;
        List<Professor> professores = new ArrayList<Professor>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from professor");
            while (rs.next()) {
                Professor professor = new Professor(
                        rs.getInt("codProfessor"),
                        rs.getString("nome"),
                        rs.getInt("coordenador")
                );
                professores.add(professor);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return professores;
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
