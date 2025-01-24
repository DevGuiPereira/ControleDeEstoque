/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estoque;

import com.mycompany.estoque.repository.Conexao;
import com.mycompany.estoque.repository.ConexaoMySQL;
import com.mycompany.estoque.view.Inicio;

/**
 *
 * @author guilh
 */
public class Estoque {
    
    private Conexao conexao;
    public ConexaoMySQL conexaoMySQL;

    public static void main(String[] args) {       
            // Inicia o Programa com a tela Início
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            inicio.setTitle("Início");
    }    
 }

