<!DOCTYPE html>

<html>
    <head>
        <title>Inicio - SCV</title>
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

        <table> 
            <tr>
                <td><center><h2>NEaD - SCV - Início</h2></center></td>
            </tr>
            <tr>
                <td>Bem vindo ao nead agendamentos!</td>
            </tr>
            <td>Faça seu login ou cadastre-se</td>
            <tr>
                <td>Email: <input type="email" name="email" size="30"> </td>
            </tr>
            <tr>
                <td>Senha: <input type='password' name='senha' size='30'></td>
            </tr>
            <tr>
                <td>
                    <button>Acessar</button>
                    <button onClick="nova_Conta()">Criar Conta</button>
                    <a href="recuperacaoSenha.jsp"> Recuperar Senha</a>
                </td> 
            </tr>

        </table>
        <!--<table>

            <tr>
            <h1 >Menu Temporário</h1>
            </tr>

            <tr>
                <td>
                    <a href="PesquisaConvidadoController">Convidado</a>
                </td>
                <td>
                    <a href="PesquisaCursoController">Curso</a>
                </td>
                <td>
                    <a href="#">(Não Existe)Declaracao Nota Tecnica</a>

                </td>
            </tr>

            <tr>
                <td>
                    <a href="PesquisaDisciplinaController">Disciplina</a>
                </td>
                <td>
                    <a href="historico.jsp">Histórico</a>
                </td>
                <td>
                    <a href="PesquisaOfertaController">Oferta</a>

                </td>
            </tr>

            <tr>
                <td>
                    <a href="PesquisaPoloController">Polo</a>
                </td>

                <td>
                    <a href="PesquisaPropostoController">Proposto</a>
                </td>

                <td>
                    <a href="PesquisaRelatorioViagemController">RelatorioViagem</a>

                </td>
            <tr>
                <td>
                    <a href="PesquisaSecretariaController">Secretaria</a>
                </td>

                <td>
                    <a href="PesquisaServidorController">Servidor</a>
                </td>

                <td>
                    <a href="PesquisaSolicitacaoController">Solicitação</a>
                </td>               
            </tr>

            <tr>
                <td>
                    <a href="PesquisaTransporteController">Transporte</a>
                </td>

                <td>
                    <a href="PesquisaTrimestreController">Trimestre</a>
                </td>

                <td>
                    <a href="PesquisaViagemController">Viagem</a>
                </td>               
            </tr>


        </table>-->

    </body>
</html>
