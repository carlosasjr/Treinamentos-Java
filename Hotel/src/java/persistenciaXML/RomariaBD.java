/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistenciaXML;

import com.thoughtworks.xstream.XStream;
import dominio.Romaria;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Carlos-TP
 */
public class RomariaBD {
    private static String arquivoXml = "C:\\romaria.xml";
    private static ArrayList<Romaria> lista = new ArrayList<>();
    
    public static void inserir(Romaria novaRomaria) {
        lerXml();
        lista.add(novaRomaria);
        salvarXml();
    }
    
    public static void alterar(Romaria romariaAlterada) {
        excluir(romariaAlterada.getCodigo());
        
        inserir(romariaAlterada);
    }
    
    public static void excluir(int codigo) {
        lerXml();

        //busca na lista
        for (int i = 0; i < lista.size(); i++){
            Romaria cadaRomaria = lista.get(i);
            if (cadaRomaria.getCodigo() == codigo) {
                lista.remove(i);
                break;
            }
        }
        
        salvarXml();
    }
    
    public static ArrayList<Romaria> listar() {
        lerXml() ;
        return lista;
    }
    
    public static void lerXml(){
        //pegar o que esta no xml e coloca no array        
        File arquivo = new File(arquivoXml);
        
        if (arquivo.exists()){
            //armazena o XML no vetor
            
            XStream xstream = new XStream();
            xstream.alias("romaria", Romaria.class);
            
            lista = (ArrayList<Romaria>) xstream.fromXML(arquivo);
        } else {
            lista = new ArrayList<Romaria>();
        }        
        
    }
    
    //pegar o que esta no array e salvar no xml
    public static void salvarXml() {
        XStream xStream = new XStream();
        xStream.alias("romaria", Romaria.class);
        
        try {
            FileWriter escritor = new FileWriter(arquivoXml);
            escritor.write(xStream.toXML(lista));
            escritor.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
        
}
