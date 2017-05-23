
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
        <title>Pesquisa de Relatorio</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Relatorio</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo:</th>
                        <th>Relatório:</th>
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${relatorioViagens}" var="relatorioViagem">
                        <tr>
                            <td><c:out value="${relatorioViagem.codRelatorioViagem}" /></td>
                            <td><c:out value="${relatorioViagem.relatorio}"/></td>
                            <td><a href="ManterRelatorioViagemController?acao=prepararEditar&txtCodRelatorioViagem=<c:out value="${relatorioViagem.codRelatorioViagem}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterRelatorioViagemController?acao=prepararExcluir&txtCodRelatorioViagem=<c:out value="${relatorioViagem.codRelatorioViagem}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterRelatorioViagemController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>
                <button class="btn btn-default" name="" value=""><a href="RelatorioRelatorioViagem.jsp" target="_parent">Relatórios</a></button>
            </form>
        </div>
    </body>
</html>
