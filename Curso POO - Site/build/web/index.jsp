<%@page import="escola.Disciplina"%>

<%  
    Disciplina disciplina1 = new Disciplina();
    
    disciplina1.setNome("Matem�tica");    
    out.println(disciplina1.getNome());
    
    disciplina1.setCargaHoraria(5);
    
    
%>
