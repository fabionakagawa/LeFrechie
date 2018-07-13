package com.example.ueno.lefrechie.DataModel;

/**
 * Created by Ueno on 3/11/2018.
 */

public class Pedido_DataModel {
    private static final String PEDIDO_ID = "Pedido_id";
    static final String PEDIDO_TABLE = "TabelaPedidos";
    static final String PEDIDO_MESA = "PedidoMesa";
    static final String PEDIDO_BALCAO= "PedidoBalcao";
    static final String PEDIDO_DATA = "PedidoData";
    static final String PEDIDO_HORA = "PedidoHora";
    static final String PEDIDO_LISTA = "PedidoLista";


    public static final String createOrderTable(){
        String query = "CREATE TABLE "+ PEDIDO_TABLE +"("
                + PEDIDO_ID + " integer primary key autoincrement,"
                + PEDIDO_MESA + " int,"
                + PEDIDO_BALCAO + " int,"
                + PEDIDO_DATA + " text,"
                + PEDIDO_HORA + " text,"
                + PEDIDO_LISTA + " int"
                +")";
        return query;
    }

    public static final String dropOrderTable(){
        String query = "DROP TABLE IF EXISTS "+ PEDIDO_TABLE;
        return query;
    }

    public static String getPedidoBalcao() {
        return PEDIDO_BALCAO;
    }

    public static String getPedidoId() {
        return PEDIDO_ID;
    }

    public static String getPedidoTable() {
        return PEDIDO_TABLE;
    }

    public static String getPedidoMesa() {
        return PEDIDO_MESA;
    }

    public static String getPedidoData() {
        return PEDIDO_DATA;
    }

    public static String getPedidoHora() {
        return PEDIDO_HORA;
    }

    public static String getPedidoLista() {
        return PEDIDO_LISTA;
    }
}
