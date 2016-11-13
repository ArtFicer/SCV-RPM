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
                    <td>Código do Servidor:</td> 
                    <td><input type="text" name="txtCodServidor" value="${proposto.codServidor}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Código da Secretaria:</td> 
                    <td><input type="text" name="txtCodSecretaria" value="${proposto.codSecretaria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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
            <!--
            
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
                if (form.txtCodServidor.value == ""){
                    mensagem = mensagem + "Informe o Código do Servidor\n";
                }                             
                if (form.txtMatriculaSiape.value == ""){
                    mensagem = mensagem + "Informe a Matricula SIAPE\n";
                }   
                if (form.txtLotadoOrgao.value == ""){
                    mensagem = mensagem + "Informe o Orgao\n";
                } 
                if (form.txtTotalPeriodos.value == ""){
                    mensagem = mensagem + "Informe o Total de Períodos\n";
                }                  
                if (form.txtCargaHoraria.value == ""){
                    mensagem = mensagem + "Informe a Carga Horária\n";
                }                  
                if (!campoNumerico(form.txtCodCurso.value)){
                    mensagem = mensagem + "Código do Curso deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtTotalPeriodos.value)){
                    mensagem = mensagem + "Total de Períodos deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtCargaHoraria.value)){
                    mensagem = mensagem + "Carga Horária deve ser numérica\n";
                }                  
                if (mensagem == ""){
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