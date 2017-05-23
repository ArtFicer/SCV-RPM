
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        
        <title>Manter Solicitações</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Transporte - ${operacao}</h1>

            <form action="ManterTransporteController?acao=confirmar${operacao}" method="post" name="frmManterTransporte" onsubmit="return validarFormulario(this)">
            
                <div class="form-group">
                    <label for="usr">Código da Transporte:</label>
                    <input type="text" class="form-control" id="usr" name="txtCodTransporte" placeholder="Ex: 23" value="${transporte.codTransporte}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Empresa:</label>
                    <input type="text" class="form-control" id="usr" name="txtEmpresa" placeholder="Ex: Zezin Bão de Chão" value="${transporte.empresa}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                </div>
                <div class="form-group">
                    <label for="usr">Veículo:</label>
                    <input type="text" class="form-control" id="usr" name="txtVeiculo" placeholder="Ex: Fusca" value="${transporte.veiculo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                
                //Transporte
                if (!campoNumerico(form.txtCodTransporte.value)){
                    mensagem = mensagem + "Informe o Código da Transporte\n";
                }
                if(form.txtCodTransporte.value === ""){
                    mensagem = mensagem + "Informe o código\n";
                }
                
                //Empresa
                if (form.txtEmpresa.value === "") {
                    mensagem = mensagem + "Informe a Empresa\n";
                }
                
                //Veículo
                if (form.txtVeiculo.value === "") {
                    mensagem = mensagem + "Informe o Veiculo\n";
                }
                
                if (mensagem === "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
        </SCRIPT>        
    </body>
</html>