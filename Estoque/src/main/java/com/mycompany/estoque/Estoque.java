/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estoque;

import com.mycompany.estoque.model.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class Estoque {

    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        
        // Criando objetos Produto
        Produto produto1 = new Produto(1, "Teclado", "Teclado mecânico RGB", 250.00, 10);
        Produto produto2 = new Produto(2, "Mouse", "Mouse gamer 16000 DPI", 150.00, 15);

        // Adicionando os produtos à lista
        produtos.add(produto1);
        produtos.add(produto2);
        
        // Exibindo informações dos produtos utilizando toString
        System.out.println("Produtos cadastrados:");
        
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
    

    

}
