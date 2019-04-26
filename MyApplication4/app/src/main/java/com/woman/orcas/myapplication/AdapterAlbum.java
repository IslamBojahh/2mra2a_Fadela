package com.woman.orcas.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ORCAS_ISLAM on 1/24/2018.
 */

public class AdapterAlbum extends RecyclerView.Adapter<AdapterAlbum.ViewHolder> {

    private ArrayList<com.woman.orcas.myapplication.albumItem> galleryList;
    private Context context;
    String x;
    String y;


    public AdapterAlbum(Context context, ArrayList<com.woman.orcas.myapplication.albumItem> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public AdapterAlbum.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_layout, viewGroup, false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(final AdapterAlbum.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(galleryList.get(i).getImage_title());
        viewHolder.img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        // viewHolder.img.setImageResource((galleryList.get(i).getImage_ID()));

        Picasso.with(context).load(galleryList.get(i).getImage_ID()).into(viewHolder.img);

        final String y = galleryList.get(i).getText();
        final String x = galleryList.get(i).getImage_ID();


        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(context,x ,Toast.LENGTH_SHORT).show();
                // Toast.makeText(context,y ,Toast.LENGTH_SHORT).show();
                Intent i = new Intent(context, com.woman.orcas.myapplication.picture_content1.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                i.putExtra("ImageUrl", x);
                i.putExtra("Title", viewHolder.title.getText());
                i.putExtra("subtitle", y);


                v.getContext().startActivity(i);


            }
        });
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView img;

        public ViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title_album);
            img = (ImageView) view.findViewById(R.id.img_album);

        }
    }
}