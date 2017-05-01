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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Pesquisa de Viagens</title>
    </head>
    <body ALIGN="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Viagens</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo Viagem:</th>
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
                </thead>
                <tbody>
                    <c:forEach items="${viagens}" var="viagem">
                        <tr>
                            <td><c:out value="${viagem.codViagem}" /></td>
                            <td><c:out value="${viagem.codRelatorioViagem.codRelatorioViagem}" /></td>
                            <td><c:out value="${viagem.codProposto.nome}" /></td>
                            <td><c:out value="${viagem.codPolo.cidade}" /></td>
                            <td><c:out value="${viagem.destino}"/></td>
                            <td><c:out value="${viagem.dataViagem}" /></td>
                            <td><c:out value="${viagem.horarioSaida}"/></td>
                            <td><c:out value="${viagem.statusConfirmacao}"/></td>
                            <td><c:out value="${viagem.statusConclusao}"/></td>
                            <td><c:out value="${viagem.codTransporte.codTransporte}"/></td>

                            <td><a href="ManterViagemController?acao=prepararEditar&txtCodViagem=<c:out value="${viagem.codViagem}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterViagemController?acao=prepararExcluir&txtCodViagem=<c:out value="${viagem.codViagem}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterViagemController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>                
                <button class="btn btn-default" name="" value=""><a href="RelatorioViagem.jsp" target="_parent">Relatórios</a></button>
            </form>
        </div>
    </body>
</html>
