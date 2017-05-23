
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Proposto</title>
        <link rel="stylesheet" type="text/css" href="tcal.css" />
        <script type="text/javascript" src="tcal.js"></script>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootstrap-datetimepicker.min"></script>


    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Cadastro de um novo Proposto - ${operacao}</h1>

            <form action="ManterPropostoController?acao=confirmar${operacao}" method="post" name="frmManterProposto" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Código do Proposto:</label>
                    <input type="text" class="form-control" id="usr" name="txtCodProposto" placeholder="Ex: 23" value="${proposto.codProposto}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>                         
                    <div class="form-group">
                        <label for="usr">Nome:</label>
                        <input type="text" class="form-control" id="usr" name="txtNome" placeholder="Ex: Valeria Campos"value="${proposto.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Setor:</label>
                        <input type="text" class="form-control" id="usr" name="txtSetor" placeholder="Ex: Professoriado" value="${proposto.setor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">CPF:</label>
                        <input type="text" class="form-control" id="usr" name="txtCPF" placeholder="Ex: 12345678910"value="${proposto.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Data de Nascimento:</label>
                        <input type="text" class="form-control" id="usr" name="txtDataNascimento" placeholder="Ex: 23/10/1990"name="date" class="tcal" value="${proposto.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Email:</label>
                        <input type="text" class="form-control" id="usr" name="txtEmail" placeholder="Ex: email@email.com" value="${proposto.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Telefone:</label>
                        <input type="text" class="form-control" id="usr" name="txtTelefone" placeholder="Ex: 323232323232" value="${proposto.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Celular:</label>
                        <input type="text" class="form-control" id="usr" name="txtCelular" placeholder="Ex: 32 999999999" value="${proposto.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Logradouro:</label>
                        <input type="text" class="form-control" id="usr" name="txtLogradouro"  placeholder="Ex: Rua Não sei"value="${proposto.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Numero:</label>
                        <input type="text" class="form-control" id="usr" name="txtNumero" placeholder="Ex: 23" value="${proposto.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Complemento:</label>
                        <input type="text" class="form-control" id="usr" name="txtComplemento" placeholder="Ex: Ap 201" value="${proposto.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Bairro:</label>
                        <input type="text" class="form-control" id="usr" name="txtBairro" placeholder="Ex: Morro do Alemão"value="${proposto.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Cidade:</label>
                        <input type="text" class="form-control" id="usr" name="txtCidade" placeholder="Ex: Juiz de Fora"value="${proposto.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">UF:</label>
                        <input type="text" class="form-control" id="usr" name="txtUF" placeholder="Ex: MG" value="${proposto.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">CEP:</label>
                        <input type="text" class="form-control" id="usr" name="txtCEP" placeholder="Ex: 36036036" value="${proposto.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Titulação Máxima:</label>
                        <input type="text" class="form-control" id="usr" name="txtTitulacaoMaxima" placeholder="Ex: Mestre" value="${proposto.titulacaoMaxima}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Bairro:</label>
                        <input type="text" class="form-control" id="usr" name="txtBanco" placeholder="Ex: Banco do Brasil"value="${proposto.banco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Agencia:</label>
                        <input type="text" class="form-control" id="usr" name="txtAgencia" placeholder="Ex: 8823" value="${proposto.agencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Conta:</label>
                        <input type="text" class="form-control" id="usr" name="txtConta" placeholder="Ex: 123456" value="${proposto.conta}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Cargo:</label>
                        <input type="text" class="form-control" id="usr" name="txtCargo" placeholder="Ex: Professor" value="${proposto.cargo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
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
                if (form.txtCodServidor.value === "") {
                    mensagem = mensagem + "Informe o Código do Servidor\n";
                }
                if (form.txtMatriculaSiape.value === "") {
                    mensagem = mensagem + "Informe a Matricula SIAPE\n";
                }
                if (form.txtNome.value === "") {
                    mensagem = mensagem + "Informe o Nome do Proposto\n";
                }
                if (form.txtSetor.value === "") {
                    mensagem = mensagem + "Informe o Setor \n";
                }
                if (form.txtCPF.value === "") {
                    mensagem = mensagem + "Informe o CPF \n";
                }
                if (form.txtCodCurso.value === "") {
                    mensagem = mensagem + "Informe o código do Curso\n";
                }
                if (form.txtDataNascimento.value === "") {
                    mensagem = mensagem + "Informe a data de nascimento \n";
                }
                if (form.txtEmail.value === "") {
                    mensagem = mensagem + "Informe o email \n";
                }
                if (form.txtTelefone.value === "") {
                    mensagem = mensagem + "Informe o número do telefone\n";
                }
                if (form.txtCelular.value === "") {
                    mensagem = mensagem + "Informe o número do celular\n";
                }
                if (form.txtLogradouro.value === "") {
                    mensagem = mensagem + "Informe o logradouro \n";
                }
                if (form.txtNumero.value === "") {
                    mensagem = mensagem + "Informe o número do logradouro\n";
                }
                if (form.txtComplemento.value === "") {
                    mensagem = mensagem + "Informe o complemento \n";
                }
                if (form.txtLogradouro.value === "") {
                    mensagem = mensagem + "Informe o Bairro \n";
                }
                if (form.txtCidade.value === "") {
                    mensagem = mensagem + "Informe a Cidade \n";
                }
                if (form.txtUF.value === "") {
                    mensagem = mensagem + "Informe a UF \n";
                }
                if (form.txtCEP.value === "") {
                    mensagem = mensagem + "Informe o CEP \n";
                }
                if (form.txtTitulacaoMaxima.value === "") {
                    mensagem = mensagem + "Informe a titulacao Maxima\n";
                }
                if (form.txtBanco.value === "") {
                    mensagem = mensagem + "Informe o nome do banco\n";
                }
                if (form.txtAgencia.value === "") {
                    mensagem = mensagem + "Informe a agencia do banco\n";
                }
                if (form.txtConta.value === "") {
                    mensagem = mensagem + "Informe o número da conta\n";
                }
                if (form.txtCargo.value === "") {
                    mensagem = mensagem + "Informe o cargo \n";
                }
                if (form.txtSenha.value === "") {
                    mensagem = mensagem + "Informe o cargo \n";
                }


                if (!campoNumerico(form.txtCodServidor.value)) {
                    mensagem = mensagem + "O Código do Servidor deve ser numérico\n";
                }
                if (!campoNumerico(form.txtMatriculaSiape.value)) {
                    mensagem = mensagem + "A Matricula SIAPE deve ser numérico\n";
                }
                if (campoNumerico(form.txtNome.value)) {
                    mensagem = mensagem + "O Nome do Proposto não deve conter números\n";
                }
                if (!campoNumerico(form.txtSetor.value)) {
                    mensagem = mensagem + "O Setor deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCPF.value)) {
                    mensagem = mensagem + "O CPF deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCodCurso.value)) {
                    mensagem = mensagem + "O código do Curso deve ser numérico\n";
                }
                if (!campoNumerico(form.txtDataNascimento.value)) {
                    mensagem = mensagem + "A data de nascimento deve ser numérico\n";
                }
                if (!campoNumerico(form.txtTelefone.value)) {
                    mensagem = mensagem + "O número do telefone deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCelular.value)) {
                    mensagem = mensagem + "O número do celular deve ser numérico\n";
                }
                if (!campoNumerico(form.txtNumero.value)) {
                    mensagem = mensagem + "O número deve ser numérico\n";
                }
                if (campoNumerico(form.txtUF.value)) {
                    mensagem = mensagem + "A UF não pode ser numérico\n";
                }
                if (!campoNumerico(form.txtCEP.value)) {
                    mensagem = mensagem + "O CEP deve ser numérico\n";
                }
                if (campoNumerico(form.txtTitulacaoMaxima.value)) {
                    mensagem = mensagem + "A titulacao Maxima não deve ser numérico\n";
                }
                if (campoNumerico(form.txtBanco.value)) {
                    mensagem = mensagem + "O nome do banco não deve ser numérico\n";
                }
                if (!campoNumerico(form.txtAgencia.value)) {
                    mensagem = mensagem + "A agencia do banco deve ser numérico\n";
                }
                if (!campoNumerico(form.txtConta.value)) {
                    mensagem = mensagem + "O número da conta deve ser numérico\n";
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