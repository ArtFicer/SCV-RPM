package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Secretaria;

public class SecretariaDAO {
    public static List<Secretaria> obterSecretaria() throws ClassNotFoundExeception, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Secretaria> secretaria = new ArrayList<Secretaria>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()){
                Secretaria secretarias = new Secretaria(rs.getString("nome"),
                    rs.getString("email"),
                    rs.getInt("cpf"),rs.getInt("senha"),rs.getInt("codSecretaria")
                );
            }
        }catch(SQLException e){
            //e.printStckTrace();
        }finally{
            fecharConexao(conexao, comando);
        }
return null;
    }
    
    public static void fecharConexao(Connection conexao, Statement comando){
        try{
            if(comando != null){
                comando.close();
            }
            if(conexao != null){
                conexao.close();
            }
        }catch(SQLException e){
        }
    }
    
    
    
    
}
