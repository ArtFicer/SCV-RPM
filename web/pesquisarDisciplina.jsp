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
    <body align="center" bgcolor="#B0C4DE"
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
        <h1>Pesquisa de Disciplinas</h1>
        <table border=1px bordercolor="black" border-collapse: collapse BORDER=0 CELLPADDING=0 cellspacing=0 ALIGN="center">
            <tr>
                <th>Codigo:</th>
                <th>Nome:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${disciplinas}" var="disciplina">
                <tr>
                    <td><c:out value="${disciplina.codDisciplina}" /></td>
                    <td><c:out value="${disciplina.nome}"/></td>
                    <td><a href="ManterDisciplinaController?acao=prepararEditar&txtCodDisciplina=<c:out value="${disciplina.codDisciplina}"/>">Editar</a> </td>
                    <td><a href="ManterDisciplinaController?acao=prepararExcluir&txtCodDisciplina=<c:out value="${disciplina.codDisciplina}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterDisciplinaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
