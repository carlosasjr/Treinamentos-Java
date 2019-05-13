<%-- 
    Document   : salvardisciplina
    Created on : 08/05/2019, 17:53:02
    Author     : Carlos-TP
--%>

<%@page import="java.io.File"%>
<%@page import="java.io.FilterWriter"%>
<%@page import="java.io.FileWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.thoughtworks.xstream.XStream"%>
<%@page import="escola.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            request.setCharacterEncoding("UTF-8");
 
            String nome = request.getParameter("nome");
            String cargaHoraria = request.getParameter("cargaHoraria");

            //cria o objeto disciplina
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(nome);
            disciplina.setCargaHoraria(Integer.parseInt(cargaHoraria));
            
            if (disciplina.salvar()) {
                out.println("Disciplina cadastrada com sucesso!");
            } else {
                out.println("Opps.. Algo deu errado");
            }
        %>

        
        <br>
        <br>
        <a href="cadastrardisciplina.jsp">Cadatrar Outra</a>
        <br>
        <a href="listardisciplina.jsp">Ver Disciplinas</a>
    </body>
</html>
