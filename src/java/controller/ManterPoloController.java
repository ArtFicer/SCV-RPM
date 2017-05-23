package controller;

import dao.PoloDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Polo;

public class ManterPoloController extends HttpServlet {

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

            RequestDispatcher view = request.getRequestDispatcher("/manterPolo.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int codPolo = Integer.parseInt(request.getParameter("txtCodPolo"));
            String cidade = request.getParameter("txtCidade");
            String logradouro = request.getParameter("txtLogradouro");
            String bairro = request.getParameter("txtBairro");
            int numero = Integer.parseInt(request.getParameter("txtNumero"));
            int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
            String email = request.getParameter("txtEmail");

            Polo polo = new Polo(codPolo, cidade, logradouro, bairro, numero, telefone, email);

            PoloDAO.obterInstancia().gravar(polo);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPoloController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            int codPolo = Integer.parseInt(request.getParameter("txtCodPolo"));
            Polo polo = PoloDAO.obterInstancia().obterPolo(codPolo);

            request.setAttribute("polo", polo);

            RequestDispatcher view = request.getRequestDispatcher("/manterPolo.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int codPolo = Integer.parseInt(request.getParameter("txtCodPolo"));
            String cidade = request.getParameter("txtCidade");
            String logradouro = request.getParameter("txtLogradouro");
            String bairro = request.getParameter("txtBairro");
            int numero = Integer.parseInt(request.getParameter("txtNumero"));
            int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
            String email = request.getParameter("txtEmail");

            Polo polo = new Polo(codPolo, cidade, logradouro, bairro, numero, telefone, email);

            PoloDAO.obterInstancia().alterar(polo);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPoloController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Excluir");

            int codPolo = Integer.parseInt(request.getParameter("txtCodPolo"));
            Polo polo = PoloDAO.obterInstancia().obterPolo(codPolo);

            request.setAttribute("polo", polo);

            RequestDispatcher view = request.getRequestDispatcher("/manterPolo.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int codPolo = Integer.parseInt(request.getParameter("txtCodPolo"));
            String cidade = request.getParameter("txtCidade");
            String logradouro = request.getParameter("txtLogradouro");
            String bairro = request.getParameter("txtBairro");
            int numero = Integer.parseInt(request.getParameter("txtNumero"));
            int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
            String email = request.getParameter("txtEmail");

            Polo polo = new Polo(codPolo, cidade, logradouro, bairro, numero, telefone, email);

            PoloDAO.obterInstancia().excluir(polo);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPoloController");
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
            Logger.getLogger(ManterPoloController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPoloController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterPoloController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPoloController.class.getName()).log(Level.SEVERE, null, ex);
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
