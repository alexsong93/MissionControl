package com.example.missioncontrol;

import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RAregisterActivity extends ActionBarActivity {
	
	EditText nameInput;
	EditText phoneInput;
	EditText emailInput;
	EditText pwInput;
	Button regisBtn;
	
	String nameStr;
	String phoneStr;
	String emailStr;
	String pwStr;
	
	int lastId;
	DatabaseHandler db = new DatabaseHandler(this);;
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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_raregister); 
		
		
//		lastId = db.getRAContactsCount();
//		if(lastId == 0) {
//			lastId = -1;
//		}
		regisBtn = (Button) findViewById(R.id.button1);
		regisBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText nameInput = (EditText) findViewById(R.id.editText1);
				nameStr = nameInput.getText().toString();
				EditText phoneInput = (EditText) findViewById(R.id.editText4);
				phoneStr = phoneInput.getText().toString();
				EditText emailInput = (EditText) findViewById(R.id.editText2);
				emailStr = emailInput.getText().toString();
				EditText pwInput = (EditText) findViewById(R.id.editText3);
				pwStr = pwInput.getText().toString();
				
				db.addContact(new RAContact(1, nameStr, phoneStr, emailStr, pwStr));
				Toast.makeText(getApplicationContext(), "RA Contact Created!",
						   Toast.LENGTH_LONG).show();
//				List<RAContact> contacts = db.getAllContacts();
//				Log.d("Reading all contacts...", "");
//				for (RAContact cn : contacts) {
//		            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//		                // Writing Contacts to log
//			        Log.d("Name: ", log);
//			    }
			}
		});
		
	}
}
