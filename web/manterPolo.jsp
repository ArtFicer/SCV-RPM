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
        <title>Manter Polo</title>
    </head>
    <body>
        <h1>Manter Polo - ${operacao}</h1>

        <form action="ManterPoloController?acao=confirmar${operacao}" method="post" name="frmManterPolo" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código do Polo</td> 
                    <td><input type="text" name="txtCodPolo" value="${polo.codPolo}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Código do Transporte:</td> 
                    <td><input type="text" name="txtCodTransporte" value="${polo.codTransporte}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Cidade:</td> 
                    <td><input type="text" name="txtCidade" value="${polo.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Logradouro:</td> 
                    <td><input type="text" name="txtLogradouro" value="${polo.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Bairro:</td> 
                    <td><input type="text" name="txtCodBairro" value="${polo.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Numero:</td> 
                    <td><input type="text" name="txtNumero" value="${polo.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Telefone:</td> 
                    <td><input type="text" name="txtTelefone" value="${polo.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Email:</td> 
                    <td><input type="text" name="txtEmail" value="${polo.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
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
                if (form.txtCodPolo.value == ""){
                    mensagem = mensagem + "Informe o Código do Polo\n";
                }                             
                if (form.txtCodTransporte.value == ""){
                    mensagem = mensagem + "Informe o Código do Transporte\n";
                }
                if (form.txtCidade.value == ""){
                    mensagem = mensagem + "Informe a Cidade\n";
                } 
                if (form.txtLogradouro.value == ""){
                    mensagem = mensagem + "Informe o Logradouro\n";
                } 
                if (form.txtCodBairro.value == ""){
                    mensagem = mensagem + "Informe o Bairro\n";
                } 
                if (form.txtNumero.value == ""){
                    mensagem = mensagem + "Informe o Numero\n";
                } 
                if (form.txtTelefone.value == ""){
                    mensagem = mensagem + "Informe o Telefone\n";
                } 
                if (form.txtEmail.value == ""){
                    mensagem = mensagem + "Informe o Email\n";
                }
                if (form.txtTotalPeriodos.value == ""){
                    mensagem = mensagem + "Informe o Total de Períodos\n";
                }                  
                if (form.txtCargaHoraria.value == ""){
                    mensagem = mensagem + "Informe a Carga Horária\n";
                }                  
                if (!campoNumerico(form.txtCodCurso.value)){
                    mensagem = mensagem + "Código do Curso deve ser numérico\n";
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
