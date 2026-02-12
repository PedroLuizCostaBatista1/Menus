package br.com.vendas.model;

import br.com.vendas.daos.VendasDAO;

public class Vendas {
    private int id;
    private int fkIdCliente;
    private int fkIdProduto;
    private String clienteNome;
    private String produtoNome;
    private int quantidade;
    private double valor;
    private VendasDAO vendasDAO = new VendasDAO();

    public Vendas(int fkIdCliente, int fkIdProduto, int quantidade, double valor) {
        this.fkIdCliente = fkIdCliente;
        this.fkIdProduto = fkIdProduto;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Vendas(int id, int fkIdCliente, int fkIdProduto, int quantidade, double valor) {
        this(fkIdCliente, fkIdProduto, quantidade, valor);
        this.id = id;
    }

    public Vendas(int id, String clienteNome, String produtoNome, int quantidade, double valor) {
        this.id = id;
        this.clienteNome = clienteNome;
        this.produtoNome = produtoNome;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public boolean adicionarVenda(Vendas vendas) {
        return vendasDAO.inserir(vendas);
    }

    public int getId() {
        return this.id;
    }

    public int getFkIdCliente() {
        return this.fkIdCliente;
    }

    public int getFkIdProduto() {
        return this.fkIdProduto;
    }

    public String getClienteNome() {
        return this.clienteNome;
    }

    public String getProdutoNome() {
        return this.produtoNome;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public double getValor() {
        return this.valor;
    }
}
