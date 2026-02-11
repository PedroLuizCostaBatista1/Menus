module br.com.vendas {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires java.sql;

    opens br.com.vendas.controller to javafx.fxml;
    opens br.com.vendas.model to javafx.base;
    exports br.com.vendas;
}
