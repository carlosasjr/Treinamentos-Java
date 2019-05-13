package escola;

import java.util.ArrayList;

/**
 *
 * @author Carlos-TP
 */
public class Turma {

    private String sigla;
    private int ano;
    
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Disciplina> disciplinas;
    
    //método construtor do java tem o mesmo nome da classe
    public Turma() {
       //inicia uma lista de alunos vazia
       this.alunos = new ArrayList<Aluno>();
    }

    public void adicionarAluno(Aluno aluno) {
       this.alunos.add(aluno);
    }
    
    public int countAlunos() {
        //retorna a quantidade de registro da lista
        return this.alunos.size();
    }
    
    public void excluirAluno(Aluno aluno){
        //remover uma aluno
        this.alunos.remove(aluno);
    }
    
   //retorno um aluno de uma determinada posição
    public Aluno getAluno(int posicao){
        return this.alunos.get(posicao);
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    

}
