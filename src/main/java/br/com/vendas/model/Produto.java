package br.com.vendas.model;

import br.com.vendas.daos.ProdutoDAO;

public class Produto {
    private int id;
    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    
    public Produto(String nome, String codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Produto(int id, String nome, String codigo, double preco, int quantidade) {
        this(nome, codigo, preco, quantidade);
        this.id = id;
    }

    public boolean inserirProduto(Produto produto) {
        return produtoDAO.cadastrar(produto);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
