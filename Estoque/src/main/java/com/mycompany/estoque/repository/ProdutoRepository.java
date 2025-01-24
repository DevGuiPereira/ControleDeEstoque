/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estoque.repository;
import com.mycompany.estoque.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author guilh
 */
public class ProdutoRepository implements Crud<Produto> {

    @Override
    public boolean inserir(Connection connection, Produto produto) {
        PreparedStatement stmt = null;
        try{
            String comando = "INSERT INTO produtos(nome, descricao, preco, quantidade) " +
                             "VALUES(?, ?, ?, ?)";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao inserir produto: " + ex.getMessage(),
                    "Erro ao inserir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean atualizar(Connection connection, Produto produto) {
        PreparedStatement stmt = null;
        try{
            String comando = "UPDATE produtos SET " +
                             "nome = ?, descricao = ?, preco = ?, quantidade = ? " +
                             "WHERE idprodutos = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao atualizar prouto: " + ex.getMessage(),
                    "Erro ao atualizar",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }
    }

    @Override
    public boolean deletar(Connection connection, int id) {
        PreparedStatement stmt = null;
        try{
            String comando = "DELETE FROM produtos " +
                             "WHERE idprodutos = ?";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1,id);
            stmt.executeUpdate();
            stmt.close();
            return true;
        }catch(Exception ex){
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao excluir produto: " + ex.getMessage(),
                    "Erro ao excluir",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }   
    }

    @Override
    public Produto selecionar(Connection connection, int id) {
        Produto produto = new Produto();
        
        try{
            PreparedStatement stmt = null;
            String comando = "SELECT * FROM produtos WHERE idprodutos = ? ";
            stmt = connection.prepareStatement(comando);
            stmt.setInt(1, id);
            
            ResultSet res = stmt.executeQuery();
            if(res.next()){                
                produto.setId(Integer.parseInt(res.getString("idprodutos") ));
                produto.setNome(res.getString("nome"));
                produto.setDescricao(res.getString("descricao"));
                produto.setPreco(res.getDouble("preco"));
                produto.setQuantidade(Integer.parseInt(res.getString("quantidade") ));
            }
        }catch(Exception ex){ 
            ex.printStackTrace();
        }
        return produto;
    }

    @Override
    public List<Produto> selecionarTodos(Connection connection) {
        List<Produto> produtos = new ArrayList<>();
        String comando = "SELECT * FROM produtos";

        try {
            PreparedStatement stmt = connection.prepareStatement(comando);
            ResultSet rs = stmt.executeQuery();

            // Preenchendo a lista de produtos com os dados do ResultSet
            while (rs.next()) {
                
                Produto produto = new Produto();
                produto.setId(rs.getInt("idprodutos"));  // Assumindo que a coluna seja 'idProduto'
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);  // Adiciona o produto na lista
            }

            rs.close();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return produtos;  // Retorna a lista de produtos
    }

    @Override
    public List<Produto> selecionarPoucoEstoque(Connection connection) {
        
        List<Produto> produtos = new ArrayList<>();
        String comando = "SELECT * FROM produtos WHERE quantidade < 5";

        try {
            PreparedStatement stmt = connection.prepareStatement(comando);
            ResultSet rs = stmt.executeQuery();

            // Preenchendo a lista de produtos com os dados do ResultSet
            while (rs.next()) {
                
                Produto produto = new Produto();
                produto.setId(rs.getInt("idprodutos"));  // Assumindo que a coluna seja 'idProduto'
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);  // Adiciona o produto na lista
            }

            rs.close();
            stmt.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return produtos;  // Retorna a lista de produtos
    }

}
    
