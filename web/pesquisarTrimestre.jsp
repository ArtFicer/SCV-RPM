<%-- 
    Document   : manterTrimestre
    Created on : 13/09/2016, 10:13:07
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Pesquisa de Trimestre</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Trimestre</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo:</th>
                        <th>Trimestre:</th>
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${trimestres}" var="trimestre">
                        <tr>
                            <td><c:out value="${trimestre.codTrimestre}" /></td>
                            <td><c:out value="${trimestre.numeroTrimestre}"/></td>
                            <td><a href="ManterTrimestreController?acao=prepararEditar&txtCodTrimestre=<c:out value="${trimestre.codTrimestre}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterTrimestreController?acao=prepararExcluir&txtCodTrimestre=<c:out value="${trimestre.codTrimestre}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterTrimestreController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>
            </form>
        </div>
    </body>
</html>
