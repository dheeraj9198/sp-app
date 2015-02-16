package com.softcircles.superprofs.controllers;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.softcircles.superprofs.R;
import com.softcircles.superprofs.constants.Constants;
import com.softcircles.superprofs.dos.SubjectDO;

    public class SimpleListAdapter extends BaseAdapter {

        private LayoutInflater layoutInflater;
        private String courseName;
        private Context context;
        private int listSize;

        Typeface fontBold;
        Typeface fontCond;

        public SimpleListAdapter(Context activity, String courseName, int listSize) {
            this.context = activity;
            this.listSize = listSize;
        	layoutInflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.courseName = courseName;
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
                listItem = layoutInflater.inflate(R.layout.list_item_cource_subject,
                        null);

                vh.setTvSubjectName((TextView)listItem
                        .findViewById(R.id.tv_Subject_name));
                vh.getTvSubjectName().setTypeface(fontBold);

                vh.setTvTeacherName((TextView)listItem
                        .findViewById(R.id.tv_teacher_name));
                vh.getTvTeacherName().setTypeface(fontCond);

                vh.setTvLanguage((TextView)listItem
                        .findViewById(R.id.tv_language_name));
                vh.getTvLanguage().setTypeface(fontCond);
                
                vh.setIvBackgorund((ImageView)listItem.findViewById(R.id.iv_subject));
                
                vh.setIvNotification( (ImageView) (listItem.findViewById(R.id.iv_notification_icon)));
                vh.setTvNotificationCount( (TextView) (listItem.findViewById(R.id.tv_notification_count)));
                vh.getTvNotificationCount().bringToFront();

                vh.getTvNotificationCount().setTypeface(fontBold);

                listItem.setTag(vh);

            }
            vh = (ViewHolder) listItem.getTag();
            
            // change background using subjectDO object
            // it is used just for sample
            if (position % 2 == 0)
    		{
    			vh.getIvBackgorund().setImageDrawable(context.getResources().getDrawable(R.drawable.iv_subject_background2));
    		}
            else
            {
            	vh.getIvBackgorund().setImageDrawable(context.getResources().getDrawable(R.drawable.iv_subject_background));
            }
            
            for (int i = 0; i < Constants.courseDictionariesList.size(); i++)
            {
            	if (Constants.courseDictionariesList.get(i).containsKey(courseName))
            	{
            		ArrayList<SubjectDO> subjectDOList = Constants.courseDictionariesList.get(i).get(courseName);
                	SubjectDO subjectDO = subjectDOList.get(position);
                	
                	vh.getTvSubjectName().setText(subjectDO.getSubjectName());
                	
                	vh.getTvTeacherName().setText(subjectDO.getTeacherName());
                	
                	vh.getTvLanguage().setText(subjectDO.getLanguage());
                	
                	vh.getTvNotificationCount().setText(subjectDO.getNotificationDO().getNotificationValue());

                	vh.getIvNotification().setImageDrawable(context.getResources().getDrawable(R.drawable.iv_notification));
                	break;
            	}
            	
            }
            
            // set values for every element of list item here using viewholder object (vh)
            return listItem;

        }
    }


