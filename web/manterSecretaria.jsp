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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
        <title>Manter Secretaria</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Secretaria - ${operacao}</h1>

            <form action="ManterSecretariaController?acao=confirmar${operacao}" method="post" name="frmManterSecretaria" onsubmit="return validarFormulario(this)">
            
                <div class="form-group">
                    <label for="usr">Código da Secretaria:</label>
                    <input type="text" class="form-control" id="usr" name="txtCodSecretaria" value="${secretaria.codSecretaria}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Nome:</label>
                    <input type="text" class="form-control" id="usr" name="txtNome" value="${secretaria.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">CPF:</label>
                    <input type="text" class="form-control" id="usr" name="txtCPF" value="${secretaria.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Email:</label>
                    <input type="text" class="form-control" id="usr" name="txtEmail" value="${secretaria.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="pwd">Senha:</label>
                    <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="txtSenha" value="${secretaria.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <button type="submit" class="btn btn-default" name="btnConfirmar" value="Confirmar">Confirmar</button>
            </form>
        </div>
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