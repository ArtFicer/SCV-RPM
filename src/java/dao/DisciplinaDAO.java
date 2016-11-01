package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Disciplina;

public class DisciplinaDAO {

    public static List<Disciplina> obterDisciplina() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Disciplina> disciplinas = new ArrayList<Disciplina>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from Disciplina");
            while (rs.next()) {
                Disciplina disciplina = new Disciplina(
                        rs.getString("nome"),
                        rs.getInt("codDisciplina")
                );
                disciplinas.add(disciplina);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return disciplinas;
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

        public static void gravar(Disciplina disciplina) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into disciplina (codDisciplina, nome) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, disciplina.getCodDisciplina());
            comando.setString(2, disciplina.getNome());
//            if(Disciplina.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,Disciplina.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }
    public static void alterar(Disciplina Disciplina) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update Disciplina set nome = ? where codDisciplina = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, Disciplina.getNome());
            comando.setInt(2,Disciplina.getCodDisciplina());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }

}
