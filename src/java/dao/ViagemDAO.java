package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Viagem;

public class ViagemDAO {

    public static List<Viagem> obterViagem() throws ClassNotFoundExeception, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Viagem> viagem = new ArrayList<Viagem>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from curso");
            while (rs.next()) {
                Viagem viagens = new Viagem(rs.getString("destino"),
                        rs.getString("statusConfirmacao"),
                        rs.getString("statusConclusao"),
                        rs.getInt("codTransporte"),
                        rs.getInt("horarioSaida"),
                        rs.getInt("codViagem")
                );
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return null;
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
