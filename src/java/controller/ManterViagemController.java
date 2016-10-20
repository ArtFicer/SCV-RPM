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
import modelo.Viagem;
import modelo.Viagem;

/**
 *
 * @author pe-ri
 */
@WebServlet(name = "ManterViagemController", urlPatterns = {"/ManterViagemController"})
public class ManterViagemController extends HttpServlet {

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
            //request.setAttribute("viagens", Viagem.obterViagem());
            RequestDispatcher view = request.getRequestDispatcher("/manterTrimestre.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        }
    }

    private void confirmarIncliuir(HttpServletRequest request, HttpServletResponse response) {
        int codViagem = Integer.parseInt(request.getParameter("txtcodViagem"));
        int horarioSaida = Integer.parseInt(request.getParameter("txtHorarioSaida"));
        int data = Integer.parseInt(request.getParameter("txtData"));
        String statusConclusao  = request.getParameter("txtStatusConclusao");
        String statusConfirmacao  = request.getParameter("txtStatusConfirmacao");
        String destino  = request.getParameter("txtDestino");
        
        try {
            Viagem viagem = new Viagem(destino,statusConfirmacao,statusConclusao,data,horarioSaida,codViagem);
            viagem.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaViagemController");
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
            Logger.getLogger(ManterViagemController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterViagemController.class.getName()).log(Level.SEVERE, null, ex);
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
