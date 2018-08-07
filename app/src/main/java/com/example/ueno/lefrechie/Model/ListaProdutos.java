package com.example.ueno.lefrechie.Model;

import java.util.List;

/**
 * Created by Ueno on 3/11/2018.
 */

public class ListaProdutos {

    private int ListaId_Q;
    private int Lista_PedidoId;
    private int ListaTamanho;
    private int ListaProdutoId;
    private String ListaProdutoNome;
    private int ListaProdutoQuantidade;
    private String ListaData;
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

    public int getListaTamanho() {
        return ListaTamanho;
    }

    public void setListaTamanho(int listaTamanho) {
        ListaTamanho = listaTamanho;
    }

    public String getListaData() {
        return ListaData;
    }

    public void setListaData(String listaData) {
        ListaData = listaData;
    }

    public int getListaProdutoId() {
        return ListaProdutoId;
    }

    public void setListaProdutoId(int listaProdutoId) {
        ListaProdutoId = listaProdutoId;
    }

    public String getListaProdutoNome() {
        return ListaProdutoNome;
    }

    public void setListaProdutoNome(String listaProdutoNome) {
        ListaProdutoNome = listaProdutoNome;
    }

    public int getListaProdutoQuantidade() {
        return ListaProdutoQuantidade;
    }

    public void setListaProdutoQuantidade(int listaProdutoQuantidade) {
        ListaProdutoQuantidade = listaProdutoQuantidade;
    }

    public int getLista_PedidoId() {
        return Lista_PedidoId;
    }

    public void setLista_PedidoId(int lista_PedidoId) {
        Lista_PedidoId = lista_PedidoId;
    }
}
