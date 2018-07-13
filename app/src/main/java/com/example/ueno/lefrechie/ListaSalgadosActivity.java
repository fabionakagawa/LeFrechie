package com.example.ueno.lefrechie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ueno.lefrechie.DAO.ProdutoDAO;
import com.example.ueno.lefrechie.Libs.ListViewCustomAdapter;
import com.example.ueno.lefrechie.Model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ueno on 3/14/2018.
 */

public class ListaSalgadosActivity extends Activity {

    ProdutoDAO dao;

    ListView mainListView;
    ListViewCustomAdapter listAdapter;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_salgado);

        dao = new ProdutoDAO(getApplicationContext());

        ImageButton logoButton = (ImageButton) findViewById(R.id.logoInicial);
        logoButton.setOnClickListener(new View.OnClickListener() {

                                          @Override
                                          public void onClick(View v) {
                                              Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                              startActivity(i);
                                          }

                                      }
        );

        List<Produto> registros = new ArrayList<>();
        registros = dao.listarTodosSalgados("Salgado");

        if (registros.size() == 0) {
            Intent i = new Intent(getApplicationContext(), ProdutoActivity.class);
            startActivity(i);
            Toast.makeText(getApplicationContext(), "Ainda não há cadastro de salgados.",
                    Toast.LENGTH_LONG).show();
        } else {
            for (int i = 0; i < registros.size(); i++) {

                // dadosListView.add(registros.get(i).getNome().toString()+" : "
                //         +registros.get(i).getPreco());
            }

            mainListView = (ListView) findViewById(R.id.mainListView);

            listAdapter = (ListViewCustomAdapter) new ListViewCustomAdapter(this, R.layout.single_item_salgado, registros);

            mainListView.setAdapter(listAdapter);
        }
    }
}
