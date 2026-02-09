package br.com.vendas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import br.com.vendas.Main;
import br.com.vendas.model.Produto;
import br.com.vendas.utils.Alerta;

public class TelaProdutosController {
    private Produto produto;

    @FXML
    private TextField fieldNome;

    @FXML
    private TextField fieldCodigo;

    @FXML
    private TextField fieldPreco;

    @FXML
    private TextField fieldEstoque;

    @FXML
    private Button botaoCadastro;

    @FXML
    private void cadastrarProduto() throws IOException {
        try {
            produto = new Produto(fieldNome.getText(), fieldCodigo.getText(), Double.valueOf(fieldPreco.getText()), Integer.valueOf(fieldEstoque.getText()));
            produto.inserirProduto(produto);
        } catch (NumberFormatException e) {
            Alerta.mostrarAviso(Alerta.AlertaTipo.ERRO, "Erro", "Ocorreu um erro durante o processo de cadastrar o produto. Tente novamente.");
        }
    }

    @FXML
    private void voltarMenuPrincipal() throws IOException {
        Main.setRoot("menuprincipal");
    }
}
