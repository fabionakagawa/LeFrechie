package com.example.ueno.lefrechie.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.ueno.lefrechie.DataModel.Lista_DataModel;
import com.example.ueno.lefrechie.DataModel.Pedido_DataModel;
import com.example.ueno.lefrechie.DataModel.Produto_DataModel;
import com.example.ueno.lefrechie.Model.Pedido;
import com.example.ueno.lefrechie.Model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ueno on 3/11/2018.
 */

public class Pedido_DAO {
    com.example.ueno.lefrechie.DataSource.DataSource ds;
    ContentValues values;

    public Pedido_DAO(Context context) {
        ds = new com.example.ueno.lefrechie.DataSource.DataSource(context);
    }

    public boolean adicionar(Pedido obj) {


        boolean retorno = false;

        values = new ContentValues();
        values.put(Pedido_DataModel.getPedidoNum(),obj.getPedidoNum());
        values.put(Pedido_DataModel.getPedidoProdutonome(),obj.getProdutoNome());
        values.put(Pedido_DataModel.getPedidoProdutoquantidade(),obj.getProdutoQuantidade());
        values.put(Pedido_DataModel.getPedidoProdutostatus(), obj.getStatus());
        values.put(Pedido_DataModel.getPedidoMesa(), obj.getMesaId_Q());
        values.put(Pedido_DataModel.getPedidoBalcao(), obj.getBalcao());
        values.put(Pedido_DataModel.getPedidoData(), obj.getData());
        values.put(Pedido_DataModel.getPedidoHora(), obj.getHora());

        try {
            ds.persist(values, Pedido_DataModel.getPedidoTable(), Pedido_DataModel.getPedidoId());
            retorno = true;
        } catch (Exception e) {

        }

        return retorno;
    }

    public int getLastOrderId(String data){
        int i;
        Cursor cursor = ds.find(Pedido_DataModel.getPedidoTable(),
                null,Pedido_DataModel.getPedidoData()+" = "+data,
                null,null,null,Pedido_DataModel.getPedidoId(),null);
        if (cursor.getCount()<=0) {
            return 1;
        }
        else{
            cursor.moveToLast();
            i= cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoId())+1);
            return i;
        }
    }

    public List<Pedido> getListaPedidos(int id) {
        int i;
        List<Pedido> lista = new ArrayList<>();

        Cursor cursor = ds.find(Pedido_DataModel.getPedidoTable(),
                null, Pedido_DataModel.getPedidoNum()+" = "+id,
                null, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (i = 0; i < cursor.getCount(); i++) {

                Pedido pedido = new Pedido();
                
                pedido.setPedidoId_Q(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoId())));
                pedido.setPedidoNum(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoNum())));
                pedido.setData(cursor.getString(cursor.getColumnIndex(Pedido_DataModel.getPedidoData())));
                pedido.setHora(cursor.getString(cursor.getColumnIndex(Pedido_DataModel.getPedidoHora())));
                pedido.setProdutoId(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoProdutoid())));
                pedido.setProdutoNome(cursor.getString(cursor.getColumnIndex(Pedido_DataModel.getPedidoProdutonome())));
                pedido.setProdutoQuantidade(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoProdutoquantidade())));

                lista.add(pedido);

                cursor.moveToNext();
            }
        }
        return lista;
    }
    public List<Pedido> getListaTodosPedidos() {
        int i;
        List<Pedido> lista = new ArrayList<>();

        Cursor cursor = ds.find(Pedido_DataModel.getPedidoTable(),
                null, null,
                null, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (i = 0; i < cursor.getCount(); i++) {

                Pedido pedido = new Pedido();

                pedido.setPedidoId_Q(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoId())));
                pedido.setPedidoNum(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoNum())));
                pedido.setData(cursor.getString(cursor.getColumnIndex(Pedido_DataModel.getPedidoData())));
                pedido.setHora(cursor.getString(cursor.getColumnIndex(Pedido_DataModel.getPedidoHora())));
                pedido.setProdutoId(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoProdutoid())));
                pedido.setProdutoNome(cursor.getString(cursor.getColumnIndex(Pedido_DataModel.getPedidoProdutonome())));
                pedido.setProdutoQuantidade(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoProdutoquantidade())));
                Log.i("PedidoId" , String.valueOf(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoId()))));
                Log.i("PedidoIdXXXXXXXXXX" , String.valueOf(pedido.getPedidoId_Q()));
                lista.add(i,pedido);
                Log.i("PedidoIdYYYYYYYYY" , String.valueOf(lista.get(i).getPedidoId_Q()));
                Log.i("CursorId" , String.valueOf(cursor.getPosition()));
                cursor.moveToNext();
                Log.i("CursorId2" , String.valueOf(cursor.getPosition()));
            }
        }
        return lista;
    }
}

