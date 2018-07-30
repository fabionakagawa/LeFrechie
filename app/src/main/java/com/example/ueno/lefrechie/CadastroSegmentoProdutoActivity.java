package com.example.ueno.lefrechie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.example.ueno.lefrechie.DAO.Flags_DAO;
import com.example.ueno.lefrechie.DAO.ProdutoDAO;
import com.example.ueno.lefrechie.Model.Produto;

/**
 * Created by Ueno on 3/11/2018.
 */

public class CadastroSegmentoProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segmento_produto);

        ImageButton logoButton = (ImageButton) findViewById(R.id.logoInicial);
        logoButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                               startActivity(i);
                                           }

                                       }
        );

        ImageButton doceButton = (ImageButton) findViewById(R.id.doces);
        doceButton.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                                                Flags_DAO flags_dao = new Flags_DAO(getApplication());
                                                int flag = flags_dao.getFlagCadastro();
                                                Log.i("OOOOOOOO" , Integer.toString(flag));
                                                    if(flag == 1) {
                                                        Produto doce = new Produto();
                                                        doce.setSegmento("Doce");
                                                        Intent i = new Intent(getApplicationContext(), CadastroDoceActivity.class);
                                                        i.putExtra("Doce", doce);
                                                        startActivity(i);
                                                        finish();
                                                    }
                                                    else{
                                                        Intent i = new Intent(getApplicationContext(), ListaDocesActivity.class);
                                                        startActivity(i);
                                                        finish();
                                                        }
                                                }

                                            }
        );
        ImageButton salgadoButton = (ImageButton) findViewById(R.id.salgados);
        salgadoButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Flags_DAO flags_dao = new Flags_DAO(getApplication());
                                               int flag = flags_dao.getFlagCadastro();
                                               if(flag == 1) {
                                                   Produto salgado = new Produto();
                                                   salgado.setSegmento("Salgado");
                                                   Intent i = new Intent(getApplicationContext(), CadastroSalgadoActivity.class);
                                                   i.putExtra("Salgado", salgado);
                                                   startActivity(i);
                                                   finish();
                                               }
                                               else{
                                                   Intent i = new Intent(getApplicationContext(), ListaSalgadosActivity.class);
                                                   startActivity(i);
                                                   finish();
                                               }
                                           }

                                       }
        );
        ImageButton cafeButton = (ImageButton) findViewById(R.id.cafes);
        cafeButton.setOnClickListener( new View.OnClickListener() {

                                              @Override
                                              public void onClick(View v) {
                                                  Flags_DAO flags_dao = new Flags_DAO(getApplication());
                                                  int flag = flags_dao.getFlagCadastro();
                                                  if(flag == 1) {
                                                      Produto cafe = new Produto();
                                                      cafe.setSegmento("Cafe");
                                                      Intent i = new Intent(getApplicationContext(), CadastroCafeActivity.class);
                                                      i.putExtra("Cafe", cafe);
                                                      startActivity(i);
                                                      finish();
                                                  }
                                                  else{
                                                      Intent i = new Intent(getApplicationContext(), ListaCafesActivity.class);
                                                      startActivity(i);
                                                      finish();
                                                  }
                                              }

                                          }
        );

        ImageButton bebidaButton = (ImageButton) findViewById(R.id.bebidas);
        bebidaButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Flags_DAO flags_dao = new Flags_DAO(getApplication());
                                               int flag = flags_dao.getFlagCadastro();
                                               if(flag == 1) {
                                                   Produto bebida = new Produto();
                                                   bebida.setSegmento("Bebida");
                                                   Intent i = new Intent(getApplicationContext(), CadastroBebidaActivity.class);
                                                   i.putExtra("Bebida", bebida);
                                                   startActivity(i);
                                                   finish();
                                               }
                                               else{
                                                   Intent i = new Intent(getApplicationContext(), ListaBebidasActivity.class);
                                                   startActivity(i);
                                                   finish();
                                               }
                                           }

                                       }
        );
        ImageButton petiscoButton = (ImageButton) findViewById(R.id.petisco);
        petiscoButton.setOnClickListener( new View.OnClickListener() {

                                              @Override
                                              public void onClick(View v) {
                                                  Flags_DAO flags_dao = new Flags_DAO(getApplication());
                                                  int flag = flags_dao.getFlagCadastro();
                                                  if(flag == 1) {
                                                      Produto petisco = new Produto();
                                                      petisco.setSegmento("Petisco");
                                                      Intent i = new Intent(getApplicationContext(), CadastroPetiscoActivity.class);
                                                      i.putExtra("Petisco", petisco);
                                                      startActivity(i);
                                                      finish();
                                                  }
                                                  else{
                                                      Intent i = new Intent(getApplicationContext(), ListaPetiscosActivity.class);
                                                      startActivity(i);
                                                      finish();
                                                  }
                                              }

                                          }
        );
    }
}
