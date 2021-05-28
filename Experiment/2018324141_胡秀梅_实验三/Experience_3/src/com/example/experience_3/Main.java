package com.example.experience_3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

@SuppressLint({ "SdCardPath", "SimpleDateFormat" })
public class Main extends Activity {
	MediaRecorder recorder1;	//录音的MediaRecorder
	Button startBtn1;
	Button stopBtn1;
	
	MediaRecorder recorder2;	//录音的MediaRecorder
	Button startBtn2;
	Button stopBtn2;
	
	SurfaceView view;	//录像时预览视图
	SurfaceHolder holder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initAudio();
        initVideo();
    }


    //录音
	void initAudio() {
		recorder1=new MediaRecorder();
		startBtn1=(Button) findViewById(R.id.startBtn1);
		stopBtn1=(Button) findViewById(R.id.stopBtn1);
		
		//音频源是麦克风
		recorder1.setAudioSource(MediaRecorder.AudioSource.MIC);
		//输出格式AMR_NB
		recorder1.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		//输出文件路劲
		recorder1.setOutputFile("/sdcard/"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".3gp");
		startBtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					recorder1.prepare(); //准备录制
					recorder1.start();	//开始录制
					startBtn1.setEnabled(false);
					stopBtn1.setEnabled(true);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		stopBtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				recorder1.stop();	//停止录制
				recorder1.release();	//释放资源
				startBtn1.setEnabled(true);
				stopBtn1.setEnabled(false);
			}
		});
	}

	void initVideo() {
		recorder2=new MediaRecorder();
		startBtn2=(Button) findViewById(R.id.startBtn2);
		stopBtn2=(Button) findViewById(R.id.stopBtn2);
		view=(SurfaceView) findViewById(R.id.view);
		holder=view.getHolder();
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		
		//使用holder的surface作为录像时的预览视图
		recorder2.setPreviewDisplay(holder.getSurface());
		//音频源是麦克风
		recorder2.setAudioSource(MediaRecorder.AudioSource.MIC);
		//视频源是摄像头
		recorder2.setVideoSource(MediaRecorder.VideoSource.CAMERA);
		//输出格式MPEG_4
		recorder2.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
		//音频编码格式
		recorder2.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
		//视频分别率
		recorder2.setVideoSize(320, 240);
		//视频帧率
		recorder2.setVideoFrameRate(20);
		//视频编码格式H263
		recorder2.setOutputFile("/sdcard/"+new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+".mp4");
		startBtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					recorder2.prepare();	//准备录制
					recorder2.start();	//开始录制
					startBtn2.setEnabled(false);
					stopBtn2.setEnabled(true);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		startBtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					recorder2.prepare();
					recorder2.start();	//释放资源
					startBtn2.setEnabled(true);
					stopBtn2.setEnabled(false);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	//停止录制
			}
		});
		stopBtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				recorder2.stop();	//停止录制
				recorder2.release();	//释放资源
				startBtn2.setEnabled(true);
				stopBtn2.setEnabled(false);
			}
		});
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
