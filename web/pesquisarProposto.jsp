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
                <th>Nome:</th>
                <th>CPF</th>
                <th>Nascimento:</th>
                <th>Email:</th>
                <th>Telefone:</th>
                <th>Celular:</th>
                <th>Numero:</th>
                <th>Agencia:</th>
                <th>Conta:</th>
                <th>Senha:</th>
                <th>Setor:</th>
                <th>Logradouro:</th>
                <th>Complemento:</th>
                <th>Bairro:</th>
                <th>Cidade:</th>
                <th>UF:</th>
                <th>Cep:</th>
                <th>RG:</th>
                <th>Titulação Máxima:</th>
                <th>Banco:</th>
                <th>Cargo:</th>
                <th>Tipo do Proposto:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${propostos}" var="curso">
                <tr>
                    <td><c:out value="${proposto.codProposto}" /></td>
                    <td><c:out value="${proposto.nome}"/></td>
                    <td><c:out value="${proposto.cpf}"/></td>
                    <td><c:out value="${proposto.nascimento}"/></td>
                    <td><c:out value="${proposto.email}"/></td>
                    <td><c:out value="${proposto.telefone}"/></td>
                    <td><c:out value="${proposto.celular}"/></td>
                    <td><c:out value="${proposto.numero}"/></td>
                    <td><c:out value="${proposto.agencia}"/></td>
                    <td><c:out value="${proposto.conta}"/></td>
                    <td><c:out value="${proposto.senha}"/></td>
                    <td><c:out value="${proposto.setor}"/></td>
                    <td><c:out value="${proposto.logradouro}"/></td>
                    <td><c:out value="${proposto.complemento}"/></td>
                    <td><c:out value="${proposto.bairro}"/></td>
                    <td><c:out value="${proposto.cidade}"/></td>
                    <td><c:out value="${proposto.uf}"/></td>
                    <td><c:out value="${proposto.cep}"/></td>
                    <td><c:out value="${proposto.rg}"/></td>
                    <td><c:out value="${proposto.titulacaoMaxima}"/></td>
                    <td><c:out value="${proposto.banco}"/></td>
                    <td><c:out value="${proposto.cargo}"/></td>
                    <td><c:out value="${proposto.tipoProposto}"/></td>

                    <td><a href="ManterCursoContoller?acao=prepararEditar&codCurso=<c:out value="${proposto.codProposto}"/>">Editar</a> </td>
                    <td><a href="ManterCursoContoller?acao=prepararExcluir&codCurso=<c:out value="${proposto.codProposto}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
