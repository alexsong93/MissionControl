package com.example.missioncontrol;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class RALoginActivity extends ActionBarActivity {
	
	EditText emailInput;
	EditText pwInput;
	Button loginBtn;
	Button signupBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ralogin);
		
		emailInput = (EditText) findViewById(R.id.editText1);
		pwInput = (EditText) findViewById(R.id.editText2);
		loginBtn = (Button) findViewById(R.id.button1);
		signupBtn = (Button) findViewById(R.id.button2);
		
		loginBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(v == loginBtn){
					//Go to RA view
				}
				
			}
		});
		
		
		
		

	}
	
	public void openSignupPage(View view) {
		Intent intent = new Intent(this, RAregisterActivity.class);
		startActivity(intent);
	}
}