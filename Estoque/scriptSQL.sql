CREATE DATABASE controle_Estoque

USE controle_Estoque;

CREATE TABLE produtos (
    idProduto INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao VARCHAR(100),
    preco DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL
);

select * from produtos

INSERT INTO produtos (nome, descricao, preco, quantidade)
VALUES ('teste', 'teste teste', 10, 1)

SHOW GRANTS FOR 'root'@'localhost';

GRANT ALL PRIVILEGES ON controle_estoque.* TO 'root'@'localhost' IDENTIFIED BY 'Guirp007007!';
FLUSH PRIVILEGES;

SHOW DATABASES;
