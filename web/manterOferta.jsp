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
        <title>Manter Oferta</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
        <h1>Manter Oferta - ${operacao}</h1>

        <form action="ManterOfertaController?acao=confirmar${operacao}" method="post" name="frmManterOferta" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código da Oferta:</td> 
                    <td><input type="text" name="txtCodOferta" value="${oferta.codOferta}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Ano:</td> 
                    <td><input type="text" name="txtAno" value="${oferta.ano}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if(form.txtCodOferta.value === ""){
                    mensagem = mensagem + "Informe o código\n";
                }
                if(form.txtAno.value === ""){
                    mensagem = mensagem + "Informe o ano\n";
                }
                if (!campoNumerico(form.txtCodOferta.value)){
                    mensagem = mensagem + "O código deve ser numérico\n";
                }                             
                if (!campoNumerico(form.txtAno.value)){
                    mensagem = mensagem + "O ano deve ser numérico\n";
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
</html>
