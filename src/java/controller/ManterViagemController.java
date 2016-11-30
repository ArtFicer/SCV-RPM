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
import modelo.DeclaracaoNotaTecnica;
import modelo.Polo;
import modelo.Proposto;
import modelo.RelatorioViagem;
import modelo.Transporte;
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
            request.setAttribute("viagens", Viagem.obterViagem());
            RequestDispatcher view = request.getRequestDispatcher("/manterViagem.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    // Realiza e confirma a Inclusão no banco de dados
    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {
        int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
        DeclaracaoNotaTecnica codDeclaracaoNotaTecnica = new DeclaracaoNotaTecnica(Integer.parseInt(request.getParameter("txtCodDeclaracaoNotaTecnica")),null);
        RelatorioViagem codRelatorioViagem = new RelatorioViagem(Integer.parseInt(request.getParameter("txtCodRelatorioViagem")),null);
        Proposto codProposto = new Proposto(Integer.parseInt(request.getParameter("txtCodProposto")),null);
        Polo codPolo = new Polo(Integer.parseInt(request.getParameter("txtCodPolo")),null,null,null,null,0,0,null);
        String destino = request.getParameter("txtDestino");
        String dataViagem = request.getParameter("txtDataViagem");
        int horarioSaida = Integer.parseInt(request.getParameter("txtHorarioSaida"));
        String statusConfirmacao = request.getParameter("txtStatusConfirmacao");
        String statusConclusao = request.getParameter("txtStatusConclusao");
        Transporte codTransporte = new Transporte(Integer.parseInt(request.getParameter("txtCodTransporte")),null,null);

        try {
            Viagem viagem = new Viagem(codViagem, codDeclaracaoNotaTecnica, codRelatorioViagem, codProposto, codPolo, destino, dataViagem, horarioSaida, statusConfirmacao, statusConclusao, codTransporte);
            viagem.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaViagemController");
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
            int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
            Viagem viagem = Viagem.obterViagem(codViagem);
            request.setAttribute("viagem", viagem);
            RequestDispatcher view = request.getRequestDispatcher("/manterViagem.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    //Confrimar a edição
    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {
        int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
        DeclaracaoNotaTecnica codDeclaracaoNotaTecnica = new DeclaracaoNotaTecnica(Integer.parseInt(request.getParameter("txtCodDeclaracaoNotaTecnica")),null);
        RelatorioViagem codRelatorioViagem = new RelatorioViagem(Integer.parseInt(request.getParameter("txtCodRelatorioViagem")),null);
        Proposto codProposto = new Proposto(Integer.parseInt(request.getParameter("txtCodProposto")),null);
        Polo codPolo = new Polo(Integer.parseInt(request.getParameter("txtCodPolo")),null,null,null,null,0,0,null);
        String destino = request.getParameter("txtDestino");
        String dataViagem = request.getParameter("txtDataViagem");
        int horarioSaida = Integer.parseInt(request.getParameter("txtHorarioSaida"));
        String statusConfirmacao = request.getParameter("txtStatusConfirmacao");
        String statusConclusao = request.getParameter("txtStatusConclusao");
        Transporte codTransporte = new Transporte(Integer.parseInt(request.getParameter("txtCodTransporte")),null,null);

        try {
            Viagem viagem = new Viagem(codViagem, codDeclaracaoNotaTecnica, codRelatorioViagem, codProposto, codPolo, destino, dataViagem, horarioSaida, statusConfirmacao, statusConclusao, codTransporte);
            viagem.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaViagemController");
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
            int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
            Viagem viagem = Viagem.obterViagem(codViagem);
            request.setAttribute("viagem", viagem);
            RequestDispatcher view = request.getRequestDispatcher("/manterViagem.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    //Confirma a Exclusão
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {
        int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
        DeclaracaoNotaTecnica codDeclaracaoNotaTecnica = new DeclaracaoNotaTecnica(Integer.parseInt(request.getParameter("txtCodDeclaracaoNotaTecnica")),null);
        RelatorioViagem codRelatorioViagem = new RelatorioViagem(Integer.parseInt(request.getParameter("txtCodRelatorioViagem")),null);
        Proposto codProposto = new Proposto(Integer.parseInt(request.getParameter("txtCodProposto")),null);
        Polo codPolo = new Polo(Integer.parseInt(request.getParameter("txtCodPolo")),null,null,null,null,0,0,null);
        String destino = request.getParameter("txtDestino");
        String dataViagem = request.getParameter("txtDataViagem");
        int horarioSaida = Integer.parseInt(request.getParameter("txtHorarioSaida"));
        String statusConfirmacao = request.getParameter("txtStatusConfirmacao");
        String statusConclusao = request.getParameter("txtStatusConclusao");
        Transporte codTransporte = new Transporte(Integer.parseInt(request.getParameter("txtCodTransporte")),null,null);

        try {
            Viagem viagem = new Viagem(codViagem, codDeclaracaoNotaTecnica, codRelatorioViagem, codProposto, codPolo, destino, dataViagem, horarioSaida, statusConfirmacao, statusConclusao, codTransporte);
            viagem.Excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaViagemController");
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
            Logger.getLogger(ManterViagemController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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
