package com.softcircles.superprofs.activities;

import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.softcircles.superprofs.R;
import com.softcircles.superprofs.constants.Constants;
import com.softcircles.superprofs.fragments.SubjectListFragment;

import java.util.ArrayList;

public class CourcesActivity extends FragmentActivity implements
		SubjectListFragment.OnFragmentInteractionListener {

    Typeface fontBold;
    Typeface fontCond;

    private PagerSlidingTabStrip tabs;
    private ViewPager pager;
    private MyPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // fixed the activity orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_cources);

        fontBold = Typeface.createFromAsset(getAssets(),
                "MyriadPro-Semibold.otf");
        fontCond = Typeface.createFromAsset(getAssets(),
                "MyriadPro-Regular.otf");

        tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        ((LinearLayout)tabs.getChildAt(0)).setBackgroundResource(R.drawable.iv_top_white_plane);

        //tabs.setTextSize(45);
        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setViewPager(pager);
        setFontToTabs(tabs, fontCond);

        PageListener pageListner = new PageListener();
        tabs.setOnPageChangeListener(pageListner);
    }

    private class PageListener extends ViewPager.SimpleOnPageChangeListener {

        public PageListener(){
            //Set the first image button in tabStrip to selected,
            TextView tv = (TextView)((LinearLayout)tabs.getChildAt(0)).getChildAt(0);
            tv.setTextColor(getResources().getColor(R.color.orange));
        }

        public void onPageSelected(int position) {
            Log.i("TAG", "page selected " + position);
            for(int i=0; i < ((LinearLayout)tabs.getChildAt(0)).getChildCount(); i++){
                TextView tv = (TextView)((LinearLayout)tabs.getChildAt(0)).getChildAt(i);
                if(i == position){
                    tv.setTextColor(getResources().getColor(R.color.orange));
                } else {
                    tv.setTextColor(getResources().getColor(R.color.black));
                }
            }
        }
    }

    private void setFontToTabs(PagerSlidingTabStrip tabs, Typeface font)
    {
        for(int i=0; i < ((LinearLayout)tabs.getChildAt(0)).getChildCount(); i++){
            TextView tv = (TextView)((LinearLayout)tabs.getChildAt(0)).getChildAt(i);
            tv.setTypeface(font);
            tv.setTextSize(22);
        }
    }

    private void setBackgroundColor(View view, int color)
    {
        view.setBackgroundColor(color);
    }

    public class MyPagerAdapter extends FragmentPagerAdapter {

        private final ArrayList<String> TITLES = Constants.courceNamesList;

        public MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return TITLES.get(position);
        }

        @Override
        public int getCount()
        {
            return TITLES.size();
        }

        @Override
        public Fragment getItem(int position) {
            return SubjectListFragment.newInstance(TITLES.get(position));
        }

    }


	@Override
	public void onFragmentInteraction(Uri uri) {

	}
}
