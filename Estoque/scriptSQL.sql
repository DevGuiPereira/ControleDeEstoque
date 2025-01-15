CREATE DATABASE controle_Estoque

USE controle_estoque;

CREATE TABLE produtos (
    idProduto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(100),
    preco DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL
);
