package com.example.experience_2;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AnalogClock;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.TextView;
import android.widget.TimePicker;

public class Second_Activity extends Activity {
	//second
	DatePicker dp;
	TimePicker tp;
	DigitalClock dc;
	AnalogClock ac;
	TextView tv;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//second
		setContentView(R.layout.date_picker);
		
		dp=(DatePicker) findViewById(R.id.dp);
		tp=(TimePicker) findViewById(R.id.tp);
		dc=(DigitalClock) findViewById(R.id.dc);
		ac=(AnalogClock) findViewById(R.id.ac);
		tv=(TextView) findViewById(R.id.tv);
		
		Calendar c=Calendar.getInstance();
		dp.init(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
			public void onDateChanged(DatePicker view, int year, int monthOfYear,
					int dayOfMonth) {
				display();
				
			}
		});
		tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// TODO Auto-generated method stub
				display();
			}
		});
		
	}
	
	
	//second
	void display(){
		int y=dp.getYear();
		int m=dp.getMonth();
		int d=dp.getDayOfMonth();
		int h=tp.getCurrentHour();
		int mi=tp.getCurrentMinute();
		int s=Calendar.getInstance().get(Calendar.SECOND);
		tv.setText(y+"-"+m+"-"+d+" "+h+":"+":"+mi+":"+s);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_, menu);
		return true;
	}
}
