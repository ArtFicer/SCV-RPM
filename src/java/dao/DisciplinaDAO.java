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

    //obter
    //obter listas
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
                        rs.getInt("codDisciplina"),
                        rs.getString("nome")
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
    
     // obtem codigo da disciplina para o .dao
    public static Disciplina obterDisciplina(int codDisciplina)  throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Disciplina disciplina = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from disciplina where codDisciplina ="+codDisciplina);
            rs.first();
            
            disciplina = new Disciplina(
                    rs.getInt("codDisciplina"),
                    rs.getString("nome")
            );
            disciplina.setCodDisciplina(rs.getInt("codDisciplina"));
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return disciplina;   
    }

    //fechar conexão
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
        
    //alterar
    public static void alterar(Disciplina disciplina) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update disciplina (codDisciplina, nome) values (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, disciplina.getCodDisciplina());
            comando.setString(2, disciplina.getNome());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
    
    //Excluir
     public static void excluir(Disciplina disciplina) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from disciplina where codDisciplina = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, disciplina.getCodDisciplina());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
}
}
