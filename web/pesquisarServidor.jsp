<%-- 
    Document   : pesquisaServidor
    Created on : 13/09/2016, 09:55:59
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Servidores</title>
    </head>
    <body>
       <h1>Pesquisa de Servidores</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Matricula SIAPE:</th>
                <th>Lotado no Orgão:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${servidores}" var="curso">
                <tr>
                    <td><c:out value="${servidore.codServidor}" /></td>
                    <td><c:out value="${servidore.matriculaSIAP}"/></td>
                    <td><c:out value="${servidore.LotadoOrgao}"/></td>
                    <td><a href="ManterCursoContoller?acao=prepararEditar&codCurso=<c:out value="${servidore.codServidor}"/>">Editar</a> </td>
                    <td><a href="ManterCursoContoller?acao=prepararExcluir&codCurso=<c:out value="${servidore.codServidor}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
