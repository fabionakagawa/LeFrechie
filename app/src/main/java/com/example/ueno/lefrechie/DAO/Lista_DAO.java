package com.example.ueno.lefrechie.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

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

    public boolean adicionar(ListaProdutos obj) {


        boolean retorno = false;
        int i,Total = 0 ;
        List<Integer> ProdutosId = null;
        List<Integer> ValorUnitario = null;
        List<Integer> Quantidade = null;
        ProdutoDAO produtoDAO;
        Produto produto;

        values = new ContentValues();

        values.put(Lista_DataModel.getLista_ID(), obj.getListaId_Q());
        int size = obj.getProdutos().size();
        values.put(Lista_DataModel.getLista_TAMANHO(),size);

        for (i=0;i<size; i++)
        {
           ProdutosId.add(obj.getProdutos().get(i).getProdutoId_Q());
           Quantidade.add(obj.getProdutos().get(i).getQuantidade());
        };

        for(int x = 0; x<size; x++){
            Cursor cursor = ds.find(Produto_DataModel.getProdutoTable(),
                    null, Produto_DataModel.getProdutoId()+" = '"+ProdutosId.get(x)+"'",null,null,null,null,null);

            cursor.moveToFirst();
            ValorUnitario.set(x,cursor.getInt(cursor.getColumnIndex(Produto_DataModel.getProdutoPreco())));
            Total = ValorUnitario.get(x)*Quantidade.get(x);
        }
        values.put(Lista_DataModel.getListaTotal(), Total);

        if(i>9){
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
            values.put(Lista_DataModel.getListaProduto2(), obj.getProdutos().get(1).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade2(), obj.getProdutos().get(1).getQuantidade());
            values.put(Lista_DataModel.getListaProduto3(), obj.getProdutos().get(2).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade3(), obj.getProdutos().get(2).getQuantidade());
            values.put(Lista_DataModel.getListaProduto4(), obj.getProdutos().get(3).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade4(), obj.getProdutos().get(3).getQuantidade());
            values.put(Lista_DataModel.getListaProduto5(), obj.getProdutos().get(4).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade5(), obj.getProdutos().get(4).getQuantidade());
            values.put(Lista_DataModel.getListaProduto6(), obj.getProdutos().get(5).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade6(), obj.getProdutos().get(5).getQuantidade());
            values.put(Lista_DataModel.getListaProduto7(), obj.getProdutos().get(6).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade7(), obj.getProdutos().get(6).getQuantidade());
            values.put(Lista_DataModel.getListaProduto8(), obj.getProdutos().get(7).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade8(), obj.getProdutos().get(7).getQuantidade());
            values.put(Lista_DataModel.getListaProduto9(), obj.getProdutos().get(8).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade9(), obj.getProdutos().get(8).getQuantidade());
            values.put(Lista_DataModel.getListaProduto10(), obj.getProdutos().get(9).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade10(), obj.getProdutos().get(9).getQuantidade());
        }
        if(i>8){
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
            values.put(Lista_DataModel.getListaProduto2(), obj.getProdutos().get(1).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade2(), obj.getProdutos().get(1).getQuantidade());
            values.put(Lista_DataModel.getListaProduto3(), obj.getProdutos().get(2).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade3(), obj.getProdutos().get(2).getQuantidade());
            values.put(Lista_DataModel.getListaProduto4(), obj.getProdutos().get(3).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade4(), obj.getProdutos().get(3).getQuantidade());
            values.put(Lista_DataModel.getListaProduto5(), obj.getProdutos().get(4).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade5(), obj.getProdutos().get(4).getQuantidade());
            values.put(Lista_DataModel.getListaProduto6(), obj.getProdutos().get(5).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade6(), obj.getProdutos().get(5).getQuantidade());
            values.put(Lista_DataModel.getListaProduto7(), obj.getProdutos().get(6).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade7(), obj.getProdutos().get(6).getQuantidade());
            values.put(Lista_DataModel.getListaProduto8(), obj.getProdutos().get(7).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade8(), obj.getProdutos().get(7).getQuantidade());
            values.put(Lista_DataModel.getListaProduto9(), obj.getProdutos().get(8).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade9(), obj.getProdutos().get(8).getQuantidade());
        }
        if(i>7){
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
            values.put(Lista_DataModel.getListaProduto2(), obj.getProdutos().get(1).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade2(), obj.getProdutos().get(1).getQuantidade());
            values.put(Lista_DataModel.getListaProduto3(), obj.getProdutos().get(2).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade3(), obj.getProdutos().get(2).getQuantidade());
            values.put(Lista_DataModel.getListaProduto4(), obj.getProdutos().get(3).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade4(), obj.getProdutos().get(3).getQuantidade());
            values.put(Lista_DataModel.getListaProduto5(), obj.getProdutos().get(4).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade5(), obj.getProdutos().get(4).getQuantidade());
            values.put(Lista_DataModel.getListaProduto6(), obj.getProdutos().get(5).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade6(), obj.getProdutos().get(5).getQuantidade());
            values.put(Lista_DataModel.getListaProduto7(), obj.getProdutos().get(6).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade7(), obj.getProdutos().get(6).getQuantidade());
            values.put(Lista_DataModel.getListaProduto8(), obj.getProdutos().get(7).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade8(), obj.getProdutos().get(7).getQuantidade());
        }
        if (i > 6) {
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
            values.put(Lista_DataModel.getListaProduto2(), obj.getProdutos().get(1).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade2(), obj.getProdutos().get(1).getQuantidade());
            values.put(Lista_DataModel.getListaProduto3(), obj.getProdutos().get(2).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade3(), obj.getProdutos().get(2).getQuantidade());
            values.put(Lista_DataModel.getListaProduto4(), obj.getProdutos().get(3).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade4(), obj.getProdutos().get(3).getQuantidade());
            values.put(Lista_DataModel.getListaProduto5(), obj.getProdutos().get(4).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade5(), obj.getProdutos().get(4).getQuantidade());
            values.put(Lista_DataModel.getListaProduto6(), obj.getProdutos().get(5).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade6(), obj.getProdutos().get(5).getQuantidade());
            values.put(Lista_DataModel.getListaProduto7(), obj.getProdutos().get(6).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade7(), obj.getProdutos().get(6).getQuantidade());
        }
        if(i>5){
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
            values.put(Lista_DataModel.getListaProduto2(), obj.getProdutos().get(1).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade2(), obj.getProdutos().get(1).getQuantidade());
            values.put(Lista_DataModel.getListaProduto3(), obj.getProdutos().get(2).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade3(), obj.getProdutos().get(2).getQuantidade());
            values.put(Lista_DataModel.getListaProduto4(), obj.getProdutos().get(3).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade4(), obj.getProdutos().get(3).getQuantidade());
            values.put(Lista_DataModel.getListaProduto5(), obj.getProdutos().get(4).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade5(), obj.getProdutos().get(4).getQuantidade());
            values.put(Lista_DataModel.getListaProduto6(), obj.getProdutos().get(5).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade6(), obj.getProdutos().get(5).getQuantidade());
        }
        if(i>4){
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
            values.put(Lista_DataModel.getListaProduto2(), obj.getProdutos().get(1).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade2(), obj.getProdutos().get(1).getQuantidade());
            values.put(Lista_DataModel.getListaProduto3(), obj.getProdutos().get(2).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade3(), obj.getProdutos().get(2).getQuantidade());
            values.put(Lista_DataModel.getListaProduto4(), obj.getProdutos().get(3).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade4(), obj.getProdutos().get(3).getQuantidade());
            values.put(Lista_DataModel.getListaProduto5(), obj.getProdutos().get(4).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade5(), obj.getProdutos().get(4).getQuantidade());
        }
        if(i>3){
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
            values.put(Lista_DataModel.getListaProduto2(), obj.getProdutos().get(1).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade2(), obj.getProdutos().get(1).getQuantidade());
            values.put(Lista_DataModel.getListaProduto3(), obj.getProdutos().get(2).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade3(), obj.getProdutos().get(2).getQuantidade());
            values.put(Lista_DataModel.getListaProduto4(), obj.getProdutos().get(3).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade4(), obj.getProdutos().get(3).getQuantidade());
        }

        if(i>2){
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
            values.put(Lista_DataModel.getListaProduto2(), obj.getProdutos().get(1).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade2(), obj.getProdutos().get(1).getQuantidade());
            values.put(Lista_DataModel.getListaProduto3(), obj.getProdutos().get(2).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade3(), obj.getProdutos().get(2).getQuantidade());
        }
        if(i>1){
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
            values.put(Lista_DataModel.getListaProduto2(), obj.getProdutos().get(1).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade2(), obj.getProdutos().get(1).getQuantidade());
        }
        else{
            values.put(Lista_DataModel.getListaProduto1(), obj.getProdutos().get(0).getProdutoId_Q());
            values.put(Lista_DataModel.getListaQuantidade1(), obj.getProdutos().get(0).getQuantidade());
        }

        try {
            ds.persist(values, Lista_DataModel.getListaTable(), Lista_DataModel.getLista_ID());
            retorno = true;
        } catch (Exception e) {

        }

        return retorno;
    }
}
