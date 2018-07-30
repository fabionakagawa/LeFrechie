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
import android.text.InputFilter;
import android.text.InputType;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ueno.lefrechie.DAO.ProdutoDAO;
import com.example.ueno.lefrechie.DataSource.DataSource;
import com.example.ueno.lefrechie.Libs.BaseSwipListAdapter;
import com.example.ueno.lefrechie.Libs.SwipeMenu;
import com.example.ueno.lefrechie.Libs.SwipeMenuCreator;
import com.example.ueno.lefrechie.Libs.SwipeMenuItem;
import com.example.ueno.lefrechie.Libs.SwipeMenuListView;
import com.example.ueno.lefrechie.Model.Produto;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ueno on 3/13/2018.
 */

public class ListaDocesActivity extends Activity {

    ProdutoDAO dao;

    private List<ApplicationInfo> mAppList;
    private List<Produto> registros = new ArrayList<>();
    private AppAdapter mAdapter;
    private SwipeMenuListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_doces);

        dao = new ProdutoDAO(getApplicationContext());


        registros = dao.listarTodosDoces("Doce");

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
                        // Edit
                        Produto doce = mAdapter.getItem(position);
                        Intent i = new Intent(getApplicationContext(), CadastroDoceActivity.class);
                        i.putExtra("Doce", doce);
                        startActivity(i);
                        break;
                    case 1:
                        // delete
                        DataSource db = new DataSource(getApplicationContext());
                        Produto produto = mAdapter.getItem(position);
                        db.deleteProduto(produto.getProdutoId_Q(),produto.getSegmento());
                        mAdapter.notifyDataSetChanged();
                        finish();
                        startActivity(getIntent());
                        Toast.makeText(getApplicationContext(), "Doce Deletado com Sucesso!",
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
        public Produto getItem(int position) {
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
                        R.layout.single_item_doce, null);
                new ViewHolder(convertView);
            }
            ViewHolder holder = (ViewHolder) convertView.getTag();
            Produto item = getItem(position);
//            holder.iv_icon.setImageDrawable(item.loadIcon(getPackageManager()));
            holder.holder_name.setText(item.getNome());
            holder.holder_price.setText("R$ "+
                    String.valueOf(String.format("%.2f", item.getPreco())));

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
            return convertView;
        }

        class ViewHolder {
            TextView holder_name;
            TextView holder_price;
//            ImageView iv_icon;
//            TextView tv_name;

            public ViewHolder(View view) {
                holder_name = view.findViewById(R.id.nomeDoce);
                holder_price = view.findViewById(R.id.precoDoce);
//                iv_icon = (ImageView) view.findViewById(R.id.iv_icon);
//                tv_name = (TextView) view.findViewById(R.id.tv_name);
                holder_name.setTypeface(null, Typeface.BOLD);
                holder_name.setTextSize(TypedValue.COMPLEX_UNIT_PX,65);
                holder_name.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                holder_price.setTypeface(null, Typeface.BOLD);
                holder_price.setTextSize(TypedValue.COMPLEX_UNIT_PX,55);
                holder_price.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
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
        Intent i = new Intent(getApplicationContext(), CadastroSegmentoProdutoActivity.class);
        startActivity(i);
        finish();
    }
}