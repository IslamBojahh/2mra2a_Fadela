package com.woman.orcas.myapplication;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ORCAS_ISLAM on 1/22/2018.
 */


public class Custom_listAdapter_calender extends ArrayAdapter<com.woman.orcas.myapplication.product_calender> {



        ArrayList<com.woman.orcas.myapplication.product_calender> products;
        Context context ;
        int resource;


        public Custom_listAdapter_calender(@NonNull Context context, int resource, @NonNull ArrayList<com.woman.orcas.myapplication.product_calender> products) {
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

                convertView=layoutInflater.inflate(R.layout.calender_item,null,true);

            }
            com.woman.orcas.myapplication.product_calender product=getItem(position);
            //final ImageView imageView =(ImageView)convertView.findViewById(R.id.calender_name);

           // Picasso.with(context).load(product.getImage()).into(imageView);


            final TextView textName=(TextView) convertView.findViewById(R.id.calender_name);
            textName.setText(product.getName());

            TextView textdate=(TextView) convertView.findViewById(R.id.calender_date);
            textdate.setText(product.getDate());

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            try {
                Date date=format.parse(product.getDate());
            } catch (ParseException e) {
                e.printStackTrace();
            }



            return convertView;
        }


    }



