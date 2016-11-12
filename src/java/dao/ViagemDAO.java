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
    
    //obter
    //obter listas
    public static List<Viagem> obterViagem() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Viagem> viagens = new ArrayList<Viagem>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from viagem");
            while (rs.next()) {
                Viagem viagem = new Viagem(
                        rs.getInt("codViagem"),
                        rs.getInt("codDeclaracaoNotaTecnica"),
                        rs.getInt("codRelatorioViagem"),
                        rs.getInt("codProposto"),
                        rs.getInt("codPolo"),
                        rs.getString("destino"),
                        rs.getString("data_viagem"),
                        rs.getInt("horario_saida"),
                        rs.getString("status_confirmacao"),
                        rs.getString("status_conclusao"),
                        rs.getInt("codTransporte")
                );
                viagens.add(viagem);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return viagens;
    }
    
    //Obter normal
    public static Viagem obterViagem(int codViagem) throws  ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Viagem viagem = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from viagem where codViagem ="+codViagem);
            rs.first();
            
            viagem = new Viagem(
                    rs.getInt("codViagem"),
                        rs.getInt("codDeclaracaoNotaTecnica"),
                        rs.getInt("codRelatorioViagem"),
                        rs.getInt("codProposto"),
                        rs.getInt("codPolo"),
                        rs.getString("destino"),
                        rs.getString("data_viagem"),
                        rs.getInt("horario_saida"),
                        rs.getString("status_confirmacao"),
                        rs.getString("status_conclusao"),
                        rs.getInt("codTransporte")
            );
            viagem.setCodViagem(rs.getInt("codViagem"));
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return viagem;
    }

    //fechar conexão
    public static void fecharConexao(Connection conexao, Statement comando) throws SQLException {
        try {
            if (comando != null) {
                comando.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    //gravar   
    public static void gravar(Viagem viagem) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into viagem (codViagem, codDeclaracaoNotaTecnica,codRelatorioViagem,codProposto,codPolo,destino,data_viagem,horario_saida,status_confirmacao,status_conclusao,codTransporte) values (?,?,?,?,?,?,?,?)";
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
            comando.setInt(11, viagem.getCodTransporte());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    //alterar
    public static void alterar(Viagem viagem) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update viagem set codDeclaracaoNotaTecnica = ?,codRelatorioViagem = ?,codProposto = ?,codPolo = ?,destino = ?,data_viagem = ?,horario_saida = ?,status_confirmacao = ?,status_conclusao = ?,codTransporte = ? where codViagem = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, viagem.getCodDeclaracaoNotaTecnica());
            comando.setInt(2, viagem.getCodRelatorioViagem());
            comando.setInt(3, viagem.getCodProposto());
            comando.setInt(4, viagem.getCodPolo());
            comando.setString(5, viagem.getDestino());
            comando.setString(6, viagem.getDataViagem());
            comando.setInt(7, viagem.getHorarioSaida());
            comando.setString(8, viagem.getStatusConfirmacao());
            comando.setString(9, viagem.getStatusConclusao());
            comando.setInt(10, viagem.getCodTransporte());
            comando.setInt(11, viagem.getCodViagem());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
    }
    
    //excluir
        public static void excluir(Viagem viagem) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from viagem where codViagem = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, viagem.getCodViagem());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
}
}
