package controller;

import dao.BD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class RelatorioTransporteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String nomeRelatorio = request.getParameter("nomeRelatorio");
            String parametroBusca = request.getParameter("parametroBusca");
            HashMap parametros = new HashMap();
            String relatorio = null;
            if (!nomeRelatorio.equals("Transporte")) {
                nomeRelatorio = "Transporte";
            }
            if (!parametroBusca.equals("")) {
                parametros.put("P_Empresa", parametroBusca);
                relatorio = getServletContext().getRealPath("/WEB-INF/Relatorios") + "/Relatorio" + nomeRelatorio + "Parametro.jasper";
                response.setHeader("Content-Disposition", "attachment;filename=Relatorio" + nomeRelatorio + "Parametro.pdf");

            } else {
                relatorio = getServletContext().getRealPath("/WEB-INF/Relatorios") + "/Relatorio" + nomeRelatorio + ".jasper";
                response.setHeader("Content-Disposition", "attachment;filename=Relatorio" + nomeRelatorio +".pdf");
            }
            JasperPrint jp = JasperFillManager.fillReport(relatorio, parametros, conexao);
            byte[] relat = JasperExportManager.exportReportToPdf(jp);
            response.setContentType("application/pdf");
            response.getOutputStream().write(relat);
        } catch (ClassNotFoundException | SQLException | JRException ex) {
            ex.printStackTrace();
        } finally {
            BD.fecharConexao(conexao);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioCursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioCursoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
