package com.softcircles.superprofs.fragments;

import java.util.ArrayList;

import com.softcircles.superprofs.R;
import com.softcircles.superprofs.constants.Constants;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ResourceCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class HorizontalListFragment extends Fragment{

    TextView tvCourseName;
	public int fragmentPosition;
	public SubjectListFragment mSubjectListFragment;
	public View view;
	public ArrayList<TextView> listTextViews;
	
	@Override
	public View onCreateView(LayoutInflater inflater,
		ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.list_item_fragment_horizontallist, container, false);
		tvCourseName = (TextView) view.findViewById(R.id.tv_course_name);
		tvCourseName.setText(Constants.courceNamesList.get(fragmentPosition));
		listTextViews.add(tvCourseName);
		tvCourseName.setTextColor(getResources().getColor(R.color.orange));
		
		tvCourseName.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
					
			if (tvCourseName != null)
			{
			    tvCourseName.setTextColor(getResources().getColor(R.color.black));
			}
						  
			tvCourseName = (TextView) view.findViewById(R.id.tv_course_name);
			tvCourseName.setTextColor(getResources().getColor(R.color.orange));
			mSubjectListFragment.populateFragment(tvCourseName.getText().toString());
				
			}
		});
		
		return view;
	}

}
