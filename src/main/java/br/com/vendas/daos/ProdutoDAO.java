package br.com.vendas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.vendas.model.Produto;

public class ProdutoDAO {
    private boolean verificarCodigo(String codigo) {
        String comando = "SELECT id FROM produtos WHERE codigo = ?";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(comando);
        ) {
            stmt.setString(1, codigo);
            ResultSet resultado = stmt.executeQuery();

            return resultado.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void cadastrar(Produto produto) {
        if (verificarCodigo(produto.getCodigo())) {
            return;
        }

        inserir(produto);
    }

    private void inserir(Produto produto) {
        String comando = "INSERT INTO produtos (nome, codigo, preco, estoque) VALUES (?, ?, ?, ?)";
    }
}
