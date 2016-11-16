/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Convidado;

/**
 *
 * @author pe-ri
 */

@WebServlet(name = "ManterConvidadoController", urlPatterns = {"/ManterConvidadoController"})
public class ManterConvidadoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    //Processamento de requisição
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else {
            if (acao.equals("confirmarIncluir")) {
                confirmarIncluir(request, response);
            } else {
                if (acao.equals("prepararEditar")) {
                    prepararEditar(request, response);
                } else {
                    if (acao.equals("confirmarEditar")) {
                        confirmarEditar(request, response);
                    } else {
                        if (acao.equals("prepararExcluir")) {
                            prepararExcluir(request, response);
                        } else {
                            if (acao.equals("confirmarExcluir")) {
                                confirmarExcluir(request, response);
                            }
                        }
                    }
                }
            }
        }
    }

    
    // Inclusão
    // Prepara a Inclusão no banco de dados
    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("convidados", Convidado.obterConvidado());
            RequestDispatcher view = request.getRequestDispatcher("/manterConvidado.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }
    
    // Realiza e confirma a Inclusão no banco de dados
    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {
        int codConvidado = Integer.parseInt(request.getParameter("txtCodConvidado"));
        int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
        int matriculaSIAPE = Integer.parseInt(request.getParameter("txtMatriculaSIAPE"));
        try {
            Convidado convidado = new Convidado(codConvidado, codProposto, matriculaSIAPE);
            convidado.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaConvidadoController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException | ServletException ex) {
            throw ex;
        }
    }

    
    
    //Edição
    //Preparar a edição
    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("operacao", "Editar");
            int codConvidado = Integer.parseInt(request.getParameter("txtCodConvidado"));
            Convidado convidado = Convidado.obterConvidado(codConvidado);
            request.setAttribute("convidado", convidado);
            RequestDispatcher view = request.getRequestDispatcher("/manterConvidado.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }
    
    
    //Confrimar a edição
    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {
        int codConvidado = Integer.parseInt(request.getParameter("txtCodConvidado"));
        int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
        int matriculaSIAPE = Integer.parseInt(request.getParameter("txtMatriculaSIAPE"));
        try {
            Convidado convidado = new Convidado(codConvidado, codProposto, matriculaSIAPE);
            convidado.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaConvidadoController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException | ServletException ex) {
            throw ex;
        }
    }

    
    //Exclusão
    //Preparar Exclução
    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        try {
            request.setAttribute("operacao", "Excluir");
            int codConvidado = Integer.parseInt(request.getParameter("txtCodConvidado"));
            Convidado convidado = Convidado.obterConvidado(codConvidado);
            request.setAttribute("convidado", convidado);
            RequestDispatcher view = request.getRequestDispatcher("/manterConvidado.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    //Confirma a Exclusão
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {

        int codConvidado = Integer.parseInt(request.getParameter("txtCodConvidado"));
        int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
        int matriculaSIAPE = Integer.parseInt(request.getParameter("txtMatriculaSIAPE"));
        try {
            Convidado convidado = new Convidado(codConvidado, codProposto, matriculaSIAPE);
            convidado.Excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaConvidadoController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException | ServletException ex) {
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
            Logger.getLogger(ManterConvidadoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterConvidadoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterConvidadoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterConvidadoController.class.getName()).log(Level.SEVERE, null, ex);
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