package escola;

import java.util.ArrayList;

/**
 *
 * @author Carlos-TP
 */
public class Professor extends Pessoa {

    private String formacaoAcademica;
    private double salario;
    
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Turma> turmas;

    public Professor() {
       this.disciplinas = new ArrayList<Disciplina>();
    }
    
    public void adicionarDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
    }
    
    public void excluirDisciplina(Disciplina disciplina) {
        this.disciplinas.remove(disciplina);
    }
    
    public int countDisciplinas() {
        return this.disciplinas.size();
    }
    
    public Disciplina getDisciplina(int posicao) {
     return this.disciplinas.get(posicao);
    }
    
    public void aplicarAvaliacao() {
    }

    public String getFormacaoAcademica() {
        return formacaoAcademica;
    }

    public void setFormacaoAcademica(String formacaoAcademica) {
        this.formacaoAcademica = formacaoAcademica;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    
   
}
