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
        <title>Manter Relatorio Viagem</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
        <h1>Manter Relatorio Viagem - ${operacao}</h1>

        <form action="ManterRelatorioViagemController?acao=confirmar${operacao}" method="post" name="frmManterRelatorioViagem" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código do Relatorio da Viagem:</td> 
                    <td><input type="text" name="txtCodRelatorioViagem" value="${relatorioViagem.codRelatorioViagem}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Relatorio:</td> 
                    <td><input type="text" name="txtRelatorio" value="${relatorioViagem.relatorio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                for (i = 0; i < valor.length && ehNumero === true; i++) 
                { 
                    umCaracter = valor.charAt(i); 
                    if (caracteresValidos.indexOf(umCaracter) === -1) 
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if(form.txtCodRelatorioViagem.value === ""){
                    mensagem = mensagem + "Informe o Código do Relatorio\n";
                }
                if(form.txtRelatorio.value === ""){
                    mensagem = mensagem + "Informe o Relatorio\n";
                }
                if (!campoNumerico(form.txtCodRelatorioViagem.value)){
                    mensagem = mensagem + "O Código do Relatorio da Viagem deve ser numérico\n";
                }                             
                if (mensagem === ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
        </SCRIPT>        
    </body>
</html>
