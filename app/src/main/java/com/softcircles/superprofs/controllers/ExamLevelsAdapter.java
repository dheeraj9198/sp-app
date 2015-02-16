package com.softcircles.superprofs.controllers;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.softcircles.superprofs.R;
import com.softcircles.superprofs.constants.Constants;

public class ExamLevelsAdapter extends BaseAdapter{
	private LayoutInflater layoutInflater;
	private String examName;
	private int listSize;

    Typeface fontBold;
    Typeface fontCond;
	

    public ExamLevelsAdapter(Context activity, String examName, int listSize) {
        this.examName = examName;
        this.listSize = listSize;
        layoutInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        fontBold = Typeface.createFromAsset(activity.getAssets(),
                "MyriadPro-Semibold.otf");
        fontCond = Typeface.createFromAsset(activity.getAssets(),
                "MyriadPro-Regular.otf");
    }

    @Override
    public int getCount() {
        // Set the count value to the total number of items in the Array
        return listSize;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh;
        // Inflate the item layout and set the views
        View listItem = convertView;
        if (listItem == null) {
            vh = new ViewHolder();
            listItem = layoutInflater.inflate(R.layout.list_item_exam_level,
                    null);

            vh.setTvSubjectName((TextView)listItem
                    .findViewById(R.id.tv_exam_level_dialog));
            vh.getTvSubjectName().setTypeface(fontBold);
            listItem.setTag(vh);

        }
        vh = (ViewHolder) listItem.getTag();
        for (int i = 0; i < Constants.examDictionariesList.size(); i++)
        {
        	if (Constants.examDictionariesList.get(i).containsKey(examName))
        	{
        		ArrayList<String> examLevelsList = Constants.examDictionariesList.get(i).get(examName);
            	String examLevel = examLevelsList.get(position);
            	vh.getTvSubjectName().setText(examLevel);
            	break;
        	}
        	
        }
        return listItem;
    }

}
