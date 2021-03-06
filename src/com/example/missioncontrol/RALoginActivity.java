package com.example.missioncontrol;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
		
		
		
		

	}
	
	public void openSignupPage(View view) {
		Intent intent = new Intent(this, RAregisterActivity.class);
		startActivity(intent);
	}
	
	public void openRABoard(View view) {
		Intent intent = new Intent(this, RABoardActivity.class);
		startActivity(intent);
	}
	
	@Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                                                        INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }
}