<%-- 
    Document   : cadastrar
    Created on : 13/05/2019, 09:59:54
    Author     : Carlos-TP
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="persistenciaXML.LiderBD"%>
<%@page import="dominio.Lider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../validarUsuario.jsp"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Lideres</title>
    </head>
    <body>
        <jsp:include page="../menu.jsp"></jsp:include>
        
        <%
         String cpf = request.getParameter("cpf");
         
         Lider lider = null;         
         
         if (cpf != null) {
             lider = LiderBD.getBycpf(cpf);
         } else {
             lider  = new Lider();
         }
         
         String dataNascimento = "";
         
         if (lider.getDataNascimento() != null) {
             SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
             dataNascimento = formato.format(lider.getDataNascimento());
         }
        %>
        
        <h1>Cadastro de Lideres</h1>

        <form name="frmCadastro" method="post" action="salvar.jsp">
            <label>Nome</label>
            <input type="text" name="nome" value="<%= lider.getNome() %>">
            <br />

            <label>CPF</label>
            <input type="text" name="cpf" value="<%= lider.getCpf()%>">
            <br />  

            <label>Telefone</label>
            <input type="text" name="telefone" value="<%= lider.getTelefone()%>">
            <br />   
            
            <label>Cidade</label>
            <input type="text" name="cidade" value="<%= lider.getCidade() %>">
            <br />
            
            <label>Estado</label>
            <%
                String estado = "";
                if (lider.getEstado() != null) {
                    estado = lider.getEstado();
                }
            %>
            
            
            <select name="estado">
                <option value="SP" <%= (estado.equals("SP")) ? "selected" : "" %>>São Paulo</option>
                <option value="RJ" <%= (estado.equals("RJ")) ? "selected" : "" %>>Rio de Janeiro</option>
            </select>
            <br />
            
            <label>Data de Nascimento</label>
            <input type="text" name="dataNascimento" value="<%= dataNascimento %>">
            <br /> 
            
            <input type="hidden" name="idAlterado" value="<%= cpf %>">
            <input type="submit" value="Salvar" name="salvar">
                   

        </form>
    </body>
</html>
