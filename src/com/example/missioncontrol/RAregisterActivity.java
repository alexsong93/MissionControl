package com.example.missioncontrol;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RAregisterActivity extends ActionBarActivity {
	
	EditText nameInput;
	EditText emailInput;
	EditText pwInput;
	Button regisBtn;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_raregister);
		
		nameInput = (EditText) findViewById(R.id.editText1);
		emailInput = (EditText) findViewById(R.id.editText2);
		pwInput = (EditText) findViewById(R.id.editText3);
		regisBtn = (Button) findViewById(R.id.button1);
		
		regisBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v==regisBtn){
					//Send Email to RC
				}
				
			}
		});
		
	}
}
