<!DOCTYPE html>

<html>
    <head>
        <title>Inicio - SCV</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>

            //Criado para fazer o botão "Cadastrar" Acessar a tela de cadastro    
            function nova_Conta()
            {
                location.ref = "manterServidor.jsp";
            }
        </script>
    </head>
    <body>

    <center>
        <table> 
            <tr>
                <td><center><h2>NEaD - SCV - In�cio</h2></center></td>
            </tr>
            <tr>
                <td>
                    <a href="index.jsp">Inicio</a>   
                    <a href="sobre.jsp">Sobre</a>
                </td>
            </tr>
            <tr>
                <td>Bem vindo ao nead agendamentos!</td>
            </tr>
            <td>Fa�a seu login ou cadastre-se</td>
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
        <table>

            <tr>
            <h1>Menu Tempor�rio Pesquisar</h1>
            </tr>

            <tr>
                <td>
                    <a href="PesquisaCursoController">Curso</a>
                </td>
                <td>
                    <a href="historico.jsp">Hist�ricoN</a>
                </td>
                <td>
                    <a href="PesquisaTrimestreController">Trimestre</a>
                </td>
            </tr>

            <tr>
                <td>
                    <a href="PesquisaSolicitacaoController">Solicita��o</a>
                </td>
                <td>
                    <a href="PesquisaRelatorioViagemController">RelatorioViagem</a>
                </td>
                <td>
                    <a href="PesquisaPoloController">Polo</a>
                </td>
            </tr>

            <tr>
                <td>
                    <a href="PesquisaViagemController">Viagem</a>
                </td>

                <td>
                    <a href="PesquisaPropostoController">Proposto</a>
                </td>

                <td>
                    <a href="PesquisaServidorController">Servidor</a>
                </td>
            <tr>
                <td>
                    <a href="PesquisaOfertaController">Oferta</a>
                </td>

                <td>
                    <a href="PesquisaDisciplinaController">Disciplina</a>
                </td>
            </tr>

           
        </table>

    </body>
</html>
