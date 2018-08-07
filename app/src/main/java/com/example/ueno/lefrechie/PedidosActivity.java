package com.example.ueno.lefrechie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.ueno.lefrechie.DAO.Flags_DAO;

/**
 * Created by Ueno on 3/11/2018.
 */

public class PedidosActivity extends AppCompatActivity {

    Flags_DAO flagsDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        flagsDao = new Flags_DAO(getApplicationContext());

        ImageButton logoButton = (ImageButton) findViewById(R.id.logoInicial);
        logoButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                               startActivity(i);
                                               finish();
                                           }

                                       }
        );
        ImageButton novoButton = (ImageButton) findViewById(R.id.novo);
        novoButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               flagsDao.setFlagIdPedido(0);
                                               Intent i = new Intent(getApplicationContext(), PedidosItensActivity.class);
                                               startActivity(i);
                                               finish();
                                           }

                                       }
        );
    }
}