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
        
    </head>
    <body>
    <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
    <center>
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
                <td>Senha: <input type="password" name="senha" size="30"></td>
            </tr>
            <tr>
                <td>
                    <button>Acessar</button>
                    <button onClick="nova_Conta()">Criar Conta</button>
                    <a href="recuperacaoSenha.jsp"> Recuperar Senha</a>
                </td> 
            </tr>

        </table>
        </center>
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
