package com.example.experience_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class First_Activity extends Activity{
	//first
	 private static final String[] phonenumberStr=new String[]{
		"88888888888","86668888","77777777","66666666","861434129","861238888"
	};
	
	 protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			//first
			setContentView(R.layout.activity_main);
			ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, phonenumberStr);
			AutoCompleteTextView autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.autoTextView);
			autoCompleteTextView.setAdapter(adapter);
		}
		
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main_, menu);
			return true;
		}
}
