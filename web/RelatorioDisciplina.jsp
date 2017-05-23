
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
        <title>Relatórios de Disciplina</title>
    </head>
    <body style="background-color:#e6ffe6">
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container" >
            <h1>Relatório de Disciplina</h1>
            <form data-toggle="validator" role="form" action="RelatorioDisciplinaController?acao=exibirRelatorio" method="post" name="frmRelatorioCurso" >
                <div class="form-group">
                    <label for="usr">Nome da Disciplina(O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pNome" name="pNome" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${disciplina.nome != null}">selected</c:if>></option>
                        <c:forEach items="${disciplinas}" var="disciplina">
                            <option value="${disciplina.nome}">
                                ${disciplina.nome}
                            </option>  
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Trimestre(O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pTrimestre" name="pTrimestre" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${trimestre.numeroTrimestre != null}">selected</c:if>></option>
                        <c:forEach items="${trimestres}" var="trimestre">
                            <option value="${trimestre.numeroTrimestre}">
                                ${trimestre.numeroTrimestre}
                            </option>  
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Exibir Relatório</button> 
                <button class="btn btn-default" ><a href="PesquisaDisciplinaController" target="_parent">Voltar</a></button>   
            </form>
        </div>        

        <SCRIPT language="JavaScript">

            function bloqueiaSelect(campo) {

                if (campo.name === "pNome" && campo.value !== "") {

                    $('#pTrimestre').prop('disabled', true);
                    document.getElementById("pTrimestre").value = "";

                } else if (campo.name === "pNome" && document.getElementById("pNome").value === "") {

                    $('#pTrimestre').prop('disabled', false);

                } else if (campo.name === "pTrimestre" && campo.value !== "") {

                    $('#pNome').prop('disabled', true);
                    document.getElementById("pNome").value = "";

                } else if (campo.name === "pTrimestre" && document.getElementById("pTrimestre").value === "") {

                    $('#pNome').prop('disabled', false);
                }
            }
        </SCRIPT>   
    </body>
</html>
