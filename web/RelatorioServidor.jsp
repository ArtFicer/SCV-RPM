
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
        <title>Relatórios de Servidor</title>
    </head>
    <body style="background-color:#e6ffe6">
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container" >
            <h1>Relatório de Servidor</h1>
            <form data-toggle="validator" role="form" action="RelatorioServidorController?acao=exibirRelatorio" method="post" name="frmRelatorioProposto" >
                <div class="form-group">
                    <label for="usr">SIAPE (O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pMatricula" name="pMatricula">
                        <option value="" <c:if test="${servidor.matriculaSIAPE != null}">selected</c:if>></option>
                        <c:forEach items="${servidores}" var="servidor">
                            <option value="${servidor.matriculaSIAPE}">
                                ${servidor.matriculaSIAPE}
                            </option>  
                        </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Exibir Relatório</button> 
                <button class="btn btn-default" ><a href="PesquisaServidorController" target="_parent">Voltar</a></button>   
            </form>
        </div>        
    </body>
</html>
