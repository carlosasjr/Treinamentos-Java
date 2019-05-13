package escola;

import java.util.Date;

/**
 *
 * @author Carlos-TP
 */
public class Aluno extends Pessoa {

    private Date dataNascimento;
    private Turma turma;

    //void quando não existe um return
    public void realizarAvaliacao() {

    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
