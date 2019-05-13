/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dominio.Lider;
import dominio.Romaria;
import persistenciaXML.LiderBD;
import persistenciaXML.RomariaBD;

/**
 *
 * @author Carlos-TP
 */
public class TesteSalvar {
    public static void main(String[] args) {
        
        Romaria romaria  = new Romaria();
        romaria.setCodigo(1);
        romaria.setQuantidadeCasais(10);
        RomariaBD.inserir(romaria);
        
        System.out.println("Cadastrado com sucesso");
    }
 
}
