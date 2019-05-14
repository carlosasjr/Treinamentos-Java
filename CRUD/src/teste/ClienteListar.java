/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import crud.ClienteDAO;
import dominio.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Carlos-TP
 */
public class ClienteListar {

    public static void main(String[] args) throws SQLException {
        ArrayList<Cliente> lista = new ArrayList<>();

        lista = ClienteDAO.listarTodos();

        for (Cliente cliente : lista) {
            System.out.println(cliente.getNome());
        }

        System.out.println("------BUSCANDO POR ID--------");

        Cliente cli;

        cli = ClienteDAO.getByID(1);

        if (cli != null) {
            System.out.println(cli.getNome());
        }

    }

}
