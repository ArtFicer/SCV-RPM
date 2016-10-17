<%-- 
    Document   : manterRelatorioViagem
    Created on : 13/09/2016, 10:11:15
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Relatorio</title>
    </head>
    <body>
        <h1>Pesquisa de Relatorio</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Relatório:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${relatorios}" var="relatorioViagem">
                <tr>
                    <td><c:out value="${relatorio.codEscreverRelatorio}" /></td>
                    <td><c:out value="${relatorio.relatorio}"/></td>
                    <td><a href="ManterRelatorioViagemContoller?acao=prepararEditar&codRelatorioViagem=<c:out value="${relatorio.codEscreverRelatorio}"/>">Editar</a> </td>
                    <td><a href="ManterRelatorioViagemContoller?acao=prepararExcluir&codRelatorioViagem=<c:out value="${relatorio.codEscreverRelatorio}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterRelatorioViagemController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
