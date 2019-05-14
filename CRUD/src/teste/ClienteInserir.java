/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import crud.ClienteDAO;
import dominio.Cliente;
import java.sql.SQLException;

/**
 *
 * @author Carlos-TP
 */
public class ClienteInserir {
    public static void main(String[] args) throws SQLException {
        Cliente cli = new Cliente();
        cli.setNome("Teste Java");
        cli.setEmail("email@java.com.br");
        cli.setSenha("123");
        cli.setIdPerfil(1);
        cli.setIp("192.0.0.1");
        ClienteDAO.inserir(cli);
        
        System.out.println("Salvo com sucesso");
        
    }
}
