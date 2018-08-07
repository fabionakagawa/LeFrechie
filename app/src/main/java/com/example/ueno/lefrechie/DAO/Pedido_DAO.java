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
        values.put(Pedido_DataModel.getPedidoId(), obj.getPedidoId_Q());
        values.put(Pedido_DataModel.getPedidoMesa(), obj.getMesaId_Q());
        values.put(Pedido_DataModel.getPedidoBalcao(), obj.getBalcao());
        values.put(Pedido_DataModel.getPedidoData(), obj.getDate());
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

    public List<Pedido> getListaPedidos() {
        int i;
        List<Pedido> lista = new ArrayList<>();
        Pedido pedido = new Pedido();
        Cursor cursor = ds.find(Pedido_DataModel.getPedidoTable(),
                null, null,
                null, null, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (i = 0; i < cursor.getCount(); i++) {
                pedido.setPedidoId_Q(cursor.getInt(cursor.getColumnIndex(Pedido_DataModel.getPedidoId())));
                pedido.setDate(cursor.getString(cursor.getColumnIndex(Pedido_DataModel.getPedidoData())));
                pedido.setHora(cursor.getString(cursor.getColumnIndex(Pedido_DataModel.getPedidoHora())));
                lista.add(pedido);
                cursor.moveToNext();
            }
        }
        return lista;
    }

}

