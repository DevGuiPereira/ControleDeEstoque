# Estoque - Sistema de Controle de Estoque

Este projeto é um sistema de controle de estoque desenvolvido a matéria de POO em Java. Ele permite gerenciar produtos, incluindo operações de criação, edição, exclusão e consulta (CRUD), utilizando uma interface gráfica construída com Swing. A aplicação está integrada a um banco de dados MySQL para persistência dos dados localmente.

## 🔧 Funcionalidades

- **Cadastro de Produtos**: Insira novos produtos com informações como nome, descrição, preço e quantidade.
- **Edição de Produtos**: Atualize as informações dos produtos existentes.
- **Exclusão de Produtos**: Remova produtos do banco de dados.
- **Busca por ID**: Localize produtos rapidamente utilizando seu identificador único.
- **Interface Gráfica**: Navegação amigável com telas desenvolvidas em Swing.
- **Conexão com Banco de Dados**: Persistência dos dados em um banco de dados MySQL Local.

## 📂 Estrutura do Projeto

O projeto está organizado em pacotes para facilitar a manutenção:

- `model`: Classes de modelo, como `Produto`, que representam os dados da aplicação.
- `repository`: Contém as classes de conexão com o banco de dados e operações CRUD.
- `view`: Interface gráfica com telas como cadastro, edição e listagem.

## 🛑 Requisitos

Certifique-se de ter os seguintes requisitos instalados antes de executar o projeto:

- Java JDK 8 ou superior
- MySQL Server
- Maven (para gerenciamento de dependências)
- IDE compatível (NetBeans ou IntelliJ)

## 🔧 Configuração e Execução

1. Clone este repositório:
   ```bash
   git clone https://github.com/DevGuiPereira/ControleDeEstoque.git
   ```
2. Navegue até a pasta do projeto:
   ```bash
   cd estoque
   ```
3. Configure o banco de dados:
   - Crie o banco de dados `estoque` no MySQL.
   - Importe o script SQL disponível no projeto para criar a tabela `produtos`.
4. Compile e execute o projeto:
   ```bash
   mvn clean install
   mvn exec:java
   ```
5. Use a aplicação através da interface gráfica.
6. Lembre-se de colocar a sua senha do banco de dados nos arquivos de 'Cadastro','Edicao' e 'Inicio' para o programa funcionar.

## 🚀 Tecnologias Utilizadas

- **Linguagem**: Java
- **Banco de Dados**: MySQL
- **Interface Gráfica**: Swing
- **Gerenciamento de Dependências**: Maven

## 🤝 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma _issue_.

## ✨ Autor

- **Guilherme Pereira** - [LinkedIn](https://www.linkedin.com/in/guilherme-reis-pereira/) | [GitHub](https://github.com/DevGuiPereira)
