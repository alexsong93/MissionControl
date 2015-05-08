package com.example.missioncontrol;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class RACalendarTabActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setTextSize(25);
        tv.setText("RA CALENDAR");
        setContentView(tv);
    }
}
