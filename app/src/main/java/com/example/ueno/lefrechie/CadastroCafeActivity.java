package com.example.ueno.lefrechie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ueno.lefrechie.DAO.ProdutoDAO;
import com.example.ueno.lefrechie.Model.Produto;

import java.io.Serializable;

/**
 * Created by Ueno on 3/17/2018.
 */

public class CadastroCafeActivity extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cafe);

        ImageButton logoButton = (ImageButton) findViewById(R.id.logoInicial);
        logoButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                               startActivity(i);
                                           }

                                       }
        );

        Intent i = getIntent();
        final Produto cafe = (Produto) i.getSerializableExtra("Cafe");
        int type = InputType.TYPE_CLASS_NUMBER |  InputType.TYPE_NUMBER_FLAG_DECIMAL;

        final EditText cafeNome = (EditText) findViewById(R.id.nomeCafe);
        final EditText cafePreco = (EditText) findViewById(R.id.precoCafe);
        ((EditText)findViewById(R.id.precoCafe)).setInputType(type);
        ImageButton adicionarDoce = (ImageButton) findViewById(R.id.adicionarDoce);
        adicionarDoce.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String strDoceName = cafeNome.getText().toString();
                String strDocePreco = cafePreco.getText().toString();
                if(TextUtils.isEmpty(strDoceName)) {
                    cafeNome.setError("Digite o nome do Café");
                    return;
                }
                if(TextUtils.isEmpty(strDocePreco)) {
                    cafePreco.setError("Digite o preço do Café");
                    return;
                }
                cafe.setSegmento("Cafe");
                cafe.setNome(cafeNome.getText().toString());
                double n2Var = Double.parseDouble(cafePreco.getText().toString());
                cafe.setPreco(n2Var);
                ProdutoDAO produtoDAO = new ProdutoDAO(getApplicationContext());
                produtoDAO.adicionar(cafe);
                Intent i = new Intent(getApplicationContext(), ProdutoActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Café Adicionado com Sucesso!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
