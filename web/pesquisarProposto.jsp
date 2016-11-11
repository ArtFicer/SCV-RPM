<%-- 
    Document   : pesquisaProposto
    Created on : 06/10/2016, 07:37:32
    Author     : pe-ri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Propostos</title>
    </head>
    <body>
        <h1>Pesquisa de Propostos</h1>
        <table border=1>
            <tr>
                <th>Codigo:</th>
                <th>Calendario:</th>
                <th>Servidor:</th>
                <th>Secretaria:</th>
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
                    <td><a href="ManterPropostoController?acao=prepararEditar&txtCodProposto=<c:out value="${solicitacao.codProposto}"/>">Editar</a> </td>
                    <td><a href="ManterPropostoController?acao=prepararExcluir&txtCodProposto=<c:out value="${solicitacao.codProposto}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterPropostoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
