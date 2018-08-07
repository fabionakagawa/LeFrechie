package com.example.ueno.lefrechie.DataModel;

import android.util.Log;

import java.util.List;

/**
 * Created by Ueno on 3/11/2018.
 */

public class Lista_DataModel {

    private static final String Lista_ID = "Lista_Id";
    static final String LISTA_PEDIDO_ID = "ListaPedidoId";
    static final String LISTA_TABLE = "TabelaLista";
    static final String Lista_TAMANHO = "ListaTamanho";
    static final String LISTA_PRODUTO_ID = "ListaProdutoId";
    static final String LISTA_PRODUTO_NOME = "ListaProdutoNome";
    static final String LISTA_PRODUTO_QUANTIDADE = "ListaProdutoQuantidade";
    static final String LISTA_TOTAL = "ListaTotal";


    public static final String createListTable(){
        String query = "CREATE TABLE "+ LISTA_TABLE +"("
                + Lista_ID + " integer primary key autoincrement,"
                + LISTA_PEDIDO_ID + " int,"
                + Lista_TAMANHO + " int,"
                + LISTA_PRODUTO_ID + " int,"
                + LISTA_PRODUTO_NOME + " text,"
                + LISTA_PRODUTO_QUANTIDADE + " int,"
                + LISTA_TOTAL + " int"
                +")";
        return query;
    }

    public static String getListaTotal() {
        return LISTA_TOTAL;
    }

    public static final String dropListTable(){
        String query = "DROP TABLE IF EXISTS "+ LISTA_TABLE;
        return query;
    }

    public static String getLista_ID() {
        return Lista_ID;
    }

    public static String getListaTable() {
        return LISTA_TABLE;
    }

    public static String getLista_TAMANHO() {
        return Lista_TAMANHO;
    }

    public static String getListaProdutoId() {
        Log.i("AQUI" ,LISTA_PRODUTO_ID );
        return LISTA_PRODUTO_ID;
    }

    public static String getListaProdutoNome() {
        return LISTA_PRODUTO_NOME;
    }

    public static String getListaProdutoQuantidade() {
        return LISTA_PRODUTO_QUANTIDADE;
    }

    public static String getListaPedidoId() {
        return LISTA_PEDIDO_ID;
    }
}
