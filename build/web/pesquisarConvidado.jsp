
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
        <title>Pesquisa Convidados</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Convidados</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo:</th>
                        <th>Matrícula SIAPE:</th>
                        <th>Código Proposto:</th>
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${convidados}" var="convidado">
                        <tr>
                            <td><c:out value="${convidado.codConvidado}" /></td>
                            <td><c:out value="${convidado.matriculaSIAPE}"/></td>
                            <td><c:out value="${convidado.propostocodProposto.nome}"/></td>
                            <td><a href="ManterConvidadoController?acao=prepararEditar&txtCodConvidado=<c:out value="${convidado.codConvidado}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterConvidadoController?acao=prepararExcluir&txtCodConvidado=<c:out value="${convidado.codConvidado}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterConvidadoController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>
            </form>
            <form action="RelatorioConvidadoController?acao=prepararRelatorio" method="post">
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Relatórios</button>
            </form>
        </div>
    </body>
</html>

