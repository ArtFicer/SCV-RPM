package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Proposto;

public class PropostoDAO {

    //obter
    //obter listas
    public static List<Proposto> obterProposto() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Proposto> propostos = new ArrayList<Proposto>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from proposto");
            while (rs.next()) {
                Proposto proposto = new Proposto(
                        rs.getInt("codProposto"),
                        rs.getInt("codCalendarioProposto"),
                        rs.getInt("codServidor"),
                        rs.getInt("codSecretaria"),
                        rs.getString("nome"),
                        rs.getString("setor"),
                        rs.getInt("cpf"),
                        rs.getInt("data_nascimento"),
                        rs.getString("email"),
                        rs.getInt("telefone"),
                        rs.getInt("celular"),
                        rs.getString("logradouro"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getInt("cep"),
                        rs.getString("titulacao_maxima"),
                        rs.getString("banco"),
                        rs.getInt("agencia"),
                        rs.getInt("conta"),
                        rs.getString("cargo"),
                        rs.getString("senha"),
                        rs.getString("tipo_proposto")
                );
                propostos.add(proposto);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return propostos;
    }
    //Obter normal
    public static Proposto obterProposto(int codProposto) throws  ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Proposto proposto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from proposto where codProposto ="+codProposto);
            rs.first();
            
            proposto = new Proposto(
                    rs.getInt("codProposto"),
                        rs.getInt("codCalendarioProposto"),
                        rs.getInt("codServidor"),
                        rs.getInt("codSecretaria"),
                        rs.getString("nome"),
                        rs.getString("setor"),
                        rs.getInt("cpf"),
                        rs.getInt("data_nascimento"),
                        rs.getString("email"),
                        rs.getInt("telefone"),
                        rs.getInt("celular"),
                        rs.getString("logradouro"),
                        rs.getInt("numero"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getInt("cep"),
                        rs.getString("titulacao_maxima"),
                        rs.getString("banco"),
                        rs.getInt("agencia"),
                        rs.getInt("conta"),
                        rs.getString("cargo"),
                        rs.getString("senha"),
                        rs.getString("tipo_proposto")
            );
            proposto.setCodProposto(rs.getInt("codProposto"));
        } catch (SQLException e) {
            throw e;
        } finally {
            fecharConexao(conexao, comando);
        }
        return proposto;
    }

    //Fechar Conexão
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

    //Gravar    
    public static void gravar(Proposto proposto) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into proposto (codProposto, codCalendario,codServidor,codSecretaria,nome,setor,cpf,data_nascimento,email,telefone,celular,logradouro,numero,complemento,bairro,cidade,uf,cep,titulacao_maxima,banco,agencia,conta,cargo,senha,tipo_proposto) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, proposto.getCodProposto());
            comando.setInt(2, proposto.getCodCalendario());
            comando.setInt(3, proposto.getCodServidor());
            comando.setInt(4, proposto.getCodSecretaria());
            comando.setString(5, proposto.getNome());
            comando.setString(6, proposto.getSetor());
            comando.setInt(7, proposto.getCpf());
            comando.setInt(8, proposto.getDataNascimento());
            comando.setString(9, proposto.getEmail());
            comando.setInt(10, proposto.getTelefone());
            comando.setInt(11, proposto.getCelular());
            comando.setString(12, proposto.getLogradouro());
            comando.setInt(13, proposto.getNumero());
            comando.setString(14, proposto.getComplemento());
            comando.setString(15, proposto.getBairro());
            comando.setString(16, proposto.getCidade());
            comando.setString(17, proposto.getUf());
            comando.setInt(18, proposto.getCep());
            comando.setString(19, proposto.getTitulacaoMaxima());
            comando.setString(20, proposto.getBanco());
            comando.setInt(21, proposto.getAgencia());
            comando.setInt(22, proposto.getConta());
            comando.setString(23, proposto.getCargo());
            comando.setString(24, proposto.getSenha());
            comando.setString(25, proposto.getTipoProposto());
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    //Alterar
    public static void alterar(Proposto proposto) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update proposto  set codCalendarioProposto = ?,codServidor = ?,codSecretaria = ?,nome = ?,setor = ?,cpf = ?,data_nascimento = ?,email = ?,telefone = ?,celular = ?,logradouro = ?,numero = ?,complemento = ?,bairro = ?,cidade = ?,uf = ?,cep = ?,titulacao_maxima = ?,banco = ?,agencia = ?,conta = ?,cargo = ?,senha = ?,tipo_proposto = ? where codProposto = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, proposto.getCodCalendario());
            comando.setInt(2, proposto.getCodServidor());
            comando.setInt(3, proposto.getCodSecretaria());
            comando.setString(4, proposto.getNome());
            comando.setString(5, proposto.getSetor());
            comando.setInt(6, proposto.getCpf());
            comando.setInt(7, proposto.getDataNascimento());
            comando.setString(8, proposto.getEmail());
            comando.setInt(9, proposto.getTelefone());
            comando.setInt(10, proposto.getCelular());
            comando.setString(11, proposto.getLogradouro());
            comando.setInt(12, proposto.getNumero());
            comando.setString(13, proposto.getComplemento());
            comando.setString(14, proposto.getBairro());
            comando.setString(15, proposto.getCidade());
            comando.setString(16, proposto.getUf());
            comando.setInt(17, proposto.getCep());
            comando.setString(18, proposto.getTitulacaoMaxima());
            comando.setString(19, proposto.getBanco());
            comando.setInt(20, proposto.getAgencia());
            comando.setInt(21, proposto.getConta());
            comando.setString(22, proposto.getCargo());
            comando.setString(23, proposto.getSenha());
            comando.setString(24, proposto.getTipoProposto());
            comando.setInt(25, proposto.getCodProposto());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
    }
    
    //Excluir
        public static void excluir(Proposto proposto) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from proposto where codProposto = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, proposto.getCodProposto());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
                throw ex;
        }
}
    
}

