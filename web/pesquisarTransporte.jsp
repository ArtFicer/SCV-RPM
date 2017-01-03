<%-- 
    Document   : manterTransporte
    Created on : 13/09/2016, 10:11:47
    Author     : 041801-Nead
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Solicitações</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
       <h1>Pesquisa de Transporte</h1>
        <table border=1px bordercolor="black" border-collapse: collapse BORDER=0 CELLPADDING=0 cellspacing=0 ALIGN="center">
            <tr>
                <th>Codigo:</th>
                <th>Assunto:</th>
                <th>Texto:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${transportes}" var="transporte">
                <tr>
                    <td><c:out value="${transporte.codTransporte}" /></td>
                    <td><c:out value="${transporte.empresa}"/></td>
                    <td><c:out value="${transporte.veiculo}"/></td>
                    <td><a href="ManterTransporteController?acao=prepararEditar&txtCodTransporte=<c:out value="${transporte.codTransporte}"/>">Editar</a> </td>
                    <td><a href="ManterTransporteController?acao=prepararExcluir&txtCodTransporte=<c:out value="${transporte.codTransporte}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterTransporteController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
