/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciaXML;

import com.thoughtworks.xstream.XStream;
import dominio.Lider;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Carlos-TP
 */
public class LiderBD {
    
    private static String arquivoXml = "C:\\lider.xml";
    private static ArrayList<Lider> lista = new ArrayList<>();
    
    public static void inserir(Lider novoLider) {
        lerXml();
        lista.add(novoLider);
        salvarXml();
    }
    
    public static void alterar(Lider liderAlterado) {
        excluir(liderAlterado.getCpf());
        
        inserir(liderAlterado);
    }
    
    public static void excluir(String cpf) {
        lerXml();

        //busca na lista
        for (int i = 0; i < lista.size(); i++){
            Lider cadaLider = lista.get(i);
            if (cadaLider.getCpf().equals(cpf)) {
                lista.remove(i);
                break;
            }
        }
        
        salvarXml();
    }
    
    public static ArrayList<Lider> listar() {
        lerXml() ;
        return lista;
    }
    
    public static void lerXml(){
        //pegar o que esta no xml e coloca no array        
        File arquivo = new File(arquivoXml);
        
        if (arquivo.exists()){
            //armazena o XML no vetor
            
            XStream xstream = new XStream();
            xstream.alias("lider", Lider.class);
            
            lista = (ArrayList<Lider>) xstream.fromXML(arquivo);
        } else {
            lista = new ArrayList<Lider>();
        }        
        
    }
    
    //pegar o que esta no array e salvar no xml
    public static void salvarXml() {
        XStream xStream = new XStream();
        xStream.alias("lider", Lider.class);
        
        try {
            FileWriter escritor = new FileWriter(arquivoXml);
            escritor.write(xStream.toXML(lista));
            escritor.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static Lider getBycpf(String cpf) {
        lerXml();

        //busca na lista
        for (int i = 0; i < lista.size(); i++){
            Lider cadaLider = lista.get(i);
            if (cadaLider.getCpf().equals(cpf)) {
                return cadaLider;
            }
        } 
        
        return null;
    }
}
