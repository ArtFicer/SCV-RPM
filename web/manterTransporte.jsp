<%-- 
    Document   : SCV
    Created on : 2/2016
    Author     : RPM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Solicitações</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <h1>Manter Solicitações - ${operacao}</h1>

        <form action="ManterTransporteController?acao=confirmar${operacao}" method="post" name="frmManterTransporte" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código da Transporte:</td> 
                    <td><input type="text" name="txtCodTransporte" value="${transporte.codTransporte}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Empresa:</td> 
                        <td><input type="text" name="txtEmpresa" value="${transporte.empresa}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Veículo:</td> 
                        <td><input type="text" name="txtVeiculo" value="${transporte.veiculo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
        <SCRIPT language="JavaScript">

            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == -1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) {
                var mensagem;
                mensagem = "";
                if (!campoNumerico(form.txtTransporte.value)){
                    mensagem = mensagem + "Informe o Código da Transporte\n";
                }
                if (form.txtEmpresa.value == "") {
                    mensagem = mensagem + "Informe a Empresa\n";
                }
                if (form.txtVeiculo.value == "") {
                    mensagem = mensagem + "Informe o Veiculo\n";
                }
                
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
        </SCRIPT>        
    </body>
</html>