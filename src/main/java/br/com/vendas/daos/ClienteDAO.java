package br.com.vendas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

            return resultado.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean cadastrar(Cliente cliente) {
        if (verificarCPF(cliente.getCPF()) || verificarEmail(cliente.getEmail())) {
            return false;
        }

        return true;
    }
}
