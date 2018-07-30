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

public class CadastroBebidaActivity extends AppCompatActivity implements Serializable {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_bebida);

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
        final Produto bebida = (Produto) i.getSerializableExtra("Bebida");
        int type = InputType.TYPE_CLASS_NUMBER |  InputType.TYPE_NUMBER_FLAG_DECIMAL;

        final EditText bebidaNome = (EditText) findViewById(R.id.nomeBebida);
        final EditText bebidaPreco = (EditText) findViewById(R.id.precoBebida);
        ((EditText)findViewById(R.id.precoBebida)).setInputType(type);
        ImageButton adicionarDoce = (ImageButton) findViewById(R.id.adicionarBebida);
        adicionarDoce.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String strDoceName = bebidaNome.getText().toString();
                String strDocePreco = bebidaPreco.getText().toString();
                if(TextUtils.isEmpty(strDoceName)) {
                    bebidaNome.setError("Digite o nome da Bebida");
                    return;
                }
                if(TextUtils.isEmpty(strDocePreco)) {
                    bebidaPreco.setError("Digite o preço da Bebida");
                    return;
                }
                bebida.setNome(bebidaNome.getText().toString());
                double n2Var = Double.parseDouble(bebidaPreco.getText().toString());
                bebida.setPreco(n2Var);
                ProdutoDAO produtoDAO = new ProdutoDAO(getApplicationContext());
                produtoDAO.adicionar(bebida);
                Intent i = new Intent(getApplicationContext(), ProdutoActivity.class);
                startActivity(i);
                finish();
                if(bebida.getNome() == null){
                    Toast.makeText(getApplicationContext(), "Bebida Adicionada com Sucesso!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Bebida Editada com Sucesso!",
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
