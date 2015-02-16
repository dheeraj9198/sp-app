package com.softcircles.superprofs.dos;

import android.media.Image;

public class SubjectDO {

	private String subjectName;
    private String teacherName;
	private String language;

    //path to image that needs to be set. Will be fetched from server.
    private String ivSubject;

    //if you want to keep copy of the fetched image; then use it.
    private Image ivImage;

    //set boolean to show if course is new or not
    private boolean isNew;

    //set full data object items to set the notification
    private NotificationDO notificationDO;


    public SubjectDO()
	{
		notificationDO = new NotificationDO();
	}

    public String getIvSubject()
    {
        return this.ivSubject;
    }

    public void setIvSubject(String ivSubject)
    {
        this.ivSubject = ivSubject;
    }

	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	public String getTeacherName() {
		return teacherName;
	}
	
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}

    public Image getImage() {
        return ivImage;
    }

    public void setImage(Image image) { this.ivImage = image; }
	
	public boolean getIsNew() {
		return isNew;
	}
	
	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}
	
	public NotificationDO getNotificationDO() {
		return notificationDO;
	}

	public void setNotificationDO(NotificationDO notificationDO) {
		this.notificationDO = notificationDO;
	}
	
	
}
