<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Sobre - SCV</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
    <center>
        <form>
            <table width="700px">
                <tr>
                    <td><center><h2>NEaD - SCV - Viagem</h2></center></td>
                </tr>

                <tr>
                    <td>
                        <p>Servidor:  <select nome="servidor"></select>
                        <p>Local de viagem:  <select nome="local_viagem"></select>

                        <p>UF: <select name="uf">
                                <option value="ac">AC</option>
                                <option value="al">AL</option>
                                <option value="ap">AP</option>
                                <option value="am">AM</option>
                                <option value="ba">BA</option>
                                <option value="CE">CE</option>
                                <option value="DF">DF</option>
                                <option value="ES">ES</option>
                                <option value="GO">GO</option>
                                <option value="MA">MA</option>
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
                        <p>Hotel: <input type="text" name="hotel" size="14">
                    </td>
                </tr>

                <td>
                    <p>Duração da viagem em dias:  <select nome="duracao_viagem"></select>
                    <p>Data Inicio:  <input type="date" name="data_inicio">
                        Data Retorno:  <input type="date" name="data_retorno">
                    <p>Transporte:  <select nome="transporte"></select>
                    <p>Transporte adaptado:  <select nome="transporte_adaptdado">
                            <option value="s">Sim</option>
                            <option value="n">Não</option></select>
                        <p><input type="submit" name="enviar">
                </td>

               
            </table>
        </form>
    </center>
</body>
</html>
