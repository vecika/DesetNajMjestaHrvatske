package com.vecika.zadatak;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.vecika.zadatak.Util.TouchImageView;

/**
 * Created by vecika on 05/05/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    int[] slike;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context,int[] slike) {
        this.context = context;
        this.slike = slike;
    }

    @Override
    public int getCount() {
        return slike.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        TouchImageView imgslike;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.activity_galerija, container,false);

        imgslike = (TouchImageView) itemView.findViewById(R.id.slike);
        imgslike.setImageResource(slike[position]);

        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}