package escola;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import escola.Conexao;

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
        if (cargaHoraria < 0) {
            throw new Exception("Carga horária inválida");
        }

        this.cargaHoraria = cargaHoraria;
    }

    public boolean salvar() {
        try {
            //cria um array de disciplina vazio
            ArrayList<Disciplina> arrayDisciplinas = Disciplina.listar();

            //adiciona o objeto no array
            arrayDisciplinas.add(this);

            //cria o xml
            XStream xstream = new XStream();
            xstream.alias("disciplina", Disciplina.class);

            FileWriter escritor = new FileWriter(Conexao.getCaminho() + "disciplina.xml");

            //passa o array para o arquivo
            escritor.write(xstream.toXML(arrayDisciplinas));
            escritor.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static  ArrayList<Disciplina> listar() {
        ArrayList<Disciplina> arrayDisciplinas = new ArrayList();

        //carregar xml se existir
        XStream leitor = new XStream();
        leitor.alias("disciplina", Disciplina.class);

        File arquivo = new File(Conexao.getCaminho() + "disciplina.xml");

        if (arquivo.exists()) {
            //realiza um cast passando o objeto para o array
            arrayDisciplinas = (ArrayList<Disciplina>) leitor.fromXML(arquivo);
        }
        return arrayDisciplinas;
    }

}
