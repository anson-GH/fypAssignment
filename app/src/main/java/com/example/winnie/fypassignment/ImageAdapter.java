package com.example.winnie.fypassignment;

/**
 * Created by bnaitali on 23/08/2016.
 */
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by bnaitali on 01/09/2015.
 */
public class ImageAdapter extends PagerAdapter {
    Context context;
    private String imageUrls[] ;
    private String names ;

    ImageAdapter(Context context, String[] imageUrls, String names){
        this.context=context;
        this.imageUrls=imageUrls;
        this.names=names;

    }
 //   @Override
   public int getCount() {
        return imageUrls.length;
   }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ImageView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        int padding = 0;

        imageView.setPadding(padding, padding, padding, padding);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int i = ((ViewPager) container).getCurrentItem();
        Toast.makeText(context, "" + names, Toast.LENGTH_SHORT).show();
        // imageView.setImageResource(GalImages[position]);
        Picasso
                .with(context)
                .load(imageUrls[position])
                .fit() // will explain later
                .into((imageView));

        ((ViewPager) container).addView(imageView, 0);

        // position = position -1;



        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((ImageView) object);
    }
}