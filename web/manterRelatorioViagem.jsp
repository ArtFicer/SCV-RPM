<%-- 
    Document   : manterRelatorioViagem
    Created on : 13/09/2016, 10:11:15
    Author     : 041801-Nead
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Relatorio Viagem</title>
    </head>
    <body>
        <h1>Manter Relatorio Viagem - ${operacao}</h1>

        <form action="ManterRelatorioViagemController?acao=confirmar${operacao}" method="post" name="frmManterRelatorioViagem" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código do Relatorio da Viagem:</td> 
                    <td><input type="text" name="txtCodRelatorioViagem" value="${relatorioviagem.codRelatorioViagem}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Relatorio:</td> 
                    <td><input type="text" name="txtRelatorio" value="${relatorioviagem.relatorio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if (form.txtCodRelatorioViagem.value == ""){
                    mensagem = mensagem + "Informe o Código do Relatorio da Viagem\n";
                }                             
                if (form.txtRelatorio.value == ""){
                    mensagem = mensagem + "Informe o Relatorio\n";
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
