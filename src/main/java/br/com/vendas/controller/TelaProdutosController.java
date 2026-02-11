package br.com.vendas.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import br.com.vendas.Main;
import br.com.vendas.model.Produto;
import br.com.vendas.utils.Alerta;
import br.com.vendas.daos.ProdutoDAO;

public class TelaProdutosController {
    @FXML private TextField fieldNome;
    @FXML private TextField fieldCodigo;
    @FXML private TextField fieldPreco;
    @FXML private TextField fieldEstoque;
    @FXML private TableView<Produto> tabelaProdutos;
    @FXML private TableColumn<Produto, Integer> colId;
    @FXML private TableColumn<Produto, String> colNome;
    @FXML private TableColumn<Produto, Integer> colCodigo;
    @FXML private TableColumn<Produto, Double> colPreco;
    @FXML private TableColumn<Produto, Integer> colEstoque;

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private Produto produto;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        colEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        atualizarTabela();
    }

    @FXML
    private void cadastrarProduto() throws IOException {
        try {
            produto = new Produto(fieldNome.getText(), fieldCodigo.getText(), Double.valueOf(fieldPreco.getText()), Integer.valueOf(fieldEstoque.getText()));

            if (produto.inserirProduto(produto)) {
                Alerta.mostrarAviso(Alerta.CADASTRO_PRODUTO_CONCLUIDO);
                atualizarTabela();
            }
        } catch (NumberFormatException e) {
            Alerta.mostrarAviso(Alerta.ERRO_CAMPO_PRODUTO);
        }
    }

    private void atualizarTabela() {
        try {
            tabelaProdutos.setItems(FXCollections.observableArrayList(produtoDAO.listarProdutos()));
        } catch (Exception e) {
            Alerta.mostrarAviso(Alerta.ERRO_ATUALIZAR_TABELA);
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
