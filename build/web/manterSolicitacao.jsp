
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
            <h1>Manter Solicitações - ${operacao}</h1>

            <form action="ManterSolicitacaoController?acao=confirmar${operacao}" method="post" name="frmManterSolicitacao" onsubmit="return validarFormulario(this)">

                <div class="form-group">
                    <label for="usr">Código da Solicitaçao:</label>
                    <input type="text" class="form-control" id="usr" name="txtCodSolicitacao" placeholder="Ex: 23" value="${solicitacao.codSolicitacao}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Assunto:</label>
                        <input type="text" class="form-control" id="usr" name="txtAssunto" placeholder="Ex: Datashow"value="${solicitacao.assunto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="comment">Texto:</label>
                        <textarea class="form-control" rows="5" id="comment" name="txtTexto" placeholder="Ex: Venho solicitar por meio deste um datashow para a viagem do dia 23/01/17" value="${solicitacao.texto}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>${solicitacao.texto}</textarea>
                    </div>
                    <div class="form-group">
                        <label for="usr">Nome do Proposto:</label>
                        <select class="selectpicker" name="txtCodProposto" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${proposto.codProposto != null}"> selected</c:if>></option>
                        <c:forEach items="${propostos}" var="proposto">
                            <option value="${proposto.codProposto}" <c:if test="${proposto.codProposto == solicitacao.propostocodProposto.codProposto}"> selected</c:if>>
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

                //Codigo Solicitacoes
                if (!campoNumerico(form.txtCodSolicitacoes.value)) {
                    mensagem = mensagem + "Informe o Código da Solicitaçao válido\n";
                }
                if (form.txtCodSolicitacoes.value === "") {
                    mensagem = mensagem + "Informe o código\n";
                }

                //Assunto
                if (form.txtAssunto.value === "") {
                    mensagem = mensagem + "Informe o Assunto\n";
                }

                //Texto
                if (form.txtTexto.value === "") {
                    mensagem = mensagem + "Informe o Texto\n";
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