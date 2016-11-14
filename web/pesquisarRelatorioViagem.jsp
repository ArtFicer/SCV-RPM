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
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
        <h1>Pesquisa de Relatorio</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Relatório:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${relatorioViagens}" var="relatorioViagem">
                <tr>
                    <td><c:out value="${relatorioViagem.codRelatorioViagem}" /></td>
                    <td><c:out value="${relatorioViagem.relatorio}"/></td>
                    <td><a href="ManterRelatorioViagemController?acao=prepararEditar&txtCodRelatorioViagem=<c:out value="${relatorioViagem.codRelatorioViagem}"/>">Editar</a> </td>
                    <td><a href="ManterRelatorioViagemController?acao=prepararExcluir&txtCodRelatorioViagem=<c:out value="${relatorioViagem.codRelatorioViagem}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterRelatorioViagemController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
