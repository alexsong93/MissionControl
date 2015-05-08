package com.example.missioncontrol;

import java.util.List;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class StudentActivity extends ActionBarActivity {
	
	String name;
	String phoneNumber;
	String message;
	String section;
	String roomNumber;
	
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
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student);

//		List<RAContact> contacts = db.getAllContacts();
//		Log.d("Reading all contacts...", "");
//		for (RAContact cn : contacts) {
//            String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
//                // Writing Contacts to log
//	        Log.d("Name: ", log);
//	    }
		
		Button btnSendSMS = (Button) findViewById(R.id.helpme);
				
		btnSendSMS.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				name = ((EditText)findViewById(R.id.name)).getText().toString();
				phoneNumber = ((EditText)findViewById(R.id.phone)).getText().toString();
				message = ((EditText)findViewById(R.id.message)).getText().toString();
				Spinner spinner = (Spinner)findViewById(R.id.section);
				section = spinner.getSelectedItem().toString();
				roomNumber = ((EditText)findViewById(R.id.roomnumber)).getText().toString();
				if(name.trim().equals("")) {
					Toast.makeText(getApplicationContext(), "Please Enter your name!",
							   Toast.LENGTH_LONG).show();
				} else if(phoneNumber.trim().equals("")) {
					Toast.makeText(getApplicationContext(), "Please Enter your phone number!",
							   Toast.LENGTH_LONG).show();
				} else if(roomNumber.trim().equals("")) {
					Toast.makeText(getApplicationContext(), "Please Enter your room number!",
							   Toast.LENGTH_LONG).show();
				} else if(message.trim().equals("")) {
					Toast.makeText(getApplicationContext(), "Please Enter your message!",
							   Toast.LENGTH_LONG).show();
				} else {
					sendSMS("9197978781", "Hi there RA. Your help is needed!\n" 
							+ "\nName: " + name
							+ "\nPhone: " + phoneNumber
							+ "\nSection: " + section
							+ "\nRoom Number: " + roomNumber
							+ "\nMessage: " + message);
					
					Toast.makeText(getApplicationContext(), "Alert Sent! Your RA will get back to you soon!",
							   Toast.LENGTH_LONG).show();
				}
			}
			
		});
	}
	
	private void sendSMS(String phoneNumber, String message){
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, message, null, null);
	}
}
