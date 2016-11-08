package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Polo;

public class PoloDAO {

    //Obter
    //obter Listas
    public static List<Polo> obterPolo() throws ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        List<Polo> polos = new ArrayList<Polo>();
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select = from polo");
            while (rs.next()) {
                Polo polo = new Polo(
                        rs.getInt("codPolo"),
                        rs.getInt("codTransporte"),
                        rs.getString("cidade"),
                        rs.getString("logradouro"),
                        rs.getString("bairro"),
                        rs.getInt("numero"),
                        rs.getInt("telefone"),
                        rs.getString("email")
                );
                polos.add(polo);
            }
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return polos;
    }
    //Obter normal
    public static Polo obterPolo(int codPolo) throws  ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        Polo polo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from polo where codPolo ="+codPolo);
            rs.first();
            
            polo = new Polo(
                    rs.getInt("codPolo"),
                    rs.getInt("codTransporte"),
                    rs.getString("cidade"),
                    rs.getString("logradouro"),
                    rs.getString("bairro"),
                    rs.getInt("numero"),
                    rs.getInt("telefone"),
                    rs.getString("email")
            );
            polo.setCodPolo(rs.getInt("codPolo"));
        } catch (SQLException e) {
            //e.printStckTrace();
        } finally {
            fecharConexao(conexao, comando);
        }
        return polo;
    }

    //Fechar conexão
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

    //Gravar    
    public static void gravar(Polo polo) throws SQLException,ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "insert into polo (codPolo,codTransporte, cidade,logradouro,bairro,numero,telefone,email) values (?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, polo.getCodPolo());
            comando.setInt(2, polo.getCodTransporte());
            comando.setString(3, polo.getCidade());
            comando.setString(4, polo.getLogradouro());
            comando.setString(5, polo.getBairro());
            comando.setInt(6, polo.getNumero());
            comando.setInt(7, polo.getTelefone());
            comando.setString(8, polo.getEmail());
//            if(polo.getProposto()==null)
//            {
//                comando.setNull(3,Types.NULL);
//            }else{
//                comando.setInt(3,polo.getProposto().getCodProposto());
//            }
            comando.execute();
            comando.close();
            conexao.close();
        }catch (SQLException e){
            throw e;
        }
       }

    //Alterar
    public static void alterar(Polo polo) throws SQLException, ClassNotFoundException{
        Connection conexao = null;
        try{
            conexao = BD.getConexao();
            String sql = "update polo (codPolo,codTransporte, cidade,logradouro,bairro,numero,telefone,email) values (?,?,?,?,?,?,?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, polo.getCodPolo());
            comando.setInt(2, polo.getCodTransporte());
            comando.setString(3, polo.getCidade());
            comando.setString(4, polo.getLogradouro());
            comando.setString(5, polo.getBairro());
            comando.setInt(6, polo.getNumero());
            comando.setInt(7, polo.getTelefone());
            comando.setString(8, polo.getEmail());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
    }
    //Excluir
        public static void excluir(Polo polo) throws SQLException, ClassNotFoundException {
       Connection conexao = null ;
        try{
            conexao = BD.getConexao();
            String sql = "delete from polo where codPolo = ?";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setInt(1, polo.getCodPolo());
            comando.execute();
            comando.close();
            conexao.close();
            }catch (SQLException | ClassNotFoundException ex) {
        }
}
}
