package br.com.vendas.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public enum Alerta {
    ERRO_CAMPO_PRODUTO(1001, "Ocorreu um erro durante o processo de cadastrar o produto. Tente novamente.", AlertType.ERROR),
    ERRO_BANCO_DE_DADOS(1002, "Ocorreu um erro na conexão do banco de dados", AlertType.ERROR),
    ERRO_VERIFICAR_CODIGO(1003, "Ocorreu um erro durante o processo de verificar o codigo do produto", AlertType.ERROR),
    ERRO_CODIGO_EXISTENTE(1004, "Esse codigo já existe. Tente novamente com o codigo diferente.", AlertType.ERROR),
    ERRO_INSERIR_DADOS(1005, "Ocorreu um erro durante o processo de inserir os dados ao banco de dados", AlertType.ERROR),
    ERRO_ATUALIZAR_TABELA(1006, "Ocorreu um erro durante o processo de atualizar a tabela", AlertType.ERROR),
    ERRO_VERIFICAR_CPF(1007, "Ocorreu um erro durante o processo de verificar o CPF do cliente", AlertType.ERROR),
    ERRO_CPF_EXISTENTE(1008, "Este CPF já está cadastrado", AlertType.ERROR),
    ERRO_CAMPO_CLIENTE(1009, "Ocorreu um erro durante o processo de cadastrar o cliente. Tente novamente.", AlertType.ERROR),
    ERRO_EMAIL_EXISTENTE(1010, "Este e-mail já está cadastrado. Tente usar um email diferente", AlertType.ERROR),
    CADASTRO_PRODUTO_CONCLUIDO(0, "O cadastro do produto foi concluido com sucesso!", AlertType.INFORMATION),
    CADASTRO_CLIENTE_CONCLUIDO(0, "O cadastro do cliente foi concluido com sucesso!", AlertType.INFORMATION),
    INFORMACAO_DO_PRODUTO(0, "Nome: Sistema de Vendas\n" + "Versão: 1.0.0\n" + "Desenvolvedor: Pedro Luiz\n" + "Ano: 2026", AlertType.INFORMATION);

    private final int codigo;
    private final String mensagem;
    private final AlertType tipo;

    private Alerta(int codigo, String mensagem, AlertType tipo) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.tipo = tipo;
    }

    public static void mostrarAviso(Alerta alerta) {
        Alert alert = new Alert(alerta.tipo);
        alert.setTitle("Aviso");
        alert.setHeaderText(null);
    
        if (alerta.name().startsWith("ERRO")) {
            alert.setContentText(alerta.mensagem + "\n\n(Codigo do Erro: " + alerta.codigo + ")");
        } else {
            alert.setContentText(alerta.mensagem);
        }

        alert.showAndWait();
    }
}
