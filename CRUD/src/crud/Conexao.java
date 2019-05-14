/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public abstract class Conexao {

    private static Connection con;

    public static Connection getConnection() {
        try {

            if (con == null) {
                con = DriverManager.getConnection("jdbc:mysql://localhost/carlo019_bontur", "root", "");
            }

            return con;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
