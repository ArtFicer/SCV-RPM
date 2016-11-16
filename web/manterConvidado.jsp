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
        <title>Manter Convidado</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
    <center>
        <h1>Manter Convidado - ${operacao}</h1>

        <form action="ManterConvidadoController?acao=confirmar${operacao}" method="post" name="frmManterConvidado" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código do convidado:</td> 
                    <td><input type="text" name="txtCodConvidado" value="${convidado.codConvidado}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Código Proposto:</td> 
                    <td><input type="text" name="txtCodProposto" value="${convidado.codProposto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Matrícula SIAPE:</td> 
                    <td><input type="text" name="txtMatriculaSIAPE" value="${convidado.matriculaSIAPE}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
    </center>
        <SCRIPT language="JavaScript">
            <!--
            
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
                if (form.txtCodConvidado.value == ""){
                    mensagem = mensagem + "Informe o Código do Convidado\n";
                }                             
                if (form.txtNomeConvidado.value == ""){
                    mensagem = mensagem + "Informe o Nome do Convidado\n";
                }             
                if (form.txtTotalPeriodos.value == ""){
                    mensagem = mensagem + "Informe o Total de Períodos\n";
                }                  
                if (form.txtCargaHoraria.value == ""){
                    mensagem = mensagem + "Informe a Carga Horária\n";
                }                  
                if (!campoNumerico(form.txtCodConvidado.value)){
                    mensagem = mensagem + "Código do Convidado deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtTotalPeriodos.value)){
                    mensagem = mensagem + "Total de Períodos deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtCargaHoraria.value)){
                    mensagem = mensagem + "Carga Horária deve ser numérica\n";
                }                  
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            //-->
        </SCRIPT>        
    </body>
</html>
