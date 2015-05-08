package com.example.missioncontrol;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class RAContactsTabActivity extends ListActivity {
	
	List<String> listItems = new ArrayList<String>();
	ArrayAdapter<String> adapter;
	
	DatabaseHandler db = new DatabaseHandler(this);
	@Override
	protected void onResume() {
		super.onResume();
		db = new DatabaseHandler(this);
	}
	@Override
	protected void onPause() {
		super.onPause();
		if(db != null) {
			db.close();
		}
	}
	@Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        TextView tv = new TextView(this);
//        tv.setTextSize(25);
//        tv.setText("RA CONTACTSS");
//        setContentView(tv);
        
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                listItems);
        setListAdapter(adapter);
        
        List<RAContact> contacts = db.getAllContacts();
		for (RAContact cn : contacts) {
			listItems.add(cn.getID() + " | "+ cn.getName() + " | " + cn.getPhoneNumber() 
					+ " | " + cn.getEmail() + " | " + cn.getPassword());
	    }
		adapter.notifyDataSetChanged();
    }
}
