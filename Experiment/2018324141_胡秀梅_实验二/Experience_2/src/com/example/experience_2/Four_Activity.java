package com.example.experience_2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SeekBar;
import android.widget.TextView;

public class Four_Activity extends Activity{
	SeekBar sb;
	TextView stv;
	boolean dragging; //是否已启动
	boolean finshed;	//是否已完成
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//four
		setContentView(R.layout.seekbar);
		sb=(SeekBar) findViewById(R.id.sb);
		stv=(TextView) findViewById(R.id.stv);
		final int max=sb.getMax();
		
		sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				dragging=false;	//停止
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				dragging=true;	//开始拖动
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				int p=sb.getProgress();
				stv.setText("进度:"+p*100/max+"%");
				if(p==max){
					finshed=true;
				}
			}
		});
		new Thread(){
			public void run(){
				while(!finshed){
					if(!dragging){
						try{
							Thread.sleep(50);
							sb.incrementProgressBy(1);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_, menu);
		return true;
	}
}
