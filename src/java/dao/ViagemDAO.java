package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Viagem;

public class ViagemDAO {

    public static List<Viagem> obterViagem() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Viagem> viagens = new ArrayList<Viagem>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from viagem");
            while (rs.next()) {
                Viagem viagem = new Viagem(
                        rs.getInt("codViagem"),
                        rs.getInt("codDeclaracaoNotaTecnica"),
                        rs.getInt("codRelatorioViagem"),
                        rs.getInt("codProposto"),
                        rs.getInt("codPolo"),
                        rs.getString("destino"),
                        rs.getString("dataViagem"),
                        rs.getInt("horarioSaida"),
                        rs.getString("statusConfirmacao"),
                        rs.getString("statusConclusao"),
                        rs.getInt("codTransporte")
                );
                viagens.add(viagem);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return viagens;
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

        public static void gravar(Viagem viagem) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into viagem (codViagem, codDeclaracaoNotaTecnica,codRelatorioViagem,codProposto,codPolo,destino,data_viagem,horario_saida,status_confirmacao,status_conclusao,transporte) values (?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, viagem.getCodViagem());
            comando.setInt(2, viagem.getCodDeclaracaoNotaTecnica());
            comando.setInt(3, viagem.getCodRelatorioViagem());
            comando.setInt(4, viagem.getCodProposto());
            comando.setInt(5, viagem.getCodPolo());
            comando.setString(6, viagem.getDestino());
            comando.setString(7, viagem.getDataViagem());
            comando.setInt(8, viagem.getHorarioSaida());
            comando.setString(9, viagem.getStatusConfirmacao());
            comando.setString(10, viagem.getStatusConclusao());
            comando.setString(11, viagem.getTransporte());
//            if(viagem.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,viagem.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    public static void alterar(Viagem viagem) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update viagem (codViagem, codDeclaracaoNotaTecnica,codRelatorioViagem,codProposto,codPolo,destino,data_viagem,horario_saida,status_confirmacao,status_conclusao,transporte) values (?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, viagem.getCodViagem());
            comando.setInt(2, viagem.getCodDeclaracaoNotaTecnica());
            comando.setInt(3, viagem.getCodRelatorioViagem());
            comando.setInt(4, viagem.getCodProposto());
            comando.setInt(5, viagem.getCodPolo());
            comando.setString(6, viagem.getDestino());
            comando.setString(7, viagem.getDataViagem());
            comando.setInt(8, viagem.getHorarioSaida());
            comando.setString(9, viagem.getStatusConfirmacao());
            comando.setString(10, viagem.getStatusConclusao());
            comando.setString(11, viagem.getTransporte());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
}
