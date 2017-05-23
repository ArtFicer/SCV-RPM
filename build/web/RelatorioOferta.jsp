
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
        <title>Relatórios de Oferta</title>
    </head>
    <body style="background-color:#e6ffe6">
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container" >
            <h1>Relatório de Oferta</h1>
            <form data-toggle="validator" role="form" action="RelatorioOfertaController?acao=exibirRelatorio" method="post" name="frmRelatorioOferta" >
                <div class="form-group">
                    <label for="usr">Polo (O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pPolo" name="pPolo" onchange="bloqueiaSelect(this)">
                        <option value ="" <c:if test="${polo.cidade != null}">selected</c:if>></option>
                        <c:forEach items="${polos}" var="polo">
                            <option value="${polo.cidade}">
                                ${polo.cidade}
                            </option>  
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Ano de Oferta (O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pAno" name="pAno" onchange="bloqueiaSelect(this)" >
                        <option value ="" <c:if test="${oferta.ano != null}">selected</c:if>></option>
                        <c:forEach items="${ofertas}" var="oferta">
                            <option value="${oferta.ano}">
                                ${oferta.ano}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Exibir Relatório</button> 
                <button class="btn btn-default" ><a href="PesquisaOfertaController" target="_parent">Voltar</a></button>   
            </form>
        </div>     
        <SCRIPT language="JavaScript">

            function bloqueiaSelect(campo) {

                if (campo.name === "pPolo" && campo.value !== "") {

                    $('#pAno').prop('disabled', true);
                    document.getElementById("pAno").value = "";

                } else if (campo.name === "pPolo" && document.getElementById("pPolo").value === "") {

                    $('#pAno').prop('disabled', false);

                } else if (campo.name === "pAno" && campo.value !== "") {

                    $('#pPolo').prop('disabled', true);
                    document.getElementById("pPolo").value = "";

                } else if (campo.name === "pAno" && document.getElementById("pAno").value === "") {

                    $('#pPolo').prop('disabled', false);
                }
            }
        </SCRIPT>      
    </body>
</html>
