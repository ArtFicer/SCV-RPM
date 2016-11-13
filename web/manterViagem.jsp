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
                    <td><input type="text" name="txtCodDeclaracaoNotaTecnica" value="${viagem.codDeclaracaoNotaTecnica}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Código do Relatório da Viagem:</td> 
                    <td><input type="text" name="txtCodRelatorioViagem" value="${viagem.codRelatorioViagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Código do Proposto:</td> 
                    <td><input type="text" name="txtCodProposto" value="${viagem.codProposto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Código do Polo:</td> 
                    <td><input type="text" name="txtCodPolo" value="${viagem.codPolo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Destino:</td> 
                    <td><input type="text" name="txtDestino" value="${viagem.destino}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
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
                    <td><input type="text" name="txtCodTransporte" value="${viagem.codTransporte}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <!--    Comentário
                <tr>
                    <td>
                    <p>UF: <select name="uf">
                                <option value="ac">AC</option>
                                <option value="al">AL</option>
                                <option value="ap">AP</option>
                                <option value="am">AM</option>
                                <option value="ba">BA</option>
                                <option value="CE">CE</option>
                                <option value="DF">DF</option>
                                <option value="ES">ES</option>
                                <option value="GO">GO</option>
                                <option value="MA">MA</option>
                                <option value="mt">MT</option>
                                <option value="ms">MS</option>
                                <option value="mg">MG</option>
                                <option value="pa">PA</option>
                                <option value="pb">PB</option>
                                <option value="pr">PR</option>
                                <option value="pe">PI</option>
                                <option value="rj">RJ</option>
                                <option value="rn">RN</option>
                                <option value="rs">RS</option>
                                <option value="ro">RO</option>
                                <option value="rr">RR</option>
                                <option value="sc">SC</option>
                                <option value="sp">SP</option>
                                <option value="se">SE</option>
                                <option value="to">TO</option>
                            </select>
                    </td>
                </tr>
                -->
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
        
                
</body>
</html>
