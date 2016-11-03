/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;
import modelo.Solicitacao;
import modelo.Solicitacao;

/**
 *
 * @author pe-ri
 */
@WebServlet(name = "ManterSolicitacaoController", urlPatterns = {"/ManterSolicitacaoController"})
public class ManterSolicitacaoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        }
    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response)  {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("solicitacoes", Solicitacao.obterSolicitacao());
            RequestDispatcher view = request.getRequestDispatcher("/manterSolicitacao.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }
    
        public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("solicitacao", Solicitacoes.obterSolicitacoes());
            int codSolicitacoes = Integer.parseInt( request.getParameter("codSolicitacoes"));
            Solicitacoes solicitacoes = Solicitacoes.obterSolicitacoes(codSolicitacoes);
            request.setAttribute("solicitacao",solicitacoes);
            RequestDispatcher view = request.getRequestDispatcher("/manterSolicitacoes.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex)  {
        }
    }
    
    private void confirmarIncliuir(HttpServletRequest request, HttpServletResponse response) {
        int codSolicitacao = Integer.parseInt(request.getParameter("txtCodSolicitacao"));
        String assunto = request.getParameter("txtAssunto");
        String texto =request.getParameter("txtTexto");
         
        try {
            Solicitacao solicitacao = new Solicitacao(assunto, texto, codSolicitacao);
            solicitacao.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaSolicitacaoController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException | ServletException ex) {
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
            Logger.getLogger(ManterSolicitacaoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterSolicitacaoController.class.getName()).log(Level.SEVERE, null, ex);
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
