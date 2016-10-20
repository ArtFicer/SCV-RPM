package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Secretaria;

public class SecretariaDAO {

    public static List<Secretaria> obterSecretaria() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Secretaria> secretarias = new ArrayList<Secretaria>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()) {
                Secretaria secretaria = new Secretaria(
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getInt("cpf"),
                        rs.getInt("senha"),
                        rs.getInt("codSecretaria")
                );
                secretarias.add(secretaria);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return secretarias;
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

        public static void gravar(Secretaria secretaria) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into secretaria (codSecretaria, nome,cpf,email,senha) values (?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, secretaria.getCodSecretaria());
            comando.setString(2, secretaria.getNome());
            comando.setInt(3, secretaria.getCpf());
            comando.setString(4, secretaria.getEmail());
            comando.setString(5, secretaria.getSenha());
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


}
