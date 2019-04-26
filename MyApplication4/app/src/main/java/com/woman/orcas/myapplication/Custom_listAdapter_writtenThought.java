package com.woman.orcas.myapplication;

import android.app.Activity;
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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import android.app.Activity;
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

        import java.util.ArrayList;

/**
 * Created by ORCAS_ISLAM on 1/21/2018.
 */





    public class Custom_listAdapter_writtenThought extends ArrayAdapter<com.woman.orcas.myapplication.product_writtenThought> {



        ArrayList<com.woman.orcas.myapplication.product_writtenThought> products;
        Context context ;
        int resource;


        public Custom_listAdapter_writtenThought(@NonNull Context context, int resource, @NonNull ArrayList<com.woman.orcas.myapplication.product_writtenThought> products) {
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

                convertView=layoutInflater.inflate(R.layout.custom_writtenthought,null,true);

            }
            final com.woman.orcas.myapplication.product_writtenThought product=getItem(position);
            final ImageView imageView =(ImageView)convertView.findViewById(R.id.Image_writtenThought);

            Picasso.with(context).load(product.getImage_w()).into(imageView);


            final TextView textName=(TextView) convertView.findViewById(R.id.textname_writtenThought);
            textName.setText(product.getName_w());

            TextView textPrice=(TextView) convertView.findViewById(R.id.textdescription_writtenThought);
            textPrice.setText(product.getDescription_w());

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i=new Intent(context, com.woman.orcas.myapplication.foryou_content.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    i.putExtra("ImageUrl",product.getImage_w());
                    i.putExtra("Title",product.getName_w());
                    i.putExtra("subtitle",product.getDescription_w());
                    view.getContext().startActivity(i);


                }
            });

            return convertView;
        }


    }


