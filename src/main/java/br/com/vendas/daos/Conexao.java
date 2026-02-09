package br.com.vendas.daos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static final String url = "";
    private static final String usuario = "root";
    private static final String senha = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
