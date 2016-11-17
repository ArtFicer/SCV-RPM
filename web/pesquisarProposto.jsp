<%-- 
    Document   : manterProposto
    Created on : 13/09/2016, 10:11:29
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Proposto</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
        <h1>Pesquisa de Proposto</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Codigo Calendario:</th>
                <th>Codigo Servidor:</th>
                <th>Codigo Secretaria:</th>
                <th>Nome:</th>
                <th>Setor:</th>
                <th>CPF::</th>
                <th>Nascimento:</th>
                <th>Email:</th>
                <th>Telefone:</th>
                <th>Celular:</th>
                <th>Logradouro:</th>
                <th>Numero:</th>
                <th>Complemento:</th>
                <th>Bairro:</th>
                <th>Cidade:</th>
                <th>UF:</th>
                <th>CEP:</th>
                <th>Titulação Máxima:</th>
                <th>Banco:</th>
                <th>Agência:</th>
                <th>Conta:</th>
                <th>Cargo:</th>
                <th>Senha:</th>
                <th>Tipo do Proposto:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${propostos}" var="proposto">
                <tr>
                    <td><c:out value="${proposto.codProposto}" /></td>
                    <td><c:out value="${proposto.codCalendario}" /></td>
                    <td><c:out value="${proposto.codServidor}" /></td>
                    <td><c:out value="${proposto.codSecretaria}" /></td>
                    <td><c:out value="${proposto.nome}"/></td>
                    <td><c:out value="${proposto.setor}"/></td>
                    <td><c:out value="${proposto.cpf}"/></td>
                    <td><c:out value="${proposto.dataNascimento}"/></td>
                    <td><c:out value="${proposto.email}"/></td>
                    <td><c:out value="${proposto.telefone}"/></td>
                    <td><c:out value="${proposto.celular}"/></td>
                    <td><c:out value="${proposto.logradouro}"/></td>
                    <td><c:out value="${proposto.numero}"/></td>
                    <td><c:out value="${proposto.complemento}"/></td>
                    <td><c:out value="${proposto.bairro}"/></td>
                    <td><c:out value="${proposto.cidade}"/></td>
                    <td><c:out value="${proposto.uf}"/></td>
                    <td><c:out value="${proposto.cep}"/></td>
                    <td><c:out value="${proposto.titulacaoMaxima}"/></td>
                    <td><c:out value="${proposto.banco}"/></td>
                    <td><c:out value="${proposto.agencia}"/></td>
                    <td><c:out value="${proposto.conta}"/></td>
                    <td><c:out value="${proposto.cargo}"/></td>
                    <td><c:out value="${proposto.senha}"/></td>
                    <td><c:out value="${proposto.tipoProposto}"/></td>
                    <td><a href="ManterPropostoController?acao=prepararEditar&txtCodProposto=<c:out value="${proposto.codProposto}"/>">Editar</a> </td>
                    <td><a href="ManterPropostoController?acao=prepararExcluir&txtCodProposto=<c:out value="${proposto.codProposto}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterPropostoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
