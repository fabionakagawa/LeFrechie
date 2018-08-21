package com.example.ueno.lefrechie.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.ueno.lefrechie.DataModel.Flags_DataModel;
import com.example.ueno.lefrechie.DataSource.DataSource;

/**
 * Created by Ueno on 3/13/2018.
 */

public class Flags_DAO {

    DataSource ds;
    ContentValues values;

    public Flags_DAO(Context context){
        ds= new DataSource(context);
    }

    public void setFlagCadastro(){
        values = new ContentValues();
        values.put(Flags_DataModel.getFlagId(),1);
        values.put(Flags_DataModel.getFlagCadastro(),1);
        try {
            ds.persist(values, Flags_DataModel.getFlagTable(),Flags_DataModel.getFlagId());
        }catch (Exception e){

        }
    }
    public void setFlagEditar(){
        values = new ContentValues();
        values.put(Flags_DataModel.getFlagId(),1);
        values.put(Flags_DataModel.getFlagCadastro(),0);
        try {
            ds.persist(values, Flags_DataModel.getFlagTable(),Flags_DataModel.getFlagId());
        }catch (Exception e){

        }
    }

    public void setFlagAdicionarLista(){
        values = new ContentValues();
        values.put(Flags_DataModel.getFlagId(),1);
        values.put(Flags_DataModel.getFlagCadastro(),2);
        try {
            ds.persist(values, Flags_DataModel.getFlagTable(),Flags_DataModel.getFlagId());
        }catch (Exception e){

        }
    }

    public void setFlagIdPedido(int id){
        values = new ContentValues();
        values.put(Flags_DataModel.getFlagId(),1);
        values.put(Flags_DataModel.getFlagIdpedido(),id);
        try {
            ds.persist(values, Flags_DataModel.getFlagTable(),Flags_DataModel.getFlagId());
        }catch (Exception e){

        }
    }

    public int getFlagCadastro(){
        Cursor cursor = ds.find(Flags_DataModel.getFlagTable(),
                null, null, null, null, null, null, null);
        cursor.moveToFirst();
        int flag = cursor.getInt(cursor.getColumnIndex(Flags_DataModel.getFlagCadastro()));
        return flag;
    }
    public int getFlagIdPedido(){
        Cursor cursor = ds.find(Flags_DataModel.getFlagTable(),
                null, null, null, null, null, null, null);
        cursor.moveToFirst();
        int flag = cursor.getInt(cursor.getColumnIndex(Flags_DataModel.getFlagIdpedido()));
        return flag;
    }
}
