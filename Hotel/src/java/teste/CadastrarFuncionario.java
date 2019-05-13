/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dominio.Funcionario;
import persistenciaXML.FuncionarioBD;

/**
 *
 * @author Carlos-TP
 */
public class CadastrarFuncionario {
    public static void main(String[] args) {
        Funcionario func = new Funcionario();
        
        func.setCodigo(1);
        func.setLogin("carlos");
        func.setSenha("123");
        FuncionarioBD.inserir(func);
        
    }
  
}
