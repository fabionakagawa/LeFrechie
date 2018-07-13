package com.example.ueno.lefrechie.DataModel;

import java.util.List;

/**
 * Created by Ueno on 3/11/2018.
 */

public class Lista_DataModel {

    private static final String Lista_ID = "Lista_id";
    private static final String Lista_TAMANHO = "Lista_Tamanho";
    static final String LISTA_TABLE = "TabelaLista";
    static final String LISTA_PRODUTO1 = "ListaProduto1";
    static final String LISTA_QUANTIDADE1 = "ListaQuantidade1";
    static final String LISTA_PRODUTO2 = "ListaProduto2";
    static final String LISTA_QUANTIDADE2 = "ListaQuantidade2";
    static final String LISTA_PRODUTO3 = "ListaProduto3";
    static final String LISTA_QUANTIDADE3 = "ListaQuantidade3";
    static final String LISTA_PRODUTO4 = "ListaProduto4";
    static final String LISTA_QUANTIDADE4 = "ListaQuantidade4";
    static final String LISTA_PRODUTO5 = "ListaProduto5";
    static final String LISTA_QUANTIDADE5 = "ListaQuantidade5";
    static final String LISTA_PRODUTO6 = "ListaProduto6";
    static final String LISTA_QUANTIDADE6 = "ListaQuantidade6";
    static final String LISTA_PRODUTO7 = "ListaProduto7";
    static final String LISTA_QUANTIDADE7 = "ListaQuantidade7";
    static final String LISTA_PRODUTO8 = "ListaProduto8";
    static final String LISTA_QUANTIDADE8 = "ListaQuantidade8";
    static final String LISTA_PRODUTO9 = "ListaProduto9";
    static final String LISTA_QUANTIDADE9 = "ListaQuantidade9";
    static final String LISTA_PRODUTO10 = "ListaProduto10";
    static final String LISTA_QUANTIDADE10 = "ListaQuantidade10";
    static final String LISTA_TOTAL = "ListaTotal";


    public static final String createListTable(){
        String query = "CREATE TABLE "+ LISTA_TABLE +"("
                + Lista_ID + " integer primary key autoincrement,"
                + Lista_TAMANHO + " int,"
                + LISTA_TOTAL + " int,"
                + LISTA_PRODUTO1 + " int,"
                + LISTA_QUANTIDADE1 + " int,"
                + LISTA_PRODUTO2 + " int,"
                + LISTA_QUANTIDADE2 + " int,"
                + LISTA_PRODUTO3 + " int,"
                + LISTA_QUANTIDADE3 + " int,"
                + LISTA_PRODUTO4 + " int,"
                + LISTA_QUANTIDADE4 + " int,"
                + LISTA_PRODUTO5 + " int,"
                + LISTA_QUANTIDADE5 + " int,"
                + LISTA_PRODUTO6 + " int,"
                + LISTA_QUANTIDADE6 + " int,"
                + LISTA_PRODUTO7 + " int,"
                + LISTA_QUANTIDADE7 + " int,"
                + LISTA_PRODUTO8 + " int,"
                + LISTA_QUANTIDADE8 + " int,"
                + LISTA_PRODUTO9 + " int,"
                + LISTA_QUANTIDADE9 + " int,"
                + LISTA_PRODUTO10 + " int,"
                + LISTA_QUANTIDADE10 + " int"
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

    public static String getLista_TAMANHO() {
        return Lista_TAMANHO;
    }

    public static String getLista_ID() {
        return Lista_ID;
    }

    public static String getListaTable() {
        return LISTA_TABLE;
    }

    public static String getListaProduto1() {
        return LISTA_PRODUTO1;
    }

    public static String getListaQuantidade1() {
        return LISTA_QUANTIDADE1;
    }

    public static String getListaProduto2() {
        return LISTA_PRODUTO2;
    }

    public static String getListaQuantidade2() {
        return LISTA_QUANTIDADE2;
    }

    public static String getListaProduto3() {
        return LISTA_PRODUTO3;
    }

    public static String getListaQuantidade3() {
        return LISTA_QUANTIDADE3;
    }

    public static String getListaProduto4() {
        return LISTA_PRODUTO4;
    }

    public static String getListaQuantidade4() {
        return LISTA_QUANTIDADE4;
    }

    public static String getListaProduto5() {
        return LISTA_PRODUTO5;
    }

    public static String getListaQuantidade5() {
        return LISTA_QUANTIDADE5;
    }

    public static String getListaProduto6() {
        return LISTA_PRODUTO6;
    }

    public static String getListaQuantidade6() {
        return LISTA_QUANTIDADE6;
    }

    public static String getListaProduto7() {
        return LISTA_PRODUTO7;
    }

    public static String getListaQuantidade7() {
        return LISTA_QUANTIDADE7;
    }

    public static String getListaProduto8() {
        return LISTA_PRODUTO8;
    }

    public static String getListaQuantidade8() {
        return LISTA_QUANTIDADE8;
    }

    public static String getListaProduto9() {
        return LISTA_PRODUTO9;
    }

    public static String getListaQuantidade9() {
        return LISTA_QUANTIDADE9;
    }

    public static String getListaProduto10() {
        return LISTA_PRODUTO10;
    }

    public static String getListaQuantidade10() {
        return LISTA_QUANTIDADE10;
    }

}
