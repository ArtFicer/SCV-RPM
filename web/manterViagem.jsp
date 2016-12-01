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
        <title>Sobre - SCV</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <!--Menu-->
    <nav>
        <object width="100%" height="65px" data="menu.jsp"></object>
    </nav>
    <h1>Manter Viagem - ${operacao}</h1>

    <form action="ManterViagemController?acao=confirmar${operacao}" method="post" name="frmManterViagem" onsubmit="return validarFormulario(this)">
        <table>
            <tr>
                <td><center><h2>NEaD - SCV - Viagem</h2></center></td>
            </tr>
            <tr>
                <td>Código da Viagem:</td> 
                <td><input type="text" name="txtCodViagem" value="${viagem.codViagem}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Código da Declaração de Nota Técnica:</td>
                        <td><select name="txtCodDeclaracaoNotaTecnica" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${declaracaoNotaTecnica.codDeclaracaoNotaTecnica != null}"> selected</c:if>></option>
                            <c:forEach items="${declaracaoNotaTecnicas}" var="declaracaoNotaTecnica">
                                <option value="${declaracaoNotaTecnica.codDeclaracaoNotaTecnica}" <c:if test="${declaracaoNotaTecnica.codDeclaracaoNotaTecnica == viagem.codDeclaracaoNotaTecnica}"> selected</c:if>>
                                    ${declaracaoNotaTecnica.codDeclaracaoNotaTecnica}
                                </option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Código do Relatório da Viagem:</td> 
                        <td><select name="txtCodRelatorioViagem" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${relatorioViagem.codRelatorioViagem != null}"> selected</c:if>></option>
                            <c:forEach items="${relatorioViagens}" var="relatorioViagem">
                                <option value="${relatorioViagem.codRelatorioViagem}" <c:if test="${relatorioViagem.codRelatorioViagem == viagem.codRelatorioViagem}"> selected</c:if>>
                                    ${relatorioViagem.codRelatorioViagem}
                                </option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Código do Proposto:</td> 
                        <td><select name="txtCodProposto" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${proposto.codProposto != null}"> selected</c:if>></option>
                            <c:forEach items="${propostos}" var="proposto">
                                <option value="${proposto.codProposto}" <c:if test="${proposto.codProposto == viagem.codProposto}"> selected</c:if>>
                                    ${proposto.codProposto}
                                </option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Código do Polo:</td> 
                        <td><select name="txtCodPolo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${polo.codPolo != null}"> selected</c:if>></option>
                            <c:forEach items="${polos}" var="polo">
                                <option value="${polo.codPolo}" <c:if test="${polo.codPolo == viagem.codPolo}"> selected</c:if>>
                                    ${polo.codPolo}
                                </option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Destino:</td> 
                    <td><input type="text" name="txtDestino" value="${viagem.destino}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
            </tr>
            
                    <td>Data da Viagem:</td> 
                    <td><input type="text" name="txtDataViagem" value="${viagem.dataViagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Horário de Saída:</td> 
                    <td><input type="text" name="txtHorarioSaida" value="${viagem.horarioSaida}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Status Confirmação:</td> 
                    <td><input type="text" name="txtStatusConfirmacao" value="${viagem.statusConfirmacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Status Conclusão:</td> 
                    <td><input type="text" name="txtStatusConclusao" value="${viagem.statusConclusao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Código do Transporte:</td> 
                    <td><select name="txtCodTransporte" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${transporte.codTransporte != null}"> selected</c:if>></option>
                        <c:forEach items="${transportes}" var="transporte">
                            <option value="${transporte.codTransporte}" <c:if test="${transporte.codTransporte == viagem.codTransporte}"> selected</c:if>>
                                ${transporte.codTransporte}
                            </option>  
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <!-- Comentário <tr><td><p>UF: <select name="uf"><option value="ac">AC</option><option value="al">AL</option><option value="ap">AP</option><option value="am">AM</option><option value="ba">BA</option><option value="CE">CE</option><option value="DF">DF</option><option value="ES">ES</option><option value="GO">GO</option><option value="MA">MA</option><option value="mt">MT</option><option value="ms">MS</option><option value="mg">MG</option><option value="pa">PA</option><option value="pr">PR</option><option value="pe">PI</option><option value="rj">RJ</option><option value="rn">RN</option><option value="rs">RS</option><option value="ro">RO</option><option value="rr">RR</option><option value="sc">SC</option><option value="sp">SP</option><option value="se">SE</option><option value="to">TO</option></select></td></tr>-->
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
            if (!campoNumerico(form.txtCodViagem.value)) {
                mensagem = mensagem + "Informe o Código da Viagem \n";
            }
            if (!campoNumerico(form.txtCodDeclaracaoNotaTecnica.value)) {
                mensagem = mensagem + "Informe codigo da declaracao da nota tecnica\n";
            }
            if (!campoNumerico(form.txtCodRelatorioViagem.value)) {
                mensagem = mensagem + "Informe codigo do relatorio da viagem \n";
            }
            if (!campoNumerico(form.txtCodProposto.value)) {
                mensagem = mensagem + "Código do Proposto\n";
            }
            if (!campoNumerico(form.txtCodPolo.value)) {
                mensagem = mensagem + "Insira o cod polo\n";
            }
            if (form.txtDestino.value == "") {
                mensagem = mensagem + "Insira o destino\n";
            }
            if (form.txtDataViagem.value = "") {
                mensagem = mensagem + "Digite a data da viagem \n";
            }
            if (form.txtHorarioSaida.value = "") {
                mensagem = mensagem + "Digite Horario Saida \n";
            }
            if (form.txtStatusConfirmacao.value = "") {
                mensagem = mensagem + "Digite o status da confirmacao \n";
            }

            if (form.txtStatusConclusao.value = "") {
                mensagem = mensagem + "Digite o status da conclusaoo \n";
            }
            if (!campoNumerico(form.txtCodTransporte.value)) {
                mensagem = mensagem + "Insira o codigo do transporte \n";
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
