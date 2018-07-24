package com.example.ueno.lefrechie.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.example.ueno.lefrechie.DataModel.Produto_DataModel;
import com.example.ueno.lefrechie.Model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ueno on 3/11/2018.
 */

public class ProdutoDAO {
    com.example.ueno.lefrechie.DataSource.DataSource ds;
    ContentValues values;

    public ProdutoDAO(Context context) {
        ds = new com.example.ueno.lefrechie.DataSource.DataSource(context);
    }

    public boolean adicionar(Produto obj) {


        boolean retorno = false;

        values = new ContentValues();
        if(obj.getProdutoId_Q() != 0){
            values.put(Produto_DataModel.getProdutoId(),obj.getProdutoId_Q());
        }

        values.put(Produto_DataModel.getProdutoNome(), obj.getNome());
        values.put(Produto_DataModel.getProdutoSegmento(),obj.getSegmento());
        values.put(Produto_DataModel.getProdutoPreco(), obj.getPreco());

        try {
            ds.persist(values, Produto_DataModel.getProdutoTable(), Produto_DataModel.getProdutoId());
            retorno = true;
        } catch (Exception e) {

        }

        return retorno;

    }

    public List<Produto> listarTodosDoces(String doce) {

        Cursor cursor = ds.find(Produto_DataModel.getProdutoTable(),
                null, Produto_DataModel.getProdutoSegmento()+" = '"+doce+"'", null, null, null, null, null);

        List<Produto> lista = new ArrayList<Produto>();

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {

                Produto obj = new Produto();

                obj.setProdutoId_Q(cursor.getInt(cursor.getColumnIndex(Produto_DataModel.getProdutoId())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoNome())));
                obj.setPreco(cursor.getDouble(cursor.getColumnIndex(Produto_DataModel.getProdutoPreco())));
                obj.setSegmento(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoSegmento())));

                lista.add(obj);

                cursor.moveToNext();
            }

        }

        return lista;
    }

    public List<Produto> listarTodosSalgados(String salgado) {

        Cursor cursor = ds.find(Produto_DataModel.getProdutoTable(),
                null, Produto_DataModel.getProdutoSegmento()+" = '"+salgado+"'", null, null, null, null, null);

        List<Produto> lista = new ArrayList<Produto>();

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {

                Produto obj = new Produto();

                obj.setProdutoId_Q(cursor.getInt(cursor.getColumnIndex(Produto_DataModel.getProdutoId())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoNome())));
                obj.setPreco(cursor.getDouble(cursor.getColumnIndex(Produto_DataModel.getProdutoPreco())));
                obj.setSegmento(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoSegmento())));

                lista.add(obj);

                cursor.moveToNext();
            }

        }

        return lista;
    }

    public List<Produto> listarTodosCafes(String cafe) {

        Cursor cursor = ds.find(Produto_DataModel.getProdutoTable(),
                null, Produto_DataModel.getProdutoSegmento()+" = '"+cafe+"'", null, null, null, null, null);

        List<Produto> lista = new ArrayList<Produto>();

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {

                Produto obj = new Produto();

                obj.setProdutoId_Q(cursor.getInt(cursor.getColumnIndex(Produto_DataModel.getProdutoId())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoNome())));
                obj.setPreco(cursor.getDouble(cursor.getColumnIndex(Produto_DataModel.getProdutoPreco())));
                obj.setSegmento(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoSegmento())));

                lista.add(obj);

                cursor.moveToNext();
            }

        }

        return lista;
    }

    public List<Produto> listarTodasBebidas(String bebida) {

        Cursor cursor = ds.find(Produto_DataModel.getProdutoTable(),
                null, Produto_DataModel.getProdutoSegmento()+" = '"+bebida+"'", null, null, null, null, null);

        List<Produto> lista = new ArrayList<Produto>();

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {

                Produto obj = new Produto();

                obj.setProdutoId_Q(cursor.getInt(cursor.getColumnIndex(Produto_DataModel.getProdutoId())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoNome())));
                obj.setPreco(cursor.getDouble(cursor.getColumnIndex(Produto_DataModel.getProdutoPreco())));
                obj.setSegmento(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoSegmento())));

                lista.add(obj);

                cursor.moveToNext();
            }

        }

        return lista;
    }

    public List<Produto> listarTodosPetiscos(String petisco) {

        Cursor cursor = ds.find(Produto_DataModel.getProdutoTable(),
                null, Produto_DataModel.getProdutoSegmento()+" = '"+petisco+"'", null, null, null, null, null);

        List<Produto> lista = new ArrayList<Produto>();

        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {

                Produto obj = new Produto();

                obj.setProdutoId_Q(cursor.getInt(cursor.getColumnIndex(Produto_DataModel.getProdutoId())));
                obj.setNome(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoNome())));
                obj.setPreco(cursor.getDouble(cursor.getColumnIndex(Produto_DataModel.getProdutoPreco())));
                obj.setSegmento(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoSegmento())));

                lista.add(obj);

                cursor.moveToNext();
            }

        }

        return lista;
    }
    public Produto retornaproduto() {

        Cursor cursor = ds.find(Produto_DataModel.getProdutoTable(),
                null, null, null, null, null, null, null);
        Produto obj = null;
        if (cursor.getCount() > 0) {

            cursor.moveToFirst();

            obj = new Produto();

            obj.setProdutoId_Q(cursor.getInt(cursor.getColumnIndex(Produto_DataModel.getProdutoId())));
            obj.setNome(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoNome())));
            obj.setPreco(cursor.getDouble(cursor.getColumnIndex(Produto_DataModel.getProdutoPreco())));
            obj.setSegmento(cursor.getString(cursor.getColumnIndex(Produto_DataModel.getProdutoSegmento())));

        }
        return obj;
    }
}