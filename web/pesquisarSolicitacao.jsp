<%-- 
    Document   : manterSolicitacao
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
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
       <h1>Pesquisa de Solicitações</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Assunto:</th>
                <th>Texto:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${solicitacoes}" var="solicitacao">
                <tr>
                    <td><c:out value="${solicitacao.codSolicitacao}" /></td>
                    <td><c:out value="${solicitacao.assunto}"/></td>
                    <td><c:out value="${solicitacao.texto}"/></td>
                    <td><a href="ManterSolicitacaoController?acao=prepararEditar&txtCodSolicitacao=<c:out value="${solicitacao.codSolicitacao}"/>">Editar</a> </td>
                    <td><a href="ManterSolicitacaoController?acao=prepararExcluir&txtCodSolicitacao=<c:out value="${solicitacao.codSolicitacao}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterSolicitacaoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
