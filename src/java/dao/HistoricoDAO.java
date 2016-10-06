package dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Historico;

public class HistoricoDAO {
    public static List<Historico> obterHistorico() throws ClassNotFoundExeception, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Historico> historico = new ArrayList<Historico>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()){
                Historico historicos = new Historico(rs.getInt("codHistorico")
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
