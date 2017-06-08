
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
        <title>Manter Disciplina</title>
    </head>
    <body>
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container">
            <h1>Manter Disciplina - ${operacao}</h1>

            <form action="ManterDisciplinaController?acao=confirmar${operacao}" method="post" name="frmManterDisciplina" onsubmit="return validarFormulario(this)">
                <div class="form-group">
                    <label for="usr">Código do Disciplina:</label>
                    <input type="text" maxlength=6 class="form-control" id="usr" name="txtCodDisciplina" placeholder="Ex: 23" value="${disciplina.codDisciplina}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Nome da Disciplina:</label>
                        <input type="text" class="form-control" id="usr" name="txtNomeDisciplina" placeholder="Ex: Portugues Instrumental" value="${disciplina.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                    </div>
                    <div class="form-group">
                        <label for="usr">Trimestre:</label>
                        <select class="selectpicker" name="txtCodTrimestre" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <option value="0" <c:if test="${trimestre.codTrimestre != null}"> selected</c:if>></option>
                        <c:forEach items="${trimestres}" var="trimestre">
                            <option value="${trimestre.codTrimestre}" <c:if test="${trimestre.codTrimestre == disciplina.trimestrecodTrimestre.codTrimestre}"> selected</c:if>>
                                ${trimestre.numeroTrimestre}
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
                if (form.txtCodDisciplina.value === "") {
                    mensagem = mensagem + "Informe o Código da Disciplina\n";
                }
                if (form.txtNomeDisciplina.value === "") {
                    mensagem = mensagem + "Informe o Nome do Disciplina\n";
                }
                if (!campoNumerico(form.txtCodDisciplina)) {
                    mensagem = mensagem + "O código deve ser numérico\n";
                }
                if (!campoNumerico(form.txtNomeDisciplina)) {
                    mensagem = mensagem + "O nome não pode ser numérico\n";
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
