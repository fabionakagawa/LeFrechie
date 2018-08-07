package com.example.ueno.lefrechie.DataModel;

/**e
 * Created by Ueno on 3/12/2018.
 */

public class Flags_DataModel {
    private static final String FLAG_ID = "Flag_id";
    static final String FLAG_TABLE = "TabelaFlags";
    static final String FLAG_CADASTRO = "ProdutoCadastro"; //1 Cadastro 0 Editar
    static final String FLAG_IDPEDIDO = "IdPedido"; //Numero Id Pedido
    static final String FLAG_X = "x";

    public static final String createFlagTable(){
        String query = "CREATE TABLE "+ FLAG_TABLE +"("
                + FLAG_ID + " integer primary key,"
                + FLAG_CADASTRO + " integer,"
                + FLAG_IDPEDIDO + " integer,"
                + FLAG_X + " text"
                +")";
        return query;
    }

    public static String getFlagId() {
        return FLAG_ID;
    }

    public static String getFlagTable() {
        return FLAG_TABLE;
    }

    public static String getFlagCadastro() {
        return FLAG_CADASTRO;
    }

    public static String getFlagX() {
        return FLAG_X;
    }

    public static String getFlagIdpedido() {
        return FLAG_IDPEDIDO;
    }
}
