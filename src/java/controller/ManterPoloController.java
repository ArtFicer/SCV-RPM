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
import modelo.Polo;

/**
 *
 * @author pe-ri
 */

@WebServlet(name = "ManterPoloController", urlPatterns = {"/ManterPoloController"})
public class ManterPoloController extends HttpServlet {

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
            request.setAttribute("polos", Polo.obterPolo());
            RequestDispatcher view = request.getRequestDispatcher("/manterPolo.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
        }
    }
    
    // Realiza e confirma a Inclusão no banco de dados
    private void confirmarIncliuir(HttpServletRequest request, HttpServletResponse response) {
        int codPolo = Integer.parseInt(request.getParameter("txtCodPolo"));
        int codTransporte = Integer.parseInt(request.getParameter("txtCodTransporte"));
        String cidade = request.getParameter("txtCidade");
        String logradouro = request.getParameter("txtLogradouro");
        String bairro = request.getParameter("txtBairro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
        String email = request.getParameter("txtEmail");
        try {
            //Proposto proposto = null;
            Polo polo = new Polo(codPolo,codTransporte,cidade,logradouro,bairro,numero,telefone,email);
            polo.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPoloController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException | ServletException ex) {
        }
    }

    
    
    //Edição
    //Preparar a edição
    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            //request.setAttribute("polos", Polo.obterPolo());
            int codPolo = Integer.parseInt(request.getParameter("codPolo"));
            Polo polo = Polo.obterPolo(codPolo);
            request.setAttribute("polo", polo);
            RequestDispatcher view = request.getRequestDispatcher("/manterPolo.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
        }
    }
    
    
    //Confrimar a edição
    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codPolo = Integer.parseInt(request.getParameter("txtCodPolo"));
        int codTransporte = Integer.parseInt(request.getParameter("txtCodTransporte"));
        String cidade = request.getParameter("txtCidade");
        String logradouro = request.getParameter("txtLogradouro");
        String bairro = request.getParameter("txtBairro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
        String email = request.getParameter("txtEmail");
        //int coordenador = Integer.parseInt(request.getParameter("optProposto"));
        try {
            //Proposto proposto = null;
            Polo polo = new Polo(codPolo,codTransporte,cidade,logradouro,bairro,numero,telefone,email);
            polo.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPoloController");
            view.forward(request, response);
        } catch (IOException | SQLException | ClassNotFoundException | ServletException ex) {
        }
    }

    
    //Exclusão
    //Preparar Exclução
    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            int codPolo = Integer.parseInt(request.getParameter("codPolo"));
            Polo polo = Polo.obterPolo(codPolo);
            request.setAttribute("polo", polo);
            RequestDispatcher view = request.getRequestDispatcher("/manterPolo.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
        }
    }

    //Confirma a Exclusão
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {

        int codPolo = Integer.parseInt(request.getParameter("txtCodPolo"));
        int codTransporte = Integer.parseInt(request.getParameter("txtCodTransporte"));
        String cidade = request.getParameter("txtCidade");
        String logradouro = request.getParameter("txtLogradouro");
        String bairro = request.getParameter("txtBairro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
        String email = request.getParameter("txtEmail");
        //int coordenador = Integer.parseInt(request.getParameter("optProposto"));
        try {
            //Proposto proposto = null;
            Polo polo = new Polo(codPolo,codTransporte,cidade,logradouro,bairro,numero,telefone,email);
            polo.Excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPoloController");
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