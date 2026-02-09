package br.com.vendas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import br.com.vendas.Main;

public class MenuPrincipalController {
    private Alert alert = new Alert(AlertType.INFORMATION);

    @FXML
    private Button botaoSair;
    
    @FXML
    private void sair() throws IOException {
        Stage stage = (Stage) botaoSair.getScene().getWindow();
        stage.close(); 
    }

    @FXML 
    private void acessarMenuCadastro() throws IOException {
        Main.setRoot("telacadastroclientes");
    }

    @FXML
    private void acessarCadastroProdutos() throws IOException {
        Main.setRoot("telacadastroprodutos");
    }

    @FXML
    private void acessarNovaVenda() throws IOException {
        Main.setRoot("telanovavenda");
    }

    @FXML
    private void acessarRelatorios() throws IOException {
        Main.setRoot("telarelatoriovendas");
    }

    @FXML
    private void acessarConfiguracoes() throws IOException {
        Main.setRoot("telaconfiguracoes");
    }

    @FXML
    private void mensagemAjuda() throws IOException {
        alert.setTitle("Ajuda do produto");
        alert.setHeaderText(null);
        alert.setContentText(
            "Nome: Sistema de Vendas\n" +
            "Versão: 1.0.0\n" +
            "Desenvolvedor: Pedro Luiz\n" +
            "Ano: 2026"
        );
        alert.showAndWait();
    }
}
