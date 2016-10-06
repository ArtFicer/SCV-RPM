<%-- 
    Document   : manterCadastroRapido
    Created on : 15/09/2016, 06:52:00
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nead - SCV - Cadastro Rapido </title>
    </head>
    <body>
        <form>
            <table width="700px">
                <tr>
                    <td><center><h2>Cadastro Rápido</h2></center></td>
                </tr>
                <tr>
                    <td>
                        <p>Nome:  <input type="text" name="nome" size="30">
                        <p>CPF <input type="text" name="cpf" size="11">
                            <p><input type="submit" name="enviar">
                    </td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
