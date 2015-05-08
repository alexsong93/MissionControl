package com.example.missioncontrol;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class RABoardActivity extends TabActivity {
	
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_raboard);
		
		TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
		
		TabSpec tab1 = tabHost.newTabSpec("Newsfeed");
        TabSpec tab2 = tabHost.newTabSpec("Calendar");
        TabSpec tab3 = tabHost.newTabSpec("Contacts");
        
        tab1.setIndicator("Newsfeed");
        tab1.setContent(new Intent(this,RANewsfeedTabActivity.class));
        
        tab2.setIndicator("Calendar");
        tab2.setContent(new Intent(this,RACalendarTabActivity.class));

        tab3.setIndicator("Contacts");
        tab3.setContent(new Intent(this,RAContactsTabActivity.class));
        
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
	}
}
