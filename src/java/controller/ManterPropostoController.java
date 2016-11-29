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
import modelo.Secretaria;
import modelo.Servidor;

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
            request.setAttribute("propostos", Proposto.obterProposto());
            request.setAttribute("servidores", Servidor.obterServidor());
            request.setAttribute("secretarias", Secretaria.obterSecretaria());
            RequestDispatcher view = request.getRequestDispatcher("/manterProposto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }
    
    // Realiza e confirma a Inclusão no banco de dados
    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {
        int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
        int codCalendario = Integer.parseInt(request.getParameter("txtCodCalendario"));
        Servidor codServidor = Servidor(Integer.parseInt(request.getParameter("txtCodServidor")),null);
        int codSecretaria = Integer.parseInt(request.getParameter("txtCodSecretaria"));
        String nome = request.getParameter("txtNome");
        String setor = request.getParameter("txtSetor");
        int cpf = Integer.parseInt(request.getParameter("txtCPF"));
        int dataNascimento = Integer.parseInt(request.getParameter("txtDataNascimento"));
        String email = request.getParameter("txtEmail");
        int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        String logradouro = request.getParameter("txtLogradouro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String uf = request.getParameter("txtUF");
        int cep = Integer.parseInt(request.getParameter("txtCEP"));
        String titulacaoMaxima = request.getParameter("txtTitulacaoMaxima");
        String banco = request.getParameter("txtBanco");
        int agencia = Integer.parseInt(request.getParameter("txtAgencia"));
        int conta = Integer.parseInt(request.getParameter("txtConta"));
        String cargo = request.getParameter("txtCargo");
        String senha = request.getParameter("txtSenha");
        String tipoProposto = request.getParameter("txtTipoProposto");
        try {
            Proposto proposto = new Proposto(codProposto, codCalendario, codServidor, codSecretaria, nome,setor,cpf, dataNascimento, email, telefone, celular, logradouro, numero, complemento, bairro, cidade, uf ,cep, titulacaoMaxima, banco, agencia, conta, cargo, senha, tipoProposto);
            proposto.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostoController");
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
            int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
            Proposto proposto = Proposto.obterProposto(codProposto);
            request.setAttribute("proposto", proposto);
            RequestDispatcher view = request.getRequestDispatcher("/manterProposto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }
    
    
    //Confrimar a edição
    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {
        int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
        int codCalendario = Integer.parseInt(request.getParameter("txtCodCalendario"));
        Servidor codServidor = Servidor(Integer.parseInt(request.getParameter("txtCodServidor")),null);
        int codSecretaria = Integer.parseInt(request.getParameter("txtCodSecretaria"));
        String nome = request.getParameter("txtNome");
        String setor = request.getParameter("txtSetor");
        int cpf = Integer.parseInt(request.getParameter("txtCPF"));
        int dataNascimento = Integer.parseInt(request.getParameter("txtDataNascimento"));
        String email = request.getParameter("txtEmail");
        int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        String logradouro = request.getParameter("txtLogradouro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String uf = request.getParameter("txtUF");
        int cep = Integer.parseInt(request.getParameter("txtCEP"));
        String titulacaoMaxima = request.getParameter("txtTitulacaoMaxima");
        String banco = request.getParameter("txtBanco");
        int agencia = Integer.parseInt(request.getParameter("txtAgencia"));
        int conta = Integer.parseInt(request.getParameter("txtConta"));
        String cargo = request.getParameter("txtCargo");
        String senha = request.getParameter("txtSenha");
        String tipoProposto = request.getParameter("txtTipoProposto");
        try {
            Proposto proposto = new Proposto(codProposto, codCalendario, codServidor, codSecretaria, nome,setor,cpf, dataNascimento, email, telefone, celular, logradouro, numero, complemento, bairro, cidade, uf ,cep, titulacaoMaxima, banco, agencia, conta, cargo, senha, tipoProposto);
            proposto.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostoController");
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
            int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
            Proposto proposto = Proposto.obterProposto(codProposto);
            request.setAttribute("proposto", proposto);
            RequestDispatcher view = request.getRequestDispatcher("/manterProposto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
            throw ex;
        }
    }

    //Confirma a Exclusão
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ClassNotFoundException, ServletException {

        int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
        int codCalendario = Integer.parseInt(request.getParameter("txtCodCalendario"));
        int codServidor = Integer.parseInt(request.getParameter("txtCodServidor"));
        int codSecretaria = Integer.parseInt(request.getParameter("txtCodSecretaria"));
        String nome = request.getParameter("txtNome");
        String setor = request.getParameter("txtSetor");
        int cpf = Integer.parseInt(request.getParameter("txtCPF"));
        int dataNascimento = Integer.parseInt(request.getParameter("txtDataNascimento"));
        String email = request.getParameter("txtEmail");
        int telefone = Integer.parseInt(request.getParameter("txtTelefone"));
        int celular = Integer.parseInt(request.getParameter("txtCelular"));
        String logradouro = request.getParameter("txtLogradouro");
        int numero = Integer.parseInt(request.getParameter("txtNumero"));
        String complemento = request.getParameter("txtComplemento");
        String bairro = request.getParameter("txtBairro");
        String cidade = request.getParameter("txtCidade");
        String uf = request.getParameter("txtUF");
        int cep = Integer.parseInt(request.getParameter("txtCEP"));
        String titulacaoMaxima = request.getParameter("txtTitulacaoMaxima");
        String banco = request.getParameter("txtBanco");
        int agencia = Integer.parseInt(request.getParameter("txtAgencia"));
        int conta = Integer.parseInt(request.getParameter("txtConta"));
        String cargo = request.getParameter("txtCargo");
        String senha = request.getParameter("txtSenha");
        String tipoProposto = request.getParameter("txtTipoProposto");
        try {
            Proposto proposto = new Proposto(codProposto, codCalendario, codServidor, codSecretaria, nome,setor,cpf, dataNascimento, email, telefone, celular, logradouro, numero, complemento, bairro, cidade, uf ,cep, titulacaoMaxima, banco, agencia, conta, cargo, senha, tipoProposto);
            proposto.Excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostoController");
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
            Logger.getLogger(ManterPropostoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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
        } catch (SQLException ex) {
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