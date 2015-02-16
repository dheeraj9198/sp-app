package com.softcircles.superprofs.fragments;

import android.app.Activity;

import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.softcircles.superprofs.R;
import com.softcircles.superprofs.controllers.SimpleListAdapter;
import com.softcircles.superprofs.constants.Constants;


public class SubjectListFragment extends Fragment {

    public static SubjectListFragment mSubjectListFragment;
    ListView lvCourseSubjects;
    Activity activity;
    
    private static final String COURSE_NAME = "courseName";


    // TODO: Rename and change types of parameters
    private String courseName;

    private OnFragmentInteractionListener mListener;

    public static SubjectListFragment newInstance(String courseName) {
        SubjectListFragment fragment = new SubjectListFragment();
        Bundle args = new Bundle();
        args.putString(COURSE_NAME, courseName);
        fragment.setArguments(args);
        return fragment;
    }
    
    public SubjectListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            courseName = getArguments().getString(COURSE_NAME);
        }
    }

    
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mSubjectListFragment = this;
        View view;
        activity = getActivity();
        view = inflater.inflate(R.layout.fragment_subject_list, container, false);
        lvCourseSubjects = null;
        lvCourseSubjects = (ListView) view.findViewById(R.id.lv_cource_subjects);
        this.populateFragment(courseName);
        lvCourseSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return view;
    }
    

    public void populateFragment(String courseName)
    {
    	int listSize = 0;
    	for (int i = 0; i < Constants.courseDictionariesList.size(); i++)
        {
        	if (Constants.courseDictionariesList.get(i).containsKey(courseName))
        	{
        		listSize = Constants.courseDictionariesList.get(i).get(courseName).size();
        		lvCourseSubjects.setAdapter(new SimpleListAdapter(activity, courseName, listSize));
        		break;
        	}
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
