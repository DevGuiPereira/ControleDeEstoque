package com.mycompany.estoque.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoMySQL {
    private Conexao conexao = null;
    public static Connection connection = null;

    public ConexaoMySQL(Conexao conexao) {
        this.conexao = conexao;
    }

    public boolean conectar() {
        if (conexao != null) {
            try {
                String url = "jdbc:mysql://" + conexao.getEndereco() +
                             ":" + conexao.getPorta() +
                             "/" + conexao.getNomeBanco();
                        
                        
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Estabelece a conexão
                connection = DriverManager.getConnection(
                        url,
                        conexao.getUser(),
                        conexao.getPassword()
                );

                return true;

            } catch (Exception ex) {
                // Exibe a mensagem de erro e imprime o stack trace
                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao conectar ao banco de dados: " + ex.getMessage(),
                        "Erro ao conectar",
                        JOptionPane.ERROR_MESSAGE
                );
                ex.printStackTrace();
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Configuração de conexão inválida!",
                    "Erro ao conectar",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }
}
