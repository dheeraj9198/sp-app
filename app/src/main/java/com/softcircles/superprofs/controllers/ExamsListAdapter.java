package com.softcircles.superprofs.controllers;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.softcircles.superprofs.R;
import com.softcircles.superprofs.constants.Constants;

public class ExamsListAdapter extends BaseAdapter {
	private LayoutInflater layoutInflater;
    Typeface fontBold;
    Typeface fontCond;

    public ExamsListAdapter(Context activity) {
        // TODO Auto-generated constructor stub
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
        return Constants.examsList.size();
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
            listItem = layoutInflater.inflate(R.layout.list_item_registration_listview,
                    null);

            vh.setTvSubjectName((TextView)listItem
                    .findViewById(R.id.tv_exam_item));
            vh.getTvSubjectName().setTypeface(fontCond);

            vh.setTvExamLevel((TextView)listItem
                    .findViewById(R.id.tv_exam_level));
            vh.getTvExamLevel().setTypeface(fontCond);
            listItem.setTag(vh);

        }
        vh = (ViewHolder) listItem.getTag();
        vh.getTvSubjectName().setText(Constants.examsList.get(position));
        return listItem;
    }
}
