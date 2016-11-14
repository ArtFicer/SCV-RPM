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
        <title>Pesquisa de Viagens</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
        <h1>Pesquisa de Viagens</h1>
        <table border=1>
            <tr>
                <th>Codigo Viagem:</th>
                <th>Codigo Declaração Nota Técnica:</th>
                <th>Codigo Relatorio Viagem:</th>
                <th>Codigo Proposto:</th>
                <th>Codigo Polo:</th>
                <th>Destino:</th>
                <th>Data da Viagem:</th>
                <th>Horario de Saída:</th>
                <th>Confirmação:</th>
                <th>Conclusão:</th>
                <th>Codigo Transporte:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${viagens}" var="viagem">
                <tr>
                    <td><c:out value="${viagem.codViagem}" /></td>
                    <td><c:out value="${viagem.codDeclaracaoNotaTecnica}" /></td>
                    <td><c:out value="${viagem.codRelatorioViagem}" /></td>
                    <td><c:out value="${viagem.codProposto}" /></td>
                    <td><c:out value="${viagem.codPolo}" /></td>
                    <td><c:out value="${viagem.destino}"/></td>
                    <td><c:out value="${viagem.dataViagem}" /></td>
                    <td><c:out value="${viagem.horarioSaida}"/></td>
                    <td><c:out value="${viagem.statusConfirmacao}"/></td>
                    <td><c:out value="${viagem.statusConclusao}"/></td>
                    <td><c:out value="${viagem.codTransporte}"/></td>
                    
                    <td><a href="ManterViagemController?acao=prepararEditar&txtCodViagem=<c:out value="${viagem.codViagem}"/>">Editar</a> </td>
                    <td><a href="ManterViagemController?acao=prepararExcluir&txtCodViagem=<c:out value="${viagem.codViagem}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterViagemController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
