package br.com.vendas.daos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/vendas";
    private static final String usuario = "pedro";
    private static final String senha = "12345";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
