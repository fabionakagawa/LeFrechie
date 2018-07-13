package com.example.ueno.lefrechie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Ueno on 3/11/2018.
 */

public class PedidosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        ImageButton logoButton = (ImageButton) findViewById(R.id.logoInicial);
        logoButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                               startActivity(i);
                                           }

                                       }
        );

        ImageButton clickButton = (ImageButton) findViewById(R.id.balcao);
        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), BalcaoActivity.class);
                startActivity(i);
            }
        });

    }
}
