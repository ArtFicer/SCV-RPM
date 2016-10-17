<%-- 
    Document   : manterDisciplina
    Created on : 13/09/2016, 10:13:19
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Disciplinas</title>
    </head>
    <body>
        <h1>Pesquisa de Disciplinas</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Nome:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${disciplinas}" var="disciplina">
                <tr>
                    <td><c:out value="${disciplina.codDisciplina}" /></td>
                    <td><c:out value="${disciplina.nome}"/></td>
                    <td><a href="ManterDisciplinaContoller?acao=prepararEditar&codDisciplina=<c:out value="${disciplina.codDisciplina}"/>">Editar</a> </td>
                    <td><a href="ManterDisciplinaContoller?acao=prepararExcluir&codDisciplina=<c:out value="${disciplina.codDisciplina}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterDiscilpinaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
