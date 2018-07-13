package com.example.ueno.lefrechie.Model;

import java.io.Serializable;

/**
 * Created by Ueno on 3/6/2018.
 */

public class Produto implements Serializable {

    private int ProdutoId_Q;
    private String Nome;
    private String Segmento;
    private double Preco;
    private int Quantidade;


    public int getProdutoId_Q() {
        return ProdutoId_Q;
    }

    public String getNome() {
        return Nome;
    }

    public String getSegmento() {
        return Segmento;
    }

    public double getPreco() {
        return Preco;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setProdutoId_Q(int produtoId_Q) {
        ProdutoId_Q = produtoId_Q;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setSegmento(String segmento) {
        Segmento = segmento;
    }

    public void setPreco(Double preco) {
        Preco = preco;
    }

    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }
}
