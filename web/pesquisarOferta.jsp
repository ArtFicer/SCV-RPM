<%-- 
    Document   : manterOferta
    Created on : 13/09/2016, 10:12:52
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Ofertas</title>
    </head>
    <body>
       <h1>Pesquisa de Ofertas</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Ano:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${ofertas}" var="oferta">
                <tr>
                    <td><c:out value="${oferta.codOferta}" /></td>
                    <td><c:out value="${oferta.ano}"/></td>
                    <td><a href="ManterOfertaController?acao=prepararEditar&txtCodOferta=<c:out value="${oferta.codOferta}"/>">Editar</a> </td>
                    <td><a href="ManterOfertaController?acao=prepararExcluir&txtCodOferta=<c:out value="${oferta.codOferta}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterOfertaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
