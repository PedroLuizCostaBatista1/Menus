package br.com.vendas.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alerta {
    public enum AlertaTipo {
        ERRO(1001, AlertType.ERROR),
        INFORMACAO(0, AlertType.INFORMATION);

        private final int alertaCodigo;
        private final AlertType tipoAlerta;

        private AlertaTipo(int alertaCodigo, AlertType tipoAlerta) {
            this.alertaCodigo = alertaCodigo;
            this.tipoAlerta = tipoAlerta;
        }
    }

    public static void mostrarAviso(AlertaTipo tipo, String titulo, String mensagem) {
        Alert alert = new Alert(tipo.tipoAlerta);
        alert.setTitle(titulo);
        alert.setHeaderText(null);

        if (tipo.tipoAlerta.name().equals("ERROR")) {
            alert.setContentText(mensagem + "\n\n(Codigo do Erro: " + tipo.alertaCodigo + ")");
        } else {
            alert.setContentText(mensagem);
        }

        alert.showAndWait();
    }
}
