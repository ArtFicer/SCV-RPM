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
                   <li><a href="index.jsp">Inicio</a></li>
                   <li> <a href="PesquisaConvidadoController">Convidado</a></li>
                   <li> <a href="PesquisaCursoController">Curso</a></li>
                   <li> <a href="#">Declaracao Nota Tecnica</a></li>
                   <li> <a href="PesquisaDisciplinaController">Disciplina</a></li>
                   <li> <a href="historico.jsp">Histórico</a></li>
                   <li> <a href="PesquisaOfertaController">Oferta</a></li>
                   <li> <a href="PesquisaPoloController">Polo</a></li>
                   <li> <a href="PesquisaPropostoController">Proposto</a></li>
                    <li><a href="PesquisaRelatorioViagemController">RelatorioViagem</a></li>
                    <li><a href="PesquisaSecretariaController">Secretaria</a></li>
                    <li><a href="PesquisaServidorController">Servidor</a></li>
                    <li><a href="PesquisaSolicitacaoController">Solicitação</a></li>
                    <li><a href="PesquisaTransporteController">Transporte</a></li>
                   <li> <a href="PesquisaTrimestreController">Trimestre</a></li>
                    <li><li><a href="PesquisaViagemController">Viagem</a></li>
                    <li><a href="sobre.jsp">Sobre</a></li>
                    <li><a href="">Contato</a></li>
		</ul>
	</div>
   
    </body>
</html>
