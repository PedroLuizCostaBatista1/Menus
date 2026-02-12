package br.com.vendas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.model.Vendas;
import br.com.vendas.utils.Conexao;

public class VendasDAO {
    public boolean inserir(Vendas vendas) {
        String comando = "INSERT INTO vendas (fkIdCliente, fkIdProduto, quantidade, valor) VALUES (?, ?, ?, ?)";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(comando);
        ) {
            stmt.setInt(1, vendas.getFkIdCliente());
            stmt.setInt(2, vendas.getFkIdProduto());
            stmt.setInt(3, vendas.getQuantidade());
            stmt.setDouble(4, vendas.getValor());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public List<Vendas> listarVendas() {
        List<Vendas> vendas = new ArrayList<>();
        String comando = "SELECT vendas.id, clientes.nome AS nomeCliente, produtos.nome AS nomeProdutos, quantidade, valor FROM vendas JOIN clientes ON fkIdCliente = clientes.id JOIN produtos ON fkIdProduto = produtos.id";

        try (
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(comando);
            ResultSet resultado = stmt.executeQuery();
        ) {
            while (resultado.next()) {
                Vendas venda = new Vendas(
                    resultado.getInt("id"),
                    resultado.getString("nomeCliente"),
                    resultado.getString("nomeProdutos"),
                    resultado.getInt("quantidade"),
                    resultado.getDouble("valor")
                );
                
                vendas.add(venda);
            }

            return vendas;
        } catch (SQLException e) {
            return null;
        }
    }
}
