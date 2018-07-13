package com.example.ueno.lefrechie.DataModel;

/**
 * Created by Ueno on 3/11/2018.
 */

public class Produto_DataModel {
    private static final String PRODUTO_ID = "Produto_id";
    static final String PRODUTO_TABLE = "TabelaProdutos";
    static final String PRODUTO_NOME = "ProdutoNome";
    static final String PRODUTO_SEGMENTO = "ProdutoSegmento";
    static final String PRODUTO_PRECO = "ProdutoPreco";
    static final String PRODUTO_QUANTIDADE = "ProdutoQuantidade";



    public static final String createProductTable(){
        String query = "CREATE TABLE "+ PRODUTO_TABLE +"("
                + PRODUTO_ID + " integer primary key autoincrement,"
                + PRODUTO_NOME + " text,"
                + PRODUTO_SEGMENTO + " text,"
                + PRODUTO_PRECO + " double,"
                + PRODUTO_QUANTIDADE + " int"
                +")";
        return query;
    }

    public static final String dropProductTable(){
        String query = "DROP TABLE IF EXISTS "+ PRODUTO_TABLE;
        return query;
    }


    public static String getProdutoId() {
        return PRODUTO_ID;
    }

    public static String getProdutoTable() {
        return PRODUTO_TABLE;
    }

    public static String getProdutoNome() {
        return PRODUTO_NOME;
    }

    public static String getProdutoSegmento() {
        return PRODUTO_SEGMENTO;
    }

    public static String getProdutoPreco() {
        return PRODUTO_PRECO;
    }

    public static String getProdutoQuantidade() {
        return PRODUTO_QUANTIDADE;
    }
}

