<!DOCTYPE html>

<html>
    <head>
        <title>Index - SCV</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <style type="text/css">
            body {
                background-image: url('img/inicio2.jpg');
                
                background-repeat: no-repeat;
                background-size:100%;
                bottom: 0;
                color: black;
                left: 0;
                overflow: auto;
                padding: 3em;
                position: absolute;
                right: 0;
                text-align: center;
                top: 0;
                background-size: cover;
            }
        </style>
    </head>
    <body>
        <div class="login-page">
            <div class="row">
                <div class="col-md-4 col-lg-4 col-md-offset-4 col-lg-offset-4">
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <h1>NEaD - <small style="color:green !important"> SCV</small></h1>
                    <form role="form" ng-submit="submit()" action="Login" method="post">
                        <div class="form-content">
                            <div class="form-group"> <input type="email" name="email" class="form-control input-underline input-lg" placeholder="Email"> </div>
                            <div class="form-group"> <input type="password" name="pass" class="form-control input-underline input-lg" placeholder="Password"> </div>
                        </div>
                        <button type="submit" class="btn btn-white btn-outline btn-lg btn-rounded" value="login">Login</button>
                        
                    </form>
                    <form action="ManterSecretariaController?acao=prepararIncluir" method="post">
                <button type="submit" class="btn btn-default" name="btnIncluir" value="Cadastrar">Incluir</button>
            </form>
                </div>
            </div>
        </div>
    
    <!--<div class="login-page">
    <div class="container">
        <h2>NEaD - SCV</h2>
        <h4>Bem-Vindo ao NEaD Agendamentos</h4>
        <h6>Faça seu login ou cadastre-se</h6>
        <form action="Login" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" name="email" class="form-control" id="email" placeholder="Enter email">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" name="pass" class="form-control" id="pwd" placeholder="Enter password">
            </div>
            <div class="checkbox">
                <label><input type="checkbox"> Remember me</label>
            </div>
            <button type="submit" class="btn btn-default" value="login">Acessar</button>
            <button type="submit" class="btn btn-default" onClick="nova_Conta()">Criar Conta</button>
            <a href="recuperacaoSenha.jsp"> Recuperar Senha</a>
        </form>
    </div>
    </div>-->
    </body>
</html>
