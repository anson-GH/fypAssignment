package com.example.winnie.fypassignment;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList<String>  itemname;
    private final ArrayList<String>  price;
    private final ArrayList<String>  img1;

   // private final Integer[] imgid;

    public CustomListAdapter(Activity context, ArrayList<String> itemname, ArrayList<String> img1, ArrayList<String> price) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.price=price;
        this.img1=img1;
       // this.imgid=imgid;
    }



    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textPriceList);

        txtTitle.setText(itemname.get(position));
        Picasso.with(context).load(img1.get(position)).into(imageView);
       // imageView.setImageResource(img1.get(position));
        extratxt.setText("Price "+price.get(position));
        return rowView;

    };
}