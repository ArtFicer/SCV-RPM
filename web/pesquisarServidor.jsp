
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
        <title>Pesquisa de Servidores</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Servidores</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo:</th>
                        <th>Matricula SIAPE:</th>
                        <th>Lotado no Orgão:</th>       
                        <th>Proposto:</th>
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${servidores}" var="servidor">
                        <tr>
                            <td><c:out value="${servidor.codServidor}" /></td>
                            <td><c:out value="${servidor.matriculaSIAPE}"/></td>
                            <td><c:out value="${servidor.lotadoOrgao}"/></td>
                            <td><c:out value="${servidor.propostocodProposto.nome}"/></td>
                            <td><a href="ManterServidorController?acao=prepararEditar&txtCodServidor=<c:out value="${servidor.codServidor}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterServidorController?acao=prepararExcluir&txtCodServidor=<c:out value="${servidor.codServidor}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterServidorController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>
            </form>
            <form action="RelatorioServidorController?acao=prepararRelatorio" method="post">
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Relatórios</button>
            </form>
        </div>
    </body>
</html>
