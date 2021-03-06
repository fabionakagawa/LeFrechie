package com.example.ueno.lefrechie;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ueno.lefrechie.DAO.Flags_DAO;
import com.example.ueno.lefrechie.DAO.Lista_DAO;
import com.example.ueno.lefrechie.DAO.Pedido_DAO;
import com.example.ueno.lefrechie.DataModel.Lista_DataModel;
import com.example.ueno.lefrechie.DataModel.Pedido_DataModel;
import com.example.ueno.lefrechie.DataSource.DataSource;
import com.example.ueno.lefrechie.Libs.BaseSwipListAdapter;
import com.example.ueno.lefrechie.Libs.SwipeMenu;
import com.example.ueno.lefrechie.Libs.SwipeMenuCreator;
import com.example.ueno.lefrechie.Libs.SwipeMenuItem;
import com.example.ueno.lefrechie.Libs.SwipeMenuListView;
import com.example.ueno.lefrechie.Model.ListaProdutos;
import com.example.ueno.lefrechie.Model.Pedido;
import com.example.ueno.lefrechie.Model.Produto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidosItensActivity extends Activity {

    Pedido pedido = new Pedido();
    Pedido_DAO pedidoDao;
    Flags_DAO flagsDao;
    Lista_DAO listaDao;
    Lista_DataModel listaDataModel =new Lista_DataModel();
    ListaProdutos listaProdutos = new ListaProdutos();
    String dataFormatada;
    int id;
    float valor;
    private DataSource db;
    private int quantidadeProduto;
    private List<ApplicationInfo> mAppList;
    private List<Pedido> registros = new ArrayList<>();
    private AppAdapter mAdapter;
    private SwipeMenuListView mListView;
    private TextView pedidoValor;
    private TextView pedidoTexto;
    private ImageButton logoButton;
    Runnable run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos_items);

        db = new DataSource(getApplicationContext());
        flagsDao = new Flags_DAO(getApplicationContext());
        pedidoDao = new Pedido_DAO(getApplicationContext());

        id = flagsDao.getFlagIdPedido();

        run = new Runnable() {
            public void run() {
                //reload content
                valor = pedidoDao.calculaTotal(id,getApplicationContext());
                pedidoValor.setText("Total: R$"+String.valueOf(String.format("%.2f", valor)));
                mAdapter.notifyDataSetChanged();
            }
        };
//        if(flagsDao.getFlagIdPdedido()>0){
//            Log.i("FLAGIDPEDIDO", String.valueOf(flagsDao.getFlagIdPdedido()));
//            id=flagsDao.getFlagIdPdedido();
//        }
//        else{
//
//            SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy");
//            Date data = new Date();
//            dataFormatada = formataData.format(data);
//            pedido.setData(dataFormatada);
//            Log.i("AQUI", String.valueOf(flagsDao.getFlagIdPdedido()));
//            id = pedidoDao.getLastOrderId(dataFormatada);
//            Log.i("DEPOISAQUI", String.valueOf(flagsDao.getFlagIdPdedido()));
//            Log.i("DEPOISAQUIAQUI", String.valueOf(id));
//        }

        logoButton = (ImageButton) findViewById(R.id.logoInicial);
        pedidoTexto = (TextView) findViewById(R.id.texto);
        pedidoValor = (TextView) findViewById(R.id.valorPedido);
        valor = pedidoDao.calculaTotal(id,getApplicationContext());
        pedidoValor.setText("Total: R$"+valor);
        pedidoTexto.setText("PEDIDO "+id);


        TextView adicionar = (TextView) findViewById(R.id.adicionarProduto);
        adicionar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                flagsDao.setFlagAdicionarLista();
                Log.i("FLAGIDPEDIDO", String.valueOf(id));
                flagsDao.setFlagIdPedido(id);
                Log.i("FLAGIDPEDIDO", String.valueOf(flagsDao.getFlagCadastro()));
                Intent i = new Intent(getApplicationContext(), CadastroSegmentoProdutoActivity.class);
                startActivity(i);
            }
        });

        logoButton.setOnClickListener( new View.OnClickListener() {

                                           @Override
                                           public void onClick(View v) {
                                               Intent i = new Intent(getApplicationContext(), MainActivity.class);
                                               startActivity(i);
                                               finish();
                                           }

                                       }
        );

        registros = pedidoDao.getListaPedidos(id);
        mAppList = getPackageManager().getInstalledApplications(0);
        mListView = findViewById(R.id.listView);
        mAdapter = new AppAdapter();
        mListView.setAdapter(mAdapter);
        // step 1. create a MenuCreator

        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(dp2px(90));
                // set item title
                openItem.setTitle("Editar");
                // set item title fontsize
                openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(dp2px(90));
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        // set creator
        mListView.setMenuCreator(creator);

        // step 2. listener item click event
        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                ApplicationInfo item = mAppList.get(position);
                switch (index) {
                    case 0:
//                        // Edit
//                        Produto doce = mAdapter.getItem(position);
//                        Intent i = new Intent(getApplicationContext(), CadastroDoceActivity.class);
//                        i.putExtra("Doce", doce);
//                        startActivity(i);
//                        break;
                    case 1:
//                        // delete
                        pedido = mAdapter.getItem(position);
                        db.deleteItemPedido(pedido.getPedidoNum(),pedido.getPedidoId_Q());
                        registros.clear();
                        registros = pedidoDao.getListaPedidos(id);
                        mAdapter = new AppAdapter();
                        mListView.setAdapter(mAdapter);
                        runOnUiThread(run);
                        Toast.makeText(getApplicationContext(), "Item Deletado com Sucesso!",
                                Toast.LENGTH_LONG).show();
                        break;

                }
                return false;
            }
        });

        // set SwipeListener
        mListView.setOnSwipeListener(new SwipeMenuListView.OnSwipeListener() {

            @Override
            public void onSwipeStart(int position) {
                // swipe start
            }

            @Override
            public void onSwipeEnd(int position) {
                // swipe end
            }
        });

        // set MenuStateChangeListener
        mListView.setOnMenuStateChangeListener(new SwipeMenuListView.OnMenuStateChangeListener() {
            @Override
            public void onMenuOpen(int position) {
            }

            @Override
            public void onMenuClose(int position) {
            }
        });

        // other setting
//		listView.setCloseInterpolator(new BounceInterpolator());

        // test item long click
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                Toast.makeText(getApplicationContext(), position + " long click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void delete(ApplicationInfo item) {
        // delete app
        try {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.fromParts("package", item.packageName, null));
            startActivity(intent);
        } catch (Exception e) {
        }
    }

    private void open(ApplicationInfo item) {
        // open app
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        resolveIntent.setPackage(item.packageName);
        List<ResolveInfo> resolveInfoList = getPackageManager()
                .queryIntentActivities(resolveIntent, 0);
        if (resolveInfoList != null && resolveInfoList.size() > 0) {
            ResolveInfo resolveInfo = resolveInfoList.get(0);
            String activityPackageName = resolveInfo.activityInfo.packageName;
            String className = resolveInfo.activityInfo.name;

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            ComponentName componentName = new ComponentName(
                    activityPackageName, className);

            intent.setComponent(componentName);
            startActivity(intent);
        }
    }

    class AppAdapter extends BaseSwipListAdapter {

        @Override
        public int getCount() {
            return registros.size();
        }

        @Override
        public Pedido getItem(int position) {
            return registros.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = View.inflate(getApplicationContext(),
                        R.layout.single_item_salgado_pedido, null);
                new ViewHolder(convertView);
            }
            final Pedido item = getItem(position);
            quantidadeProduto = item.getProdutoQuantidade();
            new ViewHolder(convertView);
            ViewHolder holder = (ViewHolder) convertView.getTag();

//            holder.iv_icon.setImageDrawable(item.loadIcon(getPackageManager()));
            holder.holder_name.setText(item.getProdutoNome());
            holder.holder_price.setText(" "+ item.getProdutoQuantidade()+" ");

//            holder.holder_name.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(ListaDocesActivity.this, "iv_icon_click", Toast.LENGTH_SHORT).show();
//                }
//            });
//            holder.holder_price.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(ListaDocesActivity.this,"iv_icon_click",Toast.LENGTH_SHORT).show();
//                }
//            });
            holder.holder_remove.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    if(item.getProdutoQuantidade()>1){
                        pedidoDao.remover(item);
                        registros.clear();
                        registros = pedidoDao.getListaPedidos(id);
                        mAdapter = new AppAdapter();
                        mListView.setAdapter(mAdapter);
                        runOnUiThread(run);
                    }
                    else{
                        db.deleteItemPedido(item.getPedidoNum(),item.getPedidoId_Q());
                        registros.clear();
                        registros = pedidoDao.getListaPedidos(id);
                        mAdapter = new AppAdapter();
                        mListView.setAdapter(mAdapter);
                        runOnUiThread(run);
                    }
                }
            });
            holder.holder_add.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    item.setProdutoQuantidade(1);
                    pedidoDao.adicionar(item);
                    registros.clear();
                    registros = pedidoDao.getListaPedidos(id);
                    mAdapter = new AppAdapter();
                    mListView.setAdapter(mAdapter);
                    runOnUiThread(run);
                }
            });
            return convertView;
        }

        class ViewHolder {
            TextView holder_name;
            TextView holder_price;
            Button holder_remove;
            Button holder_add;
//            ImageView iv_icon;
//            TextView tv_name;

            public ViewHolder(View view) {
                holder_name = view.findViewById(R.id.nomeProduto);
                holder_price = view.findViewById(R.id.quantidadeProduto);
                holder_remove = view.findViewById(R.id.removeButton);
                holder_add = view.findViewById(R.id.addButton);
//                iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
//                tv_name = (TextView) view.findViewById(R.id.tv_name);
                holder_name.setTypeface(null, Typeface.BOLD);
                holder_name.setTextSize(TypedValue.COMPLEX_UNIT_PX,65);
                holder_name.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                holder_price.setTypeface(null, Typeface.BOLD);
                holder_price.setTextSize(TypedValue.COMPLEX_UNIT_PX,100);
                holder_price.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                if(quantidadeProduto == 1){
                    holder_remove.setBackgroundResource(R.drawable.ic_removebuttoncirclewhite);
                }
                else
                    holder_remove.setBackgroundResource(R.drawable.ic_removebuttoncircleblack);
                view.setTag(this);
            }
        }

        @Override
        public boolean getSwipEnableByPosition(int position) {
//            if(position % 2 == 0){
//                return false;
//            }
            return true;
        }
    }

    private int dp2px(int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                getResources().getDisplayMetrics());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_left) {
            mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_LEFT);
            return true;
        }
        if (id == R.id.action_right) {
            mListView.setSwipeDirection(SwipeMenuListView.DIRECTION_RIGHT);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        int newFlag = flagsDao.getFlagIdPedido()+1;
        flagsDao.setFlagIdPedido(newFlag);
        startActivity(i);
        finish();
    }


}
