package br.com.vendas.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import br.com.vendas.Main;
import br.com.vendas.model.Produto;
import br.com.vendas.utils.Alerta;

public class TelaProdutosController {
    @FXML private TextField fieldNome;
    @FXML private TextField fieldCodigo;
    @FXML private TextField fieldPreco;
    @FXML private TextField fieldEstoque;
    @FXML private Button botaoCadastro;
    @FXML private TableView<Produto> tabelaProdutos;
    @FXML private TableColumn<Produto, Integer> colId;
    @FXML private TableColumn<Produto, String> colNome;
    @FXML private TableColumn<Produto, Integer> colCodigo;
    @FXML private TableColumn<Produto, Double> colPreco;
    @FXML private TableColumn<Produto, Integer> colEstoque;

    private Produto produto;

    @FXML
    private void cadastrarProduto() throws IOException {
        try {
            produto = new Produto(fieldNome.getText(), fieldCodigo.getText(), Double.valueOf(fieldPreco.getText()), Integer.valueOf(fieldEstoque.getText()));

            if (produto.inserirProduto(produto)) {
                Alerta.mostrarAviso(Alerta.CADASTRO_CONCLUIDO);
            }
        } catch (NumberFormatException e) {
            Alerta.mostrarAviso(Alerta.ERRO_CAMPO);
        }
    }

    private void atualizarTabela() {
        try {
            tabelaProdutos.setItems(FXCollections.observableArrayList());
        } catch (Exception e) {

        }
    }

    @FXML
    private void limparCampos() {
        fieldNome.clear();
        fieldCodigo.clear();
        fieldPreco.clear();
        fieldEstoque.clear();
    }

    @FXML
    private void voltarMenuPrincipal() throws IOException {
        Main.setRoot("menuprincipal");
    }
}
