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
        <title>Manter Secretaria</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <h1>Manter Secretaria - ${operacao}</h1>

        <form action="ManterSecretariaController?acao=confirmar${operacao}" method="post" name="frmManterSecretaria" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código da Secretaria:</td> 
                    <td><input type="text" name="txtCodSecretaria" value="${secretaria.codSecretaria}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Nome:</td> 
                        <td><input type="text" name="txtNome" value="${secretaria.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>CPF:</td> 
                        <td><input type="text" name="txtCPF" value="${secretaria.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Email:</td> 
                        <td><input type="text" name="txtEmail" value="${secretaria.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Senha:</td> 
                        <td><input type="text" name="txtSenha" value="${secretaria.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                
                //Codigo Secretaria
                if (!campoNumerico(form.txtCodSecretaria.value)) {
                    mensagem = mensagem + "Informe o Código da Secretaria\n";
                }
                if(form.txtCodSecretaria.value === ""){
                    mensagem = mensagem + "Informe o Código\n";
                }
                
                //Nome
                if (form.txtNome.value === "") {
                    mensagem = mensagem + "Informe o Nome\n";
                }
                
                //CPF
                if (!campoNumerico(form.txtCPF.value)) {
                    mensagem = mensagem + "Informe o CPF \n";
                }
                if(form.txtCPF.value === ""){
                    mensagem = mensagem + "Informe o CPF\n";
                }
                
                //Email
                if (form.txtEmail.value === ""){
                    mensagem = mensagem + "Digite um email válido \n";
                }
                
                //Senha
                if (!campoNumerico(form.txtSenha.value)) {
                    mensagem = mensagem + "Insira a senha \n";
                }
                if(form.txtSenha.value === ""){
                    mensagem = mensagem + "Informe uma senha\n";
                }
                
                                
                if (mensagem === "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
            //-->
        </SCRIPT>        
    </body>
</html>