package com.softcircles.superprofs.controllers;

import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ViewHolder {

    private RelativeLayout parentLayout;
    private TextView tvSubjectName;
    private TextView tvTeacherName;
    private TextView tvLanguage;
    private ImageView ivNotification;
    private ImageView ivBackgorund;
    private TextView tvNotificationCount;
    private TextView tvExamLevel;
	private RelativeLayout relativeLayout;

    public TextView getTvExamLevel() {
        return tvExamLevel;
    }

    public void setTvExamLevel(TextView tvExamLevel) {
        this.tvExamLevel = tvExamLevel;
    }

    public ImageView getIvBackgorund() {
		return ivBackgorund;
	}
    
	public void setIvBackgorund(ImageView ivBackgorund) {
		this.ivBackgorund = ivBackgorund;
	}

    public RelativeLayout getRelativeLayout() {
		return relativeLayout;
	}
    
	public void setRelativeLayout(RelativeLayout relativeLayout) {
		this.relativeLayout = relativeLayout;
	}
	
	public RelativeLayout getParentLayout() {
		return parentLayout;
	}
	
	public void setParentLayout(RelativeLayout parentLayout) {
		this.parentLayout = parentLayout;
	}

	public TextView getTvSubjectName(){
		return tvSubjectName;
	}

	public void setTvSubjectName(TextView tvSubjectName) {
		this.tvSubjectName = tvSubjectName;
	}

    public TextView getTvTeacherName(){
        return tvTeacherName;
    }

    public void setTvTeacherName(TextView tvTeacherName) {
        this.tvTeacherName = tvTeacherName;
    }

    public TextView getTvLanguage(){
        return tvLanguage;
    }

    public void setTvLanguage(TextView tvLanguage) {
        this.tvLanguage = tvLanguage;
    }
    
    public ImageView getIvNotification() {
		return ivNotification;
	}
    
	public void setIvNotification(ImageView ivNotification) {
		this.ivNotification = ivNotification;
	}
	
	public TextView getTvNotificationCount() {
		return tvNotificationCount;
	}
	
	public void setTvNotificationCount(TextView tvNotificationCount) {
		this.tvNotificationCount = tvNotificationCount;
	}
}