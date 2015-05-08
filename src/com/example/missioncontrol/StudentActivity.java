package com.example.missioncontrol;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
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
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student);
		Button btnSendSMS = (Button) findViewById(R.id.helpme);
				
		btnSendSMS.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				name = ((EditText)findViewById(R.id.name)).getText().toString();
				phoneNumber = ((EditText)findViewById(R.id.phone)).getText().toString();
				message = ((EditText)findViewById(R.id.message)).getText().toString();
				Spinner spinner = (Spinner)findViewById(R.id.section);
				section = spinner.getSelectedItem().toString();
				roomNumber = ((EditText)findViewById(R.id.roomnumber)).getText().toString();
				
				sendSMS("9197978781", "Hi there RA. Your help is needed!\n" 
						+ "\nName: " + name
						+ "\nPhone: " + phoneNumber
						+ "\nSection: " + section
						+ "\nRoom Number " + roomNumber
						+ "\nMessage: " + message);
				
				Toast.makeText(getApplicationContext(), "SMS sent!",
						   Toast.LENGTH_LONG).show();
			}
			
		});
	}
	
	private void sendSMS(String phoneNumber, String message){
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, message, null, null);
	}
}
