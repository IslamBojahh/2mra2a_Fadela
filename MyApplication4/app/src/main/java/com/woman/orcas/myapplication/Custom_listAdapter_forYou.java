package com.woman.orcas.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ORCAS_ISLAM on 1/21/2018.
 */


public class  Custom_listAdapter_forYou extends ArrayAdapter<com.woman.orcas.myapplication.product_foryou> {

    ArrayList<com.woman.orcas.myapplication.product_foryou> products;
    Context context ;
    int resource;


    public Custom_listAdapter_forYou(@NonNull Context context, int resource, @NonNull ArrayList<com.woman.orcas.myapplication.product_foryou> products) {
        super(context, resource, products);

        this.products=products;
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){

            LayoutInflater layoutInflater=(LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView=layoutInflater.inflate(R.layout.custom_foryou,null,true);

        }
        final com.woman.orcas.myapplication.product_foryou product=getItem(position);
        final ImageView imageView =(ImageView)convertView.findViewById(R.id.ImageViewProduct);

        Picasso.with(context).load(product.getImage()).into(imageView);


        final TextView textName=(TextView) convertView.findViewById(R.id.textname);
        textName.setText(product.getName());

        TextView textPrice=(TextView) convertView.findViewById(R.id.textprice);
        textPrice.setText(product.getDescription());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context, com.woman.orcas.myapplication.foryou_content.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                i.putExtra("ImageUrl",product.getImage());
                i.putExtra("Title",product.getName());
                i.putExtra("subtitle",product.getDescription());
                Log.d("iiiiiiiiiiiiiii",product.getName());
                view.getContext().startActivity(i);


            }
        });

        return convertView;
    }




}


