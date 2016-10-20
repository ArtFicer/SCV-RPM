package modelo;

import dao.HistoricoDAO;
import java.sql.SQLException;

public class Historico {
private int codHistorico;

    public Historico(int codHistorico) {
        this.codHistorico = codHistorico;
    }

    public int getCodHistorico() {
        return codHistorico;
    }

    public void setCodHistorico(int codHistorico) {
        this.codHistorico = codHistorico;
    }
    
    public void gravar()throws SQLException, ClassNotFoundException  {
        HistoricoDAO.gravar(this);
    }
}
