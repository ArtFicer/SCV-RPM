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
            <h1>Menu Tempor�rio</h1>
            </tr>
            
            <tr>
                <td>
                    <a href="calendario.jsp">Calend�rioN</a>
                </td>
                <td>
                    <a href="PesquisaHistoricoController">Hist�ricoN</a>
                </td>
                <td>
                    <a href="PesquisarTrimestreController">TrimestreN</a>
                </td>
            </tr>
            
            <tr>
                <td>
                    <a href="PesquisarSolicitacaoController">Solicita��oN</a>
                </td>
                <td>
                    <a href="PesquisarRelatorioViagemController">RelatorioViagemN</a>
                </td>
                <td>
                    <a href="PesquisarPoloController">PoloN</a>
                </td>
            </tr>
            
            <tr>
                <td>
                    <a href="PesquisarOfertaController">OfertaN</a>
                </td>
                <td>
                    <a href="PesquisarEditarController">EditarServidorN</a>
                </td>
                <td>
                    <a href="PesquisarDisciplinaController">DisciplinaN</a>
                </td>
            </tr>
            
            <tr>
                <td>
                    <a href="PesquisaViagemController">ViagemN</a>
                </td>
                
                <td>
                    <a href="PesquisarPropostoController">proposto</a>
                </td>
                
                <td>
                    <a href="PesquisaServidorController">ServidorN</a>
                </td>
            </tr>

            <tr>
                <td>
                    <a href="PesquisaCursoController">Curso</a>
                </td>

                <td>
                    <a href="PesquisaPesfilController">PerfilN</a>
                </td>
                <td> 
                    <a href="PesquisarCadastroRapidoController>CadastroRapido</a>
                </td>
            </tr>
        </table>
    </center>

</body>
</html>
