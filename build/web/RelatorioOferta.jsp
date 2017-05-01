<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form data-toggle="validator" role="form" action="RelatorioOfertaController" method="post" name="frmRelatorioOferta" >
                <div class="form-group row-fluid"  >
                    <label for="usr" class="col-sm-2 col-form-label" >Nome do Relatório:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" placeholder="Ex: Oferta" id="usr" name="nomeRelatorio">
                    </div>
                </div>
                <div class="form-group row-fluid" >
                    <label for="usr" class="col-sm-2 col-form-label " >Parâmetro de Busca:</label>
                    <div class="col-sm-10" >
                        <input type="text" class="form-control" placeholder="Ex: 2016" id="usr" name="parametroBusca">
                    </div>
                </div>
                <button type="submit" class="btn btn-default" name="btnRelatorio" value="Exibir">Exibir Relatório</button> 
                <button class="btn btn-default" ><a href="PesquisaOfertaController" target="_parent">Voltar</a></button>   
            </form>
        </div>        
    </body>
</html>
