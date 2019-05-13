<%-- 
    Document   : listardisciplina
    Created on : 09/05/2019, 15:03:26
    Author     : Carlos-TP
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.io.File"%>
<%@page import="com.thoughtworks.xstream.XStream"%>
<%@page import="escola.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Disciplinas</title>
    </head>
    <body>
        <h1>Disciplinas!</h1>

        <%
            //cria um array de disciplina vazio
            ArrayList<Disciplina> arrayDisciplinas = Disciplina.listar();

            for (Disciplina disc: arrayDisciplinas) {
                %>
                 
                Nome: <%= disc.getNome() %> <br>
                Carga Horária: <%= disc.getCargaHoraria() %> <br> 
                <br>
                
                <%
            }

        %>
    </body>
</html>
