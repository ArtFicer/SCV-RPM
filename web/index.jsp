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
                    <a href="historico.jsp">Hist�ricoN</a>
                </td>
                <td>
                    <a href="pesquisarTrimestre.jsp">TrimestreN</a>
                </td>
            </tr>
            
            <tr>
                <td>
                    <a href="pesquisarSolicitacao.jsp">Solicita��oN</a>
                </td>
                <td>
                    <a href="pesquisarRelatorioViagem.jsp">RelatorioViagemN</a>
                </td>
                <td>
                    <a href="pesquisarPolo.jsp">PoloN</a>
                </td>
            </tr>
            
            <tr>
                <td>
                    <a href="pesquisarOferta.jsp">OfertaN</a>
                </td>
                <td>
                    <a href="pesquisarEditarServidor.jsp">EditarServidorN</a>
                </td>
                <td>
                    <a href="pesquisarDisciplina.jsp">DisciplinaN</a>
                </td>
            </tr>
            
            <tr>
                <td>
                    <a href="pesquisaViagem.jsp">ViagemN</a>
                </td>
                
                <td>
                    <a href="pesquisarProposto.jsp">proposto</a>
                </td>
                
                <td>
                    <a href="pesquisaServidor.jsp">ServidorN</a>
                </td>
            </tr>

            <tr>
                <td>
                    <a href="PesquisaCursoController">Curso</a>
                </td>

                <td>
                    <a href="perfil.jsp">PerfilN</a>
                </td>
                <td> 
                    <a href="pesquisarCadastroRapido.jsp">CadastroRapido</a>
                </td>
            </tr>
        </table>
    </center>

</body>
</html>
