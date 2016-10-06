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
        <title>JSP Page</title>
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
                    <td><c:out value="${propostos.codProposto}" /></td>
                    <td><c:out value="${propostos.nome}"/></td>
                    <td><c:out value="${propostos.cpf}"/></td>
                    <td><c:out value="${propostos.nascimento}"/></td>
                    <td><c:out value="${propostos.email}"/></td>
                    <td><c:out value="${propostos.telefone}"/></td>
                    <td><c:out value="${propostos.celular}"/></td>
                    <td><c:out value="${propostos.numero}"/></td>
                    <td><c:out value="${propostos.agencia}"/></td>
                    <td><c:out value="${propostos.conta}"/></td>
                    <td><c:out value="${propostos.senha}"/></td>
                    <td><c:out value="${propostos.setor}"/></td>
                    <td><c:out value="${propostos.logradouro}"/></td>
                    <td><c:out value="${propostos.complemento}"/></td>
                    <td><c:out value="${propostos.bairro}"/></td>
                    <td><c:out value="${propostos.cidade}"/></td>
                    <td><c:out value="${propostos.uf}"/></td>
                    <td><c:out value="${propostos.cep}"/></td>
                    <td><c:out value="${propostos.rg}"/></td>
                    <td><c:out value="${propostos.titulacaoMaxima}"/></td>
                    <td><c:out value="${propostos.banco}"/></td>
                    <td><c:out value="${propostos.cargo}"/></td>
                    <td><c:out value="${propostos.tipoProposto}"/></td>

                    <td><a href="ManterCursoContoller?acao=prepararEditar&codCurso=<c:out value="${propostos.codProposto}"/>">Editar</a> </td>
                    <td><a href="ManterCursoContoller?acao=prepararExcluir&codCurso=<c:out value="${propostos.codProposto}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterCursoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
