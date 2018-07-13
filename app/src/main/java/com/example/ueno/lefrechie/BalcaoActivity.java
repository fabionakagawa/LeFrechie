package com.example.ueno.lefrechie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Ueno on 3/11/2018.
 */

public class BalcaoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balcao);

        ImageButton logoButton = (ImageButton) findViewById(R.id.logoInicial);
        logoButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                               startActivity(i);
                                           }

                                       }
        );
    }
}
