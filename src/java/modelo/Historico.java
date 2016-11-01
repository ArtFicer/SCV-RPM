package modelo;
import dao.HistoricoDAO;
import java.sql.SQLException;
import java.util.List;

public class Historico {

   private int codHistorico;
   
    // Construtores

    public Historico(int codHistorico) {
        this.codHistorico = codHistorico;
    }
     
    
    //Gravar No banco
    public void gravar() throws SQLException, ClassNotFoundException {
        HistoricoDAO.gravar(this);
    }

    //Lista Obter CUrso
    public static List<Historico> obterHistorico() throws java.lang.ClassNotFoundException {
        return HistoricoDAO.obterHistorico();
    }
    
    //Obter Historico
    public static Historico obterHistorico(int codHistorico) throws ClassNotFoundException {
        return HistoricoDAO.obterHistorico(codHistorico);
    }
    
    //Alterar
    public void alterar () throws SQLException, ClassNotFoundException{
        HistoricoDAO.alterar(this);
    }

    //Set e Gets

    public int getCodHistorico() {
        return codHistorico;
    }

    public void setCodHistorico(int codHistorico) {
        this.codHistorico = codHistorico;
    }
   
}
