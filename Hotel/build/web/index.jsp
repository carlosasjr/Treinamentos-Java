<%-- 
    Document   : index
    Created on : 10/05/2019, 15:48:56
    Author     : Carlos-TP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String erro = request.getParameter("erro");

            if (erro != null) {
                if (erro.equals("true")) {
                    out.println("Este usuário não existe");
                }
            }


        %>

        <form method="post" action="logar.jsp">
            <label>Login</label>
            <input type="text" name="login"><br>

            <label>Senha</label>
            <input type="password" name="senha"><br><br>

            <input type="submit" name="btnLogin" value="Entrar">

        </form>
    </body>
</html>
