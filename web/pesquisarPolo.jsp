<%-- 
    Document   : manterPolo
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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>Pesquisa de Polos</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Pesquisa de Polos</h1>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Codigo:</th>
                        <th>Transporte:</th>
                        <th>Cidade:</th>
                        <th>Logradouro:</th>
                        <th>Bairo:</th>
                        <th>Numero:</th>
                        <th>Telefone:</th>
                        <th>Email:</th>         
                        <th colspan=2>Ação:</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${polos}" var="polo">
                        <tr>
                            <td><c:out value="${polo.codPolo}" /></td>
                            <td><c:out value="${polo.codTransporte.empresa}" /></td>
                            <td><c:out value="${polo.cidade}" /></td>
                            <td><c:out value="${polo.logradouro}" /></td>
                            <td><c:out value="${polo.bairro}" /></td>
                            <td><c:out value="${polo.numero}" /></td>
                            <td><c:out value="${polo.telefone}" /></td>
                            <td><c:out value="${polo.email}" /></td>
                            <td><a href="ManterPoloController?acao=prepararEditar&txtCodPolo=<c:out value="${polo.codPolo}"/>"><i class="icon-edit"></i>Editar</a> </td>
                            <td><a href="ManterPoloController?acao=prepararExcluir&txtCodPolo=<c:out value="${polo.codPolo}"/>"><i class="icon-remove"></i>Excluir</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="ManterPoloController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Incluir">Incluir</button>
            </form>
        </div>
    </body>
</html>
