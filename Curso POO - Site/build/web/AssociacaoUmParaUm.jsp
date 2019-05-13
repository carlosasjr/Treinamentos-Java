<%@page import="escola.Turma"%>
<%@page import="java.util.Date"%>
<%@page import="escola.Aluno"%>
<%
 Turma turma1 = new Turma();
 
 turma1.setSigla("A1");
 turma1.setAno(1);
 
 Aluno aluno1 = new Aluno();
 aluno1.setNome("João");
 aluno1.setMatricula(123);
 aluno1.setDataNascimento(new Date());
 aluno1.setTurma(turma1);
 
 turma1.adicionarAluno(aluno1);
 
 
 Aluno aluno2 = new Aluno();
 aluno2.setNome("Zé");
 aluno2.setMatricula(999);
 aluno2.setDataNascimento(new Date());
 aluno2.setTurma(turma1);
 
 turma1.adicionarAluno(aluno2);
 
 out.println("Dados do aluno 1");
 out.println(aluno1.getNome());
 out.println(aluno1.getTurma().getSigla());
 
 
 out.println("Alunos da turma");
 
 for (int i = 0; i < turma1.countAlunos(); i++) {
    out.println(turma1.getAluno(i).getNome()); 
 }
 %>