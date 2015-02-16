package com.softcircles.superprofs.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.softcircles.superprofs.dos.NotificationDO;
import com.softcircles.superprofs.dos.SubjectDO;

public class Constants {
	
	public static final String EXAM_LEVEL_MESSAGE = "Please, select a level for ";
	
	// this list contains all the courses with their respective subjects
	public static ArrayList<Map<String, ArrayList<SubjectDO>>> courseDictionariesList;

    // this dictionary contains all the subjects against a single course
    public static Map<String, ArrayList<SubjectDO>> courceDictionary;

    // this list contains all subjectsDOs
    public static ArrayList<SubjectDO> subjectsList;

    // this list contains all cource names
	public static ArrayList<String> courceNamesList;

    // this list contains all exam names
	public static ArrayList<String> examsList;

    // this list contains all exam levels names
	public static ArrayList<String> examsLevelList;

    // this dictionary contains exam levels against a single exam.
	public static Map<String, ArrayList<String>> examWithItsLevelsDictionary;

    // this list contains all exams with all its respective levels.
	public static ArrayList<Map<String, ArrayList<String>>> examDictionariesList;

    // populate data first as you like according to the data structures. We have populated sample data as below.
	public static void setDataTODataStructures()
	{
        courseDictionariesList = new ArrayList<Map<String,ArrayList<SubjectDO>>>();
	    courceNamesList = new ArrayList<String>();
		courceNamesList.add("Software Engineering");
		courceNamesList.add("Information Technology");
		courceNamesList.add("Computer Sciences");
        courceNamesList.add("Software Engineering");
        courceNamesList.add("Information Technology");
        courceNamesList.add("Computer Sciences");
		
		for (int i = 0; i < courceNamesList.size(); i++)
		{	
			// populating list of subjectDOs

            // this step is not needed, its just for getting some variations in the data having limited data.
            if (i % 2 == 0) {
                NotificationDO notificationDO = new NotificationDO();
                notificationDO.setNotificationValue(String.valueOf(i));

                SubjectDO subjectDO = new SubjectDO();
                subjectDO.setIsNew(true);
                subjectDO.setSubjectName("Database Management Skills");
                subjectDO.setTeacherName("Zohaib Hassan");
                subjectDO.setLanguage("English");
                subjectDO.setNotificationDO(notificationDO);

                NotificationDO notificationDO2 = new NotificationDO();
                notificationDO2.setNotificationValue(String.valueOf(i + 1));
                SubjectDO subjectDO2 = new SubjectDO();
                subjectDO2.setSubjectName("Object Oriented Programing");
                subjectDO2.setTeacherName("Mamoona Tariq");
                subjectDO2.setLanguage("English, French");
                subjectDO2.setNotificationDO(notificationDO2);

                subjectsList = new ArrayList<SubjectDO>();
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);

                courceDictionary = new HashMap<String, ArrayList<SubjectDO>>();
                courceDictionary.put(courceNamesList.get(i), subjectsList);
                courseDictionariesList.add(courceDictionary);
            }

            else
            {
                NotificationDO notificationDO = new NotificationDO();
                notificationDO.setNotificationValue(String.valueOf(i+2));

                SubjectDO subjectDO = new SubjectDO();
                subjectDO.setIsNew(true);
                subjectDO.setSubjectName("Data Structures");
                subjectDO.setTeacherName("Kaleem Nisar");
                subjectDO.setLanguage("English");
                subjectDO.setNotificationDO(notificationDO);

                NotificationDO notificationDO2 = new NotificationDO();
                notificationDO2.setNotificationValue(String.valueOf(i + 3));
                SubjectDO subjectDO2 = new SubjectDO();
                subjectDO2.setSubjectName("Sociology and Economy");
                subjectDO2.setTeacherName("Tahir Bashir");
                subjectDO2.setLanguage("English");
                subjectDO2.setNotificationDO(notificationDO2);

                subjectsList = new ArrayList<SubjectDO>();
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);
                subjectsList.add(subjectDO);
                subjectsList.add(subjectDO2);

                courceDictionary = new HashMap<String, ArrayList<SubjectDO>>();
                courceDictionary.put(courceNamesList.get(i), subjectsList);
                courseDictionariesList.add(courceDictionary);
            }
		}	
	}

    // populate data first as u like according to the data structures. We have populated sample data as below.
	public static void setExamDataTODataStructures()
	{
		examDictionariesList = new ArrayList<Map<String,ArrayList<String>>>();
		examsList = new ArrayList<String>();
		examsList.add("ACCA");
		examsList.add("CA");
		examsList.add("CMA");
		examsList.add("CMS");
		examsList.add("GATE");
		examsList.add("NCFM");
		examsList.add("LSAT");
		examsList.add("CAT");
		examsList.add("GMAT");
		examsList.add("SAT");
        examsList.add("IIT-JEE");

		
		for (int i = 0; i < examsList.size(); i++)
		{
			examsLevelList = new ArrayList<String>();
			examsLevelList.add("CPT");
			examsLevelList.add("IPC");
			examsLevelList.add("FINAL");

			examWithItsLevelsDictionary = new HashMap<String, ArrayList<String>>();
			examWithItsLevelsDictionary.put(examsList.get(i), examsLevelList);
			examDictionariesList.add(examWithItsLevelsDictionary);
		}
	}
}


