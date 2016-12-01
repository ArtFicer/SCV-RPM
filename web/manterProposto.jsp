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
        <title>Manter Proposto</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <h1>Manter Proposto - ${operacao}</h1>

        <form action="ManterPropostoController?acao=confirmar${operacao}" method="post" name="frmManterProposto" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código do Proposto:</td> 
                    <td><input type="text" name="txtCodProposto" value="${proposto.codProposto}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Código Calendário:</td> 
                        <td><input type="text" name="txtCodCalendario" value="${proposto.codCalendario}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Codigo Servidor:</td> 
                        <td><select name="txtCodServidor" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${servidor.codServidor != null}"> selected</c:if>></option>
                            <c:forEach items="${servidores}" var="servidor">
                                <option value="${servidor.codServidor}" <c:if test="${servidor.codServidor == proposto.codServidor}"> selected</c:if>>
                                    ${servidor.codServidor}
                                </option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Codigo Secretaria:</td> 
                    <td><select name="txtCodSecretaria" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${secretaria.codSecretaria != null}"> selected</c:if>></option>
                            <c:forEach items="${secretarias}" var="secretaria">
                                <option value="${secretaria.codSecretaria}" <c:if test="${secretaria.codSecretaria == proposto.codSecretaria.codSecretaria}"> selected</c:if>>
                                    ${secretaria.codSecretaria}
                                </option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Nome:</td> 
                    <td><input type="text" name="txtNome" value="${proposto.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Setor:</td> 
                        <td><input type="text" name="txtSetor" value="${proposto.setor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>CPF:</td> 
                        <td><input type="text" name="txtCPF" value="${proposto.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Data de Nascimento:</td> 
                        <td><input type="text" name="txtDataNascimento" value="${proposto.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Email:</td> 
                        <td><input type="text" name="txtEmail" value="${proposto.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Telefone:</td> 
                        <td><input type="text" name="txtTelefone" value="${proposto.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Celular:</td> 
                        <td><input type="text" name="txtCelular" value="${proposto.celular}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Logradouro:</td> 
                        <td><input type="text" name="txtLogradouro" value="${proposto.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Numero:</td> 
                        <td><input type="text" name="txtNumero" value="${proposto.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Complemento:</td> 
                        <td><input type="text" name="txtComplemento" value="${proposto.complemento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Bairro:</td> 
                        <td><input type="text" name="txtBairro" value="${proposto.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Cidade:</td> 
                        <td><input type="text" name="txtCidade" value="${proposto.cidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>UF:</td> 
                        <td><input type="text" name="txtUF" value="${proposto.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>CEP:</td> 
                        <td><input type="text" name="txtCEP" value="${proposto.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Titulação Máxima:</td> 
                        <td><input type="text" name="txtTitulacaoMaxima" value="${proposto.titulacaoMaxima}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Banco:</td> 
                        <td><input type="text" name="txtBanco" value="${proposto.banco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Agencia:</td> 
                        <td><input type="text" name="txtAgencia" value="${proposto.agencia}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Conta:</td> 
                        <td><input type="text" name="txtConta" value="${proposto.conta}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Cargo:</td> 
                        <td><input type="text" name="txtCargo" value="${proposto.cargo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Senha:</td> 
                        <td><input type="text" name="txtSenha" value="${proposto.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td>Tipo do Proposto:</td> 
                        <td><input type="text" name="txtTipoProposto" value="${proposto.tipoProposto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
                if (!campoNumerico(form.txtCodServidor.value)) {
                    mensagem = mensagem + "Informe o Código do Servidor\n";
                }
                if (!campoNumerico(form.txtMatriculaSiape.value)) {
                    mensagem = mensagem + "Informe a Matricula SIAPE\n";
                }
                if (form.txtNome.value == "") {
                    mensagem = mensagem + "Informe o Nome do Proposto\n";
                }
                if (form.txtSetor.value == "") {
                    mensagem = mensagem + "Informe o Setor \n";
                }
                if (!campoNumerico(form.txtCPF.value)) {
                    mensagem = mensagem + "Informe o CPF \n";
                }
                if (!campoNumerico(form.txtCodCurso.value)) {
                    mensagem = mensagem + "Código do Curso deve ser numérico\n";
                }
                if (form.txtDataNascimento.value == "") {
                    mensagem = mensagem + "Digite a data de nascimento \n";
                }
                if (form.txtEmail.value = "") {
                    mensagem = mensagem + "Digite o email \n";
                }
                if (!campoNumerico(form.txtTelefone.value)) {
                    mensagem = mensagem + "Insira o número do telefone\n";
                }
                if (!campoNumerico(form.txtCelular.value)) {
                    mensagem = mensagem + "Insira o número do celular\n";
                }
                if (form.txtLogradouro.value = "") {
                    mensagem = mensagem + "Digite o logradouro \n";
                }
                if (!campoNumerico(form.txtNumero.value)) {
                    mensagem = mensagem + "Insira o número do logradouro\n";
                }
                if (form.txtComplemento.value = "") {
                    mensagem = mensagem + "Digite o complemento \n";
                }
                if (form.txtLogradouro.value = "") {
                    mensagem = mensagem + "Digite o Bairro \n";
                }
                if (form.txtCidade.value = "") {
                    mensagem = mensagem + "Digite a Cidade \n";
                }
                if (form.txtUF.value = "") {
                    mensagem = mensagem + "Digite a UF \n";
                }
                if (!campoNumerico(form.txtCEP.value)) {
                    mensagem = mensagem + "Insira o CEP \n";
                }
                if (form.txtTitulacaoMaxima.value == "") {
                    mensagem = mensagem + "Insira a titulacao Maxima\n";
                }
                if (form.txtBanco.value == "") {
                    mensagem = mensagem + "Insira o nome do banco\n";
                }
                if (!campoNumerico(form.txtAgencia.value)) {
                    mensagem = mensagem + "Insira agencia do banco\n";
                }
                if (!campoNumerico(form.txtConta.value)) {
                    mensagem = mensagem + "Insira o número da conta\n";
                }
                if (form.txtCargo.value = "") {
                    mensagem = mensagem + "Digite o cargo \n";
                }
                if (!campoNumerico(form.txtSenha.value)) {
                    mensagem = mensagem + "Insira o cargo \n";
                }




                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }

        </SCRIPT>        
    </body>
</html>