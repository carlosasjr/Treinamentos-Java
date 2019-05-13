<%@page import="escola.Professor"%>
<%@page import="escola.Disciplina"%>
<%
Disciplina disciplina1 = new Disciplina();
disciplina1.setNome("Matemática");
disciplina1.setCargaHoraria(80);

Disciplina disciplina2 = new Disciplina();
disciplina2.setNome("Portugues");
disciplina2.setCargaHoraria(80);

Professor professor1 = new Professor();
professor1.setNome("Jão");
professor1.setMatricula(123);
professor1.setFormacaoAcademica("Licenciado");
professor1.setSalario(30);

//relacao do jão com matemática
professor1.adicionarDisciplina(disciplina1);
disciplina1.adicionarProfessor(professor1);

//relacao do jão com portugues
professor1.adicionarDisciplina(disciplina2);
disciplina2.adicionarProfessor(professor1);


Professor professor2 = new Professor();
professor2.setNome("Maria");
professor2.setMatricula(321);
professor2.setFormacaoAcademica("Licenciada");
professor2.setSalario(40);

//relacao da Maria com Matematica
professor2.adicionarDisciplina(disciplina1);
disciplina2.adicionarProfessor(professor2);


//listas as disciplinas do prof jão
out.println("Disciplinas do jão" + "<br>");
for (int i = 0; i < professor1.countDisciplinas(); i++) {
    out.println(professor1.getDisciplina(i).getNome() + "<br>");
}

out.println("Professores de Portugues" + "<br>");
for (int i = 0; i < disciplina2.countProfessores(); i++) {
     out.println(disciplina2.getProfessor(i).getNome() + "<br>" ) ;
}



%>