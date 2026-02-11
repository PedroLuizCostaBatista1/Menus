package br.com.vendas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import br.com.vendas.Main;
import br.com.vendas.model.Cliente;
import br.com.vendas.utils.Alerta;

public class TelaCadastroController {
    @FXML private TextField fieldNome;
    @FXML private TextField fieldCPF;
    @FXML private TextField fieldTelefone;
    @FXML private TextField fieldEmail;
    @FXML private TextField fieldEndereco;

    private Cliente cliente;

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
            System.out.println("yee");
        }
    }

    @FXML
    private void voltarMenuPrincipal() throws IOException {
        Main.setRoot("menuprincipal");
    }
}
