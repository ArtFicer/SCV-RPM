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
       <h1>Pesquisa de Cursos</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Nome:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${cursos}" var="curso">
                <tr>
                    <td><c:out value="${curso.codCurso}" /></td>
                    <td><c:out value="${curso.nome}"/></td>
                    <td><a href="ManterCursoContoller?acao=prepararEditar&codCurso=<c:out value="${curso.codCurso}"/>">Editar</a> </td>
                    <td><a href="ManterCursoContoller?acao=prepararExcluir&codCurso=<c:out value="${curso.codCurso}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
