package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import escola.Professor;
import escola.Disciplina;

public final class muitosParaMuitos_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');

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




    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
