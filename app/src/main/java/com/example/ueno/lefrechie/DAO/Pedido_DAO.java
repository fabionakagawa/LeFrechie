package com.example.ueno.lefrechie.DAO;

import android.content.ContentValues;
import android.content.Context;

import com.example.ueno.lefrechie.DataModel.Pedido_DataModel;
import com.example.ueno.lefrechie.DataModel.Produto_DataModel;
import com.example.ueno.lefrechie.Model.Pedido;

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
        values.put(Pedido_DataModel.getPedidoData(), obj.getData());
        values.put(Pedido_DataModel.getPedidoHora(), obj.getHora());
        values.put(Pedido_DataModel.getPedidoLista(), obj.getListaProdutos().getListaId_Q());


        try {
            ds.persist(values, Produto_DataModel.getProdutoTable(), Produto_DataModel.getProdutoId());
            retorno = true;
        } catch (Exception e) {

        }

        return retorno;
    }
}

