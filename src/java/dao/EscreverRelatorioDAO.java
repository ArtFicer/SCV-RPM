package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.EscreverRelatorio;


public class EscreverRelatorioDAO {
    public static List<EscreverRelatorio> obterEscreverRelatorio() throws ClassNotFoundExeception, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<EscreverRelatorio> escreverRelatorio = new ArrayList<EscreverRelatorio>();
        try{
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()){
                EscreverRelatorio escreverRelatorios = new EscreverRelatorio(
                    rs.getString("relatorio"),rs.getInt("codEscreverRelatorio")
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
