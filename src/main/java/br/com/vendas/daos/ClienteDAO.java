package br.com.vendas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.model.Cliente;
import br.com.vendas.utils.Alerta;
import br.com.vendas.utils.Conexao;

public class ClienteDAO {
    private boolean verificarCPF(String cpf) {
        String comando = "SELECT id FROM clientes WHERE cpf = ?";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(comando);
        ) {
            stmt.setString(1, cpf);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                Alerta.mostrarAviso(Alerta.ERRO_CPF_EXISTENTE);
                return true;
            }

            return false;
        } catch (SQLException e) {
            Alerta.mostrarAviso(Alerta.ERRO_VERIFICAR_CPF);
            return false;
        }
    }

    private boolean verificarEmail(String email) {
        String comando = "SELECT id FROM clientes WHERE email = ?";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(comando);
        ) {
            stmt.setString(1, email);
            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                Alerta.mostrarAviso(Alerta.ERRO_EMAIL_EXISTENTE);
                return true;
            }

            return false;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean cadastrar(Cliente cliente) {
        if (verificarCPF(cliente.getCPF()) || verificarEmail(cliente.getEmail())) {
            return false;
        }

        return inserir(cliente);
    }

    private boolean inserir(Cliente cliente) {
        String comando = "INSERT INTO clientes (nome, cpf, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(comando);
        ) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCPF());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getEndereco());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            Alerta.mostrarAviso(Alerta.ERRO_INSERIR_DADOS);
            return false;
        }
    }

    public List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String comando = "SELECT * FROM clientes";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(comando);
            ResultSet resultado = stmt.executeQuery();
        ) {
            while (resultado.next()) {
                Cliente cliente = new Cliente(
                    resultado.getInt("id"),
                    resultado.getString("nome"),
                    resultado.getString("cpf"),
                    resultado.getString("telefone"),
                    resultado.getString("email"),
                    resultado.getString("endereco")
                );

                clientes.add(cliente);
            }

            return clientes;
        } catch (SQLException e) {
            return null;
        }
    }
}
