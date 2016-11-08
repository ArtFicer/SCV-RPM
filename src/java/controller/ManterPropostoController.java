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
import modelo.Proposto;

/**
 *
 * @author pe-ri
 */

@WebServlet(name = "ManterPropostoController", urlPatterns = {"/ManterPropostoController"})
public class ManterPropostoController extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else {
            if (acao.equals("confirmarIncluir")) {
                confirmarIncliuir(request, response);
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
    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("propostos", Proposto.obterProposto());
            RequestDispatcher view = request.getRequestDispatcher("/manterProposto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
        }
    }
    
    // Realiza e confirma a Inclusão no banco de dados
    private void confirmarIncliuir(HttpServletRequest request, HttpServletResponse response) {
        int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
        String nome = request.getParameter("txtNomeProposto");
        try {
            //Proposto proposto = null;
            Proposto proposto = new Proposto(codProposto, nome);
            proposto.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostoController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException | ServletException ex) {
        }
    }

    
    
    //Edição
    //Preparar a edição
    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            //request.setAttribute("propostos", Proposto.obterProposto());
            int codProposto = Integer.parseInt(request.getParameter("codProposto"));
            Proposto proposto = Proposto.obterProposto(codProposto);
            request.setAttribute("proposto", proposto);
            RequestDispatcher view = request.getRequestDispatcher("/manterProposto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
        }
    }
    
    
    //Confrimar a edição
    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
        String nome = request.getParameter("txtNomeProposto");
        //int coordenador = Integer.parseInt(request.getParameter("optProposto"));
        try {
            //Proposto proposto = null;
            Proposto proposto = new Proposto(codProposto, nome);
            proposto.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostoController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException | ServletException ex) {
        }
    }

    
    //Exclusão
    //Preparar Exclução
    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            int codProposto = Integer.parseInt(request.getParameter("codProposto"));
            Proposto proposto = Proposto.obterProposto(codProposto);
            request.setAttribute("proposto", proposto);
            RequestDispatcher view = request.getRequestDispatcher("/manterProposto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
        }
    }

    //Confirma a Exclusão
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {

        int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
        String nome = request.getParameter("txtNomeProposto");
        //int coordenador = Integer.parseInt(request.getParameter("optProposto"));
        try {
            //Proposto proposto = null;
            Proposto proposto = new Proposto(codProposto, nome);
            proposto.Excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostoController");
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
            Logger.getLogger(ManterPropostoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterPropostoController.class.getName()).log(Level.SEVERE, null, ex);
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