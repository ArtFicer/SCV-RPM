package exception;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TratamentoExcecao extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Exception excecao = (Exception) request.getAttribute("javax.servlet.exception");
        Integer codigoStatus = (Integer) request.getAttribute("javax.servlet.status_code");
        String nomeServlet = (String) request.getAttribute("javax.servlet.error.servlet_name");
        String uriRequisicao = (String) request.getAttribute("javax.error.request_uri");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String titulo = "Informação de Exceção";
        String tipoDocto = "<!doctype html public \"-//w3c//dtd html 4.0 transational//en\">\n";
        out.print(tipoDocto + "<html>\n<head><title>"+titulo+"</title></head>\n<body>");
        out.print("<h2>Informação sobre a exceção</h2>");
        out.print("Código do status: "+codigoStatus+"</br></br>");
        out.print("Nome do servlet"+nomeServlet+"</br></br>");
        out.print("Tipo de exceção"+excecao.getClass().getName()+"</br></br>");
        out.print("URI da requisição"+uriRequisicao+"</br></br>");
        out.print("Mensagem: "+excecao.getMessage());
        out.println("</body>");
        out.println("</html>");

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