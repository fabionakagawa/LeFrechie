package com.example.ueno.lefrechie.Model;

import java.util.List;

/**
 * Created by Ueno on 3/11/2018.
 */

public class ListaProdutos {

    private int ListaId_Q;
    private int ListaTamanho;
    private List<Produto> produtos;
    private int Total;

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public int getListaId_Q() {
        return ListaId_Q;
    }

    public void setListaId_Q(int listaId_Q) {
        ListaId_Q = listaId_Q;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getListaTamanho() {
        return ListaTamanho;
    }

    public void setListaTamanho(int listaTamanho) {
        ListaTamanho = listaTamanho;
    }
}
