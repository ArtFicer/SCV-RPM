
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Manter Viagem - SCV</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <h1>Manter Viagem - ${operacao}</h1>

            <form action="ManterViagemController?acao=confirmar${operacao}" method="post" name="frmManterViagem" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Código da Viagem:</label>
                    <input type="text" maxlength=6 class="form-control" placeholder="Ex: 23" id="usr" name="txtCodViagem" value="${viagem.codViagem}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Código do Relatório da Viagem:</label>
                        <select class="selectpicker" name="txtCodRelatorioViagem"  <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${relatorioViagem.codRelatorioViagem != null}"> selected</c:if>></option>
                        <c:forEach items="${relatorioViagens}" var="relatorioViagem">
                            <option value="${relatorioViagem.codRelatorioViagem}" <c:if test="${relatorioViagem.codRelatorioViagem == viagem.relatorioviagemcodRelatorioViagem.codRelatorioViagem}"> selected</c:if>>
                                ${relatorioViagem.codRelatorioViagem}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Nome do Proposto:</label>
                    <select class="selectpicker" name="txtCodProposto" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${proposto.codProposto != null}"> selected</c:if>></option>
                        <c:forEach items="${propostos}" var="proposto">
                            <option value="${proposto.codProposto}" <c:if test="${proposto.codProposto == viagem.propostocodProposto.codProposto}"> selected</c:if>>
                                ${proposto.nome}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Código do Polo:</label>
                    <select class="selectpicker" name="txtCodPolo" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${polo.codPolo != null}"> selected</c:if>></option>
                        <c:forEach items="${polos}" var="polo">
                            <option value="${polo.codPolo}" <c:if test="${polo.codPolo == viagem.polocodPolo.codPolo}"> selected</c:if>>
                                ${polo.codPolo}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Destino:</label>
                    <input type="text" class="form-control" id="usr" name="txtDestino" placeholder="Ex: Muriaé" value="${viagem.destino}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Data da Viagem:</label>
                        <div class="input-append date form_datetime">
                            <input size="16" type="text" class="form-control" id="usr" name="date" name="txtDataViagem"  value="${viagem.dataViagem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <span class="add-on"><i class="icon-th"></i></span>
                        </div>

                        <script type="text/javascript">
                            $(".form_datetime").datetimepicker({
                                format: "dd MM yyyy - hh:ii",
                                autoclose: true,
                                todayBtn: true,
                                pickerPosition: "bottom-left"
                            });
                        </script>
                    </div>
                    <div class="form-group">
                        <label for="usr">Horário de Saída:</label>
                        <input type="text" class="form-control" id="usr" name="txtHorarioSaida" placeholder="Ex: 19" value="${viagem.horarioSaida}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Status Confirmação:</label>
                        <input type="text" class="form-control" id="usr" name="txtStatusConfirmacao" placeholder="Ex: Confimado" value="${viagem.statusConfirmacao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Status Conclusão:</label>
                        <input type="text" class="form-control" id="usr" name="txtStatusConclusao"  placeholder="Ex: Em andamento"value="${viagem.statusConclusao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Empresa do Transporte:</label>
                        <select class="selectpicker" name="txtCodTransporte" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${transporte.codTransporte != null}"> selected</c:if>></option>
                        <c:forEach items="${transportes}" var="transporte">
                            <option value="${transporte.codTransporte}" <c:if test="${transporte.codTransporte == viagem.transportecodTransporte.codTransporte}"> selected</c:if>>
                                ${transporte.empresa}
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
                //Codigo Viagem
                if (form.txtCodViagem.value === "") {
                    mensagem = mensagem + "Informe o Código da Viagem \n";
                }

                //Codigo Declaracao Nota Tecnica
                if (form.txtCodDeclaracaoNotaTecnica.value === "") {
                    mensagem = mensagem + "Informe codigo da declaracao da nota tecnica\n";
                }

                //Codigo Relatorio Viagem
                if (form.txtCodRelatorioViagem.value === "") {
                    mensagem = mensagem + "Informe codigo do relatorio da viagem \n";
                }

                //Codigo Proposto
                if (form.txtCodProposto.value === "") {
                    mensagem = mensagem + "Código do Proposto\n";
                }

                //Codigo Polo
                if (form.txtCodPolo.value === "") {
                    mensagem = mensagem + "Insira o cod polo\n";
                }

                //Destino
                if (form.txtDestino.value === "") {
                    mensagem = mensagem + "Insira o destino\n";
                }

                //Data Viagem
                if (form.txtDataViagem.value === "") {
                    mensagem = mensagem + "Digite a data da viagem \n";
                }

                //Horario de Saida
                if (form.txtHorarioSaida.value === "") {
                    mensagem = mensagem + "Digite Horario Saida \n";
                }

                // Status Confirmação
                if (form.txtStatusConfirmacao.value === "") {
                    mensagem = mensagem + "Digite o status da confirmacao \n";
                }

                //Status Conclusao
                if (form.txtStatusConclusao.value === "") {
                    mensagem = mensagem + "Digite o status da conclusaoo \n";
                }

                //Codigo Transporte
                if (form.txtCodTransporte.value === "") {
                    mensagem = mensagem + "Insira o codigo do transporte \n";
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
