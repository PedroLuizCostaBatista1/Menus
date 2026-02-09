package br.com.vendas.controller;

import java.io.IOException;
import br.com.vendas.Main;
import javafx.fxml.FXML;

public class TelaRelatorioController {
    @FXML
    private void voltarMenuPrincipal() throws IOException {
        Main.setRoot("menuprincipal");
    }
}
