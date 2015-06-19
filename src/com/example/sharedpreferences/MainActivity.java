package com.example.sharedpreferences;

import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity
{
EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		et=(EditText)findViewById(R.id.editText1);
		
		//SharedPreferences sp = getSharedPreferences(name, mode)
		SharedPreferences sp = getSharedPreferences("MyPrefsFile",0);
		//et.setText(sp.getString(arg0, arg1))
		et.setText(sp.getString("e_key", ""));
	}
	
	
		@Override
		protected void onStop() 
	   {
			// TODO Auto-generated method stub
			super.onStop();
			
			SharedPreferences sp = getSharedPreferences("MyPrefsFile",0);
			SharedPreferences.Editor ed= sp.edit();
			ed.putString("e_key", et.getText().toString());
			ed.commit();
			
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
