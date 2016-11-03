package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import modelo.Curso;

public class CursoDAO {

    //Obter
    //Obter Lista
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
    //Obter normal
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
                    rs.getString("nome")
            );
            curso.setCodCurso(rs.getInt("codCurso"));
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return curso;
    }

    //Fechar Conexão
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

    //gravar
    public static void gravar(Curso curso) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into curso (codCurso, nome) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, curso.getCodCurso());
            comando.setString(2, curso.getNome());
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

    //Alterar
    public static void alterar(Curso curso) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update curso set nome = ? where codCurso = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, curso.getNome());
            comando.setInt(2,curso.getCodCurso());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }

    //excluir
    public static void excluir(Curso curso) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from curso where codCurso = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, curso.getCodCurso());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
}
    
}
