package com.example.ueno.lefrechie;

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
 * Created by Ueno on 3/14/2018.
 */

public class CadastroSalgadoActivity extends AppCompatActivity implements Serializable {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_salgado);

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
        final Produto salgado = (Produto) i.getSerializableExtra("Salgado");
        int type = InputType.TYPE_CLASS_NUMBER |  InputType.TYPE_NUMBER_FLAG_DECIMAL;

        final EditText salgadoNome = (EditText) findViewById(R.id.nomeSalgado);
        final EditText salgadoPreco = (EditText) findViewById(R.id.precoSalgado);
        ((EditText)findViewById(R.id.precoSalgado)).setInputType(type);
        ImageButton adicionarSalgado = (ImageButton) findViewById(R.id.adicionarSalgado);
        adicionarSalgado.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String strSalgadoName = salgadoNome.getText().toString();
                String strSalgadoPreco = salgadoPreco.getText().toString();
                if(TextUtils.isEmpty(strSalgadoName)) {
                    salgadoNome.setError("Digite o nome do Salgado");
                    return;
                }
                if(TextUtils.isEmpty(strSalgadoPreco)) {
                    salgadoPreco.setError("Digite o preço do Salgado");
                    return;
                }
                Log.i("OOOOOOOO" , salgado.getSegmento());
                salgado.setNome(salgadoNome.getText().toString());
                double n2Var = Double.parseDouble(salgadoPreco.getText().toString());
                salgado.setPreco(n2Var);
                ProdutoDAO produtoDAO = new ProdutoDAO(getApplicationContext());
                produtoDAO.adicionar(salgado);
                Intent i = new Intent(getApplicationContext(), ProdutoActivity.class);
                startActivity(i);
                finish();
                if(salgado.getNome() == null){
                    Toast.makeText(getApplicationContext(), "Salgado Adicionado com Sucesso!",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Salgado Editado com Sucesso!",
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
