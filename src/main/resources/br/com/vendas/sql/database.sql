CREATE DATABASE vendas;
USE vendas;

CREATE TABLE produtos(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    preco DECIMAL(10, 2) NOT NULL,
    estoque INT NOT NULL
);

CREATE TABLE clientes(
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    cpf VARCHAR(20) NOT NULL UNIQUE,
    telefone VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    endereco VARCHAR(200) NOT NULL
);

CREATE TABLE vendas(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fkIdCliente INT,
    fkIdProduto INT,
    quantidade INT NOT NULL,
    valor DECIMAL(10, 2) NOT NULL,

    FOREIGN KEY (fkIdCliente) REFERENCES clientes(id),
    FOREIGN KEY (fkIdProduto) REFERENCES produtos(id)
);

SELECT vendas.id, clientes.nome AS nomeCliente, produtos.nome AS nomeProdutos, quantidade, valor FROM vendas JOIN clientes ON fkIdCliente = clientes.id JOIN produtos ON fkIdProduto = produtos.id;