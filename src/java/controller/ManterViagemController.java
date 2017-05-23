package controller;

import dao.PoloDAO;
import dao.PropostoDAO;
import dao.RelatorioViagemDAO;
import dao.TransporteDAO;
import dao.ViagemDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Polo;
import model.Proposto;
import model.RelatorioViagem;
import model.Transporte;
import model.Viagem;

public class ManterViagemController extends HttpServlet {

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

            request.setAttribute("relatorioViagens", RelatorioViagemDAO.obterInstancia().obterRelatorioViagens());
            request.setAttribute("propostos", PropostoDAO.obterInstancia().obterPropostos());
            request.setAttribute("polos", PoloDAO.obterInstancia().obterPolos());
            request.setAttribute("transportes", TransporteDAO.obterInstancia().obterTransportes());

            RequestDispatcher view = request.getRequestDispatcher("/manterViagem.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            RelatorioViagem relatorioViagem = new RelatorioViagem(Integer.parseInt(request.getParameter("txtCodRelatorioViagem")));
            Proposto proposto = new Proposto(Integer.parseInt(request.getParameter("txtCodProposto")));
            Polo polo = new Polo(Integer.parseInt(request.getParameter("txtCodPolo")));
            Transporte transporte = new Transporte(Integer.parseInt(request.getParameter("txtCodTransporte")));

            int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
            String destino = request.getParameter("txtDestino");
            String dataViagem = request.getParameter("txtDataViagem");
            String horarioSaida = request.getParameter("txtHorarioSaida");
            String statusConfirmacao = request.getParameter("txtStatusConfirmacao");
            String statusConclusao = request.getParameter("txtStatusConclusao");

            Viagem viagem = new Viagem(codViagem, destino, dataViagem, horarioSaida, statusConfirmacao, statusConclusao);

            viagem.setPolocodPolo(polo);
            viagem.setPropostocodProposto(proposto);
            viagem.setRelatorioviagemcodRelatorioViagem(relatorioViagem);
            viagem.setTransportecodTransporte(transporte);

            ViagemDAO.obterInstancia().gravar(viagem);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaViagemController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("operacao", "Editar");

            int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
            Viagem viagem = ViagemDAO.obterInstancia().obterViagem(codViagem);

            request.setAttribute("viagem", viagem);
            request.setAttribute("relatorioViagens", RelatorioViagemDAO.obterInstancia().obterRelatorioViagens());
            request.setAttribute("propostos", PropostoDAO.obterInstancia().obterPropostos());
            request.setAttribute("polos", PoloDAO.obterInstancia().obterPolos());
            request.setAttribute("transportes", TransporteDAO.obterInstancia().obterTransportes());

            RequestDispatcher view = request.getRequestDispatcher("/manterViagem.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            RelatorioViagem relatorioViagem = new RelatorioViagem(Integer.parseInt(request.getParameter("txtCodRelatorioViagem")));
            Proposto proposto = new Proposto(Integer.parseInt(request.getParameter("txtCodProposto")));
            Polo polo = new Polo(Integer.parseInt(request.getParameter("txtCodPolo")));
            Transporte transporte = new Transporte(Integer.parseInt(request.getParameter("txtCodTransporte")));

            int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
            String destino = request.getParameter("txtDestino");
            String dataViagem = request.getParameter("txtDataViagem");
            String horarioSaida = request.getParameter("txtHorarioSaida");
            String statusConfirmacao = request.getParameter("txtStatusConfirmacao");
            String statusConclusao = request.getParameter("txtStatusConclusao");

            Viagem viagem = new Viagem(codViagem, destino, dataViagem, horarioSaida, statusConfirmacao, statusConclusao);

            viagem.setPolocodPolo(polo);
            viagem.setPropostocodProposto(proposto);
            viagem.setRelatorioviagemcodRelatorioViagem(relatorioViagem);
            viagem.setTransportecodTransporte(transporte);

            ViagemDAO.obterInstancia().alterar(viagem);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaViagemController");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
            Viagem viagem = ViagemDAO.obterInstancia().obterViagem(codViagem);

            request.setAttribute("viagem", viagem);
            request.setAttribute("relatorioViagens", RelatorioViagemDAO.obterInstancia().obterRelatorioViagens());
            request.setAttribute("propostos", PropostoDAO.obterInstancia().obterPropostos());
            request.setAttribute("polos", PoloDAO.obterInstancia().obterPolos());
            request.setAttribute("transportes", TransporteDAO.obterInstancia().obterTransportes());

            RequestDispatcher view = request.getRequestDispatcher("/manterViagem.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException ex) {
            throw ex;
        }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            RelatorioViagem relatorioViagem = new RelatorioViagem(Integer.parseInt(request.getParameter("txtCodRelatorioViagem")));
            Proposto proposto = new Proposto(Integer.parseInt(request.getParameter("txtCodProposto")));
            Polo polo = new Polo(Integer.parseInt(request.getParameter("txtCodPolo")));
            Transporte transporte = new Transporte(Integer.parseInt(request.getParameter("txtCodTransporte")));

            int codViagem = Integer.parseInt(request.getParameter("txtCodViagem"));
            String destino = request.getParameter("txtDestino");
            String dataViagem = request.getParameter("txtDataViagem");
            String horarioSaida = request.getParameter("txtHorarioSaida");
            String statusConfirmacao = request.getParameter("txtStatusConfirmacao");
            String statusConclusao = request.getParameter("txtStatusConclusao");

            Viagem viagem = new Viagem(codViagem, destino, dataViagem, horarioSaida, statusConfirmacao, statusConclusao);

            viagem.setPolocodPolo(polo);
            viagem.setPropostocodProposto(proposto);
            viagem.setRelatorioviagemcodRelatorioViagem(relatorioViagem);
            viagem.setTransportecodTransporte(transporte);

            ViagemDAO.obterInstancia().excluir(viagem);

            RequestDispatcher view = request.getRequestDispatcher("PesquisaViagemController");
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
