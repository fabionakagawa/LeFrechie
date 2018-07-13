package com.example.ueno.lefrechie.Libs;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ueno.lefrechie.Model.Produto;
import com.example.ueno.lefrechie.R;

import java.util.List;

/**
 * Created by Ueno on 3/21/2018.
 */

public class ListViewCustomAdapter extends ArrayAdapter<Produto> {

    int resource;
    String response;
    Context context;


    public ListViewCustomAdapter(Context context, int resource, List<Produto> items) {
        super(context, resource, items);
        this.resource=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LinearLayout contactsView;
        Produto produto = getItem(position);


        if(convertView==null) {
            contactsView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi;
            vi = (LayoutInflater)getContext().getSystemService(inflater);
            vi.inflate(resource, contactsView, true);
        } else {
            contactsView = (LinearLayout) convertView;
        }
        TextView doceName =(TextView)contactsView.findViewById(R.id.nomeDoce);
        doceName.setTypeface(null, Typeface.BOLD);
        doceName.setTextSize(TypedValue.COMPLEX_UNIT_PX,72);
        doceName.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        TextView docePreco = (TextView)contactsView.findViewById(R.id.precoDoce);
        docePreco.setTypeface(null, Typeface.BOLD);
        docePreco.setTextSize(TypedValue.COMPLEX_UNIT_PX,72);
        docePreco.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        doceName.setText(produto.getNome());
        docePreco.setText("R$ "+
                String.valueOf(String.format("%.2f", produto.getPreco())));

        return contactsView;
    }
}