
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
        <title>Manter Curso</title>
    </head>
    <body style= "background-color:  #e6ffe6"    >
        <!--Menu-->
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container" >

            <h1>Manter Curso - ${operacao}</h1>

            <form data-toggle="validator" role="form" action="ManterCursoController?acao=confirmar${operacao}" method="post" name="frmManterCurso" onsubmit="return validarFormulario(this)">
                <div class="form-group row-fluid"  >
                    <label for="usr" class="col-sm-2 col-form-label" >Código do curso:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Ex: 23" id="usr" name="txtCodCurso" value="${curso.codCurso}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                        </div>
                    </div>
                    <div class="form-group row-fluid" >
                        <label for="usr" class="col-sm-2 col-form-label " >Nome do curso:</label>
                        <div class="col-sm-10" >
                            <input type="text" class="form-control" placeholder="Ex: Sistemas de Informação" id="usr" name="txtNomeCurso" value="${curso.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        </div>
                        
                        <div class="form-group">
                            <label for="usr">Ano de Oferta:</label>
                            <select class="selectpicker" name="txtCodOferta" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${oferta.codOferta != null}"> selected</c:if>></option>
                            <c:forEach items="${ofertas}" var="oferta">
                                <option value="${oferta.codOferta}" <c:if test="${oferta.codOferta == curso.ofertacodOferta.codOferta}"> selected</c:if>>
                                    ${oferta.ano}
                                </option>  
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="usr">Trimestre:</label>
                        <select class="selectpicker" name="txtCodTrimestre" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${trimestre.codTrimestre != null}"> selected</c:if>></option>
                            <c:forEach items="${trimestres}" var="trimestre">
                                <option value="${trimestre.codTrimestre}" <c:if test="${trimestre.codTrimestre == curso.trimestrecodTrimestre.codTrimestre}"> selected</c:if>>
                                    ${trimestre.numeroTrimestre}
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
