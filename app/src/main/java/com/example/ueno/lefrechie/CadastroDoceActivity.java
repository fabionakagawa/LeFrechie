package com.example.ueno.lefrechie;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.ueno.lefrechie.DAO.ProdutoDAO;
import com.example.ueno.lefrechie.Model.Produto;

import java.io.Serializable;

/**
 * Created by Ueno on 3/12/2018.
 */

public class CadastroDoceActivity extends AppCompatActivity implements Serializable {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_doce);

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
        final Produto doce = (Produto) i.getSerializableExtra("Doce");
        int type = InputType.TYPE_CLASS_NUMBER |  InputType.TYPE_NUMBER_FLAG_DECIMAL;

        final EditText doceNome = (EditText) findViewById(R.id.nomeDoce);
        final EditText docePreco = (EditText) findViewById(R.id.precoDoce);
        ((EditText)findViewById(R.id.precoDoce)).setInputType(type);
        ImageButton adicionarDoce = (ImageButton) findViewById(R.id.adicionarDoce);
        adicionarDoce.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String strDoceName = doceNome.getText().toString();
                String strDocePreco = docePreco.getText().toString();
                if(TextUtils.isEmpty(strDoceName)) {
                    doceNome.setError("Digite o nome do Doce");
                    return;
                }
                if(TextUtils.isEmpty(strDocePreco)) {
                    docePreco.setError("Digite o preço do Doce");
                    return;
                }
                doce.setSegmento("Doce");
                doce.setNome(doceNome.getText().toString());
                double n2Var = Double.parseDouble(docePreco.getText().toString());
                doce.setPreco(n2Var);
                ProdutoDAO produtoDAO = new ProdutoDAO(getApplicationContext());


                produtoDAO.adicionar(doce);
                Intent i = new Intent(getApplicationContext(), ProdutoActivity.class);
                startActivity(i);
                finish();
                if(doce.getNome() == null){
                    Toast.makeText(getApplicationContext(), "Doce Adicionado com Sucesso!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Doce Editado com Sucesso!",
                            Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), CadastroSegmentoProdutoActivity.class);
        startActivity(i);
        finish();
    }
}
