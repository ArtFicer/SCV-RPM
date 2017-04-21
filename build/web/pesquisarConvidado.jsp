<%-- 
    Document   : pesquisaNomeCPF
    Created on : 20/09/2016, 09:16:11
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa Convidado</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
        <h1>Pesquisa de Convidados</h1>
        <table border=1px bordercolor="black" border-collapse: collapse BORDER=0 CELLPADDING=0 cellspacing=0 ALIGN="center">
            <tr>
                <th>Codigo:</th>
                <th>Código Proposto:</th>
                <th>Matrícula SIAPE:</th>
                <th colspan=2>Ação:</th>
            </tr>
            <c:forEach items="${convidados}" var="convidado">
                <tr>
                    <td><c:out value="${convidado.codConvidado}" /></td>
                    <td><c:out value="${convidado.codProposto}"/></td>
                    <td><c:out value="${convidado.matriculaSIAPE}"/></td>
                    <td><a href="ManterConvidadoController?acao=prepararEditar&txtCodConvidado=<c:out value="${convidado.codConvidado}"/>">Editar</a> </td>
                    <td><a href="ManterConvidadoController?acao=prepararExcluir&txtCodConvidado=<c:out value="${convidado.codConvidado}"/>">Excluir</a> </td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterConvidadoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
