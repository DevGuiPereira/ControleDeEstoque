/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.estoque.view;

import com.mycompany.estoque.model.Produto;
import com.mycompany.estoque.repository.Conexao;
import com.mycompany.estoque.repository.ConexaoMySQL;
import com.mycompany.estoque.repository.ProdutoRepository;
import java.sql.Connection;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class Relatorio extends javax.swing.JFrame {

    private ProdutoRepository produtoRepository;
    private Connection connection;
    
    public Relatorio() {
        initComponents();
        setLocationRelativeTo(null);
        configurarConexao();
        carregarTabela();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        relatorioProdutos = new javax.swing.JTable();
        FecharTela = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        relatorioProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Descrição", "Preço", "Qtda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(relatorioProdutos);

        FecharTela.setText("Fechar");
        FecharTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharTela(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(FecharTela))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(FecharTela)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FecharTela(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharTela
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_FecharTela

    private void configurarConexao(){
        // Configurando a conexão
        Conexao conexao = new Conexao(
                "localhost",
                "root",
                "Guirp007007!",
                3306,
                "estoque"
        );

        ConexaoMySQL conexaoMySQL = new ConexaoMySQL(conexao);
        if (conexaoMySQL.conectar()) {  // Certifique-se de que a conexão foi estabelecida
            connection = ConexaoMySQL.connection;  // Atribua a conexão à variável global
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao conectar ao banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;  // Interrompe a execução se não houver conexão
        }
    }
    
    private void carregarTabela() {
              
        // Inicializando o repositório
        ProdutoRepository produtoRepository = new ProdutoRepository();

        // Selecionando os produtos
        List<Produto> produtos = produtoRepository.selecionarTodos(connection);

        if (produtos == null || produtos.isEmpty()) {
            System.out.println("Nenhum produto encontrado no banco de dados.");
            JOptionPane.showMessageDialog(this, "Nenhum produto encontrado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Criando o modelo da tabela
        DefaultTableModel modeloTabela = (DefaultTableModel) relatorioProdutos.getModel();
        modeloTabela.setRowCount(0); // Limpa os dados anteriores da tabela

        for (Produto produto : produtos) {

            modeloTabela.addRow(new Object[]{
                    produto.getId(),
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getPreco(),
                    produto.getQuantidade()
            });
        }

    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Relatorio().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton FecharTela;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable relatorioProdutos;
    // End of variables declaration//GEN-END:variables
}
