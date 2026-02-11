package br.com.vendas.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import br.com.vendas.Main;
import br.com.vendas.daos.ClienteDAO;
import br.com.vendas.model.Cliente;
import br.com.vendas.utils.Alerta;

public class TelaCadastroController {
    @FXML private TextField fieldNome;
    @FXML private TextField fieldCPF;
    @FXML private TextField fieldTelefone;
    @FXML private TextField fieldEmail;
    @FXML private TextField fieldEndereco;
    @FXML private TableView<Cliente> tabelaClientes;
    @FXML private TableColumn<Cliente, Integer> colId;
    @FXML private TableColumn<Cliente, String> colNome;
    @FXML private TableColumn<Cliente, String> colCPF;
    @FXML private TableColumn<Cliente, String> colTelefone;
    @FXML private TableColumn<Cliente, String> colEmail;
    @FXML private TableColumn<Cliente, String> colEndereco;

    private Cliente cliente;
    private ClienteDAO clienteDAO = new ClienteDAO();

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colCPF.setCellValueFactory(new PropertyValueFactory<>("CPF"));
        colTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
        atualizarTabela();
    }

    @FXML
    private void limparCampos() {
        fieldNome.clear();
        fieldCPF.clear();
        fieldTelefone.clear();
        fieldEmail.clear();
        fieldEndereco.clear();
    }

    @FXML
    private void cadastrarCliente() throws IOException {
        cliente = new Cliente(
            fieldNome.getText(),
            fieldCPF.getText(),
            fieldTelefone.getText(),
            fieldEmail.getText(),
            fieldEndereco.getText()
        );

        if (cliente.inserirCliente(cliente)) {
            Alerta.mostrarAviso(Alerta.CADASTRO_CLIENTE_CONCLUIDO);
            atualizarTabela();
        }
    }

    private void atualizarTabela() {
        try {
            tabelaClientes.setItems(FXCollections.observableArrayList(clienteDAO.listarClientes()));
        } catch (Exception e) {
            Alerta.mostrarAviso(Alerta.ERRO_ATUALIZAR_TABELA);
        }
    }

    @FXML
    private void voltarMenuPrincipal() throws IOException {
        Main.setRoot("menuprincipal");
    }
}
