package escola;

import java.util.ArrayList;

/**
 *
 * @author Carlos-TP
 */
public class Disciplina {

    private String nome;
    private int cargaHoraria;
    
    private ArrayList<Professor> professores;
    private ArrayList<Turma> turmas;
    
    
    public Disciplina() {
        this.professores = new ArrayList<Professor>();
    }
    
    //MÉTODOS PUBLICOS
    public void adicionarProfessor(Professor professor) {
        this.professores.add(professor);
    }
    
    public void excluirProfessor(Professor professor) {
        this.professores.remove(professor);
    }
    
    public int countProfessores() {
        return this.professores.size();
    }
    
    public Professor getProfessor(int posicao) {
     return this.professores.get(posicao);
    }    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) throws Exception {
       if (cargaHoraria < 0){
           throw new Exception("Carga horária inválida");
       }          
           
        this.cargaHoraria = cargaHoraria;
    }    
}
