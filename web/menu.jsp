<!DOCTYPE html>
<html>
    <head>
    <style>
    body {
	padding:0px;
	margin:0px;
    }
    
    ul li { display: inline; }
    ul {
        padding:0;
	margin:0;
	float: left;
	width: 100%;
	background-color: #333;
	list-style:none;
	font:80% Tahoma;
        overflow: hidden;
        
    }

    li {
        float: left;
    }

    li a {
        display: block;
        color: white;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    li a:hover:not(.active) {
        background-color: #4CAF50;
    }

    .active {
        background-color: #4CAF50;
    }
    </style>
    </head>
    <body>
        <ul>
              <li class="active"><a href="index.jsp" target="_parent">Inicio</a></li>
              <li> <a href="PesquisaCursoController" target="_parent">Curso</a></li>
              <li> <a href="PesquisaDisciplinaController" target="_parent">Disciplina</a></li>
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
    </body>
</html>
