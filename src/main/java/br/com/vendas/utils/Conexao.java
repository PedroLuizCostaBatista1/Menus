package br.com.vendas.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static final String url = "jdbc:mysql://localhost:3306/vendas";
    private static final String usuario = "root";
    private static final String senha = "";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            Alerta.mostrarAviso(Alerta.ERRO_BANCO_DE_DADOS);
            throw new RuntimeException(e.getMessage());
        }
    }
}
