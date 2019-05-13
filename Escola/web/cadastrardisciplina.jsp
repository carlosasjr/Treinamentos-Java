<%-- 
    Document   : cadastrardisciplina
    Created on : 08/05/2019, 17:38:31
    Author     : Carlos-TP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Disciplinas</title>
    </head>
    <body>
        <h1>Cadastrar Disciplina</h1>

        <form name="formulario" method="post" action="salvardisciplina.jsp">
            <label>Disciplina</label>                
            <input type="text" name="nome" placeholder="Nome da Disciplina"><br>

            <label>Carga Horário</label>
            <input type="number" name="cargaHoraria" placeholder="Carga Horária"><br>

            <input type="submit" value="Salvar">                

        </form>

        <a href="listardisciplina.jsp">Ver Disciplinas</a>
    </body>
</html>
