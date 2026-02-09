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

    public boolean cadastrar(Produto produto) {
        if (verificarCodigo(produto.getCodigo())) {
            return false;
        }

        return inserir(produto);
    }

    private boolean inserir(Produto produto) {
        String comando = "INSERT INTO produtos (nome, codigo, preco, estoque) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(comando);
        ) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getCodigo());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
