package com.vecika.zadatak;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.UnderlinePageIndicator;

/**
 * Created by vecika on 05/05/2016.
 */
public class GalerijaActivity extends Activity{

    ViewPager viewPager;
    PagerAdapter adapter;
    UnderlinePageIndicator mIndicator;
    int[] slike;
    int pozicija;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_main);

        slike =  getIntent().getExtras().getIntArray("slikeGalerija");
        pozicija = getIntent().getExtras().getInt("pozicija");

        viewPager = (ViewPager)findViewById(R.id.pager);

        adapter = new ViewPagerAdapter(GalerijaActivity.this, slike);

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(pozicija);

        mIndicator = (UnderlinePageIndicator)findViewById(R.id.indicator);
        mIndicator.setFades(false);
        mIndicator.setViewPager(viewPager);
    }
}
