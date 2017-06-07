
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

        <title>Manter Secretaria</title>
    </head>
    <body>
        <!--Menu-->

        <nav <c:if test="${operacao != 'Cadastrar'}"> disable</c:if>>
                <object width="100%" height="65px" data="menu.jsp"></object>
            </nav>
            <div class="container">
                <h1>Manter Secretaria - ${operacao}</h1>

            <form action="ManterSecretariaController?acao=confirmar${operacao}" method="post" name="frmManterSecretaria" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Código da Secretaria:</label>
                    <input type="text" class="form-control" id="usr" name="txtCodSecretaria"  placeholder="Ex: 23"value="${secretaria.codSecretaria}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Nome de Usuário:</label>
                        <input type="text" class="form-control" id="usr" name="txtNome" placeholder="Ex: José Café Pelé"value="${secretaria.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Email:</label>
                        <input type="text" class="form-control" id="usr" name="txtEmail"  placeholder="Ex: email@email.com"value="${secretaria.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Senha:</label>
                        <input type="password" class="form-control" id="pwd" placeholder="Ex: 12345" name="txtSenha" value="${secretaria.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Nome do Proposto:</label>
                        <select class="selectpicker" name="txtCodProposto" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${proposto.codProposto != null}"> selected</c:if>></option>
                        <c:forEach items="${propostos}" var="proposto">
                            <option value="${proposto.codProposto}" <c:if test="${proposto.codProposto == secretaria.propostocodProposto.codProposto}"> selected</c:if>>
                                ${proposto.nome}
                            </option>
                        </c:forEach>
                    </select>
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

                if (form.txtCodSecretaria.size > 8) {
                    mensagem = mensagem + "O numero esta muito grande\n";
                }
                //Codigo Secretaria
                if (!campoNumerico(form.txtCodSecretaria.value)) {
                    mensagem = mensagem + "Informe o Código da Secretaria\n";
                }
                if (form.txtCodSecretaria.value === "") {
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
                if (form.txtCPF.value === "") {
                    mensagem = mensagem + "Informe o CPF\n";
                }

                //Email
                if (form.txtEmail.value === "") {
                    mensagem = mensagem + "Digite um email válido \n";
                }

                //Senha
                if (form.txtSenha.value === "") {
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