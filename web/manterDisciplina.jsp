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
        <title>Manter Disciplina</title>
    </head>
    <body  align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
        <h1>Manter Disciplina - ${operacao}</h1>

        <form action="ManterDisciplinaController?acao=confirmar${operacao}" method="post" name="frmManterDisciplina" onsubmit="return validarFormulario(this)">
            <table align="center">
                <tr>
                    <td>Código do disciplina:</td> 
                    <td><input type="text" name="txtCodDisciplina" value="${disciplina.codDisciplina}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nome do disciplina:</td> 
                    <td><input type="text" name="txtNomeDisciplina" value="${disciplina.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if(form.txtCodDisciplina.value === ""){
                    mensagem = mensagem + "Informe o Código da Disciplina\n";
                }
                if (form.txtNomeDisciplina.value === ""){
                    mensagem = mensagem + "Informe o Nome do Disciplina\n";
                }
                if (!campoNumerico(form.txtCodDisciplina)){
                    mensagem = mensagem + "O código deve ser numérico\n";
                }
                if (campoNumerico(form.txtNomeDisciplina)){
                    mensagem = mensagem + "O nome não pode ser numérico\n";
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
