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

    public static List<Proposto> obterProposto() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Proposto> propostos = new ArrayList<Proposto>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from proposto");
            while (rs.next()) {
                Proposto proposto = new Proposto(
                        rs.getInt("codProposto"),
                        rs.getInt("cpf"),
                        rs.getInt("dataNascimento"),
                        rs.getString("email"),
                        rs.getInt("telefone"),
                        rs.getInt("celular"),
                        rs.getInt("numero"),
                        rs.getInt("agencia"),
                        rs.getInt("conta"),
                        rs.getInt("senha"),
                        rs.getString("setor"),
                        rs.getString("nome"),
                        rs.getString("logradouro"),
                        rs.getString("complemento"),
                        rs.getString("bairro"),
                        rs.getString("cidade"),
                        rs.getString("uf"),
                        rs.getInt("cep"),
                        rs.getString("rg"),
                        rs.getString("titulacaoMaxima"),
                        rs.getString("banco"),
                        rs.getString("cargo"),
                        rs.getString("tipodeproposto"),
                        rs.getInt("codServidor"),
                        rs.getInt("codModelo")
                );
                propostos.add(proposto);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return propostos;
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

        public static void gravar(Proposto proposto) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into proposto (codProposto, CalendarioProposto_codCalendarioProposto,Servidor_codServidor,Secretaria_codSecretaria,nome,setor,cpf,data_nascimento,email,telefone,celular,logradouro,numero,complemento,bairro,cidade,uf,cep,titulacao_maxima,banco,agencia,conta,cargo,senha,tipo_proposto) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, proposto.getCodProposto());
            comando.setInt(2, proposto.getCalendarioProposto());
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
            comando.setInt(24, proposto.getSenha());
            comando.setString(25, proposto.getTipoProposto());
//            if(proposto.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,proposto.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    public static void alterar(Proposto proposto) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update proposto  proposto (codProposto, CalendarioProposto_codCalendarioProposto,Servidor_codServidor,Secretaria_codSecretaria,nome,setor,cpf,data_nascimento,email,telefone,celular,logradouro,numero,complemento,bairro,cidade,uf,cep,titulacao_maxima,banco,agencia,conta,cargo,senha,tipo_proposto) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, proposto.getCodProposto());
            comando.setInt(2, proposto.getCalendarioProposto());
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
            comando.setInt(24, proposto.getSenha());
            comando.setString(25, proposto.getTipoProposto());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
}
