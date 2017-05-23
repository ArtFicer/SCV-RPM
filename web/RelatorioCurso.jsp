
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
        <title>Relatórios de Curso</title>
    </head>
    <body style="background-color:#e6ffe6">
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container" >
            <h1>Relatório de Curso</h1>
            <form data-toggle="validator" role="form" action="RelatorioCursoController?acao=exibirRelatorio" method="post" name="frmRelatorioCurso" >
                <div class="form-group">
                    <label for="usr">Nome(O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pNome" name="pNome" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${curso.nome != null}">selected</c:if>></option>
                        <c:forEach items="${cursos}" var="curso">
                            <option value="${curso.nome}">
                                ${curso.nome}
                            </option>  
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Ano de Oferta(O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pAno" name="pAno" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${oferta.ano != null}">selected</c:if>></option>
                        <c:forEach items="${ofertas}" var="oferta">
                            <option value="${oferta.ano}">
                                ${oferta.ano}
                            </option>  
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Polo(O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pPolo" name="pPolo" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${polo.cidade != null}">selected</c:if>></option>
                        <c:forEach items="${polos}" var="polo">
                            <option value="${polo.cidade}">
                                ${polo.cidade}
                            </option>  
                        </c:forEach>
                    </select>
                </div>                        
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Exibir Relatório</button> 
                <button class="btn btn-default" ><a href="PesquisaCursoController" target="_parent">Voltar</a></button>   
            </form>
        </div>    

        <SCRIPT language="JavaScript">

            function bloqueiaSelect(campo) {

                if (campo.name === "pNome" && campo.value !== "") {

                    $('#pAno').prop('disabled', true);
                    $('#pPolo').prop('disabled', true);
                    document.getElementById("pAno").value = "";
                    document.getElementById("pPolo").value = "";

                } else if (campo.name === "pNome" && document.getElementById("pNome").value === "") {

                    $('#pAno').prop('disabled', false);
                    $('#pPolo').prop('disabled', false);

                } else if (campo.name === "pPolo" && campo.value !== "") {

                    $('#pAno').prop('disabled', true);
                    $('#pNome').prop('disabled', true);
                    document.getElementById("pAno").value = "";
                    document.getElementById("pNome").value = "";

                } else if (campo.name === "pPolo" && document.getElementById("pPolo").value === "") {

                    $('#pAno').prop('disabled', false);
                    $('#pNome').prop('disabled', false);

                } else if (campo.name === "pAno" && campo.value !== "") {

                    $('#pPolo').prop('disabled', true);
                    $('#pNome').prop('disabled', true);
                    document.getElementById("pNome").value = "";
                    document.getElementById("pPolo").value = "";

                } else if (campo.name === "pAno" && document.getElementById("pAno").value === "") {
                    $('#pPolo').prop('disabled', false);
                    $('#pNome').prop('disabled', false);
                }

            }

        </SCRIPT>        
    </body>
</html>

