
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>

        <title>Manter Relatorio Viagem</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Relatorio Viagem - ${operacao}</h1>

            <form action="ManterRelatorioViagemController?acao=confirmar${operacao}" method="post" name="frmManterRelatorioViagem" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Código do Relatorio da Viagem:</label>
                    <input type="text" maxlength=6 class="form-control" id="usr" name="txtCodRelatorioViagem" placeholder="Ex: 23" value="${relatorioViagem.codRelatorioViagem}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Relatorio:</label>
                        <input type="text" class="form-control" id="usr" name="txtRelatorio" placeholder="Ex: Atividades aplicadas em sala de aula normalmente" value="${relatorioViagem.relatorio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                if (form.txtCodRelatorioViagem.value === "") {
                    mensagem = mensagem + "Informe o Código do Relatorio\n";
                }
                if (form.txtRelatorio.value === "") {
                    mensagem = mensagem + "Informe o Relatorio\n";
                }
                if (!campoNumerico(form.txtCodRelatorioViagem.value)) {
                    mensagem = mensagem + "O Código do Relatorio da Viagem deve ser numérico\n";
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
