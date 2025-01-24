CREATE DATABASE estoque

USE estoque;

CREATE TABLE produtos (
    idprodutos INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(100),
    preco DOUBLE NOT NULL,
    quantidade INT NOT NULL
);

DESCRIBE produtos

SELECT * FROM produtos