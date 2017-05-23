
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <link rel="stylesheet" href="css/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Pesquisa de Secretarias</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Secretarias</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo:</th>
                        <th>Nome de Usuário:</th>
                        <th>Email:</th>
                        <th>Senha:</th>
                        <th>Proposto:</th>
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${secretarias}" var="secretaria">
                        <tr>
                            <td><c:out value="${secretaria.codSecretaria}" /></td>
                            <td><c:out value="${secretaria.nome}"/></td>
                            <td><c:out value="${secretaria.email}"/></td>
                            <td><c:out value="${secretaria.senha}"/></td>
                            <td><c:out value="${secretaria.propostocodProposto.nome}"/></td>
                            <td><a href="ManterSecretariaController?acao=prepararEditar&txtCodSecretaria=<c:out value="${secretaria.codSecretaria}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterSecretariaController?acao=prepararExcluir&txtCodSecretaria=<c:out value="${secretaria.codSecretaria}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterSecretariaController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>
            </form>
            <form action="RelatorioSecretariaController?acao=prepararRelatorio" method="post">
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Relatórios</button>                
            </form>
        </div>
    </body>
</html>
