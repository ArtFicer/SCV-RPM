<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>NEAD - SCV - Perfil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!--Menu-->
        <nav>
          <object width="100%" height="65px" data="menu.jsp"></object>
     </nav>
    <center>
        <form>
            <table width="700px">
                <tr>
                    <td><center><h2>NEaD - SCV - Perfil</h2></center></td>
                </tr>
                <tr>
                    <td>
                        <p>Nome:  <input type="text" name="nome" size="30">
                        <p>Logradouro: <input type="text" name="logradouro" size="30">
                        <p>Complemento: <input type="text" name="complemento" size="20">
                        <p>Cep: <input type="text" name="cep" size="8">
                        <p>Email: <input type="email" name="email" size="30">
                    </td>
                    <td>
                        <p>Nascimento:  <input type="date" name="nascimento" >
                        <p>N�: <input type="text" name="numero_logradouro" size="5">
                        <p>Bairro: <input type="text" name="bairro" size="15">
                        <p>UF: <select name="uf">
                                <option value="ac">AC</option>
                                <option value="al">AL</option>
                                <option value="ap">AP</option>
                                <option value="am">AM</option>
                                <option value="ba">BA</option>
                                <option value="ce">CE</option>
                                <option value="df">DF</option>
                                <option value="es">ES</option>
                                <option value="go">GO</option>
                                <option value="ma">MA</option>
                                <option value="mt">MT</option>
                                <option value="ms">MS</option>
                                <option value="mg">MG</option>
                                <option value="pa">PA</option>
                                <option value="pb">PB</option>
                                <option value="pr">PR</option>
                                <option value="pe">PI</option>
                                <option value="rj">RJ</option>
                                <option value="rn">RN</option>
                                <option value="rs">RS</option>
                                <option value="ro">RO</option>
                                <option value="rr">RR</option>
                                <option value="sc">SC</option>
                                <option value="sp">SP</option>
                                <option value="se">SE</option>
                                <option value="to">TO</option>
                            </select>
                        <p>Cidade: <input type="text" name="cidade" size="24">
                        <p>Senha: <input type="password" name="senha" size="14">
                    </td>
                </tr>

                <tr>
                    <td>
                        <p><h4>Proposto (Benefici�rio)</h4>
                        <p><input type="radio" name="proposto" value="servidor"> Servidor 
                        <p><input type="radio" name="proposto" value="convidado"> Convidado
                        <p><input type="radio" name="proposto" value="colaborador"> Colaborador 
                        <p><input type="radio" name="proposto" value="acessor especial"> Acessor Especial 
                        <p><input type="radio" name="proposto" value="outro"> Outro <input type="text" name="outro" size="15">
                    </td>
                </tr>

                <td>
                    <p>RG:  <input type="text" name="rg" size="10">
                    <p>Org�o Expedidor:  <input type="text" name="rg" size="8">
                    <p>Data de Expedi��o:  <input type="date" name="data_expedicao">
                    <p>Setor: <input type="text" name="logradouro" size="20">
                    <p>Cargo: <input type="text" name="logradouro" size="10">
                    <p>Titula��o M�xima: <input type="text" name="titulacao" size="15">
                    <p>SIAPE: <input type="text" name="matricula_siape" size="11">
                    <p><input type="submit" name="enviar">
                </td>

                <td>
                    <p>CPF: <input type="text" name="complemento" size="11">
                    <p>Banco: <input type="text" name="cep" size="15">
                    <p>N� Ag�ncia : <input type="text" name="numero_agencia" size="8">
                    <p>Conta Corrente: <input type="text" name="conta_corrente" size="11">
                    <p>Telefone: <input type="text" name="nome" size="11" >
                    <p>Celular: <input type="text" name="celular" size="11" >

                </td>
            </table>
        </form>
    </center>
    </body>
</html>
