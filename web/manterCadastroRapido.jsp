<%-- 
    Document   : manterCadastroRapido
    Created on : 15/09/2016, 06:52:00
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nead - SCV - Cadastro Rapido </title>
    </head>
    <body>
        <h1>Manter Cadastro Rapido - ${operacao}</h1>

        <form action="ManterCadastroRapidoController?acao=confirmar${operacao}" method="post" name="frmManterCadastroRapido" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código do curso:</td> 
                    <td><input type="text" name="txtCodCurso" value="${curso.codCurso}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nome do curso:</td> 
                    <td><input type="text" name="txtNomeCurso" value="${curso.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
