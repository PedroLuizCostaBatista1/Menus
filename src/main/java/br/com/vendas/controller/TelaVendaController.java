package br.com.vendas.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import br.com.vendas.Main;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Produto;
import br.com.vendas.model.Vendas;
import br.com.vendas.utils.Alerta;
import br.com.vendas.daos.ProdutoDAO;
import br.com.vendas.daos.VendasDAO;
import br.com.vendas.daos.ClienteDAO;

public class TelaVendaController {
    @FXML private ComboBox<Cliente> clienteCombo;
    @FXML private ComboBox<Produto> produtoBox;
    @FXML private TableView<Vendas> tabelaVendas;
    @FXML private TableColumn<Vendas, Integer> colId;
    @FXML private TableColumn<Vendas, String> colCliente;
    @FXML private TableColumn<Vendas, String> colProduto;
    @FXML private TableColumn<Vendas, Integer> colQuantidade;
    @FXML private TableColumn<Vendas, Double> colPreco;
    @FXML private TextField fieldQuantidade;
    @FXML private TextField fieldValor;

    private ProdutoDAO produtoDAO = new ProdutoDAO();
    private ClienteDAO clienteDAO = new ClienteDAO();
    private VendasDAO vendasDAO = new VendasDAO();
    private Vendas vendas;
    
    @FXML
    public void initialize() {
        produtoBox.getItems().addAll(produtoDAO.listarProdutos());
        clienteCombo.getItems().addAll(clienteDAO.listarClientes());
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("clienteNome"));
        colProduto.setCellValueFactory(new PropertyValueFactory<>("produtoNome"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colPreco.setCellValueFactory(new PropertyValueFactory<>("valor"));
        atualizarTabela();
    }

    @FXML
    private void voltarMenuPrincipal() throws IOException {
        Main.setRoot("menuprincipal");
    }

    @FXML
    private void adicionarItem() throws IOException {
        vendas = new Vendas(
            clienteCombo.getSelectionModel().getSelectedItem().getId(),
            produtoBox.getSelectionModel().getSelectedItem().getId(),
            Integer.valueOf(fieldQuantidade.getText()),
            Double.valueOf(fieldValor.getText())
        );

        vendas.adicionarVenda(vendas);
        atualizarTabela();
    }

    private void atualizarTabela() {
        try {
            tabelaVendas.setItems(FXCollections.observableArrayList(vendasDAO.listarVendas()));
        } catch (Exception e) {
            Alerta.mostrarAviso(Alerta.ERRO_ATUALIZAR_TABELA);
        }
    }
}
