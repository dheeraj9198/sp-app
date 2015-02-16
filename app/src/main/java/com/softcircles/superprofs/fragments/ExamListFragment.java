package com.softcircles.superprofs.fragments;

import com.softcircles.superprofs.R;
import com.softcircles.superprofs.controllers.ExamLevelsAdapter;
import com.softcircles.superprofs.controllers.ExamsListAdapter;
import com.softcircles.superprofs.constants.Constants;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ExamListFragment extends Fragment{

	View view;
	ListView lvExams;
	ExamListFragment mExamListFragment;
	LayoutInflater inflater;
	AlertDialog.Builder alertDialog;
    TextView tvExam;
    TextView tvExamLevel;
	AlertDialog dialog;
	ImageView ivSelectedCheckbox;
	ImageView ivSelected;
    Activity activity;

    Typeface fontBold;
    Typeface fontCond;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
        this.activity = activity;
        fontBold = Typeface.createFromAsset(activity.getAssets(),
                "MyriadPro-Semibold.otf");
        fontCond = Typeface.createFromAsset(activity.getAssets(),
                "MyriadPro-Regular.otf");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(final LayoutInflater inflater,
			ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		this.inflater = inflater;
		view = inflater.inflate(R.layout.fragment_registration, container, false);
        lvExams = (ListView) view.findViewById(R.id.lv_exams);
        
        Constants.setDataTODataStructures();
        Constants.setExamDataTODataStructures();
        
        lvExams.setAdapter(new ExamsListAdapter(getActivity()));
        
        lvExams.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewListItem, int position, long id) {

            	 if (ivSelected != null)
            	 {
            		 ivSelected.setBackgroundResource(android.R.color.transparent);
            	 }

            	 ivSelected = (ImageView) viewListItem.findViewById(R.id.iv_selection_bar_registratin);
            	 ivSelected.setBackgroundResource(R.drawable.iv_orangebar_vertical);
            	 
            	 if (ivSelectedCheckbox != null)
            	 {
            		 ivSelectedCheckbox.setBackgroundResource(android.R.color.transparent); 
            	 }

                 if (tvExam != null)
                 {
                     tvExam.setTextColor(activity.getResources().getColor(R.color.black));
                 }

            	 if (tvExamLevel != null)
            	 {
            		 tvExamLevel.setText("");
            	 }
            	 
            	 ivSelectedCheckbox = (ImageView) viewListItem.findViewById(R.id.iv_selection_check);
            	 ivSelectedCheckbox.setBackgroundResource(R.drawable.iv_selected_check);
            	
            	 tvExam = (TextView) viewListItem.findViewById(R.id.tv_exam_item);
                 tvExam.setTextColor(activity.getResources().getColor(R.color.orange));

                 tvExamLevel = (TextView) viewListItem.findViewById(R.id.tv_exam_level);
            	 String examName = tvExam.getText().toString();
            	 
            	 alertDialog = new AlertDialog.Builder(getActivity(),  AlertDialog.THEME_HOLO_LIGHT);
                 View convertView = (View) inflater.inflate(R.layout.alert_dialog_exam_levels, null);
                 alertDialog.setView(convertView);
                 //alertDialog.setTitle(Constants.EXAM_LEVEL_MESSAGE + examName + " exam");
                 
                 View dialogView = inflater.inflate(R.layout.alert_dialog_custom_title, null);
                 TextView tvDialogViewExamName = (TextView) dialogView.findViewById(R.id.tv_dialog_title_exam_name);
                 tvDialogViewExamName.setText(examName);
                 tvDialogViewExamName.setTypeface(fontBold);

                 TextView tvDialogViewExamName1 = (TextView) dialogView.findViewById(R.id.tv_dialog_title_1);
                 tvDialogViewExamName1.setTypeface(fontCond);

                 TextView tvDialogViewExamName2 = (TextView) dialogView.findViewById(R.id.tv_dialog_title_2);
                 tvDialogViewExamName2.setTypeface(fontCond);

                 alertDialog.setCustomTitle(dialogView);
                 
                 ListView lvDialogExamLevel = (ListView) convertView.findViewById(R.id.lv_exam_levels);
                 int listSize = Constants.examDictionariesList.get(position).get(examName).size();
                 lvDialogExamLevel.setAdapter(new ExamLevelsAdapter(getActivity(), examName, listSize));
                 dialog = alertDialog.show();
                 
                 
                 lvDialogExamLevel.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						TextView tvExamLevelDialog = (TextView) view.findViewById(R.id.tv_exam_level_dialog);
						String examLevelName = tvExamLevelDialog.getText().toString();
						tvExamLevel.setText(" - " + examLevelName);
						
						dialog.cancel();
					}
				});
            }
        });
        
        return view;
	}
	

}
