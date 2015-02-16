package com.softcircles.superprofs.controllers;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;



	public  class PagerAdapter extends FragmentPagerAdapter {
		
		SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();
		public  int pageCount = 1;
	    
		private final List<Fragment> mFragments = new ArrayList<Fragment>();

	    public PagerAdapter(FragmentManager fragmentManager) {
	    	super(fragmentManager);
	    }

	    public void addFragment(Fragment fragment) {
	        mFragments.add(fragment);
	        notifyDataSetChanged();
	    }

	    @Override
	    public Object instantiateItem(ViewGroup container, int position) {
	        Fragment fragment = (Fragment) super.instantiateItem(container, position);
	        registeredFragments.put(position, fragment);
	        return fragment;
	    }
	    
	    @Override
	    public int getCount() {
	        return mFragments.size();
	    }

	    @Override
	    public Fragment getItem(int position) {
	    	return mFragments.get(position);
	    }
	    
	    public Fragment getRegisteredFragment(int position) {
	        return registeredFragments.get(position);
	    }
	}


