package persistenciaXML;

import com.thoughtworks.xstream.XStream;
import dominio.Funcionario;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Carlos-TP
 */
public class FuncionarioBD {
    private static String arquivoXml = "C:\\funcionario.xml";
    private static ArrayList<Funcionario> lista = new ArrayList<>();
    
    public static void inserir(Funcionario novoFuncionario) {
        lerXml();
        lista.add(novoFuncionario);
        salvarXml();
    }
    
    public static void alterar(Funcionario funcionarioAlterado) {
        excluir(funcionarioAlterado.getCodigo() );
        
        inserir(funcionarioAlterado);
    }
    
    public static void excluir(int id) {
        lerXml();

        //busca na lista
        for (int i = 0; i < lista.size(); i++){
            Funcionario cadaFuncionario = lista.get(i);
            if (cadaFuncionario.getCodigo() == id  ) {
                lista.remove(i);
                break;
            }
        }
        
        salvarXml();
    }
    
    public static ArrayList<Funcionario> listar() {
        lerXml() ;
        return lista;
    }
    
    public static void lerXml(){
        //pegar o que esta no xml e coloca no array        
        File arquivo = new File(arquivoXml);
        
        if (arquivo.exists()){
            //armazena o XML no vetor
            
            XStream xstream = new XStream();
            xstream.alias("funcionario", Funcionario.class);
            
            lista = (ArrayList<Funcionario>) xstream.fromXML(arquivo);
        } else {
            lista = new ArrayList<Funcionario>();
        }        
        
    }
    
    //pegar o que esta no array e salvar no xml
    public static void salvarXml() {
        XStream xStream = new XStream();
        xStream.alias("funcionario", Funcionario.class);
        
        try {
            FileWriter escritor = new FileWriter(arquivoXml);
            escritor.write(xStream.toXML(lista));
            escritor.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Funcionario getById(int id) {
        lerXml();

        //busca na lista
        for (Funcionario cadaFuncionario : lista) {
            if (cadaFuncionario.getCodigo() == id ) {
                return cadaFuncionario;
            }
        } 
        
        return null;
    } 
    
    
    public static Funcionario fazerLogin(String login, String senha) {
        lerXml();        
        
        for (Funcionario func: lista) {
            if (func.getLogin().equals(login) && func.getSenha().equals(senha)) {
                return func;
            }
        }
        
        return null;
    }
}
