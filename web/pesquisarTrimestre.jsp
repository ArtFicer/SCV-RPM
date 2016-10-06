<%-- 
    Document   : manterTrimestre
    Created on : 13/09/2016, 10:13:07
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
        <h1>Pesquisa de Trimestre</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Trimestre:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${trimestre}" var="curso">
                <tr>
                    <td><c:out value="${trimestre.codTrimestre}" /></td>
                    <td><c:out value="${trimestre.numeroTrimestre}"/></td>
                    <td><a href="ManterCursoContoller?acao=prepararEditar&codCurso=<c:out value="${trimestre.codTrimestre}"/>">Editar</a> </td>
                    <td><a href="ManterCursoContoller?acao=prepararExcluir&codCurso=<c:out value="${trimestre.codTrimestre}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
