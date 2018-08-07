package com.example.ueno.lefrechie.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.ueno.lefrechie.DataModel.Lista_DataModel;
import com.example.ueno.lefrechie.DataModel.Pedido_DataModel;
import com.example.ueno.lefrechie.DataModel.Produto_DataModel;
import com.example.ueno.lefrechie.Model.ListaProdutos;
import com.example.ueno.lefrechie.Model.Pedido;
import com.example.ueno.lefrechie.Model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ueno on 3/11/2018.
 */

public class Lista_DAO {
    com.example.ueno.lefrechie.DataSource.DataSource ds;
    ContentValues values;

    public Lista_DAO(Context context) {
        ds = new com.example.ueno.lefrechie.DataSource.DataSource(context);
    }


        public boolean adicionarItemZero(){
            boolean retorno = false;

            values = new ContentValues();

            Cursor cursor = ds.find(Lista_DataModel.getListaTable(),
                    null, null,null,null,null,null,null);
            cursor.moveToFirst();
            values.put(Lista_DataModel.getLista_ID(),0);
            try {
                ds.persist(values, Lista_DataModel.getListaTable(), Lista_DataModel.getLista_ID());
                retorno = true;
            } catch (Exception e) {

            }
        return retorno;
        }

        public boolean adicionarItem(ListaProdutos obj) {


        boolean retorno = false;

        values = new ContentValues();

            Cursor cursor = ds.find(Lista_DataModel.getListaTable(),
                    null, Lista_DataModel.getListaPedidoId()+ " = "+obj.getLista_PedidoId(),null,null,null,Lista_DataModel.getLista_ID(),null);

            cursor.moveToFirst();
            if (cursor.getCount()<=0) {
                Log.i("ListaProdNome" , "MENOR ZERO - ENTROU");
                values.put(Lista_DataModel.getListaPedidoId(),obj.getLista_PedidoId());
                Log.i("ListaProdNome" , "ID ADD");
                values.put(Lista_DataModel.getListaProdutoId(),obj.getListaProdutoId());
                Log.i("ListaProdNome" , "PROD ID ADD");
                values.put(Lista_DataModel.getListaProdutoNome(),obj.getListaProdutoNome());
                Log.i("ListaProdNome" , "PROD NOME ADD");
                values.put(Lista_DataModel.getListaProdutoQuantidade(),obj.getListaProdutoQuantidade());
            }
            else{
                values.put(Lista_DataModel.getListaPedidoId(),obj.getLista_PedidoId());
                values.put(Lista_DataModel.getListaProdutoId(),obj.getListaProdutoId());
                values.put(Lista_DataModel.getListaProdutoNome(),obj.getListaProdutoNome());
                values.put(Lista_DataModel.getListaProdutoQuantidade(),Lista_DataModel.getListaProdutoQuantidade()+ obj.getListaProdutoQuantidade());
            }
        try {
            ds.persist(values, Lista_DataModel.getListaTable(), Lista_DataModel.getLista_ID());
            retorno = true;
        } catch (Exception e) {

        }
        return retorno;
    }

    public List<Produto> listaProdutos(int idPedido){
        List<Produto> lista = new ArrayList<>();
        Produto produto = new Produto();
        values = new ContentValues();

        Log.i("ZZZZZZZZ" , "CHWGOOOOOOOOOOOOOOOOOOOOOOOOOUZZZZZZZ");

        Cursor cursor = ds.find(Lista_DataModel.getListaTable(),
                null, Lista_DataModel.getLista_ID()+ " = "+ idPedido,null,null,null,null ,null);
        Log.i("KKKKKK" , "CHWGOOOOOOOOOOOOOOOOOOOOOOOOOUZZZZZZZ");
        if(cursor.getCount()>0) {
        cursor.moveToFirst();
            Log.i("JJJJJJJJJ" , "CHWGOOOOOOOOOOOOOOOOOOOOOOOOOUZZZZZZZ");
            for (int i = 0;i<cursor.getCount();i++) {
                produto.setProdutoId_Q(cursor.getInt(cursor.getColumnIndex(Lista_DataModel.getListaPedidoId())));
                Log.i("LLLLLLLLL" , "CHWGOOOOOOOOOOOOOOOOOOOOOOOOOUZZZZZZZ");
                produto.setNome(cursor.getString(cursor.getColumnIndex(Lista_DataModel.getListaProdutoNome())));
                produto.setQuantidade(cursor.getInt(cursor.getColumnIndex(Lista_DataModel.getListaProdutoQuantidade())));
                lista.add(produto);
                cursor.moveToNext();
            }
        }

        return lista;
    }
}
