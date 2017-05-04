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
                    <label for="usr">Parâmetro de Busca (O preenchimento é opcional):</label>
                    <select class="selectpicker" name="parametroBusca">
                        <option value="" <c:if test="${curso.nome != null}">selected</c:if>></option>
                            <c:forEach items="${cursos}" var="curso">
                                <option value="${curso.nome}">
                                    ${curso.nome}
                                </option>  
                            </c:forEach>
                    </select>
                </div>
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Exibir Relatório</button> 
                <button class="btn btn-default" ><a href="PesquisaCursoController" target="_parent">Voltar</a></button>   
            </form>
        </div>        
    </body>
</html>

