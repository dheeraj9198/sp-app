package com.softcircles.superprofs.activities;

import com.softcircles.superprofs.R;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class RegistrationActivity extends FragmentActivity {

    Typeface fontBold;
    Typeface fontCond;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // fixed the activity orientation
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		setContentView(R.layout.activity_regestration);
        fontBold = Typeface.createFromAsset(getAssets(),
                "MyriadPro-Semibold.otf");
        fontCond = Typeface.createFromAsset(getAssets(),
                "MyriadPro-Regular.otf");


        TextView tvExamHeaderDescription = (TextView) findViewById(R.id.tv_exam_header_description);
        tvExamHeaderDescription.setTypeface(fontBold);

		TextView iv_browse_courses = (TextView) findViewById(R.id.iv_browse_courses);
        iv_browse_courses.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(RegistrationActivity.this,
						CourcesActivity.class);
				startActivity(intent);
			}
		});
	}
}
