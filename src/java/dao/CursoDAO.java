package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
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
    
    public static Curso obterCurso(int codCurso) throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Curso curso = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from curso where codCurso ="+codCurso);
            rs.first();
            
            curso = new Curso(
                    rs.getInt("codCurso"),
                    rs.getString("nome"),
                    null
            );
            curso.setCodProposto(rs.getInt("proposto"));
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return curso;
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

    public static void gravar(Curso curso) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into curso (codCurso, nome, cargaHoraria, "
                    +"tipoCurso, totalPeriodos, proposto)"
                    +"values (?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, curso.getCodCurso());
            comando.setString(2, curso.getNome());
            if(curso.getProposto()==null)
            {
                comando.setNull(3,Types.NULL);
            }else{
                comando.setInt(3,curso.getProposto().getCodProposto());
            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }


}
