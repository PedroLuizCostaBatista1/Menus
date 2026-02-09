package br.com.vendas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import br.com.vendas.Main;

public class TelaProdutosController {

    @FXML
    private TextField fieldNome;

    @FXML
    private TextField codigoField;

    @FXML
    private TextField precoField;

    @FXML
    private void voltarMenuPrincipal() throws IOException {
        Main.setRoot("menuprincipal");
    }

    
}
