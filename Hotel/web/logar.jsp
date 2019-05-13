<%@page import="dominio.Funcionario"%>
<%@page import="persistenciaXML.FuncionarioBD"%>
<%
    String login = request.getParameter("login");
    String senha = request.getParameter("senha");

    Funcionario funcionarioEncontrado = FuncionarioBD.fazerLogin(login, senha);

    if (funcionarioEncontrado != null) {
        
        //criar sessão
        session.setAttribute("funcionario", funcionarioEncontrado);
        
        response.sendRedirect("lider/listar.jsp");
    } else {
        response.sendRedirect("index.jsp?erro=true");
    }

%>