package br.com.vendas.model;

import br.com.vendas.daos.ClienteDAO;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String endereco;
    private ClienteDAO clienteDAO = new ClienteDAO();

    public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Cliente(int id, String nome, String cpf, String telefone, String email, String endereco) {
        this(nome, cpf, telefone, email, endereco);
        this.id = id;
    }

    public boolean inserirCliente(Cliente cliente) {
        if (cliente.nome.matches("\\s*") || cliente.cpf.matches("\\s*") || cliente.telefone.matches("\\s*") || cliente.email.matches("\\s*") || cliente.endereco.matches("\\s*")) {
            return false;
        }

        return clienteDAO.cadastrar(cliente);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCPF() {
        return this.cpf;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public String getEndereco() {
        return this.endereco;
    }
}
