package com.example.experience_2;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Six_Activity extends Activity {
	//six
	Button startBtn1;
	Button startBtn2;
	ProgressDialog pd1;
	ProgressDialog pd2;
	
	
	
	@SuppressLint("HandlerLeak") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//six
		setContentView(R.layout.progress_dialog);
		startBtn1=(Button) findViewById(R.id.startBtn1);
		startBtn2=(Button) findViewById(R.id.startBtn2);
		
		pd1=new ProgressDialog(this);
		pd2=new ProgressDialog(this);
		pd1.setMessage("请稍后......");
		pd2.setMessage("请稍后......");
		pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL); //设置进度条为条形
		final int max=100;	//进度最大值
		final Handler handler=new Handler(){
			public void handleMessage(Message msg){
				int p=msg.what;
				//若果达到最大值,隐藏进度条
				if(p==max){
					pd1.hide();
					pd2.hide();
				}
				//修改条形进度条对话框的进度
				pd2.setProgress(p);
			};
		};
		
		startBtn1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				pd1.show();
				new Thread(){
					@Override
					public void run(){
						for(int i=1;i<=max;i++){
							try{
								Thread.sleep(50);
								Message msg=new Message();
								msg.what=i;
								handler.sendMessage(msg);	//发送消息
							}catch(InterruptedException e){
								e.printStackTrace();
							}
						}
					}
				}.start();
				
			}
		});
		startBtn2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				pd2.show();
				new Thread(){
					@Override
					public void run(){
						for(int i=1;i<=max;i++){
							try{
								Thread.sleep(50);
								Message msg=new Message();
								msg.what=i;
								handler.sendMessage(msg);	//发送消息
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
