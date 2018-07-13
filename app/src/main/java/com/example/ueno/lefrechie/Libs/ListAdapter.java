package com.example.ueno.lefrechie.Libs;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ueno.lefrechie.R;

import java.util.ArrayList;

/**
 * Created by AdmAbaco on 05/10/2016.
 */
public class ListAdapter extends ArrayAdapter<String> {

    private final Activity Context;
    private final ArrayList<String> ListItemsName;
    private final ArrayList<Integer> ImageName;

    public ListAdapter(Activity context, ArrayList<String> content,
                       ArrayList<Integer> ImageName) {

        super(context, R.layout.list_items, content);
        // TODO Auto-generated constructor stub

        this.Context = context;
        this.ListItemsName = content;
        this.ImageName = ImageName;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = Context.getLayoutInflater();
        View ListViewSingle = inflater.inflate(R.layout.list_items, null, true);

        TextView ListViewItems = (TextView) ListViewSingle.findViewById(R.id.textView1);
        ImageView ListViewImage = (ImageView) ListViewSingle.findViewById(R.id.imageView1);

        ListViewItems.setText(ListItemsName.get(position));
        ListViewImage.setImageResource(ImageName.get(position));
        return ListViewSingle;

    };

}