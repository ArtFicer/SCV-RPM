package controller;

import dao.CursoDAO;
import dao.OfertaDAO;
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
import model.Curso;
import model.Oferta;
import model.Trimestre;

public class ManterCursoController extends HttpServlet {

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
            request.setAttribute("ofertas", OfertaDAO.obterInstancia().obterOfertas());
            request.setAttribute("trimestres", TrimestreDAO.obterInstancia().obterTrimestres());

            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
            String nome = request.getParameter("txtNomeCurso");
            Oferta ofertaCodOferta = new Oferta(Integer.parseInt(request.getParameter("txtCodOferta")));
            Trimestre trimestrecodTrimestre = new Trimestre(Integer.parseInt(request.getParameter("txtCodTrimestre")));
            Curso curso = new Curso(codCurso, nome);
            curso.setOfertacodOferta(ofertaCodOferta);
            curso.setTrimestrecodTrimestre(trimestrecodTrimestre);
            
            CursoDAO.obterInstancia().gravar(curso);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
            Curso curso = CursoDAO.obterInstancia().obterCurso(codCurso);
            
            request.setAttribute("curso", curso);
            request.setAttribute("trimestres", TrimestreDAO.obterInstancia().obterTrimestres());
            request.setAttribute("ofertas", OfertaDAO.obterInstancia().obterOfertas());

            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
            String nomeCurso = request.getParameter("txtNomeCurso");

            Trimestre trimestre = new Trimestre(Integer.parseInt(request.getParameter("txtCodTrimestre")));
            Oferta oferta = new Oferta(Integer.parseInt(request.getParameter("txtCodOferta")));
            Curso curso = new Curso(codCurso, nomeCurso);
            
            curso.setOfertacodOferta(oferta);
            curso.setTrimestrecodTrimestre(trimestre);
            CursoDAO.obterInstancia().alterar(curso);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
            view.forward(request, response);
        } catch (IOException | ServletException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("operacao", "Excluir");

            int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
            Curso curso = CursoDAO.obterInstancia().obterCurso(codCurso);
            request.setAttribute("curso", curso);
            request.setAttribute("trimestres", TrimestreDAO.obterInstancia().obterTrimestres());
            request.setAttribute("ofertas", OfertaDAO.obterInstancia().obterOfertas());

            RequestDispatcher view = request.getRequestDispatcher("/manterCurso.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            int codCurso = Integer.parseInt(request.getParameter("txtCodCurso"));
            String nomeCurso = request.getParameter("txtNomeCurso");

            Trimestre trimestre = new Trimestre(Integer.parseInt(request.getParameter("txtCodTrimestre")));
            Oferta oferta = new Oferta(Integer.parseInt(request.getParameter("txtCodOferta")));
            Curso curso = new Curso(codCurso, nomeCurso);
            curso.setOfertacodOferta(oferta);
            curso.setTrimestrecodTrimestre(trimestre);
            CursoDAO.obterInstancia().excluir(curso);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaCursoController");
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
            Logger.getLogger(ManterOfertaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterOfertaController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterOfertaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterOfertaController.class.getName()).log(Level.SEVERE, null, ex);
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
