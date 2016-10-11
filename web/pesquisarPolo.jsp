<%-- 
    Document   : manterPolo
    Created on : 13/09/2016, 10:11:29
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pesquisa de Polos</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Cidade:</th>
                <th>Logradouro:</th>
                <th>Bairo:</th>
                <th>Telefone:</th>
                <th>Email:</th>
                <th>Numero:</th>
                <th>Modelo:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${polos}" var="curso">
                <tr>
                    <td><c:out value="${polos.codPolo}" /></td>
                    <td><c:out value="${polos.cidade}" /></td>
                    <td><c:out value="${polos.logradouro}" /></td>
                    <td><c:out value="${polos.bairro}" /></td>
                    <td><c:out value="${polos.telefone}" /></td>
                    <td><c:out value="${polos.email}" /></td>
                    <td><c:out value="${polos.numero}" /></td>
                    <td><c:out value="${polos.modelo}" /></td>
                    <td><a href="ManterCursoContoller?acao=prepararEditar&codCurso=<c:out value="${polos.codPolo}"/>">Editar</a> </td>
                    <td><a href="ManterCursoContoller?acao=prepararExcluir&codCurso=<c:out value="${polos.codPolo}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
