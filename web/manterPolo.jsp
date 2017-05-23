
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

        <title>Manter Polo</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Polo - ${operacao}</h1>

            <form action="ManterPoloController?acao=confirmar${operacao}" method="post" name="frmManterPolo" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Código do Polo</label>
                    <input type="text" class="form-control" id="usr" name="txtCodPolo" placeholder="Ex: 23" value="${polo.codPolo}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Cidade:</label>
                        <input type="text" class="form-control" id="usr" name="txtCidade" placeholder="Ex: Muriaé" value="${polo.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Logradouro:</label>
                        <input type="text" class="form-control" id="usr" name="txtLogradouro" placeholder="Ex: Rua Juarez Don Mercedes" value="${polo.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Bairro:</label>
                        <input type="text" class="form-control" id="usr" name="txtBairro" placeholder="Ex: Bairro Barroso" value="${polo.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Numero:</label>
                        <input type="text" class="form-control" id="usr" name="txtNumero" placeholder="Ex: 23"value="${polo.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Telefone:</label>
                        <input type="text" class="form-control" id="usr" name="txtTelefone" placeholder="Ex: 2332923218" value="${polo.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Email:</label>
                        <input type="text" class="form-control" id="usr" name="txtEmail" placeholder="Ex: email@email.com "value="${polo.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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

                //Código
                if (form.txtCodPolo.value === "") {
                    mensagem = mensagem + "Informe o código\n";
                }
                if (!campoNumerico(form.txtCodPolo.value)) {
                    mensagem = mensagem + "O Código deve ser numérico\n";
                }

                //Cidade
                if (form.txtCidade.value === "") {
                    mensagem = mensagem + "Informe a cidade\n";
                }
                if (campoNumerico(form.txtCidade.value)) {
                    mensagem = mensagem + "A cidade não deve ser numérico \n";
                }

                //Logradouro
                if (form.txtLogradouro.value === "") {
                    mensagem = mensagem + "Informe o logradouro\n";
                }

                //Bairro
                if (form.txtBairro.value === "") {
                    mensagem = mensagem + "Informe o Bairro\n";
                }

                //Número
                if (form.txtNumero.value === "") {
                    mensagem = mensagem + "Informe o número\n";
                }
                if (!campoNumerico(form.txtNumero.value)) {
                    mensagem = mensagem + "O campo Numero deve ser numerico\n";
                }

                //Telefone
                if (form.txtTelefone.value === "") {
                    mensagem = mensagem + "Informe o telefone\n";
                }
                if (!campoNumerico(form.txtTelefone.value === "")) {
                    mensagem = mensagem + "O campo Telefone deve ser numérico\n";
                }

                //Email
                if (form.txtEmail.value === "") {
                    mensagem = mensagem + "Informe o Email\n";
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
