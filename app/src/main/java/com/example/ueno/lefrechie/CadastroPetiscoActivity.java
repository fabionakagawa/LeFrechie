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
 * Created by Ueno on 3/20/2018.
 */

public class CadastroPetiscoActivity extends AppCompatActivity implements Serializable {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_petisco);

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
        final Produto petisco = (Produto) i.getSerializableExtra("Petisco");
        int type = InputType.TYPE_CLASS_NUMBER |  InputType.TYPE_NUMBER_FLAG_DECIMAL;

        final EditText petiscoNome = (EditText) findViewById(R.id.nomePetisco);
        final EditText petiscoPreco = (EditText) findViewById(R.id.precoPetisco);
        ((EditText)findViewById(R.id.precoPetisco)).setInputType(type);
        ImageButton adicionarDoce = (ImageButton) findViewById(R.id.adicionarPetisco);
        adicionarDoce.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String strDoceName = petiscoNome.getText().toString();
                String strDocePreco = petiscoPreco.getText().toString();
                if(TextUtils.isEmpty(strDoceName)) {
                    petiscoNome.setError("Digite o nome d0 Petisco");
                    return;
                }
                if(TextUtils.isEmpty(strDocePreco)) {
                    petiscoPreco.setError("Digite o preço do Petisco");
                    return;
                }
                petisco.setNome(petiscoNome.getText().toString());
                double n2Var = Double.parseDouble(petiscoPreco.getText().toString());
                petisco.setPreco(n2Var);
                ProdutoDAO produtoDAO = new ProdutoDAO(getApplicationContext());
                produtoDAO.adicionar(petisco);
                Intent i = new Intent(getApplicationContext(), ProdutoActivity.class);
                startActivity(i);
                finish();
                Toast.makeText(getApplicationContext(), "Petisco Adicionado com Sucesso!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
