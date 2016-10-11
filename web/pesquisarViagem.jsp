<%-- 
    Document   : pesquisaViagem
    Created on : 13/09/2016, 09:56:37
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pesquisa de Viagens</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Destino:</th>
                <th>Confirmação:</th>
                <th>Conclusão:</th>
                <th>Código do Transporte:</th>
                <th>Horário Saída:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${viagens}" var="curso">
                <tr>
                    <td><c:out value="${viagens.codViagem}" /></td>
                    <td><c:out value="${viagens.destino}"/></td>
                    <td><c:out value="${viagens.statusConfirmacao}"/></td>
                    <td><c:out value="${viagens.statusConclusao}"/></td>
                    <td><c:out value="${viagens.codTransport}"/></td>
                    <td><c:out value="${viagens.horarioSaida}"/></td>
                    <td><a href="ManterCursoContoller?acao=prepararEditar&codCurso=<c:out value="${viagens.codViagem}"/>">Editar</a> </td>
                    <td><a href="ManterCursoContoller?acao=prepararExcluir&codCurso=<c:out value="${viagens.codViagem}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
