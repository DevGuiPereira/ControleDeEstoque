/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.estoque;

import com.mycompany.estoque.model.Produto;
import com.mycompany.estoque.repository.Conexao;
import com.mycompany.estoque.repository.ConexaoMySQL;
import com.mycompany.estoque.repository.ProdutoRepository;
import com.mycompany.estoque.view.Inicio;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guilh
 */
public class Estoque {
    
    private Conexao conexao;
    public ConexaoMySQL conexaoMySQL;

    public static void main(String[] args) {
        /*Conexao conexao = new Conexao(
                "localhost",
                "root",
                "Guirp007007!",
                3306,
                "controle_estoque"
        );
        ConexaoMySQL conexaoMySQL = new ConexaoMySQL(conexao);
        conexaoMySQL.conectar();*/
            Inicio inicio = new Inicio();
            inicio.setVisible(true);
            inicio.setTitle("Início");
    }    
 }

