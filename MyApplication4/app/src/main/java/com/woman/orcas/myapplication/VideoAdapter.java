package com.woman.orcas.myapplication;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Tofiq Quadri on 27-03-2017.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    List<com.woman.orcas.myapplication.YoutubeVideo> youtubeVideoList;

    public VideoAdapter() {
    }

    public VideoAdapter(List<com.woman.orcas.myapplication.YoutubeVideo> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.card_video, parent, false);

        return new VideoViewHolder(view);

    }


    @Override
    public void onBindViewHolder(VideoViewHolder holder, final int position) {


        holder.videoWeb.loadData( youtubeVideoList.get(position).getURL(), "text/html" , "utf-8" );
        holder.t1.setText(youtubeVideoList.get(position).getVideoName());

        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(view.getContext(), com.woman.orcas.myapplication.videoActivity.class);
                intent.putExtra("videoId", youtubeVideoList.get(position).getVideoId());
                view.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        WebView videoWeb;
        TextView t1;
        LinearLayout l1;
        Button b1;

        public VideoViewHolder(View itemView) {
            super(itemView);


            videoWeb = (WebView) itemView.findViewById(R.id.webVideoView);
            b1=(Button) itemView.findViewById(R.id.button) ;
            t1=(TextView) itemView.findViewById(R.id.title);

            videoWeb.getSettings().setJavaScriptEnabled(true);








        }
    }

}

