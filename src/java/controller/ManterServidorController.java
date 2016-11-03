/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;
import modelo.Servidor;
import modelo.Oferta;

/**
 *
 * @author pe-ri
 */
@WebServlet(name = "ManterServidorController", urlPatterns = {"/ManterServidorController"})
public class ManterServidorController extends HttpServlet {

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
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        }
        
    }
    
    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("servidores", Oferta.obterOferta());
            RequestDispatcher view = request.getRequestDispatcher("/manterServidor.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
        }
    }
    
        public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("servidor", Servidor.obterServidor());
            int codServidor = Integer.parseInt( request.getParameter("codServidor"));
            Servidor servidor = Servidor.obterServidor(codServidor);
            request.setAttribute("servidor",servidor);
            RequestDispatcher view = request.getRequestDispatcher("/manterServidor.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex)  {
        }
    }
    
    private void confirmarIncliuir(HttpServletRequest request, HttpServletResponse response) {
        int codMatriculaSiape = Integer.parseInt(request.getParameter("txtMatriculaSiape"));
        int codModelo = Integer.parseInt(request.getParameter("txtCodModelo"));
        String lotadoOrgao  = request.getParameter("txtLotadoOrgao");
        //int coordenador = Integer.parseInt(request.getParameter("optProposto"));
        try {
            Servidor servidor = new Servidor(codMatriculaSiape, lotadoOrgao, codModelo);
            servidor.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaServidorController");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
