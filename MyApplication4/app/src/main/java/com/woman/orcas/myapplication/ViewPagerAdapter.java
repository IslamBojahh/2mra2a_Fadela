package com.woman.orcas.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by orcas on 15/01/18.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] Images={R.drawable.silde1};
    ImageView m1;






    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

       layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view=layoutInflater.inflate(R.layout.customs_layout, null);
       //ImageView imageView =(ImageView) view.findViewById(R.id.imageViewSilde);
       //imageView.setImageResource(Images[position]);

        ViewPager vp= (ViewPager)container;
        vp.addView(view,0);

        return view;



    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager vp=(ViewPager) container;
        View view=(View)object;
        vp.removeView(view);
    }


}

