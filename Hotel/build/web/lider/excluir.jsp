<%@page import="persistenciaXML.LiderBD"%>
<%
 String cpf = request.getParameter("cpf");
 
 LiderBD.excluir(cpf);
 response.sendRedirect("listar.jsp");
%>