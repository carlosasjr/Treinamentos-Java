/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import dominio.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class ClienteDAO {

    private static Connection con;

    public static void inserir(Cliente cliente) throws SQLException {
        con = Conexao.getConnection();

        String sql = "INSERT INTO clientes (nome, email, senha, id_perfil, ip) values(?,?,?,?, ?)";

        PreparedStatement pdo = con.prepareStatement(sql);

        pdo.setString(1, cliente.getNome());
        pdo.setString(2, cliente.getEmail());
        pdo.setString(3, cliente.getSenha());
        pdo.setInt(4, cliente.getIdPerfil());
        pdo.setString(5, cliente.getIp());

        pdo.executeUpdate();

        pdo.close();

    }

    public static void deletar(Cliente cliente) throws SQLException {
        con = Conexao.getConnection();

        String sql = "DELETE FROM clientes WHERE id = ?";

        try (PreparedStatement pdo = con.prepareStatement(sql)) {

            pdo.setInt(1, cliente.getId());

            pdo.executeUpdate();

            pdo.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void alterar(Cliente cliente) throws SQLException {
        con = Conexao.getConnection();

        String sql = "UPDATE clientes SET nome = ? WHERE id = ?";

        try (PreparedStatement pdo = con.prepareStatement(sql)) {

            pdo.setString(1, cliente.getNome());
            pdo.setInt(1, cliente.getId());

            pdo.executeUpdate();

            pdo.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Cliente> listarTodos() throws SQLException {
        con = Conexao.getConnection();

        ArrayList<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT * FROM clientes";

        try (PreparedStatement pdo = con.prepareStatement(sql)) {
            ResultSet lista = pdo.executeQuery();

            while (lista.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(lista.getInt("id"));
                cliente.setNome(lista.getString("nome"));

                clientes.add(cliente);
            }

            lista.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clientes;

    }

    public static Cliente getByID(int id) throws SQLException {
        con = Conexao.getConnection();

        String sql = "SELECT * FROM clientes WHERE id = ?";

        try (PreparedStatement pdo = con.prepareStatement(sql)) {

            pdo.setInt(1, id);

            ResultSet lista = pdo.executeQuery();

            while (lista.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(lista.getInt("id"));
                cliente.setNome(lista.getString("nome"));

                return cliente;
            }
            
            
            lista.close();
            
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
