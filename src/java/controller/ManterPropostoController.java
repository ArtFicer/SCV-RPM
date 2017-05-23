package controller;

import dao.PropostoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proposto;

public class ManterPropostoController extends HttpServlet {

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

            RequestDispatcher view = request.getRequestDispatcher("/manterProposto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
            String nome = request.getParameter("txtNome");
            String setor = request.getParameter("txtSetor");
            int cpf = Integer.parseInt(request.getParameter("txtCPF"));
            String dataNascimento = request.getParameter("txtDataNascimento");
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
            String cargo = request.getParameter("txtCargo");
            String banco = request.getParameter("txtBanco");
            int agencia = Integer.parseInt(request.getParameter("txtAgencia"));
            int conta = Integer.parseInt(request.getParameter("txtConta"));

            Proposto proposto = new Proposto(codProposto, nome, setor, cpf, dataNascimento, email, telefone, celular, logradouro, numero, complemento, bairro, cidade, uf, cep, titulacaoMaxima, banco, agencia, conta, cargo);
            PropostoDAO.obterInstancia().gravar(proposto);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostoController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
            Proposto proposto = PropostoDAO.obterInstancia().obterProposto(codProposto);

            request.setAttribute("proposto", proposto);

            RequestDispatcher view = request.getRequestDispatcher("/manterProposto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
            String nome = request.getParameter("txtNome");
            String setor = request.getParameter("txtSetor");
            int cpf = Integer.parseInt(request.getParameter("txtCPF"));
            String dataNascimento = request.getParameter("txtDataNascimento");
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

            Proposto proposto = new Proposto(codProposto, nome, setor, cpf, dataNascimento, email, telefone, celular, logradouro, numero, complemento, bairro, cidade, uf, cep, titulacaoMaxima, banco, agencia, conta, cargo);

            PropostoDAO.obterInstancia().alterar(proposto);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostoController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Excluir");

            int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
            Proposto proposto = PropostoDAO.obterInstancia().obterProposto(codProposto);

            request.setAttribute("proposto", proposto);

            RequestDispatcher view = request.getRequestDispatcher("/manterProposto.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int codProposto = Integer.parseInt(request.getParameter("txtCodProposto"));
            String nome = request.getParameter("txtNome");
            String setor = request.getParameter("txtSetor");
            int cpf = Integer.parseInt(request.getParameter("txtCPF"));
            String dataNascimento = request.getParameter("txtDataNascimento");
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

            Proposto proposto = new Proposto(codProposto, nome, setor, cpf, dataNascimento, email, telefone, celular, logradouro, numero, complemento, bairro, cidade, uf, cep, titulacaoMaxima, banco, agencia, conta, cargo);

            PropostoDAO.obterInstancia().excluir(proposto);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostoController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
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
