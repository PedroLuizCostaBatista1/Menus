package br.com.vendas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import br.com.vendas.Main;

public class TelaConfiguracoes {
    @FXML
    private void voltarMenuPrincipal() throws IOException {
        Main.setRoot("menuprincipal");
    }
}
