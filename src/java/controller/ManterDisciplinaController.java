package controller;

import dao.DisciplinaDAO;
import dao.TrimestreDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Disciplina;
import model.Trimestre;

public class ManterDisciplinaController extends HttpServlet {

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

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            request.setAttribute("operacao", "Incluir");

            request.setAttribute("trimestres", TrimestreDAO.obterInstancia().obterTrimestres());

            RequestDispatcher view = request.getRequestDispatcher("/manterDisciplina.jsp");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int codDisciplina = Integer.parseInt(request.getParameter("txtCodDisciplina"));
            String nome = request.getParameter("txtNomeDisciplina");
            Trimestre trimestre = new Trimestre(Integer.parseInt(request.getParameter("txtCodTrimestre")));
            Disciplina disciplina = new Disciplina(codDisciplina, nome);
            disciplina.setTrimestrecodTrimestre(trimestre);
            DisciplinaDAO.obterInstancia().gravar(disciplina);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaDisciplinaController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            request.setAttribute("operacao", "Editar");

            int codDisciplina = Integer.parseInt(request.getParameter("txtCodDisciplina"));
            request.setAttribute("disciplina", DisciplinaDAO.obterInstancia().obterDisciplina(codDisciplina));
            request.setAttribute("trimestres", TrimestreDAO.obterInstancia().obterTrimestres());

            RequestDispatcher view = request.getRequestDispatcher("/manterDisciplina.jsp");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int codDisciplina = Integer.parseInt(request.getParameter("txtCodDisciplina"));
            String nome = request.getParameter("txtNomeDisciplina");

            Disciplina disciplina = new Disciplina(codDisciplina, nome);
            Trimestre trimestre = new Trimestre(Integer.parseInt(request.getParameter("txtCodTrimestre")));

            disciplina.setTrimestrecodTrimestre(trimestre);
            DisciplinaDAO.obterInstancia().alterar(disciplina);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaDisciplinaController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            request.setAttribute("operacao", "Excluir");

            int codDisciplina = Integer.parseInt(request.getParameter("txtCodDisciplina"));
            request.setAttribute("disciplina", DisciplinaDAO.obterInstancia().obterDisciplina(codDisciplina));
            request.setAttribute("trimestres", TrimestreDAO.obterInstancia().obterTrimestres());

            RequestDispatcher view = request.getRequestDispatcher("/manterDisciplina.jsp");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int codDisciplina = Integer.parseInt(request.getParameter("txtCodDisciplina"));
            String nome = request.getParameter("txtNomeDisciplina");

            Trimestre trimestre = new Trimestre(Integer.parseInt(request.getParameter("txtCodTrimestre")));
            Disciplina disciplina = new Disciplina(codDisciplina, nome);
            disciplina.setTrimestrecodTrimestre(trimestre);

            DisciplinaDAO.obterInstancia().excluir(disciplina);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaDisciplinaController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
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
            Logger.getLogger(ManterDisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterDisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterDisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterDisciplinaController.class.getName()).log(Level.SEVERE, null, ex);
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
