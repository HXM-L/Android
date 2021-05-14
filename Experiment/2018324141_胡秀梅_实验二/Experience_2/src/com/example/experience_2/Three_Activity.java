package com.example.experience_2;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
public class Three_Activity extends Activity{
	//three
	ProgressBar pb1;
	ProgressBar pb2;
	ProgressBar pb3;
	ProgressBar pb4;
	Button startBtn;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//three
		setContentView(R.layout.progress);
		pb1=(ProgressBar) findViewById(R.id.pb1);
		pb2=(ProgressBar) findViewById(R.id.pb2);
		pb3=(ProgressBar) findViewById(R.id.pb3);
		pb4=(ProgressBar) findViewById(R.id.pb4);
		startBtn=(Button) findViewById(R.id.starBtn);
		final int max = pb4.getMax(); //最大值
		final Handler handler = new Handler(){
			public void handleMessage(Message msg){
				int p=msg.what;
				//若果达到最大值,隐藏圆形进度条
				if(p==max){
					pb1.setVisibility(View.GONE);
					pb2.setVisibility(View.GONE);
					pb3.setVisibility(View.GONE);
				}
				pb4.setProgress(p);	//修改进度条的精度
				pb4.setSecondaryProgress(p*2);	//修改条形进度条的第二进度
			};
		};
		startBtn.setOnClickListener(new Button.OnClickListener() {
			
			public void onClick(View v) {
				//显示四个进度条
				pb1.setVisibility(View.VISIBLE);
				pb2.setVisibility(View.VISIBLE);
				pb3.setVisibility(View.VISIBLE);
				pb4.setVisibility(View.VISIBLE);
				
				//模拟耗时操作
				new Thread(){
					public void run(){
						for(int i=1;i<=max;i++){
							try{
								Thread.sleep(50);
								Message msg=new Message();
								msg.what=i;
								handler.sendMessage(msg);
							}catch(InterruptedException e){
								e.printStackTrace();
							}
						}
					}
				}.start();
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_, menu);
		return true;
	}
}
