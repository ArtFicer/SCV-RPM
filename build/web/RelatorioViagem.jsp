
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
        <title>Relatórios de Viagem</title>
    </head>
    <body style="background-color:#e6ffe6">
        <nav>
            <object width="100%" height="65px" data="menu.jsp"></object>
        </nav>
        <div class="container" >
            <h1>Relatório de Viagem</h1>
            <form data-toggle="validator" role="form" action="RelatorioViagemController?acao=exibirRelatorio" method="post" name="frmRelatorioProposto" >
                <div class="form-group">
                    <label for="usr">Destino (O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pDestino" name="pDestino" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${viagem.destino != null}">selected</c:if>></option>
                        <c:forEach items="${viagens}" var="viagem">
                            <option value="${viagem.destino}">
                                ${viagem.destino}
                            </option>  
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="usr">Data da Viagem (O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pData" name="pData" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${viagem.dataViagem != null}">selected</c:if>></option>
                        <c:forEach items="${viagens}" var="viagem">
                            <option value="${viagem.dataViagem}">
                                ${viagem.dataViagem}
                            </option>  
                        </c:forEach>
                    </select>
                </div>      
                <div class="form-group">
                    <label for="usr">Proposto (O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pProposto" name="pProposto" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${proposto.nome != null}">selected</c:if>></option>
                        <c:forEach items="${propostos}" var="proposto">
                            <option value="${proposto.nome}">
                                ${proposto.nome}
                            </option>  
                        </c:forEach>
                    </select>
                </div>  
                <div class="form-group">
                    <label for="usr">Polo (O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pPolo" name="pPolo" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${polo.cidade != null}">selected</c:if>></option>
                        <c:forEach items="${polos}" var="polo">
                            <option value="${polo.cidade}">
                                ${polo.cidade}
                            </option>  
                        </c:forEach>
                    </select>                        
                </div>       
                <div class="form-group">
                    <label for="usr">Empresa (O preenchimento é opcional):</label>
                    <select class="selectpicker" id="pEmpresa" name="pEmpresa" onchange="bloqueiaSelect(this)">
                        <option value="" <c:if test="${transporte.empresa != null}">selected</c:if>></option>
                        <c:forEach items="${transportes}" var="transporte">
                            <option value="${transporte.empresa}">
                                ${transporte.empresa}
                            </option>  
                        </c:forEach>
                    </select>                        
                </div>                          
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Exibir Relatório</button> 
                <button class="btn btn-default" ><a href="PesquisaViagemController" target="_parent">Voltar</a></button>   
            </form>
        </div>      
        <SCRIPT language="JavaScript">

            function bloqueiaSelect(campo) {

                if (campo.name === "pDestino" && campo.value !== "") {

                    $('#pData').prop('disabled', true);
                    $('#pProposto').prop('disabled', true);
                    $('#pPolo').prop('disabled', true);
                    $('#pEmpresa').prop('disabled', true);
                    document.getElementById("pData").value = "";
                    document.getElementById("pProposto").value = "";
                    document.getElementById("pPolo").value = "";
                    document.getElementById("pEmpresa").value = "";

                } else if (campo.name === "pDestino" && document.getElementById("pDestino").value === "") {

                    $('#pData').prop('disabled', false);
                    $('#pProposto').prop('disabled', false);
                    $('#pPolo').prop('disabled', false);
                    $('#pEmpresa').prop('disabled', false);

                } else if (campo.name === "pData" && campo.value !== "") {

                    $('#pDestino').prop('disabled', true);
                    $('#pProposto').prop('disabled', true);
                    $('#pPolo').prop('disabled', true);
                    $('#pEmpresa').prop('disabled', true);
                    document.getElementById("pDestino").value = "";
                    document.getElementById("pProposto").value = "";
                    document.getElementById("pPolo").value = "";
                    document.getElementById("pEmpresa").value = "";

                } else if (campo.name === "pData" && document.getElementById("pData").value === "") {

                    $('#pDestino').prop('disabled', false);
                    $('#pProposto').prop('disabled', false);
                    $('#pPolo').prop('disabled', false);
                    $('#pEmpresa').prop('disabled', false);

                } else if (campo.name === "pProposto" && campo.value !== "") {

                    $('#pDestino').prop('disabled', true);
                    $('#pData').prop('disabled', true);
                    $('#pPolo').prop('disabled', true);
                    $('#pEmpresa').prop('disabled', true);
                    document.getElementById("pDestino").value = "";
                    document.getElementById("pData").value = "";
                    document.getElementById("pPolo").value = "";
                    document.getElementById("pEmpresa").value = "";

                } else if (campo.name === "pProposto" && document.getElementById("pProposto").value === "") {

                    $('#pDestino').prop('disabled', false);
                    $('#pData').prop('disabled', false);
                    $('#pPolo').prop('disabled', false);
                    $('#pEmpresa').prop('disabled', false);

                } else if (campo.name === "pPolo" && campo.value !== "") {

                    $('#pDestino').prop('disabled', true);
                    $('#pData').prop('disabled', true);
                    $('#pProposto').prop('disabled', true);
                    $('#pEmpresa').prop('disabled', true);
                    document.getElementById("pDestino").value = "";
                    document.getElementById("pData").value = "";
                    document.getElementById("pProposto").value = "";
                    document.getElementById("pEmpresa").value = "";

                } else if (campo.name === "pPolo" && document.getElementById("pPolo").value === "") {

                    $('#pDestino').prop('disabled', false);
                    $('#pData').prop('disabled', false);
                    $('#pProposto').prop('disabled', false);
                    $('#pEmpresa').prop('disabled', false);
                    
                } else if (campo.name === "pEmpresa" && campo.value !== "") {

                    $('#pDestino').prop('disabled', true);
                    $('#pData').prop('disabled', true);
                    $('#pProposto').prop('disabled', true);
                    $('#pPolo').prop('disabled', true);
                    document.getElementById("pDestino").value = "";
                    document.getElementById("pData").value = "";
                    document.getElementById("pProposto").value = "";
                    document.getElementById("pPolo").value = "";

                } else if (campo.name === "pEmpresa" && document.getElementById("pEmpresa").value === "") {

                    $('#pDestino').prop('disabled', false);
                    $('#pData').prop('disabled', false);
                    $('#pProposto').prop('disabled', false);
                    $('#pPolo').prop('disabled', false);
                }
            }
        </SCRIPT>  
    </body>
</html>
