package com.softcircles.superprofs.controllers;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.softcircles.superprofs.R;
import com.softcircles.superprofs.constants.Constants;

public class HorizontalListAdapter extends BaseAdapter{

	private LayoutInflater layoutInflater;
	private Context context;

    public HorizontalListAdapter(Context activity) {
        // TODO Auto-generated constructor stub
    	this.context = activity;
        layoutInflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // Set the count value to the total number of items in the Array
        return Constants.courceNamesList.size();
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
            listItem = layoutInflater.inflate(R.layout.list_item_fragment_horizontallist,
                    null);

            vh.setRelativeLayout((RelativeLayout)listItem.findViewById(R.id.rl_parent_listitem_hlist));
            vh.setTvSubjectName((TextView)listItem
                    .findViewById(R.id.tv_course_name));
            listItem.setTag(vh);

        }
        vh = (ViewHolder) listItem.getTag();
        vh.getTvSubjectName().setText(Constants.courceNamesList.get(position));
        
        return listItem;
        
    }
}
