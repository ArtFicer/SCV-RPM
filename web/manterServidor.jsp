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
        <title>Manter Servidor</title>
    </head>
    <body align="center" bgcolor="#B0C4DE">
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Servidor - ${operacao}</h1>

            <form action="ManterServidorController?acao=confirmar${operacao}" method="post" name="frmManterServidor" onsubmit="return validarFormulario(this)">
            
                <div class="form-group">
                    <label for="usr">Código do Servidor:</label>
                    <input type="text" class="form-control" id="usr" name="txtCodServidor" value="${servidor.codServidor}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Matricula SIAPE:</label>
                    <input type="text" class="form-control" id="usr" name="txtMatriculaSIAPE" value="${servidor.matriculaSIAPE}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Lotado Orgao:</label>
                    <input type="text" class="form-control" id="usr" name="txtLotadoOrgao" value="${servidor.lotadoOrgao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                
                //Codigo Sevidor
                if(form.txtCodServidor.value === ""){
                    mensagem = mensagem + "Informe o código\n";
                }
                if (!campoNumerico(form.txtCodServidor.value)){
                    mensagem = mensagem + "Informe o Código do Servidor\n";
                }
                
                //Matricula SIAPE
                if (!campoNumerico(form.txtMatriculaSIAPE.value)){
                    mensagem = mensagem + "Informe a Matricula SIAPE Valida\n";
                }
                if(form.txtMatriculaSIAPE.value === ""){
                    mensagem = mensagem + "Informe uma Matricula SIAPE\n";
                }
                
                //Lotado orgão
                if (form.txtLotadoOrgao.value === ""){
                    mensagem = mensagem + "Informe o Orgao\n";
                } 
                
                if (mensagem === ""){
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