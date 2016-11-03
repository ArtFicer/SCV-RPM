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
import modelo.Trimestre;
import modelo.Trimestre;

/**
 *
 * @author pe-ri
 */
@WebServlet(name = "ManterTrimestreController", urlPatterns = {"/ManterTrimestreController"})
public class ManterTrimestreController extends HttpServlet {

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

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response){
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("trimestres", Trimestre.obterTrimestre());
            RequestDispatcher view = request.getRequestDispatcher("/manterTrimestre.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } 
    }

    private void confirmarIncliuir(HttpServletRequest request, HttpServletResponse response) {
        int codTrimestre = Integer.parseInt(request.getParameter("txtCodTrimestre"));
        int numeroTrimestre= Integer.parseInt(request.getParameter("txtnumeroTrimestre"));
         
        try {
            Trimestre trimestre = new Trimestre(numeroTrimestre, codTrimestre);
            trimestre.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaTrimestreController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException | ServletException ex) {
        }
    }
    
        public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("trimestre", Trimestre.obterTrimestre());
            int codTrimestre = Integer.parseInt( request.getParameter("codTrimestre"));
            Trimestre trimestre = Trimestre.obterTrimestre(codTrimestre);
            request.setAttribute("trimestre",trimestre);
            RequestDispatcher view = request.getRequestDispatcher("/manterTrimestre.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex)  {
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
            Logger.getLogger(ManterTrimestreController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterTrimestreController.class.getName()).log(Level.SEVERE, null, ex);
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
