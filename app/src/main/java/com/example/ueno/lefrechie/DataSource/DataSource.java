package com.example.ueno.lefrechie.DataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


import com.example.ueno.lefrechie.DataModel.Flags_DataModel;
import com.example.ueno.lefrechie.DataModel.Lista_DataModel;
import com.example.ueno.lefrechie.DataModel.Pedido_DataModel;
import com.example.ueno.lefrechie.DataModel.Produto_DataModel;

/**
 * Created by AdmAbaco on 03/10/2016.
 */
public class DataSource extends SQLiteOpenHelper {

    SQLiteDatabase db;
    private static final String NOME_BANCO = "banco.db";
    private static final int VERSAO = 1;

    public DataSource(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
        db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("a","1");
        db.execSQL(Produto_DataModel.createProductTable());
        db.execSQL(Pedido_DataModel.createOrderTable());
        db.execSQL(Flags_DataModel.createFlagTable());
        db.execSQL(Lista_DataModel.createListTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onCreate(db);
    }
    public void deleteTables(){
        db.delete(Produto_DataModel.getProdutoTable(),null,null);
        db.delete(Pedido_DataModel.getPedidoTable(),null,null);
        db.delete(Flags_DataModel.getFlagTable(),null,null);
        db.delete(Lista_DataModel.getListaTable(),null,null);

    }

    /**
     * Método persiste - Incluir ou alterar os dados no Banco de Dados
     * Caso o ID seja nulo ou zero, será executado o método insert().
     * Caso contrário, será executado o método update().
     * @param values
     * @param tabela
     */

    public void persist(ContentValues values, String tabela,String idString) {
        Log.i("Persist","CHEGUEEEEEEEEEEEEEEI");
        Cursor cursor = this.find(tabela,
                null,idString + " = '" + values.getAsInteger(idString) + "'",null,null,null,null,null);

        if (values.containsKey(idString) && values.getAsInteger(idString) != null
                && values.getAsInteger(idString) != 0 && cursor.getCount()>0) {
            Integer id = values.getAsInteger(idString);
            db.update(tabela, values, idString+" = " + id, null);
            Log.i("Update ID",String.valueOf(id));
            Log.i("Update String",values.toString());
            Log.i("Update","CHEGUEEEEEEEEEEEEEEI");
        } else {
            Log.i("Insert","CHEGUEEEEEEEEEEEEEEI");
            db.insert(tabela, null, values);
        }

    }

    public void updateRow(ContentValues values,String whereClause, String tabela) {
        db.update(tabela,values,whereClause,null);
    }

    /**
     * Método find utilizado para persquisar dados em qualquer tabela do banco
     * de dados local conforme os parâmetros informados.
     *
     * Retorna um DataSet com o resultado da busca.
     *
     * @return retorno
     *
     */
    public Cursor find(String tabela, String[] columns, String selection,
                       String[] selectionArgs, String groupBy, String having,
                       String orderBy, String limit) {
        Cursor retorno = db.query(tabela, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit);

        return retorno;
    }

    public Cursor findDistinct(String tabela, String[] columns, String selection,
                       String[] selectionArgs, String groupBy, String having,
                       String orderBy, String limit) {
        Cursor retorno = db.query(true,tabela, columns, selection, selectionArgs,
                groupBy, having, orderBy, limit);

        return retorno;
    }

    public void delete(String tabela) {

        db.delete(tabela, null, null);
    }

    public void deleteProduto(int produtoId, String produtoSegmento) {
        Log.i("Update",Produto_DataModel.getProdutoId() + " = " + produtoId);
        db.delete(Produto_DataModel.getProdutoTable(), Produto_DataModel.getProdutoId() + " = " + produtoId , null);
        Log.i("Update","Produto Deletado com Sucesso");
    }
}