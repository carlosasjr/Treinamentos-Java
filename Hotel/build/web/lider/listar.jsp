<%-- 
    Document   : listar
    Created on : 13/05/2019, 10:26:17
    Author     : Carlos-TP
--%>

<%@page import="dominio.Funcionario"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dominio.Lider"%>
<%@page import="persistenciaXML.LiderBD"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../validarUsuario.jsp"  %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Lideres</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
        
        
        <%            ArrayList<Lider> lideres = LiderBD.listar();
        %>

        <table border="1">
            <thead>
            <th>Nome</th>
            <th>CPF</th>
            <th>Data Nascimento</th>
            <th>Acões</th>
        </thead>

        <tbody>
            <%
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                for (Lider lider : lideres) {
                    String dataNascimento = "";

                    if (lider.getDataNascimento() != null) {
                        dataNascimento = formato.format(lider.getDataNascimento());
                    }
            %>
            <tr>
                <td><%=lider.getNome()%></td>
                <td><%=lider.getCpf()%></td>
                <td><%=dataNascimento%></td>
                <td>
                    <a href="cadastrar.jsp?cpf=<%=lider.getCpf()%>">Alterar</a>
                    <a href="excluir.jsp?cpf=<%=lider.getCpf()%>" onclick="return confirm('Deseja realmente excluir?')">Excluir</a>
                </td>
            </tr>    

            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
