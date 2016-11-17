<!DOCTYPE html>

<html>
    <head>
        <title>Menu</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>

            //Criado para fazer o botÃ£o "Cadastrar" Acessar a tela de cadastro    
            function nova_Conta()
            {
                location.ref = "manterServidor.jsp";
            }
        </script>
        <style type="text/css">
	<!--
		body {
			padding:0px;
			margin:0px;
		}
 
		#menu ul {
			padding:0px;
			margin:0px;
			float: left;
			width: 100%;
			background-color:#EDEDED;
			list-style:none;
			font:80% Tahoma;
		}
 
		#menu ul li { display: inline; }
 
		#menu ul li a {
			background-color:#EDEDED;
			color: #333;
			text-decoration: none;
			border-bottom:3px solid #EDEDED;
			padding: 2px 10px;
			float:left;
		}
 
		#menu ul li a:hover {
			background-color:#D6D6D6;
			color: #6D6D6D;
			border-bottom:3px solid #EA0000;
		}
	-->
	</style>
    </head>
    <body>
	<div id="menu">
		<ul>
                   <li><a href="index.jsp" target="_parent">Inicio</a></li>
                   <!--<li> <a href="PesquisaConvidadoController" target="_parent">Convidado</a></li>-->
                   <li> <a href="PesquisaCursoController" target="_parent">Curso</a></li>
                   <!--<li> <a href="#" target="_parent">Declaracao Nota Tecnica</a></li>-->
                   <li> <a href="PesquisaDisciplinaController" target="_parent">Disciplina</a></li>
                   <!--<li> <a href="historico.jsp" target="_parent">Histórico</a></li>-->
                   <li> <a href="PesquisaOfertaController" target="_parent">Oferta</a></li>
                   <li> <a href="PesquisaPoloController" target="_parent">Polo</a></li>
                   <li> <a href="PesquisaPropostoController" target="_parent">Proposto</a></li>
                    <li><a href="PesquisaRelatorioViagemController" target="_parent">RelatorioViagem</a></li>
                    <li><a href="PesquisaSecretariaController" target="_parent">Secretaria</a></li>
                    <li><a href="PesquisaServidorController" target="_parent">Servidor</a></li>
                    <li><a href="PesquisaSolicitacaoController" target="_parent">Solicitação</a></li>
                    <li><a href="PesquisaTransporteController" target="_parent">Transporte</a></li>
                   <li> <a href="PesquisaTrimestreController" target="_parent">Trimestre</a></li>
                    <li><a href="PesquisaViagemController" target="_parent">Viagem</a></li>
                    <li><a href="sobre.jsp" target="_parent">Sobre</a></li>
                    <li><a href="" target="_parent">Contato</a></li>
		</ul>
	</div>
   
    </body>
</html>
