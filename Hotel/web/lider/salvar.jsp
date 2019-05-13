<%-- 
    Document   : salvar
    Created on : 13/05/2019, 10:05:39
    Author     : Carlos-TP
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="persistenciaXML.LiderBD"%>
<%@page import="dominio.Lider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Lideres</title>
    </head>
    <body>
        <%
            String idAlterado = request.getParameter("idAlterado");

            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String telefone = request.getParameter("telefone");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String dataNascimento = request.getParameter("dataNascimento");

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date data = formato.parse(dataNascimento);

            Lider lider;

            if (idAlterado != "null") {//se for uma alteração
                lider = LiderBD.getBycpf(idAlterado);
            } else { //for um novo cadastro
                lider = new Lider();
            }

            lider.setNome(nome);
            lider.setCpf(cpf);
            lider.setCidade(cidade);
            lider.setEstado(estado);
            lider.setDataNascimento(data);

            if (idAlterado != "null") {
                LiderBD.alterar(lider);
                out.println("<h1>Lider alterado com sucesso!</h1>");
            } else {
                LiderBD.inserir(lider);
                out.println("<h1>Lider Cadastrado com sucesso!</h1>");
            }
        %>


    </body>
</html>
