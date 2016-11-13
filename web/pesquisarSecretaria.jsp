<%-- 
    Document   : manterSecretaria
    Created on : 13/09/2016, 10:11:47
    Author     : 041801-Nead
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Solicitações</title>
    </head>
    <body>
       <h1>Pesquisa de Solicitações</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Nome:</th>
                <th>CPF:</th>
                <th>Email:</th>
                <th>Senha:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${secretarias}" var="secretaria">
                <tr>
                    <td><c:out value="${secretaria.codSecretaria}" /></td>
                    <td><c:out value="${secretaria.nome}"/></td>
                    <td><c:out value="${secretaria.cpf}"/></td>
                    <td><c:out value="${secretaria.email}"/></td>
                    <td><c:out value="${secretaria.senha}"/></td>
                    <td><a href="ManterSecretariaController?acao=prepararEditar&txtCodSecretaria=<c:out value="${secretaria.codSecretaria}"/>">Editar</a> </td>
                    <td><a href="ManterSecretariaController?acao=prepararExcluir&txtCodSecretaria=<c:out value="${secretaria.codSecretaria}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterSecretariaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
