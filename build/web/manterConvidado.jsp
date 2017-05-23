
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
        <!--<link rel="stylesheet" type="text/css" media="screen" href="css/pagina.css" />
        <link rel="canonical" href="http://www.alessioatzeni.com/wp-content/tutorials/html-css/CSS3-Loading-Animation/index.html" />-->
        <title>Manter Convidado</title>
    </head>
    <body style= "background-color:  #e6ffe6"    >
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container" >

            <h1>Manter Convidado - ${operacao}</h1>

            <form data-toggle="validator" role="form" action="ManterConvidadoController?acao=confirmar${operacao}" method="post" name="frmManterConvidado" onsubmit="return validarFormulario(this)">
                <div class="form-group row-fluid"  >
                    <label for="usr" class="col-sm-2 col-form-label" >Código do Convidado:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="" id="usr" name="txtCodConvidado" value="${convidado.codConvidado}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </div>
                    </div>
                    <div class="form-group row-fluid" >
                        <label for="usr" class="col-sm-2 col-form-label " >Matricula SIAPE:</label>
                        <div class="col-sm-10" >
                            <input type="text" class="form-control" placeholder="" id="usr" name="txtMatriculaSIAPE" value="${convidado.matriculaSIAPE}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>

                        <div class="form-group">
                            <label for="usr">Nome do Proposto:</label>
                            <select class="selectpicker" name="txtCodProposto" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${proposto.codProposto != null}"> selected</c:if>></option>
                            <c:forEach items="${propostos}" var="proposto">
                                <option value="${proposto.codProposto}" <c:if test="${proposto.codProposto == convidado.propostocodProposto.codProposto}"> selected</c:if>>
                                    ${proposto.nome}
                                </option>  
                            </c:forEach>
                        </select>
                    </div>
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
                var mensagem = "";
                if (form.txtCodCurso.value === "") {
                    mensagem = mensagem + "Informe o Código\n";
                }
                if (form.txtNomeCurso.value === "") {
                    mensagem = mensagem + "Informe o nome do curso\n";
                }
                if (!campoNumerico(form.txtCodCurso.value)) {
                    mensagem = mensagem + "Informe o Código do Curso\n";
                }
                if (form.txtNomeCurso.value === "") {
                    mensagem = mensagem + "Insira um nome válido \n";
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
