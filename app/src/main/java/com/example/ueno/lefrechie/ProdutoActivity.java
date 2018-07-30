package com.example.ueno.lefrechie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.ueno.lefrechie.DAO.Flags_DAO;
import com.example.ueno.lefrechie.DataModel.Flags_DataModel;

/**
 * Created by Ueno on 3/11/2018.
 */

public class ProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        ImageButton logoButton = (ImageButton) findViewById(R.id.logoInicial);
        logoButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                               startActivity(i);
                                           }

                                       }
        );

        ImageButton editarButton = (ImageButton) findViewById(R.id.editar);
        editarButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Flags_DAO flags_editar = new Flags_DAO(getApplicationContext());
                flags_editar.setFlagEditar();
                int flag = flags_editar.getFlagCadastro();
                Intent i = new Intent(getApplicationContext(), CadastroSegmentoProdutoActivity.class);
                startActivity(i);
                finish();
            }
        });

        ImageButton cadastroButton = (ImageButton) findViewById(R.id.cadastrar);
        cadastroButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Flags_DAO flags_cadastro = new Flags_DAO(getApplicationContext());
                flags_cadastro.setFlagCadastro();
                Intent i = new Intent(getApplicationContext(), CadastroSegmentoProdutoActivity.class);
                startActivity(i);
                finish();
            }
        });

        ImageButton importarButton = (ImageButton) findViewById(R.id.importar);
        importarButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Flags_DAO flags_cadastro = new Flags_DAO(getApplicationContext());
                flags_cadastro.setFlagCadastro();
                Intent i = new Intent(getApplicationContext(), CadastroSegmentoProdutoActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}
