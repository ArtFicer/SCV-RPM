<!DOCTYPE html>

<html>
    <head>
        <title>Inicio - SCV</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>

            //Criado para fazer o botÃ£o "Cadastrar" Acessar a tela de cadastro    
            function nova_Conta()
            {
                location.ref = "manterServidor.jsp";
            }
        </script>
        
    </head>
    <body bgcolor="#B0C4DE">
    <!--Menu-->
    <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
    

    <div class="container">
        <h2>NEaD - SCV</h2>
        <h4>Bem-Vindo ao NEaD Agendamentos</h4>
        <h6>Faça seu login ou cadastre-se</h6>
        <form>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password">
            </div>
            <div class="checkbox">
                <label><input type="checkbox"> Remember me</label>
            </div>
            <button type="submit" class="btn btn-default">Acessar</button>
            <button type="submit" class="btn btn-default" onClick="nova_Conta()">Criar Conta</button>
            <a href="recuperacaoSenha.jsp"> Recuperar Senha</a>
        </form>
    </div>

    </body>
</html>
