package br.com.vendas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import br.com.vendas.Main;
import br.com.vendas.utils.Alerta;

public class MenuPrincipalController {
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
        Alerta.mostrarAviso(Alerta.INFORMACAO_DO_PRODUTO);
    }
}
