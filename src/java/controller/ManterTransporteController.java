package controller;

import dao.TransporteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Transporte;

public class ManterTransporteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Incluir");

            RequestDispatcher view = request.getRequestDispatcher("/manterTransporte.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int codTransporte = Integer.parseInt(request.getParameter("txtCodTransporte"));
            String empresa = request.getParameter("txtEmpresa");
            String veiculo = request.getParameter("txtVeiculo");

            Transporte transporte = new Transporte(codTransporte, empresa, veiculo);

            TransporteDAO.obterInstancia().gravar(transporte);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaTransporteController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            int codTransporte = Integer.parseInt(request.getParameter("txtCodTransporte"));
            Transporte transporte = TransporteDAO.obterInstancia().obterTransporte(codTransporte);

            request.setAttribute("transporte", transporte);

            RequestDispatcher view = request.getRequestDispatcher("/manterTransporte.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int codTransporte = Integer.parseInt(request.getParameter("txtCodTransporte"));
            String empresa = request.getParameter("txtEmpresa");
            String veiculo = request.getParameter("txtVeiculo");

            Transporte transporte = new Transporte(codTransporte, empresa, veiculo);

            TransporteDAO.obterInstancia().alterar(transporte);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaTransporteController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("operacao", "Excluir");

            int codTransporte = Integer.parseInt(request.getParameter("txtCodTransporte"));
            Transporte transporte = TransporteDAO.obterInstancia().obterTransporte(codTransporte);

            request.setAttribute("transporte", transporte);

            RequestDispatcher view = request.getRequestDispatcher("/manterTransporte.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int codTransporte = Integer.parseInt(request.getParameter("txtCodTransporte"));
            String empresa = request.getParameter("txtEmpresa");
            String veiculo = request.getParameter("txtVeiculo");

            Transporte transporte = new Transporte(codTransporte, empresa, veiculo);

            TransporteDAO.obterInstancia().excluir(transporte);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaTransporteController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterTransporteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterTransporteController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterTransporteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterTransporteController.class.getName()).log(Level.SEVERE, null, ex);
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
