package com.example.ueno.lefrechie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.ueno.lefrechie.DAO.ProdutoDAO;
import com.example.ueno.lefrechie.Model.Produto;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView clickButton = (TextView) findViewById(R.id.pedidos);


        clickButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),PedidosActivity.class);
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
                ProdutoDAO dao = new ProdutoDAO(getApplication());
                Produto produto = dao.retornaproduto();
            }
        });
    }
}
