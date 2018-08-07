package com.example.ueno.lefrechie;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ueno.lefrechie.DAO.Flags_DAO;
import com.example.ueno.lefrechie.DAO.ProdutoDAO;
import com.example.ueno.lefrechie.DataSource.DataSource;
import com.example.ueno.lefrechie.Model.Produto;


public class MainActivity extends AppCompatActivity {

    Flags_DAO flagsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flagsDao = new Flags_DAO(getApplicationContext());

        TextView clickButton = (TextView) findViewById(R.id.pedidos);

        DataSource db = new DataSource(getApplicationContext());

        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PedidosActivity.class);
                flagsDao.setFlagAdicionarLista();
                startActivity(i);
            }
        });


        TextView clickButton5 = (TextView) findViewById(R.id.produtos);
        clickButton5.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ProdutoActivity.class);
                startActivity(i);
            }
        });
        TextView RelatorioButton = (TextView) findViewById(R.id.relatorioDiario);
        RelatorioButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RelatorioDiarioActivity.class);
                startActivity(i);
            }
        });
    }
}
